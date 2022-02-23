# payroll_refactor
[Link do primeiro projeto](https://github.com/michelthomas/payroll/)

## Code Smells

### Duplicated Code
* Construtores com código duplicado na classe: `Employee`
* Nas classes `PaymentService`, `Commissioned`, `Hourly` existe uma repetição de código para calcular a data do último 
contracheque
* Em `EmployeeView` e `EditEmployeeView` o mesmo trecho de código para exibir a lista de empregados é repetido em 
diversas partes
* `EmployeeView` e `EditEmployeeView`  usam o mesmo objeto de input(`Scanner`) e os controllers

### Speculative Generality
* Métodos de várias classes não são utilizados atualmente
* Lançamento de ParseException onde não é necessário


## Refactoring

### Chain constructor
* Os construtores de `Employee` foram modificados para usar chain constructor. 
[Commit](https://github.com/michelthomas/payroll_refactor/commit/80b65d264cffdd6bd83b2e69823be4a6a0a2d947)

### Pull up Constructor Body
* Foi usada essa técnica para nos construtores de `Salaried`, `Hourly` e `Commissioned` para delegar as atribuições à
superclasse `Employee`. 
[Commit](https://github.com/michelthomas/payroll_refactor/commit/80b65d264cffdd6bd83b2e69823be4a6a0a2d947)

### Extract Method
* Foi criado um método em `Employee` que retornasse a data do último pagamento para ser usado para obter determinadas
informações por período. 
[Commit](https://github.com/michelthomas/payroll_refactor/commit/ed564d3c19ab86e2b0941b5d8956fdf61f0739b6)

### Extract Superclass
* Foi criada a superclasse `View` para que os problemas de duplicação das classes `EmployeeView` e `EditEmployeeView`
fossem corrigidos. 
[Commit](https://github.com/michelthomas/payroll_refactor/commit/943285e6f1d797bcc3d6d74802479c5a06d66631)

### Removal of Speculative Generality
- Remoção do lançamento inútil de ParseException. 
[Commit](https://github.com/michelthomas/payroll_refactor/commit/a4580b7c6a13f881e00f2243daaac7f9f83ad79f)

### Strategy
* Para delegar o cálculo dos dias de pagamento de um empregado no mês para classes específicas foi usado o padrão 
Strategy. [Commit](https://github.com/michelthomas/payroll_refactor/commit/3737d557fa2c7d395599b952ad962f8303d5d789)
 e [commit](https://github.com/michelthomas/payroll_refactor/commit/080fee2f9c32390c95d55ad21be0a1288288bc38)

### Command
* Para organizar melhor o fluxo do menu foi usado o padrão Command. 
[Commit](https://github.com/michelthomas/payroll_refactor/commit/a4580b7c6a13f881e00f2243daaac7f9f83ad79f)

