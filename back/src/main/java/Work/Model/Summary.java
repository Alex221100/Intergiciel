package Work.Model;

import Data.Model.CountryDAO;
import Data.Model.GlobalDAO;

import java.util.Date;
import java.util.List;

public class Summary {
    private String id;
    private Global global;
    private List<Country> countries;
    private Date date;

    public Summary() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Global getGlobal() {
        return global;
    }

    public void setGlobal(Global global) {
        this.global = global;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
