package Work.Repositories;

import Work.Repositories.Connections.PostgreSQLJDBC;
import Work.Repositories.Model.CountryDAO;
import Work.Repositories.Model.GlobalDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PostegreSQLRepository {

    public static void insertGlobal(GlobalDAO globalDao) {
        String sql = "DELETE FROM Global;" +
                "INSERT INTO Global(newconfirmed, totalconfirmed, newdeaths, totaldeaths, newrecovered, totalrecovered, dateMaj) " +
                "VALUES (" + globalDao.getNewConfirmed() + ", " + globalDao.getTotalConfirmed() + ", " +
                globalDao.getNewDeaths() + ", " + globalDao.getTotalDeaths() + ", " + globalDao.getNewRecovered() +
                ", " + globalDao.getTotalRecovered() + ", '" + globalDao.getDate()+ "')";

        try {
            Connection connection = PostgreSQLJDBC.getConnection();
            Statement statement = connection.createStatement();

            statement.executeUpdate(sql);

            statement.close();
            connection.close();
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insertCountries(List<CountryDAO> countriesDAO) throws SQLException {
        try {
            Connection connection = PostgreSQLJDBC.getConnection();
            Statement statement = connection.createStatement();
            for (CountryDAO countryDAO : countriesDAO) {
                String sql = "INSERT INTO Country(country, countrycode, slug, newconfirmed, totalconfirmed, newdeaths, " +
                        "totaldeaths, newrecovered, totalrecovered, dateMaj) " +
                        "VALUES ('" + countryDAO.getCountry().replace("'", "''") + "','" +
                        countryDAO.getCountryCode() +  "', '" + countryDAO.getSlug() + "', " + countryDAO.getNewConfirmed() +
                        ", " + countryDAO.getTotalConfirmed() + ", " + countryDAO.getNewDeaths() + ", " +
                        countryDAO.getTotalDeaths() + ", " + countryDAO.getNewRecovered() + ", " + countryDAO.getTotalRecovered()
                        + ", '" + countryDAO.getDate() + "') ON CONFLICT (country) DO UPDATE " +
                        "SET newconfirmed = EXCLUDED.newconfirmed," +
                        "totalconfirmed = EXCLUDED.totalconfirmed," +
                        "newdeaths = EXCLUDED.newdeaths," +
                        "totaldeaths = EXCLUDED.totaldeaths," +
                        "newrecovered = EXCLUDED.newrecovered," +
                        "totalrecovered = EXCLUDED.totalrecovered," +
                        "dateMaj = EXCLUDED.dateMaj;";

                statement.executeUpdate(sql);
            }

            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

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
                        rs.getTimestamp("Datemaj")
                );
            }
        }
        catch(Exception e) {
            System.err.println("Impossible de r??cup??rer le global : " + e.getMessage());
        }
        return result;
    }

    public static List<CountryDAO> getCountries() {
        List<CountryDAO> result = new ArrayList<>();
        try {
            Connection connection = PostgreSQLJDBC.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Country ORDER BY Country ASC;");
            while (rs.next()) {
                result.add(new CountryDAO(
                        rs.getString("Country"),
                        rs.getString("CountryCode"),
                        rs.getString("Slug"),
                        rs.getInt("NewConfirmed"),
                        rs.getInt("TotalConfirmed"),
                        rs.getInt("NewDeaths"),
                        rs.getInt("TotalDeaths"),
                        rs.getInt("NewRecovered"),
                        rs.getInt("TotalRecovered"),
                        rs.getTimestamp("Datemaj")
                ));
            }
        }
        catch(Exception e) {
            System.err.println("Impossible de r??cup??rer les pays : " + e.getMessage());
        }
        return result;
    }

    public static CountryDAO getCountry(String v_pays) {
        CountryDAO result = null;
        try {
            Connection connection = PostgreSQLJDBC.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Country WHERE Country ILIKE '" + v_pays + "';");
            if (rs.next()) {
                result = new CountryDAO(
                        rs.getString("Country"),
                        rs.getString("CountryCode"),
                        rs.getString("Slug"),
                        rs.getInt("NewConfirmed"),
                        rs.getInt("TotalConfirmed"),
                        rs.getInt("NewDeaths"),
                        rs.getInt("TotalDeaths"),
                        rs.getInt("NewRecovered"),
                        rs.getInt("TotalRecovered"),
                        rs.getTimestamp("Datemaj")
                );
            }
        }
        catch(Exception e) {
            System.err.println("Impossible de r??cup??rer un pays pr??cis : " + e.getMessage());
        }
        return result;
    }
}
