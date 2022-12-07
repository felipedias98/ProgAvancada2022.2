# Projeto Programação Avançada 2022.2
Projeto de programação avaçanda de 2022.2, Uniassau Graçãs

## Requesitos
- Java JDK v17
- Mavem
- MariaDB ou Mysql

É opcional o uso do `Git` e de uma `IDE`.

## Clonando
Você pode baixar o repositório clicando [aqui](https://github.com/felipedias98/ProgAvancada2022.2). <br>
Ou você pode usar a linha de comando para obter o repositório:

```bash
git clone https://github.com/felipedias98/ProgAvancada2022.2.git
```

## Configurando
Após obter o repositório do projeto, você pode configurar o acesso aos bancos. <br>
Crie um arquiv `.env` na raiz do projeto e preenchar com as informações do seu banco de dados: <br>
```
DB_ENDPOINT=localhost
DB_PORT=3306
DB_DATABASE=prog-avancada
DB_USERNAME=root
DB_PASSWORD=
```

## Iniciando o projeto
Com o banco de dados configurado, você pode iniciar o projeto.
Você pode iniciar o projeto pela linha de comando:
```bash
mvn spring-boot:run
```

## Documentação e Endpoints
Você pode acessar a documentação e as chamadas pelo `API.postman_collection.json`.
Você pode acessar o arquivo [API.postman_collection.json](https://github.com/felipedias98/ProgAvancada2022.2/blob/main/API.postman_collection.jsong)
