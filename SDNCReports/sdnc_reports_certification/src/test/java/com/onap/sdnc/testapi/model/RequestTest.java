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

package com.onap.sdnc.testapi.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.gson.Gson;
import com.onap.sdnc.testapi.Application;
import com.onap.sdnc.testapi.ServletInitializer;
import com.onap.sdnc.testapi.model.CertificationInputs;
import com.onap.sdnc.testapi.model.Input;
import com.onap.sdnc.testapi.model.ODLClientResponse;
import com.onap.sdnc.testapi.model.Output;
import com.onap.sdnc.testapi.model.PreTestResponse;
import com.onap.sdnc.testapi.model.Request;
import com.onap.sdnc.testapi.model.Response;
import com.onap.sdnc.testapi.model.ValidationTestType;
import com.onap.sdnc.testapi.model.Vnf;
import com.onap.sdnc.testapi.model.VnfList;
import com.onap.sdnc.testapi.service.CertificationClientService;
import com.onap.sdnc.testapi.service.LayerTestServiceImpl;


public class RequestTest {
	
	private String hostname = "host";
	private String ipaddress = "0.0.0.0";
	private String network = "Network Layer";
	private String typeId="1";
	
	private ValidationTestType[] validationTestTypee;
	Request restReq= new Request();
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void TestRequest() {					
		ValidationTestType validationTestType = new ValidationTestType();
			validationTestType.setTypeId(typeId);
			validationTestType.setValidationType(network);

		VnfList<List> vnflistt = new VnfList<List>();
			vnflistt.setHostName(hostname);
			vnflistt.setIpAddress(ipaddress);
			vnflistt.setPortNo(null);
		
		VnfList[] vnflist = restReq.getVnfList();
		restReq.setValidationTestType(validationTestTypee);
		restReq.setVnfList(vnflist);
		
		ValidationTestType[] validationTestTypee = restReq.getValidationTestType();
		
		Vnf vnf = new Vnf();
			vnf.setValidationTestType(validationTestTypee);
			vnf.setVnfList(vnflist);		
			
			assertEquals(restReq.getValidationTestType(), validationTestTypee);
			assertEquals(restReq.getVnfList(), vnflist);
	}
	
}
