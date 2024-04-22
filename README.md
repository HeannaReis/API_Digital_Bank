# Projeto Banco Digital

Você montou uma startup que desenvolve softwares para clientes. Seu primeiro cliente é de uma instituição financeira e quer um software na web que seja capaz de cadastrar dados de seus clientes como:

## Dados do Cliente

- **CPF**
- **Nome**
- **Data de nascimento**
- **Endereço**

Os clientes podem ser subdivididos em três categorias:
- **Comum**
- **Super**
- **Premium**

Podem abrir contas de dois tipos:
- **Corrente**
- **Poupança**

Devendo estas realizar ações básicas, como:
- Exibir saldo
- Fazer transferências via Pix

## Contas

A conta corrente possui uma taxa mensal de manutenção que deve ser descontada a cada mês, e a conta poupança deve fazer o acréscimo conforme a taxa de rendimento no momento.

## Cartões

A partir da conta, podem ser emitidos cartões de crédito e/ou débito. Em ambos os casos, o programa deve ser capaz de aplicar taxas pela sua utilização e ser capaz de realizar pagamentos, além de mudar o status para ativo/desativado e de permitir a troca de senha.

### Cartão de Crédito

O cartão de crédito deve ter um limite de crédito aprovado e a cada pagamento, um valor é descontado até atingir o limite. Se a soma de pagamentos de um mês atingir o valor do limite, novos pagamentos devem ser bloqueados.

### Cartão de Débito

O cartão de débito deve ter um limite diário de transação, devendo impedir novos pagamentos após atingir o valor limítrofe. O programa deve permitir a alteração deste limite diário por um usuário.

## Seguros

Os cartões de crédito terão produtos de seguro específicos que serão ofertados mediante determinadas regras. O programa também deve gerar uma apólice eletrônica desse seguro, contendo o número da apólice, a data de contratação, os detalhes do cartão que terá cobertura, o valor da apólice e a descrição das condições para acionamento. O programa também deve gerar automaticamente um número de apólice a cada novo contrato.

---

### Regras de Negócio:
1. **Cadastro de Clientes:**
    - O sistema deve permitir o cadastro de novos clientes com CPF, nome, data de nascimento e endereço, classificando-os em categorias Comum, Super ou Premium.

2. **Contas Bancárias:**
    - Os clientes podem abrir contas correntes e/ou poupança, cada uma com funcionalidades específicas:
        - **Conta Corrente:** Deve ter uma taxa de manutenção mensal descontada automaticamente.
        - **Conta Poupança:** Deve creditar mensalmente o rendimento conforme a taxa vigente.

3. **Operações Bancárias:**
    - Implementar funcionalidades para exibição de saldo, transferências via Pix, e outras operações básicas.

4. **Cartões de Crédito e Débito:**
    - Emitir cartões vinculados às contas dos clientes, permitindo operações de pagamento, alteração de senha, ativação/desativação e ajuste de limites.
        - **Cartão de Crédito:** Deve ter um limite pré-aprovado e bloquear novos pagamentos ao atingir o limite.
        - **Cartão de Débito:** Deve ter um limite diário de transações, podendo ser ajustado pelo usuário.

5. **Seguros de Cartão de Crédito:**
    - Oferecer produtos de seguro específicos para cartões de crédito, gerando apólices eletrônicas com detalhes sobre cobertura e condições.

### Validação de Campos na Inserção do Usuário:
1. **CPF:**
    - Deve ser único para cada cliente.
    - Validar o formato (xxx.xxx.xxx-xx) e a autenticidade usando um algoritmo de validação de CPF.

2. **Nome:**
    - Deve conter apenas letras e espaços.
    - Comprimento mínimo de 2 caracteres e máximo de 100 caracteres.

3. **Data de Nascimento:**
    - Deve ser uma data válida no formato DD/MM/AAAA.
    - O cliente deve ser maior de idade (≥ 18 anos) com base na data atual.

4. **Endereço:**
    - Deve incluir rua, número, complemento (se aplicável), cidade, estado e CEP.
    - Verificar se o formato do CEP é válido (xxxxx-xxx).

### Contas Bancárias e Taxas:
1. **Conta Corrente:**
    - **Taxa de Manutenção Mensal:** R$ 12,00 para clientes Comuns, R$ 8,00 para clientes Super e isenta para clientes Premium.

2. **Conta Poupança:**
    - **Taxa de Rendimento Anual:** 0,5% ao ano para clientes Comuns, 0,7% ao ano para clientes Super, e 0,9% ao ano para clientes Premium.
    - O rendimento é calculado mensalmente usando a fórmula do juro composto, baseando-se no saldo presente na conta no último dia do mês.

### Cartões:
- **Cartão de Crédito:**
    - **Limite de Crédito:** Deve ser definido com base no cliente, 1 mil (COMUM), 5 mil (SUPER), 10 mil (PREMIUM).
    - **Taxa de Utilização:** 5% sobre o total gasto no mês, aplicável apenas se o total de gastos exceder 80% do limite de crédito.

