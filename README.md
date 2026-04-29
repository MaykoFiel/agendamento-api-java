# 📅 API de Sistema de Agendamentos

Esta é uma API REST desenvolvida para facilitar o gerenciamento de agendamentos entre profissionais e clientes. O projeto foi construído utilizando as melhores práticas de Engenharia de Software, focando em código limpo, separação de responsabilidades (Service Layer) e facilidade de deploy.

## 🚀 Tecnologias Utilizadas

*   **Linguagem:** Java 17
*   **Framework:** Spring Boot 3+
*   **Gerenciador de Dependências:** Gradle
*   **Banco de Dados:** MySQL 8.0
*   **Documentação:** Swagger UI (OpenAPI 3)
*   **Containerização:** Docker e Docker Compose
*   **Validação de Dados:** Bean Validation (Jakarta Validation)

## 🛠️ Funcionalidades (CRUD)

*   **Cadastrar Agendamento:** Registro de profissional, cliente e data/hora.
*   **Listar Agendamentos:** Recuperação de todos os registros do banco de dados.
*   **Atualizar Agendamento:** Edição completa de informações via método PUT.
*   **Remover Agendamento:** Exclusão de registros por ID.

## 📦 Como Rodar o Projeto

### Usando Docker (Recomendado)
Se você tiver o Docker instalado, basta rodar o comando abaixo na raiz do projeto:
```bash
docker-compose up --build
