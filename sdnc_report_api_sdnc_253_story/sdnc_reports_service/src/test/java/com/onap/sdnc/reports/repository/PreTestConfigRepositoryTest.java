package com.onap.sdnc.reports.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.onap.sdnc.reports.Application;
//import com.onap.sdnc.reports.model.DeviceConfig;
//import com.onap.sdnc.reports.model.PreTestConfig;
import com.onap.sdnc.reports.model.DeviceConfig;
import com.onap.sdnc.reports.model.PreTestConfig;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
//@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
@Transactional
public class PreTestConfigRepositoryTest {

	private static final Logger logger = LogManager.getLogger(Application.class);
	
	@Autowired
	private PreTestConfigRepository preTestRepository;
	
	@Autowired
	private TestEntityManager entityManager;
	
	
	@Test
	public void whenFindByDeviceName_thenReturnRouter() {
	    // given
		
		
		DeviceConfig deviceConfig=new DeviceConfig();
		//deviceConfig.setId(3);
		deviceConfig.setDeviceName("Router");
		deviceConfig.setPreTestConfig(null);
		deviceConfig.setProtocolConfig(null);
		deviceConfig.setCreationDate(new Date().toLocaleString());
		 
		entityManager.persist(deviceConfig);
		entityManager.flush();
		    
		PreTestConfig obj=new PreTestConfig();
		obj.setDevice(deviceConfig);
		obj.setExecuationDetails("Ping Successful");
		obj.setResult("Pass");
		//obj.setTestId(8);
		obj.setTestName("Network Layer");
		obj.setTimestamp(new Date());
		
		Set<PreTestConfig> set=new HashSet<>();
		set.add(obj);
		deviceConfig.setPreTestConfig( set);
		entityManager.persistAndFlush(deviceConfig);
		
	    entityManager.persist(obj);
	    entityManager.flush();
	    	    		    
	    Calendar calendar=Calendar.getInstance();
	    
	    calendar.add(Calendar.DATE, -7);
	    Date startDate=calendar.getTime();
	    Date endDate=new Date();
	    // when
	    List<PreTestConfig> preTestList = preTestRepository.findReportByDeviceName(startDate,endDate,"Router");
	    
	    assertThat(preTestList.get(0).getTestId())
	      .isEqualTo(obj.getTestId());
	    
	    System.out.println("Status : "+(preTestList.get(0).getTestId()==obj.getTestId()));
	}
	
	/*@Test
	public void whenFindByDeviceName_thenReturnRouter() {
	    // given
		
		PreTestConfigRepository preTestRepository= mock(PreTestConfigRepository.class);
		DeviceConfig deviceConfig=new DeviceConfig();
		//deviceConfig.setId(3);
		deviceConfig.setDeviceName("Router");
		deviceConfig.setPreTestConfig(null);
		deviceConfig.setProtocolConfig(null);
		deviceConfig.setCreationDate(new Date().toLocaleString());
		 
		
		    
		PreTestConfig obj=new PreTestConfig();
		obj.setDevice(deviceConfig);
		obj.setExecuationDetails("Ping Successful");
		obj.setResult("Pass");
		//obj.setTestId(8);
		obj.setTestName("Network Layer");
		obj.setTimestamp(new Date());
		
		Set<PreTestConfig> set=new HashSet<>();
		set.add(obj);
		deviceConfig.setPreTestConfig( set);
		
		List<PreTestConfig> dummyInput=new ArrayList<>();
		dummyInput.add(obj);
		
	    Calendar calendar=Calendar.getInstance();
	    
	    calendar.add(Calendar.DATE, -7);
	    Date startDate=calendar.getTime();
	    Date endDate=new Date();
	    // when
	    
	    when(preTestRepository.findReportByDeviceName(startDate,endDate,"Router")).thenReturn(dummyInput);
	    
	    List<PreTestConfig> preTestList = preTestRepository.findReportByDeviceName(startDate,endDate,"Router");
	    
	    assertThat(preTestList.get(0).getTestId())
	      .isEqualTo(obj.getTestId());
	    
	    logger.info("Status : "+(preTestList.get(0).getTestId()==obj.getTestId()));
	}*/

	
}
