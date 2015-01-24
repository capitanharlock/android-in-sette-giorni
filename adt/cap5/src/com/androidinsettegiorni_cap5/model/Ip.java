package com.androidinsettegiorni_cap5.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Ip {

	@JsonProperty("YourFuckingIPAddress")
	private String ip;
	@JsonProperty("YourFuckingLocation")
	private String location;
	@JsonProperty("YourFuckingHostname")
	private String hostname;
	@JsonProperty("YourFuckingISP")
	private String isp;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getIsp() {
		return isp;
	}

	public void setIsp(String isp) {
		this.isp = isp;
	}

}
