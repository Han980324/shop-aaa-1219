
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import SupportingDeliveryManager from "./components/listers/SupportingDeliveryCards"
import SupportingDeliveryDetail from "./components/listers/SupportingDeliveryDetail"
import SupportingInventoryManager from "./components/listers/SupportingInventoryCards"
import SupportingInventoryDetail from "./components/listers/SupportingInventoryDetail"

import OrderOrderManager from "./components/listers/OrderOrderCards"
import OrderOrderDetail from "./components/listers/OrderOrderDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/supportings/deliveries',
                name: 'SupportingDeliveryManager',
                component: SupportingDeliveryManager
            },
            {
                path: '/supportings/deliveries/:id',
                name: 'SupportingDeliveryDetail',
                component: SupportingDeliveryDetail
            },
            {
                path: '/supportings/inventories',
                name: 'SupportingInventoryManager',
                component: SupportingInventoryManager
            },
            {
                path: '/supportings/inventories/:id',
                name: 'SupportingInventoryDetail',
                component: SupportingInventoryDetail
            },

            {
                path: '/orders/orders',
                name: 'OrderOrderManager',
                component: OrderOrderManager
            },
            {
                path: '/orders/orders/:id',
                name: 'OrderOrderDetail',
                component: OrderOrderDetail
            },



    ]
})
