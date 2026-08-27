# Sistema Bancário em Java

Aplicação console (CLI) desenvolvida em Java puro para simular operações bancárias, gerenciamento de saldos e controle de cofrinhos virtuais. O projeto foi estruturado utilizando boas práticas de Programação Orientada a Objetos (POO) e Arquitetura MVC para garantir desacoplamento e facilidade de manutenção.

---

## Tecnologias e Conceitos Aplicados

- **Java 23**
- **Arquitetura MVC** (Model-View-Controller)
- **Result Pattern** (Tratamento padronizado de retornos de operações)
- **Collections Framework** (`List`, `ArrayList`)
- **POO Avançada** (Encapsulamento, Modifiers, Composição)
- **Tratamento de Exceções** (`try-catch` resiliente para CLI)

---

## Estrutura do Projeto (MVC)

O projeto é organizado nas seguintes camadas:

src/
└── banco/
    ├── domain/      # Entidades do sistema (Cliente, Conta, Cofrinho)
    ├── services/    # Regras de negócio e validações (DepositService, etc.)
    ├── view/        # Interface de navegação interativa no terminal
    └── Main.java    # Ponto de entrada da aplicação

---

## Funcionalidades Principais

- **Gestão de Conta:** Consulta de informações da conta e saldo atualizado.
- **Cofrinhos Virtuais:** Criação, listagem e gestão de cofrinhos organizados para metas financeiras.
- **Operações Financeiras:** Depósitos, saques e transferências (PIX) com validações em tempo de execução.
- **Retornos Estruturados:** Utilização do `OperationResult` para transporte de dados e feedbacks entre a camada de serviço e a interface.

---

## Como Executar a Aplicação

### Pré-requisitos
- **JDK 17 ou superior** (Testado no Java 23) instalado.

### Passo a passo pelo Terminal (CMD)

1. Clone este repositório:
   git clone https://github.com/SEU_USUARIO/SEU_REPOSITORIO.git

2. Navegue até a pasta das classes compiladas (ou compile os arquivos `.java`):
   cd caminho/para/o/projeto/out/production/Banco

3. Execute a classe principal informando o pacote:
   java banco.Main

---

## Próximos Passos (Evolução)

- [ ] Migração da interface CLI para uma **API REST com Spring Boot**.
- [ ] Persistência de dados utilizando **PostgreSQL** e **Spring Data JPA**.
- [ ] Gerenciamento de dependências através do **Maven**.
- [ ] Testes unitários com **JUnit 5** e **Mockito**.
