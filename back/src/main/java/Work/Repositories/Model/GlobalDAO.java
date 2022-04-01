package Work.Repositories.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GlobalDAO {

    @JsonProperty("NewConfirmed")
    private int newConfirmed;

    @JsonProperty("TotalConfirmed")
    private int totalConfirmed;

    @JsonProperty("NewDeaths")
    private int newDeaths;

    @JsonProperty("TotalDeaths")
    private int totalDeaths;

    @JsonProperty("NewRecovered")
    private int newRecovered;

    @JsonProperty("TotalRecovered")
    private int totalRecovered;

    @JsonProperty("Date")
    private Timestamp date;

    public GlobalDAO() {
    }

    public GlobalDAO(int newConfirmed, int totalConfirmed, int newDeaths, int totalDeaths, int newRecovered, int totalRecovered, Timestamp date) {
        this.newConfirmed = newConfirmed;
        this.totalConfirmed = totalConfirmed;
        this.newDeaths = newDeaths;
        this.totalDeaths = totalDeaths;
        this.newRecovered = newRecovered;
        this.totalRecovered = totalRecovered;
        this.date = date;
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

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
