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
package com.onap.sdnc.reports.rest.model;

import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProtocolModel {

	
	
	@JsonProperty(value = JSONTags.TAG_COS_ENTRY_NUMBER)
	String cos_entry_number;
	@JsonProperty(value = JSONTags.TAG_DESTINATION_ADDRESS)
	String destination_address;
	@JsonProperty(value = JSONTags.TAG_SOURCE_ADDRESS)
	String source_address;
	@JsonProperty(value = JSONTags.TAG_CUSTOMER_NAME)
	String customer_name;
	

	String date;
	
	String version_id;
	
	String protocol_name;
	
	// added by bhawna

	String process_id;
	String subnet_ip;
	String area_id;
	@JsonProperty(value = JSONTags.TAG_AS_NUMBER)
	String as_number;
	@JsonProperty(value = JSONTags.TAG_ROUTER_ID)
	String router_id;
	@JsonProperty(value = JSONTags.TAG_PEER_IP)
	String peer_ip;

	HashMap<String, String> neighbors;
	HashMap<String, String> networks;
	
	List<Object> networkList;

	public ProtocolModel() {
		super();
	}

	/*
	 * @Override public String toString() { return
	 * "RouterConfigDetailsRestModel [cos_entry_number=" + cos_entry_number +
	 * ", destination_address=" + destination_address + ", source_address=" +
	 * source_address + ", customer_name=" + customer_name + "]"; }
	 */
	public String getProtocol_name() {
		return protocol_name;
	}
	
	
	public void setProtocol_name(String protocol_name) {
		this.protocol_name = protocol_name;
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

	
	public String getProcess_id() {
		return process_id;
	}

	public void setProcess_id(String process_id) {
		this.process_id = process_id;
	}

	public String getSubnet_ip() {
		return subnet_ip;
	}

	public void setSubnet_ip(String subnet_ip) {
		this.subnet_ip = subnet_ip;
	}

	public String getArea_id() {
		return area_id;
	}

	public void setArea_id(String area_id) {
		this.area_id = area_id;
	}

	public String getAs_number() {
		return as_number;
	}

	public void setAs_number(String as_number) {
		this.as_number = as_number;
	}

	public String getRouter_id() {
		return router_id;
	}

	public void setRouter_id(String router_id) {
		this.router_id = router_id;
	}

	public String getPeer_ip() {
		return peer_ip;
	}

	public void setPeer_ip(String peer_ip) {
		this.peer_ip = peer_ip;
	}

	public HashMap<String, String> getNeighbors() {
		return neighbors;
	}

	public void setNeighbors(HashMap<String, String> neighbors) {
		this.neighbors = neighbors;
	}

	public HashMap<String, String> getNetworks() {
		return networks;
	}

	public void setNetworks(HashMap<String, String> networks) {
		this.networks = networks;
	}

	public List<Object> getNetworkList() {
		return networkList;
	}

	public void setNetworkList(List<Object> networkList) {
		this.networkList = networkList;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getVersion_id() {
		return version_id;
	}

	public void setVersion_id(String version_id) {
		this.version_id = version_id;
	}


	
}

