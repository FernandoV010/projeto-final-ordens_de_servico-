# viaOS

| | |
|---|---|
| **Aluno(a)** | Fernando Antonio Viana de Queiroz Junior |
| **Turma** | TEC-N-001788/2026 |
| **Opção escolhida** | Ordens de Serviço |
| **Versão atual** | 0.1.0 |

---

## 1. Visão geral

### 1.1 Problema

Na assistência os técnicos se perdiam em meio a pilhas de equipamentos sem saber qual consertar primeiro. Sem um fluxo claro e o controle de qual funcionário estava responsável por cada notebook ou computador, era feito anotando em uma planilha compartilhada que sempre ficava desatualizada. O sistema de ordem de serviço resolve essa desorganização interna ao centralizar o fluxo de trabalho, definir prioridades automáticas e vincular cada tarefa a um técnico responsável. Com isso, a oficina elimina o desperdício de tempo, otimiza a organização e garante que a equipe trabalhe em total sincronia, para melhor atendimento ao cliente. 

### 1.2 Canvas do projeto

| Bloco | Resposta |
|---|---|
| **Usuários** | Técnico de Informática e Administrador|
| **Problema** | Demora no preenchimento de dados em planilhas | 
| **Proposta de valor** | Agilidade no atendimento, facilidade no preenchimento das informações e na busca por informações | 
| **Funcionalidades principais** | Centralizar, organizar e automatizar informações no Banco de Dados para uma prestação de serviço ou manutenção |
| **Informações que o sistema guarda** | Dados do cliente, informações dos equipamentos, registros da execução e fechamento financeiro |
| **Indicadores** | Todas as informações sobre manutenções realizadas, quem realizou, para quem e valores finais |
| **Restrições** (prazo, tecnologia, equipe) | Projeto individual · Java 21 · Spring Boot 4 · entrega v1.0 em 11/11 |

---

## 2. Requisitos

### 2.1 Requisitos funcionais (o que o sistema FAZ)

| ID | Requisito | 
|---|---|
| RF01 | O sistema deve permitir a abertura de uma nova Ordem de Serviço, registrando dados do cliente, descrição do problema, tipo de equipamento com suas informações básicas, diagnóstico e  data | 
| RF02 | O sistema deve permitir a alteração do status da OS (ex: Aberta, Em Andamento e Concluída) | 
| RF03 | O sistema deve permitir o cadastro, edição e exclusão de clientes | 
| RF04 | O sistema deve permitir o cadastro, edição e exclusão de técnicos | 
| RF05 | O sistema permite a busca pelo nome do técnico |
| RF06 | O sistema permite a busca de endereços por uma API de CEP |

### 2.2 Requisitos não funcionais (COMO o sistema deve ser)

| ID | Requisito |
|---|---|
| RNF01 | O sistema deve exigir login e senha |
| RNF02 | O sistema deve restringir o acesso a dados financeiros e algumas configurações apenas a administradores |
| RNF03 | A busca de endereços via API deve retornar o resultado em menos de 2 segundos |



### 2.3 Regras de negócio (as REGRAS do negócio que o sistema precisa respeitar)

| ID | Regra |
|---|---|
| RN01 | Para concluir uma ordem de serviço o técnico deverá informar o diagnóstico e o valor total do serviço |
| RN02 | O administrador não poderá alterar nem excluir uma ordem de serviço concluída |

---

## 3. Histórias de usuário

**HU01 —** Como técnico de informática, quero visualizar uma lista de ordens de serviço ordenadas por prioridade e status, para que eu saiba exatamente quem está responsável por cada equipamento.

Critério de aceite: O sistema deve exibir uma tela de painel (dashboard) com as OS categorizadas em "Aberta", "Em Andamento" e "Concluída".

Critério de aceite: O técnico deve conseguir filtrar as ordens de serviço conforme as situações.

**HU02 —** Como técnico de informática, quero atualizar o status da ordem de serviço, para que os outros técnicos saibam que o equipamento está pronto e possa entrar em contato com o cliente.

Critério de aceite: O sistema deve disponibilizar um campo de texto para a descrição detalhada do defeito constatado e da solução proposta.

Critério de aceite: Ao salvar, a OS deve registrar a data e o nome do técnico responsável.

**HU03 —** Como administrador da assistência, quero visualizar o faturamento das ordens concluídas.

Critério de aceite: O sistema deve exibir na aba Ordem de Serviço o valor de cada OS.

Critério de aceite: O sistema deve pemitir imprimir um comprovante da Ordem de Serviço com informações e campos de assinatura.

---

## 4. Modelo de dados

