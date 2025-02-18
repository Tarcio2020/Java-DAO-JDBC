# Java DAO JDBC Project

Este projeto demonstra a implementação de um Data Access Object (DAO) usando JDBC em Java. Ele inclui a configuração de conexão com o banco de dados, fechamento de conexões e manipulação de exceções.

## 📁 Estrutura do Projeto

O projeto está organizado da seguinte forma:

```
Java-DAO-JDBC/
├── src/
│   ├── db/
│   │   └── DbJava.java
│   ├── model/
│   ├── dao/
│   └── application/
├── db.properties
└── README.md
```

## 📂 Arquivos e Pastas

- **src/db/DbJava.java**: Contém a classe `DbJava`, responsável por gerenciar a conexão com o banco de dados.
- **src/model/**: Contém as classes de modelo que representam as entidades do banco de dados.
- **src/dao/**: Contém as classes DAO que realizam operações de CRUD no banco de dados.
- **src/application/**: Contém a classe principal que executa a aplicação.
- **db.properties**: Arquivo de propriedades que contém as configurações de conexão com o banco de dados.

## 🔧 Classe `DbJava`

A classe `DbJava` gerencia a conexão com o banco de dados e inclui métodos para:

### ✨ Métodos

- **`getConnection()`**: Obtém a conexão com o banco de dados. Se a conexão ainda não foi estabelecida, ela é criada usando as propriedades carregadas do arquivo `db.properties`.
- **`closeConnection()`**: Fecha a conexão com o banco de dados, se estiver aberta.
- **`loadProperties()`**: Carrega as propriedades do arquivo `db.properties`.
- **`closeStatement(Statement st)`**: Fecha um objeto `Statement`.
- **`closeResultSet(ResultSet rs)`**: Fecha um objeto `ResultSet`.

### 📌 Exemplo de Uso

```java
Connection conn = DbJava.getConnection();
// Use a conexão para realizar operações no banco de dados
DbJava.closeConnection();
```

## 🛠 Configuração do Banco de Dados

O arquivo `db.properties` deve conter as seguintes propriedades:

```
dburl=jdbc:mysql://localhost:3306/seu_banco_de_dados
user=seu_usuario
password=sua_senha
```

## ⚠️ Exceções

A classe `DbJava` lança uma exceção personalizada `DbException` em caso de erros ao fechar a conexão, `Statement` ou `ResultSet`.

## ▶️ Como Executar

1. Clone o repositório:
   ```sh
   git clone https://github.com/Tarcio2020/Java-DAO-JDBC.git
   ```
2. Navegue até o diretório do projeto:
   ```sh
   cd Java-DAO-JDBC
   ```
3. Configure o arquivo `db.properties` com as informações do seu banco de dados.
4. Compile e execute a aplicação usando seu IDE ou linha de comando.

## 🤝 Contribuição

Sinta-se à vontade para contribuir com melhorias para este projeto. Faça um fork do repositório, crie um branch para suas alterações e envie um pull request.

