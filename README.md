# payroll_refactor

## Code Smells

### Duplicated Code
* Construtores com código duplicado na classe: `Employee`
* Nas classes `PaymentService`, `Commissioned`, `Hourly` existe uma repetição de código para calcular a data do último 
contracheque

## Refactoring

### Chain constructor
* Os construtores de `Employee` foram modificados para usar chain constructor.

### Pull up Constructor Body
* Foi usada essa técnica para nos construtores de `Salaried`, `Hourly` e `Commissioned` para delegar as atribuições à
superclasse `Employee`

### Extract Method
* Foi criado um método em `Employee` que retornasse a data do último pagamento para ser usado para obter determinadas
informações por período
