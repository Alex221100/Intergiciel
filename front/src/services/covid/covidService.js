import covidApi from '@/api/http/covid/covidApi'

/**
 * Covid Service.
 */
export default class covidService {

    /**
    * Gets global values.
    */
    static async getGlobalValues() {
        return await covidApi.getGlobalValues();
    }

    /**
    * Gets country values.
    */
     static async getCountryValues() {
        return await covidApi.getCountryValues();
    }

    /**
    * Gets confirmed avg.
    */
     static async getConfirmedAvg() {
        return await covidApi.getConfirmedAvg();
    }

    /**
     * Gets deaths average.
     */
     static async getDeathsAvg() {
        return await covidApi.getDeathsAvg();
    }

    /**
     * Gets countries deaths percent.
     */
     static async getCountriesDeathsPercent() {
        return await covidApi.getCountriesDeathsPercent();
    }

    /**
     * Gets export.
     */
     static async getExport() {
        return await covidApi.getExport();
    }
}