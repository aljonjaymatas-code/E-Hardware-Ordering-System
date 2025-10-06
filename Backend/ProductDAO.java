import java.sql.*;
import java.util.*;

public class ProductDAO {

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM products";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            // This is the while loop that reads each row from the ResultSet
            while (rs.next()) {
                Product p = new Product();           // create a new Product object
                p.setId(rs.getInt("id"));            // set ID
                p.setName(rs.getString("name"));     // set name
                p.setCategory(rs.getString("category")); // set category
                p.setPrice(rs.getDouble("price"));   // set price
                p.setStock(rs.getInt("stock"));      // set stock
                products.add(p);                     // add product to the list
            }

        } catch (SQLException e) {
            e.printStackTrace(); // or use proper logging
        }

        return products; // return the list of products
    }
}
