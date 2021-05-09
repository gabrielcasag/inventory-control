import { Api } from "./config";

const ProdutoService = {
  cadastrar: async (produto) => {
    return Api.post("/produto", produto);
  },

  listar: async () => {
    return Api.get("/produtos");
  },

  deletar: async (produto) => {
    return Api.delete("/produto", { data: produto });
  },

  atualizar: async (produto) => {
    return Api.put("/produto", produto);
  },
};

export default ProdutoService;
