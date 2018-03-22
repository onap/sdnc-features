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
package com.onap.sdnc.reports.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "protocolconfig",schema="testreports")
public class ProtocolConfig implements Serializable{
	
	private static final long serialVersionUID = -3009157732242241606L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "protocolid")
	private long protocolId;

	@Column(name = "protocolname")
	private String protocolname;
	
	@Column(name = "process_id")
	private String process_id;
	
	@Column(name = "networks")
	private String networks;
	
	@Column(name = "as_number")
	private String as_number;
	
	@Column(name = "neighbors")
	private String neighbors;
	
	@Column(name = "cos_entry_number")
	private String cos_entry_number;
	
	@Column(name = "destination_address")
	private String destination_address;
	
	@Column(name = "source_address")
	private String source_address;
	
	@Column(name = "customer_name")
	private String customer_name;
	
	@Column(name = "version")
	private String version;

	//@Column(name = "creationDate")
	//private String creationDate;
	
	@ManyToOne
	@JoinColumn(name="deviceid",nullable=false)
	private DeviceConfig device;
	
	public ProtocolConfig() {
	// TODO Auto-generated constructor stub
	}

	public long getProtocolId() {
		return protocolId;
	}

	public void setProtocolId(long protocolId) {
		this.protocolId = protocolId;
	}

	public String getProtocolName() {
		return protocolname;
	}

	public void setProtocolName(String protocolName) {
		this.protocolname = protocolName;
	}

	public String getProcess_id() {
		return process_id;
	}

	public void setProcess_id(String process_id) {
		this.process_id = process_id;
	}

	public String getNetworks() {
		return networks;
	}

	public void setNetworks(String networks) {
		this.networks = networks;
	}

	public String getAs_number() {
		return as_number;
	}

	public void setAs_number(String as_number) {
		this.as_number = as_number;
	}

	public String getNeighbors() {
		return neighbors;
	}

	public void setNeighbors(String neighbors) {
		this.neighbors = neighbors;
	}

	public String getCos_entry_number() {
		return cos_entry_number;
	}

	public void setCos_entry_number(String cos_entry_number) {
		this.cos_entry_number = cos_entry_number;
	}

	public String getDestination_address() {
		return destination_address;
	}

	public void setDestination_address(String destination_address) {
		this.destination_address = destination_address;
	}

	public String getSource_address() {
		return source_address;
	}

	public void setSource_address(String source_address) {
		this.source_address = source_address;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	/*public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}*/

	public DeviceConfig getDevice() {
		return device;
	}

	public void setDevice(DeviceConfig device) {
		this.device = device;
	}

	/*@Override
	public String toString() {
		return "ProtocolConfig [protocolId=" + protocolId + ", protocolname=" + protocolname + ", process_id="
				+ process_id + ", networks=" + networks + ", as_number=" + as_number + ", neighbors=" + neighbors
				+ ", cos_entry_number=" + cos_entry_number + ", destination_address=" + destination_address
				+ ", source_address=" + source_address + ", customer_name=" + customer_name + ", version=" + version
				+ ", device=" + device + "]";
	}*/
	
	
}
