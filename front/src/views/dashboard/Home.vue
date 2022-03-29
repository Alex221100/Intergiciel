<template>
  <v-container fluid class="down-top-padding">
        <v-card id=card1>
          <v-card-text class="pa-5">
            <div class="d-sm-flex align-center">
              <div>
                <h3 class="title blue-grey--text text--darken-2 font-weight-regular">GET Global values</h3>
                <h6 class="subtitle-2 font-weight-light">Les valeurs globales sur le Covid 19</h6>
              </div>
            </div>
            <div>
              <v-row>
                <v-col>
                  <code>localhost:8080/global</code><br/>
                  <v-btn elevation="2" @click="getGlobalValues">Lancer</v-btn>
                </v-col>
                <v-col class=terminal>{{globalValues}}</v-col>
              </v-row>
            </div>
          </v-card-text>
        </v-card>

        <v-card id=card2>
          <v-card-text class="pa-5">
            <div class="d-sm-flex align-center">
              <div>
                <h3 class="title blue-grey--text text--darken-2 font-weight-regular">GET Country values</h3>
                <h6 class="subtitle-2 font-weight-light">Les valeurs du pays demandé sur le Covid 19</h6>
              </div>
            </div>
            <div>
              <v-row>
                <v-col>
                  <code>localhost:8080/country</code><br/>
                  <v-btn elevation="2" @click="getCountryValues">Lancer</v-btn>
                </v-col>
                <v-col class=terminal>{{countryValues}}</v-col>
              </v-row>
            </div>
          </v-card-text>
        </v-card>

        <v-card id="card3">
          <v-card-text class="pa-5">
            <div class="d-sm-flex align-center">
              <div>
                <h3 class="title blue-grey--text text--darken-2 font-weight-regular">GET Confirmed avg</h3>
                <h6 class="subtitle-2 font-weight-light">La moyenne des cas confirmés sur le Covid 19</h6>
              </div>
            </div>
            <div>
              <v-row>
                <v-col>
                  <code>localhost:8080/confirmedAvg</code><br/>
                  <v-btn elevation="2" @click="getConfirmedAvg">Lancer</v-btn>
                </v-col>
                <v-col class=terminal>{{confirmedAvg}}</v-col>
              </v-row>
            </div>
          </v-card-text>
        </v-card>

        <v-card id=card4>
          <v-card-text class="pa-5">
            <div class="d-sm-flex align-center">
              <div>
                <h3 class="title blue-grey--text text--darken-2 font-weight-regular">GET Deaths avg</h3>
                <h6 class="subtitle-2 font-weight-light">La moyenne des décés du Covid 19</h6>
              </div>
            </div>
            <div>
              <v-row>
                <v-col>
                  <code>localhost:8080/deathsAvg</code><br/>
                  <v-btn elevation="2" @click="getDeathsAvg">Lancer</v-btn>
                </v-col>
                <v-col class=terminal>{{deathsAvg}}</v-col>
              </v-row>
            </div>
          </v-card-text>
        </v-card>

        <v-card id=card5>
          <v-card-text class="pa-5">
            <div class="d-sm-flex align-center">
              <div>
                <h3 class="title blue-grey--text text--darken-2 font-weight-regular">GET Country Deaths percent</h3>
                <h6 class="subtitle-2 font-weight-light">Le pourcentage de décès par rapport aux cas confirmés du Covid 19</h6>
              </div>
            </div>
            <div>
              <v-row>
                <v-col>
                  <code>localhost:8080/countriesDeathsPercent</code><br/>
                  <v-btn elevation="2" @click="getCountriesDeathsPercent">Lancer</v-btn>
                </v-col>
                <v-col class=terminal>{{countriesDeathsPercent}}</v-col>
              </v-row>
            </div>
          </v-card-text>
        </v-card>
  </v-container>
</template>

<script>
import covidService from '../../services/covid/covidService'

export default {
  data() {
    return{
      globalValues: null,
      countryValues: null,
      confirmedAvg: null,
      deathsAvg: null,
      countriesDeathsPercent: null,
      export: null
    }
  },
  methods:{
    async getGlobalValues(){
      try{
        const response = await covidService.getGlobalValues();
        this.globalValues = response.data;
      } catch (error) {
        console.log(error);
      }
    },

    async getCountryValues(){
      try{
      const response = await covidService.getCountryValues();
      this.countryValues = response.data;
      } catch (error) {
        console.log(error);
      }
    },

    async getConfirmedAvg(){
      try{
        const response = await covidService.getConfirmedAvg();
        this.confirmedAvg = response.data;
      } catch (error) {
        console.log(error);
      }
    },

    async getDeathsAvg(){
      try{
        const response = await covidService.getDeathsAvg();
        this.deathsAvg = response.data;
      } catch (error) {
        console.log(error);
      }
    },

    async getCountriesDeathsPercent(){
      try{
        const response = await covidService.getCountriesDeathsPercent();
        this.countriesDeathsPercent = response.data;
      } catch (error) {
        console.log(error);
      }
    },

    async getExport(){
      try{
        const response = await covidService.getExport();
        this.countriesDeathsPercent = response.data;
      } catch (error) {
        console.log(error);
      }
    }
  }
}
</script>
<style scoped>
.v-card{
  margin-top: 50px;
}

.terminal{
  background:black;
  color: white
}

.v-btn{
  margin-top: 30px;
}
</style>