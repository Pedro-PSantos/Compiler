RELATÓRIO
Grupo 4DEVS  - Pfolio -> melhorias efetuadas ao EfolioB 

• Luís Henrique Pereira Marques | nº 701887
• Ivo Arlindo Vieira Baptista | nº 2100927
• Pedro Pereira Santos | nº 2000809
• David Miguel Raposo Ferreira | nº 2102814

________________________________________

# Usamos a versão: antlr-4.13.1-complete

# Para gerar Parsers, lexers, visitor e listener usamos o comando:
antlr4 Expression.g4 -visitor
(que significa "java org.antlr.v4.Tool Expressions.g4" com visitor)

# Para criar classes, usamos o comando:
javac Expressions*.java

# Para testar o programa é necessário adicionar aos argumentos do programa o caminho do ficheiro a testar
# Ou alterar o código para correr in-line

# Compilar Todo o Código Fonte na pasta src
javac -d out $(find src -name "*.java")


Executar a Classe Principal com o ficheiro input.txt que esta na pasta TestFiles
java -cp out com.exemplo.ExpressionApplication TestFiles/Input.txt




