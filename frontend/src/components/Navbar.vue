<template>
  <b-navbar class="navbar" variant="faded" type="light">
    <b-navbar-brand class="brand" href="#">
      <b-icon id="cart" icon="cart-check-fill"></b-icon>
      <span>Controle de Estoque</span>
    </b-navbar-brand>

    <b-nav-item class="item" active to="/">Home</b-nav-item>
    <b-nav-item class="item" active to="/produto">
      Cadastrar Produto</b-nav-item
    >
  </b-navbar>
</template>

<script>
export default {};
</script>

<style>
.brand {
  padding-right: 1rem;
  border-right: 1px solid #707070;
}

.brand span {
  padding: 1rem;
  font-weight: bold;
}

li {
  list-style-type: none;
}

.item a {
  text-decoration: none;
  color: #333333;

  font-weight: 300;
}

.navbar {
  background-color: #f5f5f5;
  border-bottom: 1px solid #333333;
}
</style>
