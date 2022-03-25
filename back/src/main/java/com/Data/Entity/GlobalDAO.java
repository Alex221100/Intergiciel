package com.Data.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class GlobalDAO {

    private int newConfirmed;

    private int totalConfirmed;

    private int newDeaths;

    private int totalDeaths;

    private int newRecovered;

    private int totalRecovered;

    @Id
    private Date date;

    public GlobalDAO(int newConfirmed, int totalConfirmed, int newDeaths, int totalDeaths, int newRecovered, int totalRecovered, java.util.Date date) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "GlobalDAO{" +
                "newConfirmed=" + newConfirmed +
                ", totalConfirmed=" + totalConfirmed +
                ", newDeaths=" + newDeaths +
                ", totalDeaths=" + totalDeaths +
                ", newRecovered=" + newRecovered +
                ", totalRecovered=" + totalRecovered +
                ", date=" + date +
                '}';
    }
}
