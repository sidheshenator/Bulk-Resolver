package com.sidheshenator.bulkIPResolver;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

import com.maxmind.geoip.*;

public class Utility {
	

	
	public static void IPResolver(IPObject obj)
	{
		try{
			InetAddress inetAddress;
              // convert address from string representation to byte array
            //byte[] b = new byte[4];
            String IPAddress = obj.getIP();
          /*  String[] bytes = IPAddress.split("[.]");
            for (int i = 0; i < bytes.length; i++)
            {
                b[i] = new Integer(bytes[i]).byteValue();
            }
            // get Internet Address of this host address
            inetAddress = InetAddress.getByAddress(b);
            */
            inetAddress = InetAddress.getByName(IPAddress);
            //set DNS name
            obj.setDNSName(inetAddress.getHostName());
            
            //set routability
            if(inetAddress.isSiteLocalAddress())
            	obj.setRoutable(true);
            else
            	obj.setRoutable(false);
            
            //set reachability
            if(inetAddress.isReachable(1000))
            	obj.setActive(true);
            else
            	obj.setActive(false);
                    
            return;
		}
		catch(IOException E){
			System.out.println("Oh Shit!");
		}
	}

	public static void getGeoLocation(IPObject obj, File geoLocationFile)
	{
		LookupService lookup;
		try {
			if(obj.isRoutable() == true)
				return;
			lookup = new LookupService(geoLocationFile,LookupService.GEOIP_MEMORY_CACHE);
			Location locationServices = lookup.getLocation(obj.getIP());
			obj.setCountryCode(locationServices.countryCode);
			obj.setCountryName(locationServices.countryName);
			obj.setCity(locationServices.city);
			obj.setPostalCode(locationServices.postalCode);
			obj.setLatitude(locationServices.latitude);
			obj.setLongitude(locationServices.longitude);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}

	}
}
