/*
Desafio
Os algarismos romanos são representados por sete símbolos diferentes: I, V, X, L, C, D e M. Cada um com seu respectivo valor: 

I : 1 
V : 5 
X : 10 
L : 50 
C : 100 
D : 500 
M : 1000 

Eles são geralmente escritos do maior para o menor. Porém, para escrevermos “4” não usamos “IIII”, mas sim “IV” porque 5 - 1 = 4.

Entrada
Você receberá uma entrada em numeral romano.
Saída
Você deverá imprimir o numeral romano convertido para um número inteiro. 

Exemplos
A tabela abaixo apresenta exemplos com alguns dados de entrada e suas respectivas saídas esperadas. Certifique-se de testar seu programa com esses exemplos e com outros casos possíveis.

Entrada	    Saída
V	          5
II	        2
MCII	      1102
*/

fun main() {
  val numeroRomano: String? = readLine()
  
  val numerosRomanos = mapOf(
      'I' to 1,
      'V' to 5,
      'X' to 10,
      'L' to 50,
      'C' to 100,
      'D' to 500,
      'M' to 1000
  )
  
  //TODO("Criar uma variável mutável para armazenar o $resultado")
  var resultado = 0
    
    for (i in numeroRomano!!.indices) {
        if (i > 0 && numerosRomanos.getValue(numeroRomano[i]) > numerosRomanos.getValue(numeroRomano[i - 1])) {
            resultado += numerosRomanos.getValue(numeroRomano[i]) - 2 * numerosRomanos.getValue(numeroRomano[i - 1]);
        } else {
            resultado += numerosRomanos.getValue(numeroRomano[i]);
        }
    }
  
  print(resultado)
}