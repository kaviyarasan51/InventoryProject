package dao;
import Model.product;
import java.sql.*;
import ConnectionManager.ConnectionManager;

public class ProductDAO {
	public void addproduct(product product) throws ClassNotFoundException, SQLException
	{
		//1.JAVA and JDBC connect
		ConnectionManager comn=new ConnectionManager();
		Connection con =comn.establishConnection();
		
		String  sql_query="insert into product(productId,productName,minSellQuantity,price,quantity) values(?,?,?,?,?)";
		PreparedStatement ps =con.prepareStatement(sql_query);
		ps.setInt(1,product.getProductId());
		ps.setString(2, product.getProductName());
		ps.setInt(3, product.getMinSellQuantity());
		ps.setInt(4, product.getPrice());
		ps.setInt(5, product.getQuantity());
		ps.executeUpdate();
		comn.closeConnection();
	}
	public void display() throws SQLException, ClassNotFoundException
	{
		ConnectionManager comn=new ConnectionManager();
		Connection con =comn.establishConnection();
		
		//Create a statement obj to exercute a query
				Statement st = con.createStatement();
				
				//Execute the statement obj and return a query resultset
				ResultSet rs = st.executeQuery("select * from product");
				
				while(rs.next())
				{
					System.out.println(rs.getInt("productId")+" | "+rs.getString("productName")+" | "+rs.getInt("minSellQuantity")+" | "+rs.getInt("price")+" | "+rs.getInt("quantity"));
				}
				comn.closeConnection();
	}

}