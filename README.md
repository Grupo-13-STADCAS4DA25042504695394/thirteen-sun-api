# Thirteen Sun API
Guia rápido para executar o projeto localmente utilizando Docker.
---
## Pré-requisitos
Antes de começar, você precisa ter instalado:
- Docker
- Docker Compose (versão integrada via `docker compose`)
- Git
---
## 1° Clone o repositório
```bash
git clone https://github.com/Grupo-13-STADCAS4DA25042504695394/thirteen-sun-api.git
cd thirteen-sun-api
```
---
## 2° Execute o projeto
```bash
docker compose up
```
Para rodar em segundo plano:
```bash
docker compose up -d
```
---
# ■ Endpoints da API
Base URL:
```
http://localhost:8080
```
---
# CUSTOMER ENDPOINTS
### Criar Customer
```http
POST /customers
```
Body:
```json
{
 "name": "Empresa Solar X",
 "email": "contato@solarx.com",
 "telefone": "1133334444"
}
```
### Listar Customers
```http
GET /customers
```
### Buscar Customer por ID
```http
GET /customers/{id}
```

### Atualizar Customer
```http
PUT /customers/{id}
```
Body:
```json
{
 "name": "Empresa Atualizada",
 "email": "novoemail@solar.com",
 "telefone": "1199998888"
}
```
### Deletar Customer
```http
DELETE /customers/{id}
```

# LEAD ENDPOINTS
### Criar Lead
```http
POST /leads
```
Body:
```json
{
 "nome": "João Silva",
 "perfilDeConsumo": 3,
 "cep": "01001-000",
 "email": "joao@email.com",
 "telefone": "11999999999"
}
```

### Listar Leads
```http
GET /leads
```
---
### Buscar Lead por ID
```http
GET /leads/{id}
```
---
### Atualizar Lead
```http
PUT /leads/{id}
```
---
### Deletar Lead
```http
DELETE /leads/{id}
```

### Filtrar por Perfil
```http
GET /leads/perfil/{perfil}
```
---


# RELACIONAMENTO
### Vincular Lead a Customer
```http
POST http://localhost:8080/customer-leads/vincular?customerId=1&leadId=2
```
### Remover vínculo
```http
DELETE http://localhost:8080/customer-leads?customerId=1&leadId=2}
```

# Códigos HTTP
- 200 OK
- 201 Created
- 204 No Content
- 400 Bad Request
- 404 Not Found
- 409 Conflict
- 500 Internal Server Error