### Seguros de Cartão de Crédito:
- **Seguro Viagem:** Gratuito para clientes Premium; opcional para clientes Comum e Super, com taxa de R$ 50,00 por mês.
- **Seguro de Fraude:** Cobertura automática para todos os cartões, com um valor de apólice base de R$ 5.000,00.



## Diagramação

```
+-------------------+     +-------------------+     +-------------------+
|     Cliente       |     |      Conta        |     |      Cartao       |
+-------------------+     +-------------------+     +-------------------+
| -id: Long         |     | -id: Long         |     | -id: Long         |
| -cpf: String      |     | -saldo: double    |     | -numero: String   |
| -nome: String     |     | -cliente: Cliente |     | -senha: String    |
| -dataNascimento:  |     +-------------------+     | -ativo: boolean   |
|   Date            |     | +exibirSaldo()    |     | -limite: double   |
| -endereco: String |     | +transferir()    |     +-------------------+
| -contas: List     |     +-------------------+     | +pagar()          |
+-------------------+     |                   |     | +alterarSenha()   |
|                   |     +-------------------+     | +ativar()         |
+-------------------+     |   ContaCorrente   |     | +desativar()      |
|   ClienteComum    |     +-------------------+     +-------------------+
+-------------------+     | -taxaManutencao:  |     |                   |
|                   |     |   double          |     +-------------------+
+-------------------+     | +descontarTaxa()  |     |  CartaoCredito    |
|   ClienteSuper    |     +-------------------+     +-------------------+
+-------------------+     |                   |     | -limiteCredito:   |
|                   |     +-------------------+     |   double          |
+-------------------+     |   ContaPoupanca   |     | +bloquearPagamentos()
|   ClientePremium  |     +-------------------+     +-------------------+
+-------------------+     | -taxaRendimento:  |     |                   |
                          |   double          |     +-------------------+
                          | +creditarRendimento()   |   CartaoDebito    |
                          +-------------------+     +-------------------+
                                                    | -limiteDiario: double
                                                    | +ajustarLimiteDiario()
                                                    +-------------------+

+-------------------+
| SeguroCartaoCredito |
+-------------------+
| -id: Long         |
| -numeroApolice:   |
|   String          |
| -dataContratacao: |
|   Date            |
| -cartao: CartaoCredito
| -valorApolice: double
| -condicoes: String
+-------------------+
| +gerarApolice()   |
+-------------------+
```

Este diagrama mostra as classes `Cliente`, `Conta`, `Cartao` e `SeguroCartaoCredito`, juntamente com suas subclasses `ClienteComum`, `ClienteSuper`, `ClientePremium`, `ContaCorrente`, `ContaPoupanca`, `CartaoCredito` e `CartaoDebito`. As linhas entre as classes representam os relacionamentos entre elas. Por exemplo, um `Cliente` pode ter várias `Contas`, e uma `Conta` pode pertencer a um `Cliente`. Da mesma forma, um `CartaoCredito` pode ter um `SeguroCartaoCredito` associado.

```
classDiagram
    class Cliente {
        -id: Long
        -cpf: String
        -nome: String
        -dataNascimento: Date
        -endereco: String
        -contas: List<Conta>
    }
    class Conta {
        -id: Long
        -saldo: double
        -cliente: Cliente
        +exibirSaldo()
        +transferir()
    }
    class Cartao {
        -id: Long
        -numero: String
        -senha: String
        -ativo: boolean
        -limite: double
        +pagar()
        +alterarSenha()
        +ativar()
        +desativar()
    }
    class ClienteComum {
    }
    class ClienteSuper {
    }
    class ClientePremium {
    }
    class ContaCorrente {
        -taxaManutencao: double
        +descontarTaxa()
    }
    class ContaPoupanca {
        -taxaRendimento: double
        +creditarRendimento()
    }
    class CartaoCredito {
        -limiteCredito: double
        +bloquearPagamentos()
    }
    class CartaoDebito {
        -limiteDiario: double
        +ajustarLimiteDiario()
    }
    class SeguroCartaoCredito {
        -id: Long
        -numeroApolice: String
        -dataContratacao: Date
        -cartao: CartaoCredito
        -valorApolice: double
        -condicoes: String
        +gerarApolice()
    }

    Cliente <|-- ClienteComum
    Cliente <|-- ClienteSuper
    Cliente <|-- ClientePremium
    Cliente "*" -- "1" Conta : possui
    Conta <|-- ContaCorrente
    Conta <|-- ContaPoupanca
    Cliente "*" -- "1" Cartao : possui
    Cartao <|-- CartaoCredito
    Cartao <|-- CartaoDebito
    CartaoCredito -- SeguroCartaoCredito : possui
```