package com.gaajula.sample.webservices.simple;

import net.webservicex.GeoIP;
import net.webservicex.GeoIPService;
import net.webservicex.GeoIPServiceSoap;

public class IPLocationFinder {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("You need to pass in one IP Address.");
		} else {
			String ipAddress = args[0];
			GeoIPService ipService = new GeoIPService();
			GeoIPServiceSoap geoIPServiceSoap = ipService.getGeoIPServiceSoap();
			GeoIP geoIP = geoIPServiceSoap.getGeoIP(ipAddress);

			System.out.println("Country Code: " + geoIP.getCountryCode());
			System.out.println("Country Name: " + geoIP.getCountryName());
		}
	}
}