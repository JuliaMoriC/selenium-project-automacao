# 🤖 Automação de Pesquisas com Selenium WebDriver

Projeto desenvolvido em Java utilizando Selenium WebDriver para automatizar pesquisas na internet, coletar resultados e armazenar as informações em uma planilha Excel.

## 📌 Sobre o projeto

A aplicação realiza pesquisas automaticamente a partir de termos armazenados em uma planilha Excel.

Durante a execução, o sistema:

- Lê os termos de pesquisa do arquivo `dados.xlsx`.
- Abre o navegador Google Chrome utilizando Selenium WebDriver.
- Executa as pesquisas automaticamente.
- Captura os títulos e links dos resultados encontrados.
- Organiza os dados coletados.
- Gera uma nova planilha chamada `resultados.xlsx`.

## 🛠️ Tecnologias utilizadas

- **Java 17** – Linguagem de programação.
- **Maven** – Gerenciamento de dependências e execução.
- **Selenium WebDriver** – Automação do navegador.
- **WebDriverManager** – Gerenciamento automático do ChromeDriver.
- **Apache POI** – Leitura e escrita de arquivos Excel.
- **JUnit 5** – Testes automatizados.

## 📂 Estrutura do projeto

```text
selenium-project-automacao/
│
├── src/
│   ├── main/
│   │   └── java/org/example/
│   │       ├── Main.java
│   │       └── LeitorExcel.java
│   │
│   └── test/
│       └── java/example/
│           ├── GoogleTest.java
│           └── LeitorExcelTest.java
│
├── dados.xlsx
├── pom.xml
├── README.md
└── .gitignore
```

## ⚙️ Como executar o projeto

### 1. Pré-requisitos

- Java JDK 17 ou superior.
- Maven instalado.
- Google Chrome instalado.
- Conexão com a internet.

### 2. Clonar o repositório

```bash
git clone URL_DO_SEU_REPOSITORIO
```

### 3. Acessar a pasta

```bash
cd selenium-project-automacao
```

### 4. Configurar as pesquisas

Preencha a primeira coluna do arquivo `dados.xlsx` com os termos que deseja pesquisar.

Mantenha o arquivo na pasta principal do projeto.

### 5. Executar os testes

```bash
mvn test
```

### 6. Executar a automação

```bash
mvn exec:java "-Dexec.mainClass=org.example.Main"
```

## 📊 Resultado esperado

Ao finalizar a execução, o sistema gera automaticamente o arquivo:

`resultados.xlsx`

A planilha contém três colunas:

| Coluna | Descrição |
|---|---|
| Pesquisa | Termo pesquisado |
| Título | Título do resultado encontrado |
| Link | Endereço do resultado |

## ⚠️ Observações

- A quantidade de resultados pode variar conforme o mecanismo de busca.
- Mecanismos de busca podem apresentar CAPTCHA ou outras verificações contra automação.
- O navegador precisa ter acesso à internet durante a execução.
- O arquivo `dados.xlsx` deve estar disponível na pasta principal do projeto.

## 👩‍💻 Desenvolvimento

Projeto acadêmico desenvolvido para praticar automação de testes e coleta de dados utilizando Java, Selenium WebDriver e planilhas Excel.

---

**Tecnologias:** Java • Selenium • Maven • Apache POI • JUnit 5