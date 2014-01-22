package com.gaajula.sample.webservices.simple.business;

import java.util.ArrayList;
import java.util.List;

import com.gaajula.sample.webservices.simple.model.Product;

public class ProductServiceImpl {

	List<String> bookList = new ArrayList<>();
	List<String> musicList = new ArrayList<>();
	List<String> moviesList = new ArrayList<>();

	public ProductServiceImpl() {
		bookList.add("Inferno");
		bookList.add("Joyland");
		bookList.add("The Game Of Thrones");

		musicList.add("Random Access Memories");
		musicList.add("Night Visions");
		musicList.add("Unorthodox Jukebox");

		moviesList.add("Oz the Great and Powerful");
		moviesList.add("Despicable Me");
		moviesList.add("Start Trek Into Darkness");
	}

	public List<String> getProductCategories() {
		List<String> categories = new ArrayList<>();
		categories.add("Books");
		categories.add("Music");
		categories.add("Movies");

		return categories;
	}

	public List<String> getProducts(String category) {
		switch (category) {
		case "Books":
			return bookList;
		case "Music":
			return musicList;
		case "Movies":
			return moviesList;
		}

		return null;
	}

	public List<Product> getProductsV2(String category) {
		List<Product> listProduct = new ArrayList<Product>();

		listProduct.add(new Product("XXXXXXXXXXXXX", "aaa", 111.11));
		listProduct.add(new Product("YYYYYYYYYYYYY", "bbb", 222.22));

		return listProduct;
	}

	public boolean addProduct(String category, String product) {
		switch (category) {
		case "Books":
			this.bookList.add(product);
			break;
		case "Music":
			this.musicList.add(product);
			break;
		case "Movies":
			this.moviesList.add(product);
			break;
		default:
			return false;
		}

		return true;
	}
}
