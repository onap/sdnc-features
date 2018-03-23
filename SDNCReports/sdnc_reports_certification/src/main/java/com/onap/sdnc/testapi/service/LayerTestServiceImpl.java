/*-
 * ============LICENSE_START=======================================================
 * openECOMP : SDN-C
 * ================================================================================
 * Copyright (C) 2017 AT&T Intellectual Property. All rights
 *                             reserved.
 * ================================================================================
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ============LICENSE_END=========================================================
 */ 
package com.onap.sdnc.testapi.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.gson.Gson;
import com.onap.sdnc.reports.model.DeviceConfig;
import com.onap.sdnc.reports.repository.DeviceRepository;
import com.onap.sdnc.reports.repository.PreTestConfigRepository;
import com.onap.sdnc.testapi.model.CertificationInputs;
import com.onap.sdnc.testapi.model.Input;
import com.onap.sdnc.testapi.model.ODLClientResponse;
import com.onap.sdnc.testapi.model.PreTestResponse;
import com.onap.sdnc.testapi.model.Request;
import com.onap.sdnc.testapi.model.Response;
import com.onap.sdnc.testapi.model.ValidationTestType;
import com.onap.sdnc.testapi.model.VnfList;


@Service
public class LayerTestServiceImpl implements LayerTestService {

	private static final Logger logger = Logger.getLogger(CertificationClientService.class);
	
	@Autowired
	CertificationClientService certificationClientservice;
	
	@Autowired
	DeviceRepository deviceRepository;
	
	@Autowired
	PreTestConfigRepository preTestRepo;
	
	@Override
	public Response networkCertification(Request restReq) {
		
		String testType = "network";		
		
		VnfList[] vnf = restReq.getVnfList();
		
		ValidationTestType[] validationType = restReq.getValidationTestType();

		CertificationInputs vnfRequestParams = new CertificationInputs();

		Response resOutput = new Response();
		
		Input input = new Input();

		List<PreTestResponse> preTestNew = new ArrayList<PreTestResponse>();
		for (ValidationTestType validationTestType : validationType) {
			if (validationTestType.getValidationType().equalsIgnoreCase("Network Layer")) {
				testType = "network";
			}
			if (validationTestType.getValidationType().equalsIgnoreCase("Protocol Layer")) {
				testType = "protocol";
			}
			for (VnfList vnfList : vnf) {
				input.setIpaddress(vnfList.getIpAddress());
				input.setHostname(vnfList.getHostName());
				vnfRequestParams.setInput(input);
				certificationClientservice.restClient(vnfRequestParams, preTestNew, testType);
			}
		}		
		resOutput.setPreTestResponse(preTestNew);		
		return resOutput;
	}

	@Override
	public void testSaveResults(PreTestResponse preTest,ODLClientResponse output) {
		boolean flag=false;
		long devId = 0;
		
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		try {
			DeviceConfig devicename = deviceRepository.findDeviceName(preTest.getIpaddress());
			devId = devicename.getId();			
		} catch (Exception e) {
			flag=true;			
		}
		if(flag) {
			deviceRepository.logDeviceName(preTest.getIpaddress(), timeStamp);
		}else
		{
			DeviceConfig devicename = deviceRepository.findDeviceName(preTest.getIpaddress());
			devId = devicename.getId();
		}
		Gson gson = new Gson();
		String testName= preTest.getTesttype();
		String result = preTest.getStatus();
		String execuationDetails = gson.toJson(output);

		preTestRepo.logPreTestReport(testName, result, execuationDetails, timeStamp, devId);
	}

}
