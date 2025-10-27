# 🧪 Teste Automatizado com Selenium (Java + JUnit 5)

Este projeto demonstra como automatizar um teste de busca utilizando **Selenium WebDriver**, **Java**, **JUnit 5** e **WebDriverManager**.  
Para evitar bloqueios como CAPTCHA, o teste utiliza o site **DuckDuckGo** ao invés do Google.

---

## ✅ Tecnologias utilizadas
- Java 17+
- Selenium WebDriver 4.x
- JUnit 5
- WebDriverManager
- Maven

---

## 📦 Pré-requisitos
Certifique-se de ter instalado:

- Java 17+  
  👉 `java -version`
- Maven 3.8+  
  👉 `mvn -v`
- Navegador Google Chrome atualizado

---

## 📂 Estrutura do Projeto

selenium-demo
├─ pom.xml
└─ src
└─ test
└─ java
└─ example
└─ GoogleTest.java

---

## 🧠 O que o teste faz?

1️⃣ Abre o navegador Chrome  
2️⃣ Acessa `https://duckduckgo.com`  
3️⃣ Localiza o campo de pesquisa  
4️⃣ Digita *"Selenium WebDriver"* e pressiona ENTER  
5️⃣ Valida que o título da página contém a palavra “selenium”

---

## 🧠 Explicação detalhada

> Entenda como o teste funciona internamente e o que cada anotação faz no ciclo de vida do JUnit 5.

---

### ✅ Ciclo de vida dos testes

| Anotação        | Quando executa                     | O que faz neste projeto                                                                 |
|-----------------|------------------------------------|-----------------------------------------------------------------------------------------|
| `@BeforeAll`    | **Uma vez** antes de **todos**     | Baixa e configura automaticamente o ChromeDriver com WebDriverManager.                  |
| `@BeforeEach`   | Antes de **cada** teste            | Cria nova instância do ChromeDriver, maximiza a janela e define esperas.                |
| `@AfterEach`    | Após **cada** teste                | Fecha o navegador com `driver.quit()` liberando recursos.                               |

---

### 🧪 Funcionamento do teste `devePesquisarNoGoogle`

#### 🔁 Etapas executadas pelo teste
1. Acessa o site `https://duckduckgo.com`
2. Aguarda o campo de busca ficar visível
3. Digita “Selenium WebDriver” + ENTER
4. Aguarda o título conter “Selenium WebDriver”
5. Valida que o título contém “selenium”

---

### 📊 Fluxo resumido do teste

```mermaid
flowchart LR
  A[Abrir DuckDuckGo] --> B[Aguardar campo de busca visível]
  B --> C[Digitar termo de pesquisa e ENTER]
  C --> D[Aguardar título contendo Selenium WebDriver]
  D --> E[Validar que título contém selenium]
