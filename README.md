# NFe-Uploader
![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.5-brightgreen)
![AWS SDK](https://img.shields.io/badge/AWS%20SDK-2.22.0-yellow)
![Maven](https://img.shields.io/badge/Maven-3.9.6-red)

O **NFe-Uploader** é uma aplicação backend desenvolvida em Java com Spring Boot que permite o upload de arquivos XML de Notas Fiscais Eletrônicas (NF-e) diretamente para um bucket Amazon S3.
## Funcionalidades

- Upload de arquivos XML via formulário `multipart/form-data`
- Armazenamento em bucket S3 com nome único para evitar conflitos
- Retorno de URL pública configurada para abrir diretamente no navegador (`Content-Disposition: inline`)
- Suporte a arquivos `.xml` de qualquer origem de nota fiscal

## Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Amazon S3 (AWS SDK v2)
- Maven

## Endpoints

### POST `/nfe`

Faz o upload de uma nota fiscal em formato XML.

**Requisição:**

- Tipo: `multipart/form-data`
- Parâmetro: `file` (arquivo XML)

**Resposta:**

```json
{
  "url": "https://bucket-name.s3.region.amazonaws.com/nfe/arquivo.xml"
}
```

## Estrutura de Diretórios

```
src/
├── controller/        # Camada responsável por lidar com as requisições HTTP
├── dto/               # Objetos de transferência de dados (Data Transfer Objects)
├── infra/             # Implementações específicas, como repositórios e configurações externas
├── port/              # Interfaces de entrada e saída (portas) da aplicação
├── service/           # Camada de serviços com a lógica de negócio
```

## Configurações Necessárias

Crie um arquivo .env e adicione as seguintes propriedades:

```.env
AWS_ACCESS_KEY_ID=sua_access_key
AWS_SECRET_ACCESS_KEY=sua_secret_key
AWS_REGION=sua_região
AWS_BUCKET_NAME=nome_do_seu_bucket
```

Você também precisa configurar as credenciais AWS via `~/.aws/credentials` ou variáveis de ambiente.


## Configuração AWS S3

- Crie um bucket S3 na sua conta AWS  
- Atualize a variável `AWS_BUCKET_NAME` no seu `.env` ou no comando Docker  
- Garanta que suas credenciais AWS tenham permissões apropriadas para acesso ao bucket




---

## 📄 Licença

Este projeto está licenciado sob a Licença MIT.
