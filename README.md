# 🏅 Sport Recommender - Backend

API REST em Spring Boot para recomendação inteligente de esportes baseada em características pessoais e preferências do usuário.

## 🚀 Tecnologias

- **Java 24**
- **Spring Boot 3.5.7**
- **Spring Data JPA**
- **PostgreSQL**
- **Hibernate**
- **Maven**
- **Lombok**

## 📋 Funcionalidades

- ✅ Recomendação de esportes baseada em múltiplos critérios
- ✅ Análise de até 5 atividades favoritas do usuário
- ✅ Consideração de altura e gênero
- ✅ Sistema de pontuação por compatibilidade
- ✅ Base com 28 esportes e 12 atividades

## 🗄️ Banco de Dados

O sistema utiliza PostgreSQL com as seguintes entidades:

- **Sports**: 28 esportes cadastrados (Basquete, Futebol, Tênis, MMA, etc.)
- **Activities**: 12 atividades (correr, pular, nadar, lutar, etc.)
- **Sport_Activities**: Relacionamento entre esportes e atividades

## 🔧 Configuração

### Pré-requisitos

- Java 24 ou superior
- PostgreSQL 16
- Maven 3.8+

### Variáveis de Ambiente
```properties
SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/sport_recommender
SPRING_DATASOURCE_USERNAME=seu_usuario
SPRING_DATASOURCE_PASSWORD=sua_senha
```

### Instalação

1. Clone o repositório:
```bash
git clone https://github.com/AlvaroDultra/sport-recommender-backend.git
cd sport-recommender-backend
```

2. Configure o banco de dados no `application.properties`

3. Execute a aplicação:
```bash
mvn spring-boot:run
```

4. A API estará disponível em: `http://localhost:8080`

## 📡 Endpoints

### POST `/api/recommendations/recommend`

Recebe dados do usuário e retorna recomendação de esporte.

**Request Body:**
```json
{
  "height": 1.85,
  "gender": "male",
  "activities": ["correr", "pular", "jogar", "competir", "pensar"]
}
```

**Response:**
```json
{
  "sportName": "Basquete",
  "description": "Esporte coletivo dinâmico ideal para quem gosta de saltar...",
  "matchPercentage": 80,
  "message": "Combinação perfeita! Este esporte é ideal para você! 🎯"
}
```

### GET `/api/activities`

Lista todas as atividades disponíveis.

### GET `/api/sports`

Lista todos os esportes cadastrados.

## 🧮 Algoritmo de Recomendação

1. Filtra esportes compatíveis com altura e gênero
2. Calcula pontuação baseada em atividades correspondentes
3. Retorna o esporte com maior compatibilidade
4. Classifica resultado: 80%+ (Perfeito), 50-79% (Ótimo), <50% (Bom)

## 👨‍💻 Autor

**Álvaro Dultra**
- GitHub: [@AlvaroDultra](https://github.com/AlvaroDultra)

## 📄 Licença

Este projeto é open source e está sob a licença MIT.

---

⭐ Se este projeto foi útil, considere dar uma estrela!
