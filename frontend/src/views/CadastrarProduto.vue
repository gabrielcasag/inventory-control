<template>
  <div class="content-container">
    <b-form @submit="cadastrarProduto()" @reset="limpaForm()" v-if="show">
      <div class="title">
        Cadastro de novos produtos
      </div>

      <div class="row">
        <div class="col-md-5">
          <label>Nome</label>
          <b-form-input
            placeholder="Nome do produto"
            required
            v-model="produto.nome"
          ></b-form-input>
        </div>
      </div>
      <div class="row">
        <div class="col-md-5">
          <label>Nº de Série</label>
          <b-form-input
            placeholder="xxxxxxx"
            v-model="produto.serie"
          ></b-form-input>
        </div>
      </div>
      <div class="row">
        <div class="col-md-3">
          <label>Valor</label>
          <b-input-group prepend="R$">
            <b-form-input
              prepend="R$"
              type="text"
              placeholder="Digite o valor unitário"
              v-model="produto.valor"
            ></b-form-input>
          </b-input-group>
        </div>

        <div class="col-md-2">
          <label>Quantidade</label>
          <b-form-input
            type="number"
            min="1"
            v-model="produto.quantidade"
          ></b-form-input>
        </div>
      </div>

      <div class="row button">
        <b-button class="button" variant="outline-danger" @click="limpaForm">
          <b-icon icon="x"></b-icon>Limpar</b-button
        >
        <b-button
          class="button"
          :disabled="podeCadastrar"
          variant="outline-success"
          @click="cadastrarProduto"
          ><b-icon icon="plus"></b-icon>Cadastrar</b-button
        >
      </div>
    </b-form>
  </div>
</template>

<script>
import ProdutoService from "../services/produtoService";

export default {
  name: "CadastrarProduto",
  data() {
    return {
      produto: {
        serie: "",
        nome: "",
        valor: "",
        quantidade: 0,
      },
      show: true,
    };
  },
  methods: {
    limpaForm() {
      this.produto.serie = "";
      this.produto.nome = "";
      this.produto.valor = "";
      this.produto.quantidade = 0;
    },

    cadastrarProduto() {
      ProdutoService.cadastrar(JSON.parse(JSON.stringify(this.produto))).then(
        () => {
          alert("Produto Cadastrado!");
          this.limpaForm();
        }
      );
    },

    temCampoVazio() {
      if (
        this.produto.nome === "" ||
        this.produto.serie === "" ||
        this.produto.valor === "" ||
        this.produto.quantidade === 0
      )
        return true;
      return false;
    },
  },

  computed: {
    podeCadastrar: function() {
      return this.temCampoVazio();
    },
  },
};
</script>

<style>
.content-container {
  z-index: 999;
}

.title {
  display: flex;
  justify-content: center;
  margin: 3rem 0 0 3rem;
  text-decoration: underline;
}

.row {
  display: flex;
  align-items: center;
  justify-content: center;
}
.button {
  margin: 1rem 11rem;
  z-index: 999;
}

label {
  margin-top: 1rem;
}
</style>
