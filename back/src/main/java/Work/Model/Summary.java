package Work.Model;

import Work.Model.Global;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Summary {

    @JsonProperty("ID")
    private String id;

    @JsonProperty("Global")
    private Global global;

    @JsonProperty("Countries")
    private List<Country> countries;

    @JsonProperty("Date")
    private Timestamp date;

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

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Summary{" +
                "id='" + id + '\'' +
                ", global=" + global +
                ", countries=" + countries +
                ", date=" + date +
                '}';
    }
}

