import { defaultConfig } from "../httpConfig";
import axios from 'axios';

const baseUrl = "http://localhost:8080";

/**
 * Covid API.
 */
export default class covidApi {
    /**
     * Gets global values.
     */
    static async getGlobalValues() {
        return axios.get(`${baseUrl}/global`, defaultConfig);
    }

    /**
     * Gets country values.
     */
     static async getCountryValues() {
        return axios.get(`${baseUrl}/country`, defaultConfig);
    }

    /**
     * Gets confirmed average.
     */
     static async getConfirmedAvg() {
        return axios.get(`${baseUrl}/confirmedAvg`, defaultConfig);
    }

    /**
     * Gets deaths average.
     */
     static async getDeathsAvg() {
        return axios.get(`${baseUrl}/deathsAvg`, defaultConfig);
    }

    /**
     * Gets countries deaths percent.
     */
     static async getCountriesDeathsPercent() {
        return axios.get(`${baseUrl}/countriesDeathsPercent`, defaultConfig);
    }

    /**
     * Gets export.
     */
     static async getExport() {
        return axios.get(`${baseUrl}/export`, defaultConfig);
    }
}