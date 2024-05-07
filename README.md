# Desafio técnico da Attus - Sistema de Revendas de Veículos

Desafio proposto para a vaga de desenvolvedor backend na empresa Mobiauto. Basicamente se trata de uma API com Java e Spring Boot para o gerenciamento de revendas de veículos, com todas as operações de CRUD e regras de negócio devidas.

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
- Acessar a URL de cada endpoint para fins de teste, que são /pessoas para Pessoa e /enderecos para Endereços.


## Especificações técnicas:

- **Versão do Java:** Java 17
- **Versão do Spring Boot:** 3.2.5
- **Gerenciador de dependências:** Gradle
- **Banco de dados:** PostgreSQL
