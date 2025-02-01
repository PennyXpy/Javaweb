<template>
  <div id="app">
    <!-- <nav>
      <router-link to="/">Home</router-link> |
      <router-link to="/about">About</router-link>
    </nav>
    <router-view/> -->
    <!-- <ElementView></ElementView> -->
     <cat-view></cat-view>
  </div>
</template>

<script>
import CatView from './views/catcare/CatView.vue'
export default {
  components: {
    CatView
    // ElementView: () => import('./views/element/ElementView.vue')
  }
}
</script>

<style>

</style>
