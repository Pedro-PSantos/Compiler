grammar Expression;

@header{
    package Antlr;
}

prog: statement* EOF                                                                                                  # Program
       ;

// Statements, declarações de variáveis e funções
statement: TYPE VARIABLE  (',' VARIABLE)* ('=' expr (',' expr)*)?                                                  # ExplicitDeclaration
    | VARIABLE '=' expr (',' VARIABLE '=' expr)*                                                                        # ImplicitDeclaration
    | DEF TYPE? VARIABLE '(' (TYPE? VARIABLE (',' TYPE? VARIABLE)*)? ')' ':' NEWLINE INDENT statement+ DEDENT           # FunctionDeclaration
    | IF expr ':'  (INDENT statement+ DEDENT | statement)
      (ELIF expr ':'  (INDENT statement+ DEDENT | statement))*
      (ELSE ':'  (INDENT statement+ DEDENT | statement))?                                                               # IfClause
    | WHILE expr ':' NEWLINE INDENT statement+ DEDENT                                                                   # While
    | FOR VARIABLE 'in' (VARIABLE | ('range(' expr (',' expr (',' expr)?)? ')')) ':' NEWLINE INDENT statement+ DEDENT   # For
    | RETURN expr                                                                                                       # Return
    ;

// expressões aritméticas
expr: (PLUS|MINUS) expr                                                                                                 # SignedExpression
    |'(' expr ')'                                                                                                       # ExpressionWithParentheses
    | expr op=(DIVISION|MULTIPLICATION|INTDIVISION|MODULE|EXPONENTIAL) expr                                             # OperationMultDiv
    | expr op=(PLUS|MINUS) expr                                                                                         # OperationPM
    | expr CONDITIONALS expr                                                                                            # OperationConditional
    | VARIABLE '(' (expr (',' expr)*)? ')'                                                                              # FunctionInvocation
    | '[' expr (',' expr)* ']'                                                                                          # List
    | VARIABLE                                                                                                          # Variable
    | STRING                                                                                                            # String
    | FLOAT                                                                                                             # FloatNumber
    | INT                                                                                                               # IntegerNumber
    ;


// Tokens de tipos de variáveis e funções
TYPE: 'int' | 'float' | 'func' | 'int[]' | 'float[]';

STRING: ('"'|'”'|'“') (~["\r\n])* ('"'|'”'|'“');

VARIABLE: [a-zA-Z_][a-zA-Z_0-9]*;

INT: [0-9]+;

FLOAT: [0-9]*'.'[0-9]+;

// Operadores
MINUS: '-';
PLUS: '+';
DIVISION: '/';
MULTIPLICATION: '*';
INTDIVISION: '//';
EXPONENTIAL: '**';
MODULE: '%';

// Condicionais
CONDITIONALS: (SMALLEREQ | SMALLER | BIGGEREQ | BIGGER | DIFFERENT | EQUALS);
SMALLER: '<';
SMALLEREQ: '<=';
BIGGER: '>';
BIGGEREQ: '>=';
DIFFERENT: '!=';
EQUALS: '==';

// Ifs
IF: 'if';
ELIF: 'elif';
ELSE: 'else';

// Definição de funções
DEF: 'def';

// Loops
WHILE: 'while';
FOR: 'for';
RETURN: 'return';

// Outros tokens
COMMENT: '#' ~[\r\n]* -> skip;
WS : [ \t\r\n]+ -> channel(HIDDEN);
INDENT : ' ' -> channel(HIDDEN);
DEDENT : '\n' -> channel(HIDDEN);
NEWLINE : '\r'? '\n' -> skip;