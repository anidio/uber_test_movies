# API de Localização de Filmes em São Francisco

## 📝 Descrição
API REST desenvolvida com Spring Boot que consome dados da API pública de São Francisco (SF Movies) para fornecer informações sobre locais de filmagem na cidade. O projeto oferece endpoints para busca de filmes e funcionalidade de autocompletar.

## 🛠️ Tecnologias Utilizadas
- Java 17
- Spring Boot
- Spring WebFlux
- Lombok
- Maven

## ✨ Funcionalidades
- Listagem de todos os filmes
- Filtro de filmes por título
- Autocompletar títulos de filmes (limitado a 10 sugestões)

## 📋 Pré-requisitos
- Java 17 ou superior
- Maven

## 🚀 Como Executar

1. Clone o repositório
```bash
git clone https://github.com/anidio/uber_test_movies.git

2. Entre na pasta do projeto
```
cd uber_test_movies
```
3. Execute o projeto
```
mvn spring-boot:run
```
O servidor iniciará em http://localhost:8080

## 🔍 Endpoints Disponíveis
### Listar Todos os Filmes
```
GET /movies
```
### Filtrar Filmes por Título
```
GET /movies?title=Matrix
```
### Autocompletar Títulos
```
GET /movies/autocomplete?q=Star
```
## 📥 Exemplos de Requisições
### Buscar todos os filmes
```
curl http://localhost:8080/movies
```
### Buscar filmes por título
```
curl http://localhost:8080/movies?
title=Matrix
```
### Autocompletar títulos
```
curl http://localhost:8080/movies/
autocomplete?q=Star
```
