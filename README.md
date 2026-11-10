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
| RF04 | O sistema permite a busca de endereços por uma API de CEP |

### 2.2 Requisitos não funcionais (COMO o sistema deve ser)

| ID | Requisito |
|---|---|
| RNF01 | O sistema deve exigir login e senha |
| RNF02 | O sistema deve restringir o acesso a dados financeiros e configurações apenas a administradores |
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

---

## 5. Como executar

### No GitHub Codespaces (recomendado)
1. No repositório, clique em **Code → Codespaces → Create codespace on main** (ou abra o Codespace existente).
2. Aguarde a preparação do ambiente.
3. No terminal, execute:
   ```bash
   mvn spring-boot:run
   ```
4. Quando aparecer o aviso da porta **8080**, clique em **Abrir no navegador**.

### No computador (ferramentas instaladas)
Requisitos: JDK 21 e uma IDE (IntelliJ IDEA ou VS Code com o *Extension Pack for Java*).
Abra o projeto na IDE e execute a classe `SistemaApplication`. Acesse `http://localhost:8080`.

### Acesso
| Usuário | Senha | Perfil |
|---|---|---|
| admin | admin123 | Administrador |
| operador | operador123 | Operador |
| viana | viana020891 | Operador |

---

## 6. Tecnologias
Java 21 · Spring Boot 4 · Spring MVC · Thymeleaf · Bootstrap 5 · Spring Data JPA · H2 (desenvolvimento) · MySQL (produção) · Spring Security · Git/GitHub

## 7. Uso de inteligência artificial
Utilizei o GEMINI para alterações de códigos conforme meus requisitos funcionais e não funcionais.

## 8. Histórico de versões
| Versão | Data | Descrição |
|---|---|---|
| 0.1.0 | | Projeto inicial criado a partir do repositório modelo |

## 9. Telas
![alt text](image.png)


## Usuários de teste

| Usuário | Senha | Perfil | O que pode fazer |
|---|---|---|---|
| admin | admin123 | Administrador | Tudo |
| operador | operador123 | Operador | Consulta clientes e técnicos, abre ordens de serviço e muda a situação delas |
| viana | viana020891 | Operador | Consulta clientes e técnicos, abre ordens de serviço e muda a situação delas |