package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Cart;
import dto.Product;
import dto.User;
import factory.ConnectionFactory;
import factory.DatabaseQuery;

public class ShoppingCartDAO {

	private static ShoppingCartDAO shoppingCartDAO = null;

	public static ShoppingCartDAO getInstance() {

		if (shoppingCartDAO == null) {
			shoppingCartDAO = new ShoppingCartDAO();
		}
		return shoppingCartDAO;
	}

	public List<Product> getAllProducts() throws SQLException, Exception {

		Connection conn = null;
		CallableStatement callStmt = null;

		try {
			conn = ConnectionFactory.getConnection();
			callStmt = conn.prepareCall(DatabaseQuery.GET_ALL_PRODUCTS);
			ResultSet result = callStmt.executeQuery();

			List<Product> productsList = new ArrayList<Product>();
			while (result.next()) {
				Product product = new Product();
				product.setProductCode(result.getInt(1));
				product.setName(result.getString(2));
				product.setPrice(result.getDouble(3));
				productsList.add(product);
			}
			return productsList;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			conn.close();
			callStmt.close();
		}
	}

	public boolean addProductToCart(Product product, User user) throws SQLException, Exception {

		Connection conn = null;
		CallableStatement callStmt = null;

		try {
			conn = ConnectionFactory.getConnection();
			callStmt = conn.prepareCall(DatabaseQuery.ADD_PRODUCT);
			callStmt.setString(1, user.getUserName());
			callStmt.setInt(2, product.getProductCode());
			callStmt.setInt(3, product.getQuantity());
			int result = callStmt.executeUpdate();

			if (result > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			conn.close();
			callStmt.close();
		}
	}

	public Cart getCart(User user) throws SQLException, Exception {

		Connection conn = null;
		CallableStatement callStmt = null;

		try {
			conn = ConnectionFactory.getConnection();
			callStmt = conn.prepareCall(DatabaseQuery.GET_CART);
			callStmt.setString(1, user.getUserName());
			ResultSet result = callStmt.executeQuery();

			Cart cart = new Cart();
			ArrayList<Product> products = new ArrayList<Product>();
			while (result.next()) {
				Product product = new Product();
				product.setProductCode(result.getInt(1));
				product.setName(result.getString(2));
				product.setPrice(result.getDouble(3));
				product.setQuantity(result.getInt(4));
				products.add(product);
			}
			cart.setProducts(products);
			return cart;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			conn.close();
			callStmt.close();
		}

	}

	public boolean updateProductQuantity(User user, Product product) throws SQLException, Exception {

		Connection conn = null;
		CallableStatement callStmt = null;

		try {
			conn = ConnectionFactory.getConnection();
			callStmt = conn.prepareCall(DatabaseQuery.UPDATE_CART);
			callStmt.setString(1, user.getUserName());
			callStmt.setInt(2, product.getProductCode());
			callStmt.setInt(3, product.getQuantity());
			int result = callStmt.executeUpdate();

			if (result > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			conn.close();
			callStmt.close();
		}
	}

	public boolean removeProductFromCart(User user, Product product) throws SQLException, Exception {

		Connection conn = null;
		CallableStatement callStmt = null;

		try {
			conn = ConnectionFactory.getConnection();
			callStmt = conn.prepareCall(DatabaseQuery.UPDATE_CART);
			callStmt.setString(1, user.getUserName());
			callStmt.setInt(2, product.getProductCode());
			callStmt.setInt(3, product.getQuantity());
			int result = callStmt.executeUpdate();

			if (result > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			conn.close();
			callStmt.close();
		}
	}
}
