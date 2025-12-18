# FinanZen | Core Financial Engine

![Java](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Build](https://img.shields.io/badge/Build-Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
![Status](https://img.shields.io/badge/Status-Fase_2:_Integration_&_APIs-blueviolet?style=for-the-badge)
![License](https://img.shields.io/badge/License-MIT-blue?style=for-the-badge)

> **"A eficiência de um sistema financeiro começa na robustez de suas estruturas de dados."**

## Visão do Produto
O **FinanZen** não é apenas um gerenciador de despesas. É um laboratório de engenharia de software focado em construir um **Core Bancário** escalável, seguro e inteligente.

O objetivo é simular a complexidade de sistemas reais (conciliação, categorização, auditoria), começando pela modelagem de domínio rica em **Java Puro (Vanilla)** e evoluindo para uma arquitetura distribuída orquestrada por IA.

### Diferenciais de Engenharia
* **Integridade Decimal:** Uso estrito de `BigDecimal` para evitar erros de arredondamento (Zero Tolerance for precision errors).
* **Independência de Framework:** O domínio do negócio é desacoplado da infraestrutura.
* **Build Automatizado:** Estrutura profissional gerenciada via Maven.

---

## Roadmap de Evolução (A Estratégia)
Este projeto segue a trilha "Antigravity" de maturidade técnica:

### Fase 1: The Core (Concluído ✅)
Foco em **Lógica de Negócio e Estruturas de Dados em Memória**.
- [x] Setup do projeto com **Maven** (Padrão Industrial).
- [x] Modelagem de Domínio (`Transacao`, `GestorFinanceiro`).
- [x] Implementação de "Banco em Memória" utilizando `Collections` (List, Map).
- [x] Algoritmos de ordenação e filtros (uso de `Comparator` e `Streams`).

### Fase 2: The Integration (Estágio Atual 🚧)
Conectando o sistema ao mundo real e blindando contra falhas.
- [ ] Consumo de APIs Externas (Cotação de Moedas via HTTP Client).
- [ ] Deserialização de JSON e Mapeamento de DTOs (Records).
- [ ] Tratamento Robusto de Erros (Checked vs Unchecked Exceptions).
- [ ] Manipulação segura de Arquivos e Streams (I/O).

### Fase 3: The Framework
Profissionalização com o ecossistema **Spring**.
- [ ] Persistência robusta com **Spring Data JPA** e Banco Relacional.
- [ ] Exposição de API RESTful.
- [ ] Injeção de Dependência e Inversão de Controle.

### Fase 4: The Scale & AI
Foco em resiliência, sistemas distribuídos e inovação.
- [ ] Containerização com **Docker**.
- [ ] Integração com LLMs via **Spring AI** (Chatbot Financeiro).

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
*Engenheiro de Software Backend em especialização na Arquitetura Java e Ecossistema Spring.*


