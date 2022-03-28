package Work.Model;

import Data.Model.CountryDAO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

public class Country {
    private String country;
    private String countryCode;
    private String Slug;
    private int newConfirmed;
    private int totalConfirmed;
    private int newDeaths;
    private int totalDeaths;
    private int newRecovered;
    private int totalRecovered;
    private Date date;

    public Country(CountryDAO countryDAO) {
        this.country = countryDAO.getCountry();
        this.countryCode = countryDAO.getCountryCode();
        this.Slug = countryDAO.getSlug();
        this.newConfirmed = countryDAO.getNewConfirmed();
        this.totalConfirmed = countryDAO.getTotalConfirmed();
        this.newDeaths = countryDAO.getNewDeaths();
        this.totalDeaths = countryDAO.getTotalDeaths();
        this.newRecovered = countryDAO.getNewRecovered();
        this.totalRecovered = countryDAO.getTotalRecovered();
        this.date = countryDAO.getDate();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getSlug() {
        return Slug;
    }

    public void setSlug(String slug) {
        this.Slug = slug;
    }

    public int getNewConfirmed() {
        return newConfirmed;
    }

    public void setNewConfirmed(int newConfirmed) {
        this.newConfirmed = newConfirmed;
    }

    public int getTotalConfirmed() {
        return totalConfirmed;
    }

    public void setTotalConfirmed(int totalConfirmed) {
        this.totalConfirmed = totalConfirmed;
    }

    public int getNewDeaths() {
        return newDeaths;
    }

    public void setNewDeaths(int newDeaths) {
        this.newDeaths = newDeaths;
    }

    public int getTotalDeaths() {
        return totalDeaths;
    }

    public void setTotalDeaths(int totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    public int getNewRecovered() {
        return newRecovered;
    }

    public void setNewRecovered(int newRecovered) {
        this.newRecovered = newRecovered;
    }

    public int getTotalRecovered() {
        return totalRecovered;
    }

    public void setTotalRecovered(int totalRecovered) {
        this.totalRecovered = totalRecovered;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
