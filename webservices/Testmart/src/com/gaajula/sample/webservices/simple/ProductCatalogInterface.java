package com.gaajula.sample.webservices.simple;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.gaajula.sample.webservices.simple.model.Product;

@WebService(name = "TestMartCatalog", portName = "TestMartCatalogPort", serviceName = "TestMartCatalogService", targetNamespace = "http://www.testmart.com")
public interface ProductCatalogInterface {

	@WebMethod(exclude = false, action = "fetch_categories", operationName = "fetchCategories")
	public abstract List<String> getProductCategories();

	@WebMethod(exclude = false)
	public abstract List<String> getProducts(String category);

	@WebMethod(exclude = false)
	public abstract boolean addProduct(String category, String product);

	@WebMethod(exclude = false)
	public abstract List<Product> getProductsV2(String category);
}