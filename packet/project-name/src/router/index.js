import { createRouter, createWebHistory } from 'vue-router'
import MainLayout from "@/views/PageLogin.vue";


const routes = [

    {
        path: '/',
        name: 'pageLogin',
        component: MainLayout,
    },

    {
        path: '/pageProjectList',
        name: 'pageProjectList',
        component: () => import('../views/PageProjectList.vue')
    },
    {
        path: '/pageAddProject',
        name: 'pageAddProject',
        component: () => import('../views/PageAddProject.vue')
    },
]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
})

export default router
