# Desafio técnico da Attus - Sistema de Gerenciamento de Pessoas

Desafio proposto para a vaga de desenvolvedor backend na empresa Attus. Basicamente se trata de uma funcionalidade em uma API com Java e Spring Boot para gerenciamento de pessoas e endereços, com todas as operações devidas.


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


## Como testar a aplicação:

- Faça o clone do repositório na sua máquina, em uma pasta de sua escolha, ou baixe o .zip, extraia e abre a pasta resultante da extração na sua IDE.
- Certifique de trocar os caminhos especificados no docker-compose em "context" e "dockerfile" de acordo com a localização do diretório do projeto e do Dockerfile na sua máquina.
- Uma vez que estiver com o projeto aberto, execute "gradlew assemble" no terminal (sem as aspas) para buildar.
- Execute o comando docker-compose up --build para buildar e subir o contêiner logo em seguida.
- Acessar a URL de cada endpoint para fins de teste, que são /pessoas para Pessoas e /enderecos para Endereços.
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

## Prints de alguns testes
![postpessoa](https://github.com/josericardo0/attus_gerenciamento_pessoas/assets/92414548/665bcbc1-a13f-448b-b6d3-17698d37b501)
![putpessoa](https://github.com/josericardo0/attus_gerenciamento_pessoas/assets/92414548/38b9e7dd-2ba1-47b9-8a35-f6a85e6b232c)
![criarendereco](https://github.com/josericardo0/attus_gerenciamento_pessoas/assets/92414548/b76d686f-c0f5-495a-bc37-41dcf4bf96f2)
![putendereco](https://github.com/josericardo0/attus_gerenciamento_pessoas/assets/92414548/269b3a5a-95e9-46b1-8279-c70764783997)
![gettodaspessoas](https://github.com/josericardo0/attus_gerenciamento_pessoas/assets/92414548/062ed432-c30f-4cbf-abe1-681ccba19cd2)
![definirendereco](https://github.com/josericardo0/attus_gerenciamento_pessoas/assets/92414548/83fda232-ce31-435a-8f6e-c8501906e3fa)








## Especificações técnicas:

- **Versão do Java:** Java 17
- **Versão do Spring Boot:** 3.2.5
- **Gerenciador de dependências:** Gradle
- **Banco de dados:** PostgreSQL
- **Contêiner:** Docker
