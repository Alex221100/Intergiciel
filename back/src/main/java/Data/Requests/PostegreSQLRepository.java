package Data.Requests;

import Data.Connections.PostgreSQLJDBC;
import Data.Model.CountryDAO;
import Data.Model.GlobalDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PostegreSQLRepository {

    public static GlobalDAO getGlobal() {
        GlobalDAO result = null;

        try {
            Connection connection = PostgreSQLJDBC.getConnection();
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM Global;");
            if (rs.next()) {
                result = new GlobalDAO(
                        rs.getInt("NewConfirmed"),
                        rs.getInt("TotalConfirmed"),
                        rs.getInt("NewDeaths"),
                        rs.getInt("TotalDeaths"),
                        rs.getInt("NewRecovered"),
                        rs.getInt("TotalRecovered"),
                        rs.getDate("Date")
                );
            }
        }
        catch(Exception e) {
            System.err.println("Impossible de récupérer le global : " + e.getMessage());
        }

        return result;
    }

    public static List<CountryDAO> getCountries() {
        List<CountryDAO> result = new ArrayList<>();

        try {
            Connection connection = PostgreSQLJDBC.getConnection();
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM Countries;");
            while (rs.next()) {
                result.add(new CountryDAO(
                        rs.getString("ID"),
                        rs.getString("Country"),
                        rs.getString("CountryCode"),
                        rs.getString("Slug"),
                        rs.getInt("NewConfirmed"),
                        rs.getInt("TotalConfirmed"),
                        rs.getInt("NewDeaths"),
                        rs.getInt("TotalDeaths"),
                        rs.getInt("NewRecovered"),
                        rs.getInt("TotalRecovered"),
                        rs.getDate("Date")
                ));
            }
        }
        catch(Exception e) {
            System.err.println("Impossible de récupérer les pays : " + e.getMessage());
        }

        return result;
    }

    public static CountryDAO getCountry(String v_pays) {
        CountryDAO result = null;

        try {
            Connection connection = PostgreSQLJDBC.getConnection();
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM Countries WHERE Country = " + v_pays + ";");
            if (rs.next()) {
                result = new CountryDAO(
                        rs.getString("ID"),
                        rs.getString("Country"),
                        rs.getString("CountryCode"),
                        rs.getString("Slug"),
                        rs.getInt("NewConfirmed"),
                        rs.getInt("TotalConfirmed"),
                        rs.getInt("NewDeaths"),
                        rs.getInt("TotalDeaths"),
                        rs.getInt("NewRecovered"),
                        rs.getInt("TotalRecovered"),
                        rs.getDate("Date")
                );
            }
        }
        catch(Exception e) {
            System.err.println("Impossible de récupérer un pays précis : " + e.getMessage());
        }

        return result;
    }

    public static int insertSummary() {
        return 0;
    }

    private static int insertGlobal() {
        return 0;
    }

    private static int insertCountry() {
        return 0;
    }
}
