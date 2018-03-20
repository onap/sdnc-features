package com.onap.sdnc.reports.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.onap.sdnc.reports.Application;
import com.onap.sdnc.reports.model.DeviceConfig;
import com.onap.sdnc.reports.model.PreTestConfig;
import com.onap.sdnc.reports.repository.PreTestConfigRepository;
import com.onap.sdnc.reports.rest.model.PreTestModel;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@DataJpaTest
@Transactional
public class ReportServiceImplTest {

	private static final Logger logger = LogManager.getLogger(Application.class);
	 	
	private Date startDate,endDate;
	
/*	 @TestConfiguration
	 static class ReportServiceImplTestContextConfiguration 
	 {	  
	        @Bean
	        public IReportService reportService() 
	        {
	            return new ReportServiceImpl();
	        }
	 }

	 @Autowired
	 private IReportService reportService;
		
		@MockBean
		private PreTestConfigRepository preTestConfigRepository;
				
	 @Before
	 public void setUp() 
	 {
		 	DeviceConfig deviceConfig=new DeviceConfig();
			deviceConfig.setDeviceName("Router");
			deviceConfig.setPreTestConfig(null);
			deviceConfig.setProtocolConfig(null);
			deviceConfig.setCreationDate(new Date().toLocaleString());
	  
			PreTestConfig obj=new PreTestConfig();
			obj.setDevice(deviceConfig);
			obj.setExecuationDetails("Ping Successful");
			obj.setResult("Pass");

			obj.setTestName("Network Layer");
			obj.setTimestamp(new Date());

			
			Calendar calendar=Calendar.getInstance();
			    
			 calendar.add(Calendar.DATE, -7);
			 calendar.add(Calendar.HOUR_OF_DAY, 00);
			 calendar.add(Calendar.MINUTE, 00);
			 calendar.add(Calendar.SECOND, 00);
			 calendar.add(Calendar.MILLISECOND, 00);
			 startDate=calendar.getTime();
			 			 
			 Calendar endDateCalendar=Calendar.getInstance();
			    
			 endDateCalendar.add(Calendar.HOUR_OF_DAY, 23);
			 endDateCalendar.add(Calendar.MINUTE, 59);
			 calendar.add(Calendar.SECOND, 00);
			 endDateCalendar.add(Calendar.MILLISECOND, 00);
			  endDate=endDateCalendar.getTime();
			    			 
			 System.out.println("Before Call : startDate "+startDate.toLocaleString() +" endDate : "+endDate.toLocaleString());
			 List<PreTestConfig> configList=new ArrayList<>();
			 configList.add(obj);
			 Mockito.when(preTestConfigRepository.findReportByDeviceName(startDate,endDate,"Router"))
			 .thenReturn(configList);
	 }
	 
	 
	 @Test
	 public void whenFindByDeviceName_thenReturPreTest() 
	 {
		 int expectedTestId=0;
		 System.out.println("Test Call : startDate "+startDate.toLocaleString() +" endDate : "+endDate.toLocaleString());
		 
	     List<PreTestModel> testList;
		try {
			testList = reportService.findReportByDeviceName(startDate,endDate,"Router");
			 assertThat(testList.get(0).getTestid())
		     .isEqualTo(expectedTestId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	    
	  }
	 */
	/* @InjectMocks
	 private IReportService reportService;
	 
	 @Mock
	 private PreTestConfigRepository preTestConfigRepository;*/
	 
	 List<PreTestConfig> configList;
	 
	 List<PreTestModel> dummyList;
	 @Before
	 public void setUp() 
	 {
		 	DeviceConfig deviceConfig=new DeviceConfig();
			deviceConfig.setDeviceName("Router");
			deviceConfig.setPreTestConfig(null);
			deviceConfig.setProtocolConfig(null);
			deviceConfig.setCreationDate(new Date().toLocaleString());
	  
			PreTestConfig obj=new PreTestConfig();
			obj.setDevice(deviceConfig);
			obj.setExecuationDetails("Ping Successful");
			obj.setResult("Pass");

			obj.setTestName("Network Layer");
			obj.setTimestamp(new Date());

			PreTestModel model=new PreTestModel(1, 1, "Protocol Layer", "Router", "{\"output\": {\"testresult\": \"pass\", \"status\": \"unreachable\"}}", "Pass", new Date());
			Calendar calendar=Calendar.getInstance();
			    
			calendar.add(Calendar.DATE, -7);
			calendar.add(Calendar.HOUR_OF_DAY, 00);
			calendar.add(Calendar.MINUTE, 00);
			calendar.add(Calendar.SECOND, 00);
			calendar.add(Calendar.MILLISECOND, 00);
			startDate=calendar.getTime();
			 			 
			Calendar endDateCalendar=Calendar.getInstance();
			    
			endDateCalendar.add(Calendar.HOUR_OF_DAY, 23);
			endDateCalendar.add(Calendar.MINUTE, 59);
			calendar.add(Calendar.SECOND, 00);
			endDateCalendar.add(Calendar.MILLISECOND, 00);
			endDate=endDateCalendar.getTime();
			    			 
			System.out.println("Before Call : startDate "+startDate.toLocaleString() +" endDate : "+endDate.toLocaleString());
			configList=new ArrayList<>();
			configList.add(obj);
			
			dummyList=new ArrayList<>();
			dummyList.add(model);
			
	 }
	 
	 @Test
	 public void whenFindByDeviceName_thenReturPreTest() 
	 {
		 IReportService reportService= mock(IReportService.class);
		 try {
			when(reportService.findReportByDeviceName(startDate,endDate,"Router")).thenReturn(dummyList);
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		 
		 int expectedTestId=1;
				
	     List<PreTestModel> testList;
		try {
			testList = reportService.findReportByDeviceName(startDate,endDate,"Router");
			 assertThat(testList.get(0).getTestid())
		     .isEqualTo(expectedTestId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	   	   
	  }
}
