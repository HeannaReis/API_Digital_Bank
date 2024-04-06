projeto Banco Digital
Você montou uma startup que desenvolve softwares para clientes. 
Seu primeiro cliente é de uma instituição financeira e quer um software na web 
que seja capaz de cadastrar dados de seus clientes como 
CPF, 
Nome, 
Data de nascimento,
Endereço;


Os clientes podem ser subdivididos em três categorias: 
Comum, 
Super,
Premium;

Podem abrir contas de dois tipos: 
corrente e poupança, 

devendo estas realizar ações básicas, 
como exibir saldo 
fazer transferências via Pix. 

A conta corrente possui uma taxa mensal de manutenção 
que deve ser descontada a cada mês 
e a conta poupança deve fazer o acréscimo conforma a taxa de rendimento no momento.

A partir da conta, podem ser emitidos 
cartões de 
crédito e/ou débito.  

Em ambos os casos o programa deve ser capaz de aplicar 
taxas pela sua utilização e ser capaz de 
realizar pagamentos, 
além de mudar o status para ativo/desativado e de 
permitir a troca de senha. 

O cartão de crédito deve ter um limite de crédito aprovado 
e a cada pagamento, um valor é descontado até atingir o limite, 
se a soma de pagamentos de um mês atingir o valor do limite, 
novos pagamentos devem ser bloqueados.

O cartão de débito deve ter um limite diário de transação,
devendo impedir novos pagamentos após atingir o valor limítrofe. 
O programa deve permitir a alteração deste limite diário por um usuário.

Os cartões de crédito terão produtos de seguro específicos 
que serão ofertados mediante determinadas regras. 
O programa também deve gerar uma apólice eletrônica desse seguro, 
contendo o número da apólice, 
a data de contratação, 
os detalhes do cartão que terá cobertura, 
o valor da apólice e a descrição das condições para acionamento. 
O programa também deve gerar automaticamente um número de apólice
a cada novo contrato.


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