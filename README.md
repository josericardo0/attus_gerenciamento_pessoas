# Desafio técnico da Attus - Sistema de Gerenciamento de Pessoas

Desafio proposto para a vaga de desenvolvedor backend na empresa Attus. Basicamente se trata de uma funcionalidade em uma API com Java e Spring Boot para gerenciamento de pessoas e endereços, com todas as operações devida


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
- Uma vez que estiver com o projeto aberto, execute "gradle build" no terminal (sem as aspas) para buildar.
- Execute o comando docker-compose up --build para buildar e subir o contêiner logo em seguida.
- Acessar a URL de cada endpoint para fins de teste, que são /pessoas para Pessoas e /enderecos para Endereços.


## Especificações técnicas:

- **Versão do Java:** Java 17
- **Versão do Spring Boot:** 3.2.5
- **Gerenciador de dependências:** Gradle
- **Banco de dados:** PostgreSQL
