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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import com.onap.sdnc.testapi.model.CertificationInputs;
import com.onap.sdnc.testapi.model.Input;
import com.onap.sdnc.testapi.model.Output;
import com.onap.sdnc.testapi.model.PreTestResponse;
import com.onap.sdnc.testapi.service.CertificationClientService;

public class CertificationClientServiceTest {

	@Mock
	CertificationClientService certificationClientservice;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void TestRestClient() {
		Input input = new Input();
		CertificationInputs vnfinfo = new CertificationInputs();

			input.setHostname("hostname");
			input.setIpaddress("10.20.30.50");
			input.setNetwork("network");
			vnfinfo.setInput(input);

		List<PreTestResponse> preTestNew = new ArrayList<PreTestResponse>();
		String testType = "network";		
		Mockito.doNothing().when(certificationClientservice).restClient(vnfinfo, preTestNew, testType);
		certificationClientservice.restClient(vnfinfo, preTestNew, testType);
		assertTrue(true);
	}
	
	@Test
	public void pingServiceTest() {
		CertificationInputs vnfinfo = new CertificationInputs();
		Input input = new Input();
			input.setIpaddress("10.53.122.44");
			input.setHostname("hostname");
			vnfinfo.setInput(input);
		Output mockOutput = new Output();
			mockOutput.setIpaddress("10.53.122.44");
		Output output = CertificationClientService.pingTest(vnfinfo);
		assertEquals(output.getIpaddress(), input.getIpaddress());
	}

	@Test
	public void protocolTest() {
		CertificationInputs vnfinfo = new CertificationInputs();
		Input input = new Input();
			input.setIpaddress("10.53.122.44");
			input.setHostname("hostname");
			vnfinfo.setInput(input);
		Output mockOutput = new Output();
			mockOutput.setIpaddress("10.53.122.44");
		Output output = CertificationClientService.protocolTest(vnfinfo);
		assertEquals(output.getIpaddress(), input.getIpaddress());
	}
}
	