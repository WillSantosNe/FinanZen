# FinanZen | Core Financial Engine

![Java](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Build](https://img.shields.io/badge/Build-Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
![Status](https://img.shields.io/badge/Status-Fase_1:_Core_Logic-yellow?style=for-the-badge)


> **"A eficiência de um sistema financeiro começa na robustez de suas estruturas de dados."**

## Visão do Produto
O **FinanZen** não é apenas um gerenciador de despesas. É um laboratório de engenharia de software focado em construir um **Core Bancário** escalável, seguro e inteligente.

O objetivo é simular a complexidade de sistemas reais (conciliação, categorização, auditoria), começando pela modelagem de domínio rica em **Java Puro (Vanilla)** e evoluindo para uma arquitetura distribuída.

### Diferenciais de Engenharia
* **Integridade Decimal:** Uso estrito de `BigDecimal` para evitar erros de arredondamento (Zero Tolerance for precision errors).
* **Independência de Framework:** O domínio do negócio é desacoplado da infraestrutura.
* **Build Automatizado:** Estrutura profissional gerenciada via Maven.

---

## Roadmap de Evolução

Este projeto segue uma progressão de maturidade técnica inspirada em sistemas bancários de alta disponibilidade.

### Fase 1: The Core (Estágio Atual)
*Foco: Pureza do Domínio e Lógica de Negócio.*
- [x] **Setup Industrial:** Estruturação de projeto via Maven.
- [x] **Precision Domain:** Modelagem com `BigDecimal` e Imutabilidade.
- [x] **Data Processing:** Algoritmos de ordenação e filtros via `Streams API`.

### Fase 2: Integration & Containers
*Foco: Conectividade, Resiliência e Infraestrutura como Código.*
- [ ] **External APIs:** Consumo de câmbio via `HttpClient` (Java Nativo).
- [ ] **Containerization:** Setup de ambiente de desenvolvimento via **Docker**.
- [ ] **Robust Exceptions:** Hierarquia de erros (Business vs. Infrastructure).
- [ ] **JSON Mapping:** Desserialização performática de dados externos.

### Fase 3: Enterprise Framework (Spring Boot)
*Foco: Profissionalização com o ecossistema líder de mercado.*
- [ ] **Persistence:** Migração para **Spring Data JPA** & PostgreSQL.
- [ ] **RESTful API:** Exposição de endpoints para consumo externo.
- [ ] **Dependency Injection:** Desacoplamento via inversão de controle.

### Fase 4: Cloud & Observability (Azure)
*Foco: Entrega de Valor em Escala e Monitorização.*
- [ ] **Cloud Deploy:** Implementação na **Azure** (App Service / SQL Database).
- [ ] **Security:** Proteção de dados sensíveis e autenticação.
- [ ] **Logs & Metrics:** Monitorização de saúde do sistema (Observabilidade).

### Fase 5: AI & Future-Proof
*Foco: Inovação e Inteligência Artificial aplicada ao negócio.*
- [ ] **FinanZen AI:** Integração com LLMs via **Spring AI** para análise preditiva de gastos.

---

## Tecnologias
* **Linguagem:** Java 21 (LTS).
* **Gerenciador de Dependências:** Apache Maven.
* **Core Concepts:** POO, Collections Framework, Clean Code.
* **Integração:** Java.net.http (HttpClient), JSON Parsing.

---

## Como Executar
Este projeto utiliza **Maven** para build e gerenciamento de dependências.

### Pré-requisitos
* Java JDK 17 ou superior.
* Maven instalado (ou use o wrapper se disponível).

### Passo a Passo

1. **Clone o repositório:**
   ```bash
   git clone [https://github.com/SEU-USUARIO/finanzen-core.git](https://github.com/SEU-USUARIO/finanzen-core.git)

2.  **Entre na pasta:**

    ```bash
    cd finanzen-core
    ```

3.  **Compile o projeto (Build):**

    ```bash
    mvn clean package
    ```

    *Isso baixará as dependências, compilará o código e verificará se não há erros.*

4.  **Execute a aplicação:**

    ```bash
    java -cp target/classes br.com.william.finanzen.main.Main
    ```

    *Ou execute diretamente pela sua IDE (IntelliJ/VS Code) rodando a classe `Main`.*

    
-----

## Autor

**William Santos** - 
*Engenheiro de Software Backend em especialização na Arquitetura Java e Ecossistema Spring.*<img width="659" height="2024" alt="image" src="https://github.com/user-attachments/assets/9a01faff-3652-48cd-9ea8-405dd81f60c2" />
