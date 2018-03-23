package com.onap.sdnc.testapi.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import com.onap.sdnc.testapi.model.Response;
import com.onap.sdnc.testapi.model.CertificationInputs;
import com.onap.sdnc.testapi.model.Input;
import com.onap.sdnc.testapi.model.ODLClientResponse;
import com.onap.sdnc.testapi.model.Output;
import com.onap.sdnc.testapi.model.PreTestResponse;
import com.onap.sdnc.testapi.model.Request;
import com.onap.sdnc.testapi.model.ValidationTestType;
import com.onap.sdnc.testapi.model.VnfList;

public class LayerTestServiceImplTest {

	@Mock
	CertificationClientService cService;
	@Mock
	LayerTestServiceImpl layerTestServiceImpl;
	
	private String hostname = "host";
	private String ipaddress = "0.0.0.0";
	private String statistics = "0% loss";
	private String avgTime = "Minimum = 0ms";
	private String testresult="testresult";
	private String reason="Check your input";
	private String testtype = "network";
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void networkCertificationTest() {			 
		 
		Request restReq = new Request();
		Input input = new Input();
		CertificationInputs vnfinfo = new CertificationInputs();
		ValidationTestType vType =  new ValidationTestType();
		
		List<ValidationTestType> lVtype = new ArrayList<ValidationTestType>();
		vType.setTypeId("1");
		vType.setValidationType("Network Layer");
		lVtype.add(vType);
		
		ValidationTestType[] validationTestType = new ValidationTestType[lVtype.size()];
		lVtype.toArray(validationTestType);
		restReq.setValidationTestType(validationTestType);
		
		VnfList vnfList = new VnfList();
		vnfList.setHostName("hostname");
		vnfList.setIpAddress("0.0.0.0");
		vnfList.setPortNo("0");
		
		List<VnfList> vnfListArray =  new ArrayList<VnfList>();
		vnfListArray.add(vnfList);
		
		VnfList[] vnfInputArray = new VnfList[vnfListArray.size()];
		vnfListArray.toArray(vnfInputArray);
		restReq.setVnfList(vnfInputArray);
		input.setHostname("hostname");
		input.setIpaddress("10.20.30.50");
		input.setNetwork("network");
		vnfinfo.setInput(input);
		
		Response res =  new Response();
		
		PreTestResponse preTestRes =  new PreTestResponse();
		preTestRes.setIpaddress("0.0.0.0");
		
		List<PreTestResponse> preList =  new ArrayList<PreTestResponse>();
		preList.add(preTestRes);
		
		res.setPreTestResponse(preList);
		
		Mockito.when(layerTestServiceImpl.networkCertification(restReq)).thenReturn(res);
		
		Response actualRes = layerTestServiceImpl.networkCertification(restReq);
		
		assertEquals(actualRes.getPreTestResponse().get(0).getIpaddress(), vnfList.getIpAddress());
	}
	
	@Test
	public void TestSaveResult() {
		PreTestResponse preTestResponse = new PreTestResponse();
		ODLClientResponse odlClientResponse=new ODLClientResponse();
		
		Output output=new Output();
			output.setAvgTime(avgTime);
			output.setHostname(hostname);
			output.setIpaddress(ipaddress);
			output.setReason(reason);
			output.setStatistics(statistics);
			output.setStatus("reachable");
			output.setTestresult(testresult);
		
			odlClientResponse.setOutput(output);
		
			preTestResponse.setAvgTime(avgTime);
			preTestResponse.setIpaddress(ipaddress);
			preTestResponse.setStatistics(statistics);
			preTestResponse.setStatus("reachable");
			preTestResponse.setTesttype(testtype);
			
		Mockito.doNothing().when(layerTestServiceImpl).testSaveResults(preTestResponse, odlClientResponse);
		layerTestServiceImpl.testSaveResults(preTestResponse, odlClientResponse);
		assertTrue(true);
	}

}
