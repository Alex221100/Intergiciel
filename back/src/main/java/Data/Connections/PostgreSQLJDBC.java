package Data.Connections;

import java.sql.Connection;
import java.sql.DriverManager;

public class PostgreSQLJDBC {

    private PostgreSQLJDBC() {}

    public static Connection getConnection() {
        Connection result = null;

        try {
            Class.forName("org.postgresql.Driver");
            result = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb", "postgres", "postgres");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
        }
        System.out.println("Opened database successfully");

        return result;
    }

    private static void createTables() {

    }
}