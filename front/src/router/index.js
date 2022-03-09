import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
    base: process.env.BASE_URL,
    routes: [
        {
            path: '/',
            redirect: 'dashboard',
            component: () => import('@/layouts/Layout'),
            children: [

                {
                    name: 'Dashboard',
                    path: 'dashboard',
                    component: () => import('@/views/dashboard/BasicDashboard'),
                },

            ]
        },

    ],
})