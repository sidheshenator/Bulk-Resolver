package com.sidheshenator.bulkIPResolver;

public class IPObject {

	private String IP;
	private String DNSName;
	private String machineType;
	private boolean active;
	private boolean routable;
	
	private String countryCode;
	private String countryName;
	private String region;
	private String regionName;
	private String city;
	private String postalCode;
	private float longitude;
	private float latitude;

	
	public IPObject() {
		super();
		this.IP = null;
		this.DNSName = null;
		this.machineType = null;
		this.active = false;
		this.routable = false;
		this.countryCode = null;
		this.countryName = null;
		this.region = null;
		this.regionName = null;
		this.city = null;
		this.postalCode = null;
		this.longitude = (float) 0.0;
		this.latitude = (float) 0.0;
	}
	
	
	public String getIP() {
		return IP;
	}
	public void setIP(String iP) {
		IP = iP;
	}
	public String getDNSName() {
		return DNSName;
	}
	public void setDNSName(String dNSName) {
		DNSName = dNSName;
	}
	public String getMachineType() {
		return machineType;
	}
	public void setMachineType(String machineType) {
		this.machineType = machineType;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public boolean isRoutable() {
		return routable;
	}
	public void setRoutable(boolean routable) {
		this.routable = routable;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	
	
	public String toString()
	{
		String stringObj = null;
		stringObj = this.getIP()+"\t"+this.getDNSName()+"\t"+this.getMachineType()+"\t"+this.isActive()+"\t"+
		this.isRoutable()+"\t"+this.getCountryCode()+"\t"+this.getCountryName()+"\t"+this.getCity()+"\t"+
				this.getPostalCode()+"\t"+this.getLatitude()+"\t"+this.getLongitude()+"\n";
		return stringObj;
	}
	
}
