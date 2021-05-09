<template>
  <div class="table-container">
    <p>Esses são seus produtos</p>

    <b-table
      id="table"
      striped
      hover
      :items="produtos"
      :fields="fields"
      @row-clicked="mostraProduto"
    ></b-table>

    <b-modal id="produto-modal" hide-footer>
      <template #modal-title>
        <span>Detalhes sobre {{ produtoModal.nome }} </span>
      </template>
      <div class="modal-item">
        <span class="my-4">Número de série do produto: </span>
        <b-input v-if="editando" v-model="produtoModal.serie" disabled>
        </b-input>
        <i v-else>{{ produtoModal.serie }}</i>
        <br />
      </div>
      <div class="modal-item">
        <span class="my-4">Nome do produto: </span>
        <b-input v-if="editando" v-model="produtoModal.nome" type="text">
        </b-input>
        <i v-else>{{ produtoModal.nome }}</i>
        <br />
      </div>
      <div class="modal-item">
        <span class="my-4">Quantidade em estoque: </span>
        <b-input
          v-if="editando"
          v-model="produtoModal.quantidade"
          type="number"
        >
        </b-input>
        <i v-else>{{ produtoModal.quantidade }}</i>
        <br />
      </div>
      <div class="modal-item">
        <span>Valor unitário: </span>
        <b-input v-if="editando" v-model="produtoModal.valor" type="text">
        </b-input>
        <i v-else>{{ produtoModal.valor }}</i>
      </div>

      <div class="modal-btn">
        <b-button variant="outline-danger" @click="excluirProduto">
          <b-icon icon="trash"></b-icon> Excluir
        </b-button>
        <b-button variant="outline-primary" @click="editando = !editando"
          ><b-icon icon="pencil"></b-icon> Editar
        </b-button>
        <b-button
          v-if="editando"
          variant="outline-success"
          @click="atualizarProduto"
          ><b-icon icon="download"></b-icon> Salvar
        </b-button>
      </div>
    </b-modal>
  </div>
</template>

<script>
import ProdutoService from "../services/produtoService";

export default {
  name: "Home",

  data() {
    return {
      produtos: [],
      produtoModal: {
        id: 0,
        nome: "",
        serie: "",
        quantidade: 0,
        valor: "",
      },
      editando: false,
      fields: [
        { key: "serie", label: "Nº Série", sortable: "true" },
        { key: "nome", label: "Nome", sortable: "true" },
        { key: "quantidade", label: "Quantidade", sortable: "true" },
        { key: "valor", label: "Valor Un.", sortable: "true" },
      ],
    };
  },

  methods: {
    listarProdutos() {
      ProdutoService.listar().then((response) => {
        this.produtos = response.data;
      });
    },

    mostraProduto(record, index) {
      console.log(record, index);
      this.produtoModal = Object.assign({}, record);
      this.$bvModal.show("produto-modal");
    },

    excluirProduto() {
      console.log(this.produtoModal);

      ProdutoService.deletar(this.produtoModal).then(() => {
        alert("Produto Removido!");
        this.$bvModal.hide("produto-modal");
        this.editando = false;
        this.listarProdutos();
      });
    },

    atualizarProduto() {
      ProdutoService.atualizar(this.produtoModal).then(() => {
        alert("Produto Atualizado!");
        this.$bvModal.hide("produto-modal");
        this.editando = false;
        this.listarProdutos();
      });
    },
  },

  mounted() {
    this.listarProdutos();
  },
};
</script>

<style>
.table-container {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.table-container p {
  align-self: center;
  margin: 3rem 0 3rem 3rem;

  text-decoration: underline;
}

#table {
  width: 80%;
  z-index: 999;
}

#table td:hover {
  cursor: pointer;
}

.modal-item {
  margin: 0 1rem;
  font-size: 1.2rem;
}
.modal-item span {
  font-weight: 600;
  padding-bottom: 2rem;
}

.modal-btn {
  margin-top: 2rem;
  display: flex;
  align-items: center;
  justify-content: space-between;
}
</style>
