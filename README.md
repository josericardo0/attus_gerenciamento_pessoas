# Desafio técnico da Attus - Sistema de Gerenciamento de Pessoas

Desafio proposto para a vaga de desenvolvedor backend na empresa Attus. Basicamente se trata de uma funcionalidade em uma API com Java e Spring Boot para gerenciamento de pessoas e endereços, com todas as operações devidas.

## Observação

Por favor siga todo o passo a passo para testar a API em sua máquina, lendo cada etapa em "Como configurar a aplicação".


# Funcionalidades da API

## Pessoas
- [x] Criar uma pessoa
- [x] Editar uma pessoa
- [x] Consultar uma pessoa
- [x] Consultar várias pessoas

## Endereços
- [x] Criar um endereço para uma pessoa
- [x] Editar um endereço de uma pessoa
- [x] Consultar um endereço de uma pessoa
- [x] Consultar vários endereços de uma pessoa

## Endereço Principal
- [x] Indicar qual endereço será considerado o principal de uma pessoa


# Requisitos mínimos necessários

## Dados da Pessoa
- [x] Nome completo
- [x] Data de nascimento

## Endereços da Pessoa
- [x] Logradouro
- [x] CEP
- [x] Número
- [x] Cidade
- [x] Estado

# Critérios de Qualidade

## Testes
- [x] Cobertura total de condições
- [x] Cobertura de linhas de no mínimo 80%

## Boas Práticas de Programação
- [x] Respeitar os conceitos de Design Patterns
- [x] Respeitar os conceitos de SOLID
- [x] Respeitar os conceitos de Clean Code

## Arquitetura da API
- [x] Desenvolvimento no formato REST


## Como configurar a aplicação:

- Faça o clone do repositório na sua máquina, em uma pasta de sua escolha, ou baixe o .zip, extraia e abre a pasta resultante da extração na sua IDE.
- Certifique de trocar os caminhos especificados em "context" e em "Dockerfile" no arquivo docker-compose.yml de acordo com a localização do diretório raiz do projeto e do Dockerfile na sua máquina, respectivamente.
- Uma vez que estiver com o projeto aberto, execute "gradlew assemble" no terminal (sem as aspas) para buildar o projeto.
- Execute o comando docker-compose up --build para buildar a imagem e subir o contêiner logo em seguida.
- Acessar as URLs de cada endpoint para fins de teste, que são /pessoas para Pessoas e /enderecos para Endereços.
- Utilize o Postman ou outra ferramenta para teste de APIs de sua preferência.

# Exemplo de requisições para o endpoint de Pessoas

## 1. Criar uma nova pessoa:

- **Método:** POST
- **URL:** `http://localhost:8080/pessoas`
- **Corpo da Requisição (JSON):**
  ```json
  {
      "nomeCompleto": "Fulano de Tal",
      "dataNascimento": "1990-01-01",
      "enderecos": []
  }

## 2. Editar uma pessoa existente:

- **Método:** PUT
- **URL:** `http://localhost:8080/pessoas/{id}`
- **Corpo da Requisição (JSON):**
  ```json
  {
      "nomeCompleto": "Ciclano da Silva",
      "dataNascimento": "1985-05-15",
      "enderecos": []
  }
  
## 3. Consultar uma pessoa pelo id:
- **Método:** GET
- **URL:** `http://localhost:8080/pessoas/{id}`

## 4. Listar todas as pessoas:
- **Método:** GET
- **URL:** `http://localhost:8080/pessoas`


## 5. Excluir uma pessoa pelo id:
- **Método:** DELETE
- **URL:** `http://localhost:8080/pessoas/{id}`


# Exemplo de requisições para o endpoint de Endereços


## 1. Criar um novo endereço para uma pessoa:

- **Método:** POST
- **URL:** `http://localhost:8080/enderecos/{pessoaId}`
- **Corpo da Requisição (JSON):**
  ```json
  {
      "logradouro": "Rua dos Bobos",
      "cep": "12345-678",
      "numero": "0",
      "cidade": "Pindamonhangaba",
      "estado": "São Paulo"
  }

### 2. Editar um endereço existente:

- **Método:** PUT
- **URL:** `http://localhost:8080/enderecos/{id}`
- **Corpo da Requisição (JSON):**
  ```json
  {
      "logradouro": "Rua Acreana Acres",
      "cep": "98765-432",
      "numero": "456",
      "cidade": "Rio Branco",
      "estado": "Acre"
  }

### 3. Consultar um endereço pelo ID:

- **Método:** GET
- **URL:** `http://localhost:8080/enderecos/{id}`

### 4. Definir um endereço como principal para uma pessoa:

- **Método:** POST
- **URL:** `http://localhost:8080/enderecos/principal/{pessoaId}/{enderecoId}`


## Print da documentação dos endpoints com Swagger (Open API)
Você também pode acessar http://localhost:8080/swagger-ui/index.html depois que a API estiver rodando para ver os endpoints devidamente documentados.
![swagger](https://github.com/josericardo0/attus_gerenciamento_pessoas/assets/92414548/3fcfc97a-5822-44ab-ac00-1dcfe7be693f)

## Especificações técnicas:

- **Versão do Java:** Java 17
- **Versão do Spring Boot:** 3.2.5
- **Gerenciador de dependências:** Gradle
- **Banco de dados:** PostgreSQL
- **Contêiner:** Docker
