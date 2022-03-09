import Vue from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify'
import router from './router/index'
import store from './store/index'
var  VueScrollTo  =  require ( 'vue-scrollto' ) ;

Vue.config.productionTip = false
Vue.use( VueScrollTo )

new Vue({
    vuetify,
    store,
    router,
    render: h => h(App)
}).$mount('#app')
