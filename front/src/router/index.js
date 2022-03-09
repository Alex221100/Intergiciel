import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
    routes: [
        {
            path: '/',
            redirect: 'dashboard',
            component: () => import('@/layouts/Layout'),
            children: [
                {
                    name: 'Dashboard',
                    path: 'dashboard',
                    component: () => import('@/views/dashboard/Home'),
                },

            ]
        },

    ],
})