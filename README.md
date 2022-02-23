# payroll_refactor

## Code Smells

### Duplicated Code
* Construtores com código duplicado na classe: `Employee`
* Nas classes `PaymentService`, `Commissioned`, `Hourly` existe uma repetição de código para calcular a data do último 
contracheque
* Em `EmployeeView` e `EditEmployeeView` o mesmo trecho de código para exibir a lista de empregados é repetido em 
diversas partes
* `EmployeeView` e `EditEmployeeView`  usam o mesmo objeto de input(`Scanner`) e os controllers

## Refactoring

### Chain constructor
* Os construtores de `Employee` foram modificados para usar chain constructor.

### Pull up Constructor Body
* Foi usada essa técnica para nos construtores de `Salaried`, `Hourly` e `Commissioned` para delegar as atribuições à
superclasse `Employee`

### Extract Method
* Foi criado um método em `Employee` que retornasse a data do último pagamento para ser usado para obter determinadas
informações por período

### Extract Superclass
* Foi criada a superclasse `View` para que os problemas de duplicação das classes `EmployeeView` e `EditEmployeeView`
fossem corrigidos

### Strategy
* Para delegar o cálculo dos dias de pagamento de um empregado no mês para classes específicas foi usado o padrão 
Strategy

