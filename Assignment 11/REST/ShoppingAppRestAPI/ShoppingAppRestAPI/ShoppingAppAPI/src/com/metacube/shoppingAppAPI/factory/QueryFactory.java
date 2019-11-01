package com.metacube.shoppingAppAPI.factory;

public class QueryFactory {
	public static String getAllProductsQuery(){
		String query="SELECT ProductId , ProductName , Price , ImageUrl FROM product ; ";
		return query;
	}
	
	public static String getAllProductsQueryOfParticularCategory(){
		String query="SELECT ProductId , ProductName , Price , ImageUrl FROM product left join category on product.categoryId = category.categoryId WHERE CategoryName = ? ; ";
		return query;
	}
	
	public static String getAllCategoryQuery(){
		String query="SELECT categoryId , categoryName FROM category ; ";
		return query;
	}
}