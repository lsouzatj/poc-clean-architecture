<div align="center">

![](https://img.shields.io/badge/Status-%20Concluído-green)
</div>

<div align="center">

# POC Clean Architecture

![](https://img.shields.io/badge/Autor-Francis%20Leandro%20-brightgreen)
![](https://img.shields.io/badge/Language-java-brightgreen)
![](https://img.shields.io/badge/Framework-springboot-brightgreen)
![](https://img.shields.io/badge/Clean-Architecture-brightgreen)

</div> 

<p align="center">
    <img src="./images/clean-arch-1.jpg" height="350">
</p>

# Fundamentos 
>## O que é Clean Architecture
Clean Architecture é um conjunto de princípios de design de software desenvolvido pelo engenheiro de software e mentor de carreira Robert C. Martin, também conhecido como "Uncle Bob". Ele foi projetado para ajudar a criar sistemas de software de alta qualidade que são fáceis de manter e evoluir ao longo do tempo.
```
    - A arquitetura limpa se concentra em separar os diferentes aspectos de um sistema em camadas, 
de modo que cada camada se concentra em uma única responsabilidade. Isso ajuda a manter o sistema organizado e fácil de entender, 
e também torna mais fácil mudar ou substituir partes do sistema sem afetar outras partes.
    - A arquitetura limpa também se concentra em colocar as regras de negócio no núcleo do sistema, 
enquanto as interfaces de usuário, as bibliotecas de acesso a dados e outros componentes são colocados em camadas externas. 
Isso torna o sistema mais flexível e fácil de testar, pois as regras de negócio ficam isoladas dos detalhes de implementação.
```

## Conclusão sobre o Clean Architecture
Em resumo, a arquitetura limpa é um conjunto de princípios de design de software que visam criar sistemas de software de alta qualidade que são fáceis de manter, testar e evoluir ao longo do tempo.

>## Funcionalidades da Aplicaçao desenvolvida neste projeto

| Métodos de requisição HTTP  | Descrição                       |
|-----------------------------|---------------------------------|
| `POST`                      | Inserir cliente                 |
| `GET`                       | Listar todos os clientes salvos |
| `GET`                       | Buscar cliente por Id           |
| `PUT`                       | Atualizar cliente               |
| `DELETE`                    | Deletar cliente                 |

##  Pré -requisitos

- [ `Java 19+` ](https://www.oracle.com/java/technologies/downloads/#java19)
- [ `Maven 3+` ](https://maven.apache.org/download.cgi)
- [ `Docker-Compose` ](https://docs.docker.com/compose/install/)
- [ `Docker` ](https://www.docker.com/)
  - Imagem Apache Kafka
  - Imagem Apache ZooKeeper
  
## Tecnologias
- Java 19
- Apache Maven
- Apache ZooKeeper
- Apache Kafka
- Spring Boot 2.7.7
    - spring-boot-starter-web
    - spring-boot-starter-data-jpa
    - spring-boot-devtools
- Lombok
- H2
- Tomcat (Embedded no Spring Boot)
- Git

## Portas
| Aplicação              | Porta |
|------------------------|-------|
| poc-clean-architecture | 8020  |
| kafka                  | 9092  |
| zookeeper              | 2181  |

## Links

- Aplicação
    - http://localhost:8020

>## Setup

### Executando a aplicação com maven
- Na raiz do projeto execute o seguinte comando:
  ```
  ./mvnw clean package -DskipTests
  ```

### Gerando imagem docker
- Na raiz do projeto execute o seguinte comando para criar a imagem docker da aplicação:
```bash
docker build --tag clean-architecture .
```  

### Executar docker-compose para subir aplicação com container docker
- Dentro da pasta docker-compose, execute o seguinte comando para subir os containers:
  ```
  docker-compose up -d
  ```
- Execute o seguinte comando para verificar os status do containers docker:
  ```
  docker-compose ps
  ```
  
### Method: POST
- URL: http://localhost:8020/api/v1/person/insert
    #### Payload Request:
  ```
    {
    "name": "Teste- 01",
    "cep": "71901240"
    }
  ```

### Method: GET
- URL: http://localhost:8020/api/v1/person/findAll
### Method: GET
- URL: http://localhost:8020/api/v1/person/find/1
### Method: PUT
- URL: http://localhost:8020/api/v1/person/update/1
    #### Payload Request:
  ```
    {
        "name": "Teste-02",
        "cep": "71901060"
    }
  ```
### Method: DELETE
- URL: http://localhost:8020/api/v1/person/delete/1

>## Desenvolvedores

**Leandro D'Souza**
- LinkedIn - www.linkedin.com/in/francis-leandro-de-souza
- GitHub - https://github.com/lsouzatj
