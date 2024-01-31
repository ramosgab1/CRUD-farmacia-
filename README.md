![Proj Loja de Games](https://github.com/ramosgab1/CRUD-farmacia-/assets/151580909/955628e1-5445-4f00-934a-ef67d0c22364)
# API Backend para Farmácia.

Esta é uma API backend para uma aplicação de farmácia, que permite gerenciar categorias e produtos. Desenvolvida no Bootcamp FullStack Java React da Generation Brasil, turma 70. 

## Funcionalidades.

- CRUD (Create, Read, Update, Delete) de categorias.
- CRUD de produtos associados a categorias.

## Requisitos.

- Java JDK 8 ou superior
- Spring Boot 2.5.4
- MySQL 8 ou outro banco de dados compatível
- Insomnia ou Postman para testar a API

## Configuração do Banco de Dados.

Antes de iniciar a aplicação, certifique-se de configurar o banco de dados MySQL. Você pode encontrar o script SQL para criar as tabelas necessárias no diretório `database` deste repositório.

## Configuração da Aplicação.

1. Clone o repositório: git clone https://github.com/seu-usuario/api-farmacia.git
2. Configure as propriedades do banco de dados no arquivo `application.properties`.
3. Execute a aplicação: A API estará disponível em `http://localhost:8080`.

## Endpoints.

### Categorias.

- `GET /categorias`: Retorna todas as categorias.
- `GET /categorias/{id}`: Retorna uma categoria específica pelo ID.
- `GET /categorias/{nome}`: Retorna uma categoria específica pelo nome.
- `POST /categorias`: Cria uma nova categoria.
- `PUT /categorias/{id}`: Atualiza uma categoria existente pelo ID.
- `DELETE /categorias/{id}`: Deleta uma categoria existente pelo ID.

### Produtos.

- `GET /produtos`: Retorna todos os produtos.
- `GET /produtos/{id}`: Retorna um produto específico pelo ID.
- `GET /produtos/{nome}`: Retorna um produto específico pelo nome. 
- `POST /produtos`: Cria um novo produto.
- `PUT /produtos/{id}`: Atualiza um produto existente pelo ID.
- `DELETE /produtos/{id}`: Deleta um produto existente pelo ID.

## Contribuindo.

Contribuições são bem-vindas! Sinta-se à vontade para abrir uma issue ou enviar um pull request.
