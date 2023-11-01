<template>
  <div id="app">

    <nav>
      <div class="nav-wrapper purple darken-1">
        <a href="#" class="brand-logo center">Network Inventory</a>
      </div>
    </nav>

    <div class="container">

      <form @submit.prevent="salvar">

          <label>Serial</label>
          <input type="text" placeholder="serial" v-model="elemento.serial">
          <label>Modelo</label>
          <input type="text" placeholder="modelo" v-model="elemento.modelo">
          <label>Vendor</label>
          <input type="text" placeholder="vendor" v-model="elemento.vendor">

          <button class="waves-effect waves-light btn-small">Salvar<i class="material-icons left">save</i></button>

      </form>

      <table>

        <thead>

          <tr >
            <th>Serial</th>
            <th>Modelo</th>
            <th>Vendor</th>
            <th>OPÇÕES</th>
          </tr>

        </thead>

        <tbody>

          <tr v-for="elemento of elementos" :key="elemento.id">

            <td>{{ elemento.serial }}</td>
            <td>{{elemento.modelo }}</td>
            <td>{{elemento.vendor }}</td>
            <td>
              <button @click="editar(elemento)" class="waves-effect btn-small blue darken-1"><i class="material-icons">create</i></button>
              <button @click="remover(elemento)" class="waves-effect btn-small red darken-1"><i class="material-icons">delete_sweep</i></button>
            </td>

          </tr>

        </tbody>
      
      </table>

    </div>

  </div>
</template>

<script>
import Elementos from './service/elementos.js'

  export default {

    data(){
      return{
        elemento:{
          id:'',
          serial:'',
          modelo:'',
          vendor:''
        },
        elementos:[]
      }

    },

    mounted(){
      this.listar()
    },

    methods:{
      listar(){
        Elementos.listar().then(resposta =>{
        this.elementos = resposta.data
        })
      },
      salvar(){
        if(!this.elemento.id){
          Elementos.salvar(this.elemento).then()
          alert("Elemento Salvo!")
          this.listar()
          this.elemento={}
        }else{
          Elementos.atualizar(this.elemento).then()
          alert("Elemento Atualizado!")
          this.listar()
          this.elemento={}
        }
        
      },
      editar(elemento){
        this.elemento=elemento
      },
      remover(elemento){
        if(confirm("Deseja apagar o elemento?")){
          Elementos.apagar(elemento).then()
          alert("Elemento Removido!")
         this.listar()
        }
      }
    }
  }

</script>

<style>

</style>
