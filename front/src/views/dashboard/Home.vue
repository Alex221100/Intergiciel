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
                  <code>nom de la route</code><br/>
                  <v-btn elevation="2">Lancer</v-btn>
                </v-col>
                <v-col class=terminal>"Global": {<br/>
        "NewConfirmed": 833541,<br/>
        "TotalConfirmed": 449107234,<br/>
        "NewDeaths": 5011,<br/>
        "TotalDeaths": 6010103,<br/>
        "NewRecovered": 0,<br/>
        "TotalRecovered": 0,<br/>
        "Date": "2022-03-09T18:19:51.473Z"<br/>
    },<br/></v-col>
              </v-row>
            </div>
          </v-card-text>
        </v-card>

        <v-card >
          <v-card-text class="pa-5">
            <div class="d-sm-flex align-center">
              <div>
                <h3 class="title blue-grey--text text--darken-2 font-weight-regular">GET Country values</h3>
                <h6 class="subtitle-2 font-weight-light">Les valeurs du pays demandé sur le Covid 19</h6>
              </div>
            </div>
            <div class="mt-9">
              
            </div>
          </v-card-text>
        </v-card>

        <v-card id="element">
          <v-card-text class="pa-5">
            <div class="d-sm-flex align-center">
              <div>
                <h3 class="title blue-grey--text text--darken-2 font-weight-regular">GET Confirmed avg</h3>
                <h6 class="subtitle-2 font-weight-light">La moyenne des cas confirmés sur le Covid 19</h6>
              </div>
            </div>
            <div class="mt-9">

            </div>
          </v-card-text>
        </v-card>

        <v-card>
          <v-card-text class="pa-5">
            <div class="d-sm-flex align-center">
              <div>
                <h3 class="title blue-grey--text text--darken-2 font-weight-regular">GET Deaths avg</h3>
                <h6 class="subtitle-2 font-weight-light">La moyenne des décés du Covid 19</h6>
              </div>
            </div>
            <div class="mt-9">

            </div>
          </v-card-text>
        </v-card>

        <v-card>
          <v-card-text class="pa-5">
            <div class="d-sm-flex align-center">
              <div>
                <h3 class="title blue-grey--text text--darken-2 font-weight-regular">GET Country Deaths percent</h3>
                <h6 class="subtitle-2 font-weight-light">Le pourcentage de décès par rapport aux cas confirmés du Covid 19</h6>
              </div>
            </div>
            <div class="mt-9">

            </div>
          </v-card-text>
        </v-card>
  </v-container>
</template>


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