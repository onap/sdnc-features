/*
* ============LICENSE_START=======================================================
* ONAP : SDNC-FEATURES
* ================================================================================
* Copyright 2018 TechMahindra
*=================================================================================
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
* ============LICENSE_END=========================================================
*/
package com.onap.sdnc.reports.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onap.sdnc.reports.controller.PreTestController;
import com.onap.sdnc.reports.model.PreTestConfig;
import com.onap.sdnc.reports.model.Report;
import com.onap.sdnc.reports.model.Response;
import com.onap.sdnc.reports.repository.DeviceRepository;
import com.onap.sdnc.reports.repository.PreTestConfigRepository;
import com.onap.sdnc.reports.rest.model.PreTestModel;

@Service
public class ReportServiceImpl implements IReportService {

	private static Logger logger=Logger.getLogger(ReportServiceImpl.class);
	
	@Autowired
	DeviceRepository deviceRepository;
	
	@Autowired 
	PreTestConfigRepository preTestConfigRepository;
	
	@Override
	public void saveReport(Report Report) {
		// TODO Auto-generated method stub

	}

	@Override
	public Response findAllReports(Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response findReportByTestName(Date startDate, Date endDate, String testName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PreTestModel> findReportByDeviceName(Date startDate, Date endDate, String deviceName) throws Exception{
		try{
			List<PreTestConfig> resultSet= preTestConfigRepository.findReportByDeviceName(startDate, endDate, deviceName);
			logger.info("findReportByDeviceName Received Output : "+resultSet);
			
			List<PreTestModel> preTestList=new ArrayList<PreTestModel>();
			for(PreTestConfig config : resultSet)
			{
				try{
					long deviceid=config.getDevice().getId();
					long testid=config.getTestId();
					String testName=config.getTestName();
					String deviName=config.getDevice().getDeviceName();
					String execuationDetails=config.getExecuationDetails();
					String result=config.getResult();
					Date timeStamp=config.getTimestamp();
					
					PreTestModel model=new PreTestModel(testid, deviceid, testName, deviName, execuationDetails, result, timeStamp);
					preTestList.add(model);
				}
				catch(Exception ex)
				{
					logger.info("Exception Occured : "+ex.getLocalizedMessage());
				}			
		}
		Response r=new Response("Pass", resultSet);
		logger.info("Final PreTestConfig List Size : "+preTestList.size());
		return preTestList;
		}
		catch(Exception ex)
		{
			logger.info("Exception Occured : "+ex.getLocalizedMessage());
			throw new Exception(ex);
		}
		
	}

	@Override
	public Response findReportsByDeviceNamdAndTestName(Date startDate, Date endDate, String deviceName,
			String testName) {
		
		return null;
	}

}
