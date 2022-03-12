<template>
  <v-navigation-drawer
    v-model="Sidebar_drawer"
    :dark="SidebarColor !== 'white'"
    :color="SidebarColor"
    mobile-break-point="960"
    clipped
    :right="$vuetify.rtl"
    mini-variant-width="70"
    :expand-on-hover="expandOnHover"
    app
    id="main-sidebar"
  >
    <v-list dense nav>
      <!---USer Area -->
      <!---Sidebar Items -->
      <v-list-item
        v-for="item in items"
        :key="item.title"
        :active-class="`success white--text`"
        link
        v-scroll-to="item.to"
      >
        <v-list-item-icon>
          <v-icon>{{ item.icon }}</v-icon>
        </v-list-item-icon>

        <v-list-item-content>
          <v-list-item-title>{{ item.title }}</v-list-item-title>
        </v-list-item-content>
      </v-list-item>
      <!---Sidebar Items -->
    </v-list>
  </v-navigation-drawer>
</template>

<script>
import { mapState } from "vuex";

export default {
  name: "Sidebar",
  props: {
    expandOnHover: {
      type: Boolean,
      default: false
    }
  },
  data: () => ({
    items: [
      {
        title: "GET Global values",
        icon: "mdi-view-dashboard",
        to: "#card1"
      },

      {
        title: "GET Country values",
        icon: "mdi-city-variant",
        to: "#card2"
      },

      {
        title: "GET Confirmed avg",
        icon: "mdi-bookmark-check",
        to: "#card3"
      },

      {
        title: "GET Deaths avg",
        icon: "mdi-death-star",
        to: "#card4"
      },

      {
        title: "GET Country Deaths percent",
        icon: "mdi-percent",
        to: "#card5"
      }
    ]
  }),
  computed: {
    ...mapState(["SidebarColor", "SidebarBg"]),
    Sidebar_drawer: {
      get() {
        return this.$store.state.Sidebar_drawer;
      },
      set(val) {
        this.$store.commit("SET_SIDEBAR_DRAWER", val);
      }
    }
  },
  watch: {
    "$vuetify.breakpoint.smAndDown"(val) {
      this.$emit("update:expandOnHover", !val);
    }
  },

  methods: {}
};
</script>
<style lang="scss">
#main-sidebar{
  box-shadow:1px 0 20px rgba(0,0,0,.08);
  -webkit-box-shadow:1px 0 20px rgba(0,0,0,.08);
  .v-navigation-drawer__border{
    display: none;
  }
  .v-list{
    padding: 8px 15px;
  }
  .v-list-item{
      &__icon--text,
      &__icon:first-child{
        justify-content: center;
        text-align: center;
        width: 20px;
        
      }
      
  }    
}
</style>