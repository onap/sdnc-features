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

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.data.annotation.Id;

import com.onap.sdnc.reports.rest.model.ConfigDetailsRestModel;
import com.onap.sdnc.reports.rest.model.ProtocolModel;

public class RouterConfigDetails  implements Comparable<RouterConfigDetails>{

	@Override
	public int compareTo(RouterConfigDetails o) {
		// TODO Auto-generated method stub
		return 0;
	}

/*
	@Id
	String router_config_details_id;

	Date date;
	String version_id;
	String protocol;
	String cos_entry_number;
	String destination_address;
	String source_address;
	String customer_name;

	String process_id;
	String subnet_ip;
	String area_id;
	String as_number;
	String router_id;
	String peer_ip;

	HashMap<String, String> neighbors;
	HashMap<String, String> networks;

	List<Object> networkList;

	public static List<ConfigDetailsRestModel> fromEntityToModel(List<RouterConfigDetails> entityList) {
		List<ConfigDetailsRestModel> modelList= new ArrayList<ConfigDetailsRestModel>();
		ConfigDetailsRestModel configmodel= new ConfigDetailsRestModel();
		List<ProtocolModel> protocolmodelList= new ArrayList<ProtocolModel>();

		for (RouterConfigDetails entity : entityList) {
			ProtocolModel model = new ProtocolModel();
			//
				model.setDate(entity.getDate().toString());
			if ("ipsla".equals(entity.getProtocol())) {
				model.setVersion_id(entity.getVersion_id());
				model.setProtocol_name(entity.getProtocol());
				model.setCos_entry_number(entity.getCos_entry_number());
				model.setCustomer_name(entity.getCustomer_name());
				model.setDestination_address(entity.getDestination_address());
				model.setSource_address(entity.getSource_address());
				// routerConfigDetails.setRouter_config_details_id(String.valueOf(seqDao.getRouterConfigDetailsNextSequenceId(ROUTER_CONFIG_VERSION)));
				protocolmodelList.add(model);
			}
			if ("bgp".equals(entity.getProtocol())) {
				model.setVersion_id(entity.getVersion_id());
				model.setProtocol_name(entity.getProtocol());
				HashMap<String, String> neighbor = entity.getNeighbors();
				HashMap<String, String> neighbormap = new HashMap<String, String>();
				model.setAs_number(entity.getAs_number());
				model.setRouter_id(entity.getRouter_id());

				String as_number = neighbor.get("as_number").toString();
				String peer_ip = neighbor.get("peer_ip").toString();

				neighbormap.put("as_number", as_number);
				neighbormap.put("peer_ip", peer_ip);

				model.setNeighbors(neighbormap);
				protocolmodelList.add(model);
			}
			if ("ospf".equals(entity.getProtocol())) {
				model.setVersion_id(entity.getVersion_id());
				model.setProtocol_name(entity.getProtocol());
				HashMap<String, String> networks = entity.getNetworks();
				 HashMap<String, String> networksmap = new HashMap<String, String>();
                 String network_subnet_ip = networks.get("subnet_ip").toString();
                 String network_area_id = networks.get("area_id").toString();
                 

					networksmap.put("subnet_ip", network_subnet_ip);
					networksmap.put("area_id", network_subnet_ip);
					
					model.setNetworks(networksmap);
					model.setProcess_id(entity.getProcess_id());
					protocolmodelList.add(model);
				}
			}
		configmodel.setProtocol(protocolmodelList);
		modelList.add(configmodel);
		return modelList;
	}

	public String getRouter_config_details_id() {
		return router_config_details_id;
	}

	public void setRouter_config_details_id(String router_config_details_id) {
		this.router_config_details_id = router_config_details_id;
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

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	
	 * public String getVersion() { return version; }
	 * 
	 * public void setVersion(String version) { this.version = version; }
	 

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	public void setNeighbors(HashMap<String, String> neighbormap) {
		this.neighbors = neighbormap;
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

	@Override
	public String toString() {
		return "RouterConfigDetails [router_config_details_id=" + router_config_details_id + ",date=" + date
				+ ",protocol=" + protocol + ", cos_entry_number=" + cos_entry_number + ", destination_address="
				+ destination_address + ", source_address=" + source_address + ", customer_name=" + customer_name + "]";
	}

	//@Override
	public int compareTo(RouterConfigDetails o) {
		if (this.date.before(o.getDate()))
			return 1;
		else if (this.date.equals(o.getDate()))
			return 0;
		else
			return -1;
	}

	public String getVersion_id() {
		return version_id;
	}

	public void setVersion_id(String version_id) {
		this.version_id = version_id;
	}
*/
}
