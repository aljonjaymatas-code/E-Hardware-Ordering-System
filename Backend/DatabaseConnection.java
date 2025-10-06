import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // ✅ Change this only if your database name is different
    private static final String URL = "jdbc:mysql://localhost:3306/ehardware_db";

    // ✅ Change this to your MySQL username
    private static final String USER = "root";

    // ✅ Change this to your MySQL password (the one you set during installation)
    private static final String PASSWORD = "root123";

    public static Connection connect() {
        try {
            // ✅ Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // ✅ Try connecting to MySQL
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Database connected successfully!");
            return conn;

        } catch (ClassNotFoundException e) {
            System.out.println("❌ JDBC Driver not found: " + e.getMessage());
            return null;

        } catch (SQLException e) {
            System.out.println("❌ Connection failed: " + e.getMessage());
            return null;
        }
    }
}
