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
                <v-col class=terminal>
                  <p v-html="globalValues"></p>
                </v-col>
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
                  <code>localhost:8080/country?countryName={{countryName}}</code><br/>
                  <v-col
                    class="d-flex"
                    cols="12"
                    sm="6"
                  >
                    <v-select
                      :items="countriesName"
                      v-model="countryName"
                      label="Country"
                      outlined
                    ></v-select>
                  </v-col>
                  <v-btn elevation="2" @click="getCountryValues">Lancer</v-btn>
                </v-col>
                <v-col class=terminal>
                  <p v-html="countryValues"></p>
                </v-col>
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
                <v-col class=terminal>
                  <p v-html="countriesDeathsPercent"></p>
                </v-col>
              </v-row>
            </div>
          </v-card-text>
        </v-card>

        <v-card id=card6>
          <v-card-text class="pa-5">
            <div class="d-sm-flex align-center">
              <div>
                <h3 class="title blue-grey--text text--darken-2 font-weight-regular">GET Export</h3>
                <h6 class="subtitle-2 font-weight-light">L'exportation des données de la base de données en XML</h6>
              </div>
            </div>
            <div>
              <v-row>
                <v-col>
                  <code>localhost:8080/export</code><br/>
                  <v-btn elevation="2" @click.prevent="getExport">Lancer et télécharger</v-btn>
                </v-col>
                <v-col class=terminal>
                  {{exportDatabase}}
                </v-col>
              </v-row>
            </div>
          </v-card-text>
        </v-card>

        <v-card id=card7>
          <v-card-text class="pa-5">
            <div class="d-sm-flex align-center">
              <div>
                <h3 class="title blue-grey--text text--darken-2 font-weight-regular">GET Help</h3>
                <h6 class="subtitle-2 font-weight-light">Affichage des commandes et leurs explications.</h6>
              </div>
            </div>
            <div>
              <v-row>
                <v-col>
                  <code>localhost:8080/help</code><br/>
                  <v-btn elevation="2" @click="getHelp">Lancer</v-btn>
                </v-col>
                <v-col class=terminal>
                  <p v-html="help"></p>
                </v-col>
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
      exportDatabase: null,
      countriesName: ['Afghanistan', 'Albania', 'Algeria', 'Andorra', 'Angola', 'Antarctica', 'Antigua and Barbuda', 
      'Argentina', 'Armenia', 'Australia', 'Austria', 'Azerbaijan', 'Bahamas', 'Bahrain', 'Bangladesh', 'Barbados', 
      'Belarus', 'Belgium', 'Belize', 'Benin', 'Bhutan', 'Bolivia', 'Bosnia and Herzegovina', 'Botswana', 'Brazil', 
      'Brunei Darussalam', 'Bulgaria', 'Burkina Faso', 'Burundi', 'Cambodia', 'Cameroon', 'Canada', 'Cape Verde', 
      'Central African Republic', 'Chad', 'Chile', 'China', 'Colombia', 'Comoros', 'Congo (Brazzaville)', 
      'Congo (Kinshasa)', 'Costa Rica', 'Croatia', 'Cuba', 'Cyprus', 'Czech Republic', 'Côte d Ivoire', 
      'Denmark', 'Djibouti', 'Dominica', 'Dominican Republic', 'Ecuador', 'Egypt', 'El Salvador', 'Equatorial Guinea', 
      'Eritrea', 'Estonia', 'Ethiopia', 'Fiji', 'Finland', 'France', 'Gabon', 'Gambia', 'Georgia', 'Germany', 'Ghana', 
      'Greece', 'Grenada', 'Guatemala', 'Guinea', 'Guinea-Bissau', 'Guyana', 'Haiti', 'Holy See (Vatican City State)', 
      'Honduras', 'Hungary', 'Iceland', 'India', 'Indonesia', 'Iran, Islamic Republic of', 'Iraq', 'Ireland', 'Israel', 
      'Italy', 'Jamaica', 'Japan', 'Jordan', 'Kazakhstan', 'Kenya', 'Kiribati', 'Korea (South)', 'Kuwait', 'Kyrgyzstan', 
      'Lao PDR', 'Latvia', 'Lebanon', 'Lesotho', 'Liberia', 'Libya', 'Liechtenstein', 'Lithuania', 'Luxembourg', 
      'Macedonia, Republic of', 'Madagascar', 'Malawi', 'Malaysia', 'Maldives', 'Mali', 'Malta', 'Marshall Islands', 
      'Mauritania', 'Mauritius', 'Mexico', 'Micronesia, Federated States of', 'Moldova', 'Monaco', 'Mongolia', 
      'Montenegro', 'Morocco', 'Mozambique', 'Myanmar', 'Namibia', 'Nepal', 'Netherlands', 'New Zealand', 'Nicaragua', 
      'Niger', 'Nigeria', 'Norway', 'Oman', 'Pakistan', 'Palau', 'Palestinian Territory', 'Panama', 'Papua New Guinea', 
      'Paraguay', 'Peru', 'Philippines', 'Poland', 'Portugal', 'Qatar', 'Republic of Kosovo', 'Romania', 
      'Russian Federation', 'Rwanda', 'Saint Kitts and Nevis', 'Saint Lucia', 'Saint Vincent and Grenadines', 
      'Samoa', 'San Marino', 'Sao Tome and Principe', 'Saudi Arabia', 'Senegal', 'Serbia', 'Seychelles', 'Sierra Leone', 
      'Singapore', 'Slovakia', 'Slovenia', 'Solomon Islands', 'Somalia', 'South Africa', 'South Sudan', 'Spain', 
      'Sri Lanka', 'Sudan', 'Suriname', 'Swaziland', 'Sweden', 'Switzerland', 'Syrian Arab Republic (Syria)', 
      'Taiwan, Republic of China', 'Tajikistan', 'Tanzania, United Republic of', 'Thailand', 'Timor-Leste', 'Togo', 
      'Tonga', 'Trinidad and Tobago', 'Tunisia', 'Turkey', 'Uganda', 'Ukraine', 'United Arab Emirates', 'United Kingdom',
       'United States of America', 'Uruguay', 'Uzbekistan', 'Vanuatu', 'Venezuela (Bolivarian Republic)', 'Viet Nam', 
       'Yemen', 'Zambia', 'Zimbabwe'],
       countryName: "Afghanistan",
       help: null
    }
  },
  methods:{
    async getGlobalValues(){
      try{
        const response = await covidService.getGlobalValues();
        this.globalValues = this.formatJson(response.data);
      } catch (error) {
        console.log(error);
      }
    },

    async getCountryValues(){
      try{
      const response = await covidService.getCountryValues(this.countryName);
      this.countryValues = this.formatJson(response.data);
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
        this.countriesDeathsPercent = this.formatJson(response.data);
      } catch (error) {
        console.log(error);
      }
    },

    async getExport(){
      try{
        const response = await covidService.getExport();
        console.log(response);
        this.exportDatabase = response.data;
        this.downloadFile();
      } catch (error) {
        console.log(error);
      }
    },

    downloadFile () {
      const blob = new Blob([this.exportDatabase], { type: "text/xml" });
      const link = document.createElement("a");
      link.href = URL.createObjectURL(blob);
      link.download = "database-export";
      link.click();
      URL.revokeObjectURL(link.href);
    },

    async getHelp(){
      try{
        const response = await covidService.getHelp();
        this.help = response.data;
      } catch (error) {
        console.log(error);
      }
    },
    
    formatJson(json){
      var formattedString = json.split(",").join("<br />")
      return(formattedString)
    }

   
  },
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