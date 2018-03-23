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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onap.sdnc.reports.model.Report;
import com.onap.sdnc.reports.model.Response;
import com.onap.sdnc.reports.repository.DeviceRepository;
import com.onap.sdnc.reports.rest.model.PreTestModel;
import com.onap.sdnc.reports.service.IReportService;
import com.onap.sdnc.reports.service.ReportServiceImpl;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/sdnc/report")
//@RequestMapping("/")
public class PreTestController {

	private static final Logger logger = LogManager.getLogger(PreTestController.class);
	@Autowired
	IReportService reportService;
	
	@ApiOperation(value = "findReportByDeviceName/{startDate}/{endDate}/{deviceName}", notes = "findReportByDeviceName from specified start date and end date with given deviceName")
	@ApiResponses(value = {	@ApiResponse(code = 200, message = "got successfull"),
							@ApiResponse(code = 500, message = "Internal Server Error")
						})	
	//@RequestMapping(value="/findReportByDeviceName/{startDate}/{endDate}/{deviceName}",produces=MediaType.APPLICATION_JSON_VALUE,method=RequestMethod.GET,consumes=("text/plain"))
	@RequestMapping(value="/findReportByDeviceName/{startDate}/{endDate}/{deviceName}",method=RequestMethod.GET)
	public List<PreTestModel> findReportByDeviceName(@PathVariable("startDate") long startDate,@PathVariable("endDate") long endDate,@PathVariable("deviceName") String deviceName) {

		try{
			logger.info("findReportByDeviceName Started Working..");		
			Date sDate=new Date(startDate);
			Date eDate=new Date(endDate);
					
			if(sDate.after(eDate) || eDate.before(sDate))
			{
				// need to handle this condition
			}
			logger.info("findReportByDeviceName Finished Working..");
			return reportService.findReportByDeviceName(sDate,eDate,deviceName);		
		}
		catch(Exception ex)
		{
			logger.info("Exception Occured : "+ex.getLocalizedMessage());
			return java.util.Collections.EMPTY_LIST;
		}
		
	}

/*	@ApiOperation(value = "save users", notes = "save single report at a time")
	@ApiResponses(value = {	@ApiResponse(code = 200, message = "got successfull"),
							@ApiResponse(code = 500, message = "Internal Server Error")
						})		
	@RequestMapping(value = "/saveReport", method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public void saveReport(@RequestBody Report Report) {

		//repository.save(new Report(Report.getFirstName(), Report.getLastName()));
	}

	@ApiOperation(value = "findAllReports", notes = "findAllReports from specified start date and end date")
	@ApiResponses(value = {	@ApiResponse(code = 200, message = "got successfull"),
							@ApiResponse(code = 500, message = "Internal Server Error")
						})	
	@RequestMapping(value="/findAllReports/{startDate}/{endDate}",produces=MediaType.APPLICATION_JSON_VALUE)	
	public Response findAllReports(@PathVariable("startDate") Date startDate,@PathVariable("endDate") Date endDate) {

		//Iterable<Report> Reports = repository.findAll();

		//return new Response("Done", Reports);
		
		return reportService.findAllReports(startDate,endDate);
	}

	@ApiOperation(value = "findReportByTestName", notes = "findReportByTestName from specified start date and end date with given testName")
	@ApiResponses(value = {	@ApiResponse(code = 200, message = "got successfull"),
							@ApiResponse(code = 500, message = "Internal Server Error")
						})	
	@RequestMapping(value="/findReportByTestName/{startDate}/{endDate}/{testName}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Response findReportByTestName(@PathVariable("startDate") Date startDate,@PathVariable("endDate") Date endDate,@PathVariable("testName") String testName) {


		return reportService.findReportByTestName(startDate,endDate,testName);
	}

	

	@RequestMapping(value="/findReportsByDeviceNamdAndTestName/{startDate}/{endDate}",produces=MediaType.APPLICATION_JSON_VALUE)	
	public Response findReportsByDeviceNamdAndTestName(@PathVariable("startDate") Date startDate,@PathVariable("endDate") Date endDate,@PathVariable("deviceName") String deviceName,@PathVariable("testName") String testName) {
		
		return reportService.findReportsByDeviceNamdAndTestName(startDate,endDate,deviceName,testName);
	}*/
	
	
	
	/*@ApiOperation(value = "findReportByDeviceName/{startDate}/{endDate}/{deviceName}", notes = "findReportByDeviceName from specified start date and end date with given deviceName")
	@ApiResponses(value = {	@ApiResponse(code = 200, message = "got successfull"),
							@ApiResponse(code = 500, message = "Internal Server Error")
						})	
	//@RequestMapping(value="/findReportByDeviceName/{startDate}/{endDate}/{deviceName}",produces=MediaType.APPLICATION_JSON_VALUE,method=RequestMethod.GET,consumes=("text/plain"))
	@RequestMapping(value="/findReportByDeviceName/{startDate}/{endDate}/{deviceName}",method=RequestMethod.GET)
	public List<PreTestModel> findReportByDeviceName(@PathVariable("startDate") Date startDate,@PathVariable("endDate") Date endDate,@PathVariable("deviceName") String deviceName) {

		System.out.println("findReportByDeviceName Got Called");
		//List<Report> Reports = null;//repository.findByLastName(lastName);

		//return new Response("Done", Reports);
		
		return reportService.findReportByDeviceName(startDate,endDate,deviceName);
	}*/
	
	
}
