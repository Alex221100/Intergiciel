package Data.Connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class PostgreSQLJDBC {

    private static boolean hasCreatedTables = false;

    private PostgreSQLJDBC() {}

    public static Connection getConnection() {
        Connection result = null;

        try {
            Class.forName("org.postgresql.Driver");
            result = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");

            if (!hasCreatedTables) {
                createTables();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
        }
        System.out.println("Opened database successfully");

        return result;
    }

    private static void createTables() {
        hasCreatedTables = true;
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            String sql = """                                                   
                    CREATE TABLE IF NOT EXISTS Global (
                        NewConfirmed INT, 
                        TotalConfirmed INT, 
                        NewDeaths INT, 
                        TotalDeaths INT, 
                        NewRecovered INT, 
                        TotalRecovered INT, 
                        Datemaj TIMESTAMP PRIMARY KEY
                    );
                                    
                    CREATE TABLE IF NOT EXISTS Country (
                        Country VARCHAR(200) PRIMARY KEY, 
                        CountryCode VARCHAR(6), 
                        Slug VARCHAR(200), 
                        NewConfirmed INT, 
                        TotalConfirmed INT, 
                        NewDeaths INT, 
                        TotalDeaths INT, 
                        NewRecovered INT, 
                        TotalRecovered INT, 
                        Datemaj TIMESTAMP
                    );""";
            statement.executeUpdate(sql);

            statement.close();
            connection.close();
        }
        catch (Exception e) {
            System.err.println("Impossible de créer les tables : " + e.getMessage());
        }
    }
}