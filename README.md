

markdown

# API RESTful de Gerenciamento de Oficinas

Este projeto é uma API RESTful desenvolvida em Java, criada para gerenciar oficinas mecânicas. A API permite operações CRUD (Criar, Recuperar, Atualizar e Deletar) para entidades relacionadas a oficinas, como usuários, veículos, peças, orçamentos, itens de venda, agendamentos, entre outras.

## Tecnologias Utilizadas

- **Java** - Linguagem principal de programação
- **JAX-RS** - Framework para construção de APIs RESTful
- **Maven** - Gerenciador de dependências e build
- **Grizzly2** - Servidor embutido para facilitar o desenvolvimento e teste local
- **IntelliJ IDEA** - IDE recomendada para desenvolvimento

## Pré-requisitos


- **Java JDK 8 ou superior**
- **Maven** - Para gerenciamento de dependências e build do projeto
- **IntelliJ IDEA** - Para o desenvolvimento e execução do projeto

## Instalação

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git
Navegue até o diretório do projeto:
bash
Copiar código
cd seu-repositorio
Compile e instale as dependências usando Maven:
bash
Copiar código
mvn clean install
Executando o Projeto
Para iniciar o servidor localmente, execute o seguinte comando:

bash
Copiar código
mvn exec:java
A API estará disponível em http://0.0.0.0:8080.

Endpoints da API
Abaixo estão os endpoints de cada entidade presente na API:


Veiculo
Método	Endpoint	Descrição
POST	/veiculos	Cadastra um novo veículo
GET	/veiculos/{id}	Recupera veículo pelo ID
DELETE	/veiculos/{id}	Remove veículo pelo ID
PUT	/veiculos/{id}	Atualiza veículo pelo ID

Usuario
Método	Endpoint	Descrição
POST	/usuarios	Cadastra um novo usuário
GET	/usuarios/{id}	Recupera usuário pelo ID
DELETE	/usuarios/{id}	Remove usuário pelo ID
PUT	/usuarios/{id}	Atualiza usuário pelo ID

Oficina
Método	Endpoint	Descrição
POST	/oficinas	Cadastra uma nova oficina
GET	/oficinas/{id}	Recupera oficina pelo ID
DELETE	/oficinas/{id}	Remove oficina pelo ID
PUT	/oficinas/{id}	Atualiza oficina pelo ID

Estrutura do Projeto
bash
Copiar código
src/
├── main/
│   ├── java/
│   │   ├── com/exemplo/api/
│   │   │   ├── model/          # Classes de modelo (entidades)
│   │   │   ├── dao/            # Classes DAO (acesso a dados)
│   │   │   └── resource/       # Recursos REST (endpoints)
│   └── resources/
│       └── META-INF/
│           └── persistence.xml # Configuração de persistência
└── test/                       # Testes unitários
Exemplos de Requisição e Resposta
Criar Veículo (POST /veiculos)
Requisição
json
Copiar código
{
  "marca": "Toyota",
  "modelo": "Corolla",
  "ano": 2020
}
Resposta de Sucesso
Código: 201 Created
Corpo:
json
Copiar código
{
  "marca": "Toyota",
  "modelo": "Corolla",
  "ano": 2020
}
Resposta de Erro
Código: 401 Unauthorized
Mensagem: "Erro ao cadastrar o veículo"
Testes
Para rodar os testes unitários:

bash
Copiar código
mvn test
Contribuição
Faça um fork do projeto
Crie sua branch de feature (git checkout -b feature/nova-feature)
Commit suas alterações (git commit -m 'Adiciona nova feature')
Faça o push para a branch (git push origin feature/nova-feature)
Abra um Pull Request
Licença
Este projeto está licenciado sob a Licença MIT. Consulte o arquivo LICENSE para mais detalhes.

PARCIPANTES:
Pedro Henrique Cardoso
Cauã Sanches
Tamara Boni



