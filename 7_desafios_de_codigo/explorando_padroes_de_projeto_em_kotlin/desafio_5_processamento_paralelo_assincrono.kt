/*
Descrição
No mundo da programação, frequentemente enfrentamos situações onde múltiplas tarefas precisam ser executadas simultaneamente para otimizar o tempo de resposta ou processamento. Um exemplo comum é o download de múltiplos arquivos da internet.

Para este desafio, suponha que você tenha uma lista de URLs que deseja "baixar". Seu objetivo é simular o download desses arquivos de forma paralela e imprimir o tamanho de cada URL após seu "download" ter sido disparado. Para simplificar, cada URL leva exatamente 1 segundo para ser "baixado".

Requisitos:

Defina uma lista de URLs que você deseja "baixar".
Crie uma função para simular o "download" de uma URL. Essa função deve aceitar uma URL como entrada e retornar o tamanho da URL.
Implemente uma lógica que permita iniciar o "download" de várias URLs em paralelo.
Imprima o tamanho de cada URL na ordem em que foram inseridas.
Entrada
A entrada consiste em uma lista de URLs, uma em cada linha. Uma linha vazia indica o fim da lista.

Saída
A saída deve mostrar o tamanho de cada URL na ordem em que foram inseridas, seguido pelo "Tempo total", que é simplesmente a contagem de URLs (por mais conta-intuitivo que pareça 😁):
Iniciando downloads...
Arq1: $tamanhoUrl1
Arq2: $tamanhoUrl2
Tempo total: $quantidadeDeUrls

Exemplos
A tabela abaixo apresenta exemplos com alguns dados de entrada e suas respectivas saídas esperadas. Certifique-se de testar seu programa com esses exemplos e com outros casos possíveis.

Entrada	                                Saída
https://chat.openai.com/                Iniciando downloads...
https://www.invertexto.com/             Arq1: 24
https://web.dio.me/                     Arq2: 27
[Linha vazia]                           Arq3: 19
                                        Tempo total: 3

https://www.netflix.com/                Iniciando downloads...
https://www.hbomax.com/                 Arq1: 24
https://www.amazon.com.br/              Arq2: 23
[Linha vazia]                           Arq3: 26
                                        Tempo total: 3

https://refactoring.guru/               Iniciando downloads...
https://github.com/                     Arq1: 25
https://stackoverflow.com/              Arq2: 19
[Linha vazia]                           Arq3: 26
                                        Tempo total: 3

Nota: A simulação de download é uma forma simplificada de entender como tarefas paralelas podem ser disparadas e como os resultados podem ser coletados de volta na ordem desejada.
*/

fun main() {
  val urls = mutableListOf<String>()

  while (true) {
    val input = readLine() ?: break
    if (input.isBlank()) break
    urls.add(input)
  }

  println("Iniciando downloads...")

  // Cria uma lista de Pair (indice, tamanho)
  val results = mutableListOf<Pair<Int, Int>>()

  // Em Kotlin, Coroutines são uma opção mais idiomática e simples para operações assíncronas
  // e paralelas em comparação com Threads. No entanto, nosso editor de código atual
  // ainda não suporta Coroutines. Para mais detalhes, veja a documentação oficial:
  // https://kotlinlang.org/docs/coroutines-overview.html
  val threads = urls.mapIndexed { index, url ->
    Thread {
      val length = openLink(url)
      synchronized(results) {
        results.add(Pair(index, length))
      }
    }.start()
  }
  
  //TODO("Inicie cada Thread para começar o processo de 'download' paralelamente.")
  //TODO("Aguarde até que todas as Threads terminem suas respectivas execuções.")

  // Ordena os resultados por índice para imprimir na ordem correta
  results.sortedBy { it.first }.forEachIndexed { idx, result ->
    println("Arq${idx + 1}: ${result.second}")
  }
  println("Tempo total: ${urls.size}")
}

// Simula a abertura de uma URL, retornando seu tamanho.
fun openLink(url: String): Int {
    return url.length
}