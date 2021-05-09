import Vue from "vue";
import VueRouter from "vue-router";

import Home from "../views/Home";
import CadastrarProduto from "../views/CadastrarProduto";
// import CadastrarFornecedor from "../views/CadastrarFornecedor";

Vue.use(VueRouter);

const routes = [
  {
    name: Home,
    path: "",
    component: Home,
  },
  {
    name: CadastrarProduto,
    path: "/produto",
    component: CadastrarProduto,
  },
];

const router = new VueRouter({ mode: "history", routes });

export default router;
