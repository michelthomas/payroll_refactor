# payroll_refactor

## Code Smells

### Duplicated Code
* Construtores com código duplicado na classe: `Employee`

## Refactoring

### Chain constructor
* Os construtores de `Employee` foram modificados para usar chain constructor.

### Pull up Constructor Body
* Foi usada essa técnica para nos construtores de `Salaried`, `Hourly` e `Commissioned` para delegar as atribuições à
superclasse `Employee`
