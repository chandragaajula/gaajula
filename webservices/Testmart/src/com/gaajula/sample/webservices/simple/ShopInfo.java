package com.gaajula.sample.webservices.simple;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService(name = "ShopInfo", portName = "ShopInfoPort", serviceName = "ShopInfoService", targetNamespace = "http://www.testmart.com/shopinfo")
@SOAPBinding(style = Style.RPC)
public class ShopInfo {
	@WebMethod(exclude = false, action = "fetch_shopinfo", operationName = "getShopInfo")
	@WebResult(partName = "lookupOutput")
	public String getShopInfo(
			@WebParam(partName = "lookupInput") String property) {
		String response = "Invalid Property";
		if ("shopName".equals(property)) {
			response = "Test Mart";
		} else if ("since".equals(property)) {
			response = "Since 2012";
		}

		return response;
	}
}