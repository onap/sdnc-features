
package com.onap.sdnc.reports.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.onap.sdnc.reports.model.DeviceConfig;
import com.onap.sdnc.reports.model.PreTestConfig;
import com.onap.sdnc.reports.model.Report;

@Repository
public interface DeviceRepository extends JpaRepository<DeviceConfig, Long> {
//public interface DeviceRepository extends CrudRepository<DeviceConfig, Long> {
	//List<Report> findByLastName(String lastName);
	/*@Query(value= "from DeviceConfig where deviceName = :deviceName" )
	DeviceConfig findDeviceName(@Param("deviceName") String  deviceName);
	
	@Modifying
    @Query(value = "insert into DeviceConfig (deviceName,createdOn) VALUES (:deviceName,:createdOn)", nativeQuery = true)
    @Transactional
    void logDeviceName(@Param("deviceName") String deviceName, @Param("createdOn") String  createdOn);*/
}
