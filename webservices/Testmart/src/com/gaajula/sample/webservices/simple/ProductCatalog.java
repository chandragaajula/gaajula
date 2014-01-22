package com.gaajula.sample.webservices.simple;

import java.util.List;

import javax.jws.WebService;

import com.gaajula.sample.webservices.simple.business.ProductServiceImpl;
import com.gaajula.sample.webservices.simple.model.Product;

@WebService(endpointInterface = "com.gaajula.sample.webservices.simple.ProductCatalogInterface")
public class ProductCatalog implements ProductCatalogInterface {
	ProductServiceImpl productServiceImpl = new ProductServiceImpl();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gaajula.sample.webservices.simple.ProductCatalogInterface#
	 * getProductCategories()
	 */
	@Override
	public List<String> getProductCategories() {
		return productServiceImpl.getProductCategories();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.gaajula.sample.webservices.simple.ProductCatalogInterface#getProducts
	 * (java.lang.String)
	 */
	@Override
	public List<String> getProducts(String category) {
		return productServiceImpl.getProducts(category);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.gaajula.sample.webservices.simple.ProductCatalogInterface#addProduct
	 * (java.lang.String, java.lang.String)
	 */
	@Override
	public boolean addProduct(String category, String product) {
		return productServiceImpl.addProduct(category, product);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.gaajula.sample.webservices.simple.ProductCatalogInterface#getProductsV2
	 * (java.lang.String)
	 */
	@Override
	public List<Product> getProductsV2(String category) {
		return productServiceImpl.getProductsV2(category);
	}
}
