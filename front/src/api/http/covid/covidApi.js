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
     static async getCountryValues(countryName) {
        return axios.get(`${baseUrl}/country?countryName=${countryName}`, defaultConfig);
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
        let pathName = await axios.get(`${baseUrl}/export`, defaultConfig);
        console.log(pathName.data);
        return await axios.get(`${baseUrl}${pathName.data}`, defaultConfig);
    }

    /**
     * Gets help.
     */
     static async getHelp() {
        return axios.get(`${baseUrl}/help`, defaultConfig);
    }
}