```mermaid
classDiagram
    direction LR
    class Cliente {
        Long id
        String nome
        String telefone
        String email
        String cidade
        LocalDate dataCadastro
    }
    class Tecnico {
        Long id
        String nome
        String especialidade
        String telefone
    }
    class OrdemServico {
        Long id
        String equipamento
        String marca
        String defeitoRelatado
        String diagnostico
        BigDecimal valor
        String status
        LocalDate dataAbertura
    }
    Cliente "1" --> "*" OrdemServico : solicita
    Tecnico "1" --> "*" OrdemServico : atende
```
## 5. Como executar

### No GitHub Codespaces (recomendado)
1. No repositório, clique em **Code → Codespaces** e abra o Codespace existente (ou **Create codespace on main**).
2. No terminal, execute:
   ```bash
   mvn spring-boot:run
   ```
3. Aguarde a mensagem `Started SistemaApplication` no terminal.
4. Abra a aba **Portas** (ao lado do Terminal) e, na linha da porta **8080**, clique no ícone de globo (**Abrir no navegador**).
5. Entre com um dos usuários da seção **Usuários de teste**.

### No computador (ferramentas instaladas)
Requisitos: JDK 21 e Maven (ou uma IDE com suporte a Java, como IntelliJ IDEA ou VS Code com o *Extension Pack for Java*).
Na pasta do projeto, execute `mvn spring-boot:run` e acesse `http://localhost:8080`.

### Banco de dados de desenvolvimento
- O banco H2 fica na pasta `dados/` (não vai para o GitHub). Na primeira execução, o sistema cria as tabelas e os dados de exemplo.
- Para recomeçar com os dados de exemplo: pare o sistema e apague a pasta (`rm -rf dados`).
- Console do banco: endereço `/h2-console` (só para o perfil ADMIN).

---

## 5.1 Tecnologias
Java 21 · Spring Boot 4 · Spring MVC · Thymeleaf · Bootstrap 5 · Spring Data JPA · H2 · MySQL · Spring Security · Git/GitHub

## 6. Uso de inteligência artificial
Utilizei o GEMINI para alterações de códigos conforme meus requisitos funcionais e não funcionais. Mudança nas paletas de cores conforme meu logotipo.

## 7. Histórico de versões
| Versão | Data | Descrição |
|---|---|---|
| 0.1.0 | | Projeto inicial criado a partir do repositório modelo |

## 8.Usuários de teste

| Usuário | Senha | Perfil | O que pode fazer |
|---|---|---|---|
| admin | admin123 | Administrador | Tudo |
| operador | operador123 | Operador | Consulta clientes e técnicos, abre ordens de serviço e muda a situação delas |
| viana | viana020891 | Operador | Consulta clientes e técnicos, abre ordens de serviço e muda a situação delas |

## 9. Funcionalidades e telas

- Cadastro de clientes e técnicos.
- Abertura e acompanhamento das ordens de serviço.
- Situação de cada ordem: aberta, em andamento ou concluída.
- Painel com os indicadores do atendimento.
- Login com dois perfis: o Administrador pode tudo; o Operador consulta clientes e técnicos, abre ordens de serviço e muda a situação delas.
- Painel com pesquisa de CEP.
- Informações sobre o sistema.

### Telas

**Tela de login**

![alt text](image-20.png)

**Login Administrador**

![alt text](image-21.png)
![alt text](image-22.png)
![alt text](image-23.png)

**Login Operador**

![alt text](image-30.png)
![alt text](image-31.png)

**Painel com os indicadores do atendimento**

![alt text](image-24.png)
![alt text](image-32.png)

**Ordens de serviço e suas situações**

![alt text](image-25.png)
![alt text](image-33.png)

**Regra de negócio: concluir sem diagnóstico e valor**

![alt text](image-26.png)

**Regra de negócio: administrador não poderá alterar nem excluir uma ordem de serviço concluída**

![alt text](image-27.png)

**Painel com pesquisa de CEP**

![alt text](image-28.png)

**Informações sobre o sistema**

![alt text](image-29.png)

## 10. Checklist do nível essencial

- [x] O sistema sobe sem erros seguindo a seção 5 (Como executar)
- [x] Cadastro completo de clientes (cadastrar, listar, editar e excluir), com validação
- [x] Cadastro completo de técnicos, com validação
- [x] Ordens de serviço ligadas a clientes e técnicos, com lista de escolha no formulário
- [x] Regra de negócio 1: Não concluir uma ordem de serviço sem diagnóstico e valor.
- [x] Regra de negócio 2: Não alterar nem excluir uma ordem de serviço concluída.
- [x] Login com 2 perfis (admin e operador), senhas criptografadas e acesso conforme o perfil
- [x] Painel com os indicadores na página inicial
- [x] Repositório no GitHub com commits frequentes
- [x] README com a visão do projeto, como executar, usuários de teste, funcionalidades e telas
- [x] Quadro Kanban atualizado

