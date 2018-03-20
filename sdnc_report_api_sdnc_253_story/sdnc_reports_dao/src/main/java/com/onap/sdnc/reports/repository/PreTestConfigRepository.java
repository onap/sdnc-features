
package com.onap.sdnc.reports.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.onap.sdnc.reports.model.PreTestConfig;

@Repository
public interface PreTestConfigRepository extends JpaRepository<PreTestConfig, Long> {

	/*@Query(value= " from PreTestConfig where timestamp >= :startDate and timestamp <= :endDate" )
	List<PreTestConfig> findPreTestConfigByTimeStamp(@Param("startDate") Date startDate, @Param("endDate")Date endDate);
	
	
	@Query(value= " from PreTestConfig where timestamp >= :startDate and timestamp <= :endDate  and testName = :testName" )
	List<PreTestConfig> findReportByTestName(@Param("startDate") Date startDate, @Param("endDate")Date endDate, @Param("testName")String testName);
	*/
	@Query(value= " from PreTestConfig where timestamp >= :startDate and timestamp <= :endDate  and device.deviceName = :deviceName" )
	List<PreTestConfig> findReportByDeviceName(@Param("startDate") Date startDate, @Param("endDate")Date endDate, @Param("deviceName")String deviceName);
	
	@Modifying
    @Query(value = "insert into PreTestConfig (testName,result,execuationDetails,timestamp,deviceId) VALUES (:testName,:result,:execuationDetails,:timestamp,:deviceId)", nativeQuery = true)
    @Transactional
    void logPreTestReport(@Param("testName") String testName,@Param("result") String result, @Param("execuationDetails") String  execuationDetails,@Param("timestamp") String  timestamp,@Param("deviceId") long  deviceId);
}
