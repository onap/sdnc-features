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
package com.onap.sdnc.testapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.onap.sdnc.testapi.model.Request;
import com.onap.sdnc.testapi.model.Response;
import com.onap.sdnc.testapi.service.LayerTestService;

@CrossOrigin
@RestController
public class TestController {

	@Autowired
	LayerTestService ltService;	
	
	@RequestMapping(value="/runtest",method=RequestMethod.POST, consumes="application/json",produces=MediaType.APPLICATION_JSON_VALUE)
	public Response findReportByTestName(@RequestBody Request req) {		
		
		return ltService.networkCertification(req);		
	}
	
	@RequestMapping(value="/ping",method=RequestMethod.GET)
	public String pingService() {
		
		return "success";
	}
	
}
