## Trabalho de Programação WEB desenvolvido por Gabriel Gasperi Casagrande

## Tecnologias Utilizadas:

### Frontend:

- [Vue.js v2.6.12](https://vuejs.org/)
- [NodeJS v12.18.2](https://nodejs.org/pt-br/download/releases/)
- [Bootstrap-vue v2.21.0](https://bootstrap-vue.org/)
- [Axios 0.21.0](https://www.npmjs.com/package/axios)
- [VueRouter](https://router.vuejs.org/)

### Backend:

- [Java 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [SpringBoot](https://spring.io/)

### Database:

- [PostgreSQL 9.1](https://www.postgresql.org/)

### Ferramentas/IDE

- [Eclipse IDE](https://www.eclipse.org/downloads/)
- [Visual Studio Code](https://code.visualstudio.com/)
- [DBeaver](https://dbeaver.io/)
- [Adobe XD](https://www.adobe.com/br/products/xd.html)
- [Insomnia Core](https://insomnia.rest/download/)

## Configurações:

- Crie o banco conectando-se ao PSQL(pelo Sql shell) com o comando abaixo
- Ou pelo DBeaver, ou sua ferramenta preferida

  ```bash
    CREATE DATABASE estoque_api
    WITH OWNER = postgres
    ENCODING = 'UTF8'
    TABLESPACE = pg_default;

    \connect estoque_api;

    create schema produtos;
  ```

- Talvez seja necessário alterar as configurações de acordo com seu local
  ```bash
    spring.datasource.url=jdbc:postgresql://localhost:5432/estoque_api
    spring.datasource.password={senha_do_seu_postgres}
  ```

## Para executar

### Backend

#### Importar o projeto na Eclipse IDE:

- File -> Import
- Procure por "Projeto Maven existente"
- Escolha o caminho do pom.xml na pasta apirest e aguarde o eclipse baixar as dependencias
- Depois é so clicar no play para o backend executar

### Frontend

- Instale as dependencias do projeto estando na pasta do frontend com:

```bash
npm install
```

- Para rodar o sistema execute

```bash
npm run serve
```

- A aplicação estará disponivel provavelmente em localhost:8081


### Screenshots

- Home page
![image](https://user-images.githubusercontent.com/52332643/117588888-c21f2400-b0fc-11eb-893b-5d943b0416a0.png)

- Product page
![image](https://user-images.githubusercontent.com/52332643/117588875-b2074480-b0fc-11eb-9a2a-9386c64913b5.png)
