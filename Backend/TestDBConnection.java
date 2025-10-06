import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestDBConnection {
    public static void main(String[] args) {
        Connection conn = DatabaseConnection.connect();
        if (conn != null) {
            System.out.println("✅ Connection Test: SUCCESS");
            try {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM products");
                while (rs.next()) {
                    System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getString("category") + " | " +
                        rs.getDouble("price") + " | " +
                        rs.getInt("quantity")
                    );
                }
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("❌ Connection Test: FAILED");
        }
    }
}
