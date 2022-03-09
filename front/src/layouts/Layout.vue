<template>
  <v-app id="inspire">
    <Sidebar :expand-on-hover.sync="expandOnHover"></Sidebar>
    <v-content>
      <v-container class="fill-height" fluid>
        <router-view />
      </v-container>
    </v-content>

    <Footer></Footer>
  </v-app>
</template>

<script>
import Sidebar from "../components/navbar/Sidebar";
import Footer from "../components/footer/Footer";
import { mapState, mapMutations } from "vuex";
export default {
  name: "Layout",

  components: {
    Sidebar,
    Footer
  },

  props: {
    source: String
  },
  data: () => ({
    expandOnHover: false
  }),
  computed: {
    ...mapState(["Customizer_drawer"])
  },

  methods: {
    ...mapMutations({
      setCustomizerDrawer: "SET_CUSTOMIZER_DRAWER"
    })
  }
};
</script>
