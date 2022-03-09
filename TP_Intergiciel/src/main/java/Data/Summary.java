package Data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Summary {
    private String ID;
    private Global Global;
    private List<Country> Countries;
    private Date Date;

    public Summary() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Data.Global getGlobal() {
        return Global;
    }

    public void setGlobal(Data.Global global) {
        Global = global;
    }

    public List<Country> getCountries() {
        return Countries;
    }

    public void setCountries(List<Country> countries) {
        Countries = countries;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }
}
