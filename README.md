# Calculadora de IMC - API REST

API REST desenvolvida em Spring Boot para cálculo do Índice de Massa Corporal (IMC) com classificação automática.

## Tecnologias

- Java 17
- Spring Boot 3.5.6
- Maven

## Funcionalidades

- Cálculo do IMC baseado em peso e altura
- Classificação automática do IMC
- Validação de entrada com tratamento de exceções
- API REST com endpoints simples

## Endpoints

### Calcular IMC
```
GET /imc?peso={peso}&altura={altura}
```

**Exemplo:**
```
GET /imc?peso=70&altura=1.75
```

**Resposta:**
```json
{
  "imc": 22.86,
  "classificacao": "Peso normal"
}
```

### Obter Classificação
```
GET /imc/classificacao?peso={peso}&altura={altura}
```

**Exemplo:**
```
GET /imc/classificacao?peso=70&altura=1.75
```

**Resposta:**
```
Seu IMC é 22,86 → Peso normal
```

## Classificações do IMC

| IMC | Classificação |
|-----|---------------|
| < 18.5 | Abaixo do peso |
| 18.5 - 24.9 | Peso normal |
| 25.0 - 29.9 | Sobrepeso |
| 30.0 - 34.9 | Obesidade grau I |
| 35.0 - 39.9 | Obesidade grau II |
| ≥ 40.0 | Obesidade grau III (mórbida) |

## Como executar

1. Clone o repositório
2. Execute o comando:
```bash
./mvnw spring-boot:run
```
3. A API estará disponível em `http://localhost:8080`

## Validações

A API valida automaticamente:
- Peso deve ser maior que 0
- Altura deve ser maior que 0
- Altura não pode ser muito próxima de 0 (evita divisão por zero)

## Tratamento de Erros

A API retorna erros HTTP apropriados:
- `400 Bad Request` - Para dados inválidos
- `500 Internal Server Error` - Para erros internos