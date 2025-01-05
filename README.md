# **Agilstore - Sistema de Gerenciamento de Produtos**

## **Descrição do Projeto**

O **Agilstore** é um sistema de gerenciamento de produtos desenvolvido para facilitar o controle de estoque em uma loja. O projeto foi implementado utilizando **Java**, **Spring Boot**, **JPA/Hibernate** e um banco de dados **MySQL**. A aplicação oferece funcionalidades para cadastrar, listar, atualizar, excluir e buscar produtos, proporcionando uma gestão eficiente e fácil de usar.

### **Funcionalidades Principais**

1. **Cadastro de Produtos**  
   Permite adicionar novos produtos ao estoque, incluindo informações como nome, categoria, preço e quantidade em estoque.

2. **Listagem de Produtos**  
   Exibe todos os produtos cadastrados no sistema com seus respectivos detalhes, como nome, categoria, preço e quantidade em estoque.

3. **Atualização de Produtos**  
   Permite modificar informações de um produto já existente, como nome, categoria, preço e quantidade, garantindo a flexibilidade de gerenciar as mudanças no estoque.

4. **Exclusão de Produtos**  
   Possibilita a exclusão de produtos do sistema, removendo itens que não fazem mais parte do estoque.

5. **Busca de Produtos**  
   Realiza a pesquisa de produtos pelo nome, permitindo a busca por nome completo ou parcial, facilitando o acesso rápido às informações do produto.

---

## **Como Utilizar**

### **Pré-requisitos**
- **Java 17** ou superior.
- **Maven** para gerenciar dependências.
- **MySQL** como banco de dados.
- **pgAdmin** ou outra ferramenta de administração de banco de dados.

### **Passos para Configurar o Projeto**

1. **Clone o Repositório**  
   Primeiro, clone o repositório para o seu ambiente local:
   ```bash
   git clone https://github.com/seu-usuario/agilstore.git
   ```

2. **Configuração do Banco de Dados MySQL**  
   - Instale o **MySQL** em sua máquina, caso ainda não tenha feito.
   - Crie um banco de dados no MySQL com o nome desejado (por exemplo, `agilstore`).
   - No arquivo `application.properties` (localizado em `src/main/resources`), configure a conexão com o banco de dados:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/agilstore
     spring.datasource.username=seu-usuario
     spring.datasource.password=sua-senha
     spring.jpa.hibernate.ddl-auto=update
     spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
     ```
   - Certifique-se de substituir `seu-usuario` e `sua-senha` pelos dados corretos de acesso ao banco de dados.

3. **Baixar Dependências**  
   Utilize o Maven para baixar as dependências do projeto:
   ```bash
   mvn clean install
   ```

4. **Executar o Projeto**  
   Para rodar o projeto localmente, basta executar a classe principal `AgilstoreApplication`:
   ```bash
   mvn spring-boot:run
   ```

5. **Utilização da Aplicação**  
   Ao iniciar o projeto, a aplicação irá exibir um menu no console onde você poderá:
   - **Cadastrar um produto**: Inserir informações de novos produtos no estoque.
   - **Listar produtos**: Visualizar todos os produtos cadastrados.
   - **Atualizar um produto**: Alterar as informações de um produto existente.
   - **Excluir um produto**: Remover um produto do estoque.
   - **Buscar por produto**: Realizar uma busca por nome de produto, permitindo consultas rápidas.

---

## **Tecnologias Utilizadas**
- **Java 17**: Linguagem de programação para o desenvolvimento da aplicação.
- **Spring Boot**: Framework utilizado para facilitar a criação da aplicação.
- **Spring Data JPA**: Para a implementação das interações com o banco de dados.
- **MySQL**: Banco de dados relacional utilizado para armazenar as informações dos produtos.

---

## **Estrutura do Projeto**

- **`src/main/java/br/com/agilstore/agilstore/principal`**: Contém a classe principal `Principal`, que gerencia a interação com o usuário via console.
- **`src/main/java/br/com/agilstore/agilstore/model`**: Define as entidades, como a classe `Produto` e o enum `TipoCategoria`.
- **`src/main/java/br/com/agilstore/agilstore/repository`**: Contém o repositório `ProdutoRepository` para interagir com o banco de dados.
- **`src/main/resources`**: Contém o arquivo `application.properties` para configurar o acesso ao banco de dados.

---

## **Considerações Finais**

Esse projeto oferece uma solução simples para o gerenciamento de produtos em uma loja, utilizando as melhores práticas de desenvolvimento em Java. Ele permite que um novo usuário, mesmo sem experiência prévia no código, configure e execute a aplicação rapidamente, integrando-a com um banco de dados para gerenciar produtos de forma eficiente.
