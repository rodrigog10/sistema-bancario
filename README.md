## Sistema Bancário em Java

Aplicação console (CLI) desenvolvida em Java puro para simular operações bancárias, gerenciamento de saldos e controle de cofrinhos virtuais, integrada diretamente com banco de dados relacional. O projeto foi estruturado utilizando boas práticas de Programação Orientada a Objetos (POO) e Arquitetura em Camadas (View, Service, DAO) para garantir desacoplamento, persistência real e facilidade de manutenção.

---

## Tecnologias e Conceitos Aplicados

* **Java 23**
* **Arquitetura em Camadas** (`View`, `Service`, `DAO`)
* **Banco de Dados Relacional** (PostgreSQL)
* **Persistência de Dados** (JDBC com `PreparedStatement`)
* **Hidratação de Objetos em Memória** (Sincronização de estado entre banco e aplicação após login)
* **Collections Framework** (`List`, `ArrayList`)
* **POO Avançada** (Encapsulamento, Modifiers, Composição)
* **Tratamento de Exceções** (`try-catch` resiliente para operações SQL e CLI)

---

## Estrutura do Projeto

O projeto é organizado nas seguintes camadas:

src/
└── banco/
├── connection/      # Gerenciamento de conexão com o PostgreSQL
├── dao/             # Camada de persistência (ContaBradescoDAO, CofreDAO)
├── domain/          # Entidades do sistema (Cliente, Bradesco, CofreBradesco)
├── services/        # Regras de negócio e validações (Depósito, Saque, Gestão)
├── view/            # Interface de navegação interativa no terminal
└── Main.java        # Ponto de entrada da aplicação

---

## Funcionalidades Principais

* **Autenticação e Hidratação:** Login de usuários com carregamento automático e síncrono dos cofrinhos e saldos do PostgreSQL para a memória.
* **Gestão de Conta:** Consulta de informações da conta, perfil e saldo atualizado do aplicativo.
* **Cofrinhos Virtuais:** Criação, listagem, edição de nome/objetivo e gestão individual de cofrinhos no banco de dados.
* **Operações Financeiras Integradas:** Depósitos e saques com atualização atômica e sincronizada entre a tabela da conta e a tabela de cofrinhos no banco.

---

## Como Executar a Aplicação

### Pré-requisitos

* **JDK 17 ou superior** (Testado no Java 23) instalado.
* **PostgreSQL** instalado e configurado com o banco de dados do sistema.
* Driver JDBC do PostgreSQL (`postgresql-42.7.13.jar` ou superior).

### Passo a passo pelo Terminal (CMD)

1. Clone este repositório:
git clone [https://github.com/SEU_USUARIO/SEU_REPOSITORIO.git](https://github.com/SEU_USUARIO/SEU_REPOSITORIO.git)
2. Navegue até a pasta do projeto e certifique-se de que o servidor PostgreSQL está ativo.
3. Compile e execute a classe principal informando o classpath com o driver do PostgreSQL:
java -cp ".;caminho/para/postgresql.jar" banco.Main

---

## Próximos Passos (Evolução)

* [ ] Migração da interface CLI para uma **API REST com Spring Boot**.
* [ ] Uso do **Spring Data JPA / Hibernate** para substituir o JDBC manual.
* [ ] Gerenciamento de dependências e build através do **Maven** ou **Gradle**.
* [ ] Testes unitários com **JUnit 5** e **Mockito**.
