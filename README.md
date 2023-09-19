# Projeto Farmácia

Este é o README do projeto "Farmácia", desenvolvido durante o bootcamp da Generation no curso de Desenvolvedor Java Fullstack Jr.

## Visão Geral

O projeto "Farmácia" é uma aplicação Java Fullstack que permite gerenciar categorias e produtos de uma farmácia. Ele inclui as seguintes funcionalidades:

- CRUD (Create, Read, Update, Delete) para categorias de produtos.
- CRUD para produtos, incluindo associação com categorias.
- Consulta de produtos por distribuidor.
- Consulta de produtos por categoria.
- Lista de categorias ativas.

## Tecnologias Utilizadas

- Java
- Spring Boot
- Spring Data JPA
- MySQL
- Maven

## Estrutura do Projeto

O projeto está organizado em várias partes:

- **Controller**: Contém os controladores que definem os pontos de extremidade da API.
- **Models**: Contém as classes de modelo para Categoria e Produto.
- **Repository**: Contém as interfaces que estendem o JpaRepository para Categoria e Produto.
- **Service**: Contém os serviços que implementam a lógica de negócios para Categoria e Produto.
- **FarmaciaApplication**: Classe principal que inicia a aplicação Spring Boot.
- **application.properties**: Arquivo de configuração para propriedades da aplicação.
- **pom.xml**: Arquivo de configuração do Maven que define as dependências do projeto.

## Configuração do Banco de Dados

O projeto utiliza o MySQL como banco de dados. As configurações do banco de dados podem ser encontradas no arquivo `application.properties`. Certifique-se de que o MySQL esteja instalado e configurado corretamente.

## Endpoints da API

A seguir estão os principais endpoints da API:

### Categoria

- `GET /categoria/{id}`: Obtém uma categoria por ID.
- `GET /categoria`: Obtém todas as categorias.
- `POST /categoria`: Cria uma nova categoria.
- `PUT /categoria/{id}`: Atualiza uma categoria existente por ID.
- `DELETE /categoria/{id}`: Exclui uma categoria por ID.
- `GET /categoria/ativos`: Obtém todas as categorias ativas.

### Produto

- `GET /produto/{id}`: Obtém um produto por ID.
- `GET /produto`: Obtém todos os produtos.
- `POST /produto`: Cria um novo produto.
- `PUT /produto/{id}`: Atualiza um produto existente por ID.
- `DELETE /produto/{id}`: Exclui um produto por ID.
- `GET /produto/distribuidores`: Obtém produtos por distribuidor.
- `GET /produto/categoria/{categoria}`: Obtém produtos por categoria.

## Como Executar o Projeto

1. Clone o repositório para a sua máquina local.
2. Configure o banco de dados MySQL de acordo com as configurações em `application.properties`.
3. Abra o projeto em uma IDE compatível com Spring Boot, como o Spring Tool Suite.
4. Execute a classe `FarmaciaApplication` para iniciar a aplicação.
5. Acesse os endpoints da API usando uma ferramenta como o Postman ou um navegador web.

Lembre-se de que você pode precisar ajustar as configurações de banco de dados, como nome de usuário e senha, de acordo com o seu ambiente local.
