<template>
  <div id="app">
    <Background />
    <Navbar />
    <router-view />
  </div>
</template>

<script>
import Navbar from "./components/Navbar";
import Background from "./components/Background";

export default {
  name: "App",
  components: {
    Navbar,
    Background,
  },
};
</script>

<style>
#app {
  font-family: "Segoe UI", Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;

  font-size: 1.3rem;
  color: #333333;

  z-index: 9;
}

body {
  background-color: #fafafa;
}
</style>
