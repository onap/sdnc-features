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
package com.onap.sdnc.reports.controller;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.engine.internal.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.onap.sdnc.reports.Application;
import com.onap.sdnc.reports.model.PreTestConfig;
import com.onap.sdnc.reports.model.Report;
import com.onap.sdnc.reports.model.Response;
import com.onap.sdnc.reports.repository.DeviceRepository;
import com.onap.sdnc.reports.rest.model.PreTestModel;
import com.onap.sdnc.reports.service.IReportService;

@RestController
public class ReportController {

	private static final Logger logger = LogManager.getLogger(ReportController.class);
	
	@Autowired
	IReportService reportService;
	
	/*@RequestMapping(value = "/saveReport", method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public void saveReport(@RequestBody Report Report) {

		//repository.save(new Report(Report.getFirstName(), Report.getLastName()));
	}

	@RequestMapping(value="/findAllReports/{startDate}/{endDate}",produces=MediaType.APPLICATION_JSON_VALUE)	
	public Response findAllReports(@PathVariable("startDate") Date startDate,@PathVariable("endDate") Date endDate) {
		
		return reportService.findAllReports(startDate,endDate);
	}

	// produces = "application/json"
	@RequestMapping(value="/findReportByTestName/{startDate}/{endDate}/{testName}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Response findReportByTestName(@PathVariable("startDate") Date startDate,@PathVariable("endDate") Date endDate,@PathVariable("testName") String testName) {
		
		return reportService.findReportByTestName(startDate,endDate,testName);
	}*/

	@RequestMapping(value="/findReportByDeviceName/{startDate}/{endDate}/{deviceName}", produces = "application/json",method=RequestMethod.GET)
	public List<PreTestModel> findReportByDeviceName(@PathVariable("startDate") Date startDate,@PathVariable("endDate") Date endDate,@PathVariable("deviceName") String deviceName) {

		try{
			logger.info("findReportByDeviceName Started Working..");
			logger.info("Received StartDate : "+startDate+" ,EndDate : "+endDate+"  ,DeviceName : "+deviceName);
			/*ObjectMapper mapper=new ObjectMapper();
			String jsonVal="";
			try {
				jsonVal = mapper.writeValueAsString(reportService.findReportByDeviceName(startDate,endDate,deviceName));
				logger.info("JSON "+jsonVal);
			} catch (JsonProcessingException e) {
				
			}*/
			logger.info("findReportByDeviceName Finished Working..");
			return reportService.findReportByDeviceName(startDate,endDate,deviceName.trim());
		}
		catch(Exception ex)
		{
			logger.info("Exception Occured : "+ex.getLocalizedMessage());
			return java.util.Collections.EMPTY_LIST;
		}
		
	}

	/*@RequestMapping(value="/findReportsByDeviceNamdAndTestName/{startDate}/{endDate}",produces=MediaType.APPLICATION_JSON_VALUE)	
	public Response findReportsByDeviceNamdAndTestName(@PathVariable("startDate") Date startDate,@PathVariable("endDate") Date endDate,@PathVariable("deviceName") String deviceName,@PathVariable("testName") String testName) {
		
		return reportService.findReportsByDeviceNamdAndTestName(startDate,endDate,deviceName,testName);
	}*/
}
