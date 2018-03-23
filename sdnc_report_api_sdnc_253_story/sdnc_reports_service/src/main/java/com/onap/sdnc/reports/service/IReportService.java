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

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.onap.sdnc.reports.model.PreTestConfig;
import com.onap.sdnc.reports.model.Report;
import com.onap.sdnc.reports.model.Response;
import com.onap.sdnc.reports.rest.model.PreTestModel;

public interface IReportService {
	
	public void saveReport(@RequestBody Report Report);
	
	public Response findAllReports(@PathVariable("startDate") Date startDate,@PathVariable("endDate") Date endDate);
	
	
	public Response findReportByTestName(@PathVariable("startDate") Date startDate,@PathVariable("endDate") Date endDate,@PathVariable("testName") String testName); 
	
	public List<PreTestModel> findReportByDeviceName(@PathVariable("startDate") Date startDate,@PathVariable("endDate") Date endDate,@RequestParam("deviceName") String deviceName) throws Exception;
	
	public Response findReportsByDeviceNamdAndTestName(@PathVariable("startDate") Date startDate,@PathVariable("endDate") Date endDate,@PathVariable("deviceName") String deviceName,@PathVariable("testName") String testName);

}
