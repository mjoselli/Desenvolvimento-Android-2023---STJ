import kotlin.coroutines.*

// 1. Crie uma função que receba um número inteiro e retorne verdadeiro se o número for par e falso caso contrário.
fun isEven(number: Int): Boolean {
    return number % 2 == 0
}
fun testeIsEven() {
    println("isEven(2) = ${isEven(2)}")
    println("isEven(3) = ${isEven(3)}")
} 
// 2. Crie uma função que receba um array de inteiros e retorne o maior número. 
fun maxNumber(numbers: IntArray): Int {
    var max = numbers[0]
    for (number in numbers) {
        if (number > max) {
            max = number
        }
    }
    return max
}
fun testeMaxNumber() {
    println("maxNumber([1, 2, 3, 4, 5]) = ${maxNumber(intArrayOf(1, 2, 3, 4, 5))}")
    println("maxNumber([5, 4, 3, 2, 1]) = ${maxNumber(intArrayOf(5, 4, 3, 2, 1))}")
}
// 3. Crie uma classe chamada "Pessoa" com os atributos "nome" e "idade". Em seguida, crie uma lista de objetos "Pessoa" e ordene a lista em ordem alfabética pelo atributo "nome". 
class Pessoa(val nome: String, val idade: Int) {
    override fun toString(): String {
        return "Pessoa(nome='$nome', idade=$idade)"
    }
}
fun testePessoa(){
    //crie uma lista de objetos "Pessoa"
    val pessoas = arrayListOf(Pessoa("João", 20), Pessoa("Maria", 30), Pessoa("José", 18))
    //ordene a lista em ordem alfabética pelo atributo "nome"
    pessoas.sortBy { it.nome }
    println(pessoas)
}
// 4. Crie uma função que receba uma string e retorne verdadeiro se a string for um palíndromo (ou seja, pode ser lida da mesma forma de trás para frente). 
fun isPalindrome(text: String): Boolean {
    return text == text.reversed()
}
fun testeIsPalindrome() {
    println("isPalindrome('ana') = ${isPalindrome("ana")}")
    println("isPalindrome('abacaxi') = ${isPalindrome("abacaxi")}")
}
// 5. Implemente uma função lambda que retorne o maior valor entre dois números.
val max = { a: Int, b: Int -> if (a > b) a else b }
fun testeMax() {
    println("max(2, 3) = ${max(2, 3)}")
    println("max(3, 2) = ${max(3, 2)}")
}
// 6. Crie uma classe "ContaBancaria" com os atributos "saldo" e "limite". Adicione um método chamado "saque" que recebe um valor como parâmetro e subtrai do saldo da conta. Se o valor do saque for maior que o saldo da conta, o método deve lançar uma exceção com a mensagem "Saldo insuficiente". 
class ContaBancaria(var saldo: Double, var limite: Double) {
    fun saque(valor: Double) {
        if (valor > saldo + limite) {
            throw Exception("Saldo insuficiente")
        }
        saldo -= valor
    }
}
fun testeContaBancaria() {
    val conta = ContaBancaria(100.0, 50.0)
    conta.saque(50.0)
    println(conta.saldo) 
    conta.saque(10.0)
    println(conta.saldo) 
}
// 7. Crie uma função que receba uma lista de strings e retorne a string mais longa da lista. 
fun longestString(strings: List<String>): String {
    var longest = strings[0]
    for (string in strings) {
        if (string.length > longest.length) {
            longest = string
        }
    }
    return longest
}
fun testeLongestString() {
    println("longestString(['a', 'ab', 'abc']) = ${longestString(listOf("a", "ab", "abc"))}")
    println("longestString(['abc', 'ab', 'a']) = ${longestString(listOf("abc", "ab", "a"))}")
}
// 8. Crie uma classe "Funcionario" com os atributos "nome", "idade" e "salario". Crie uma função que receba uma lista de funcionários e retorne o funcionário com o maior salário. 
class Funcionario(val nome: String, val idade: Int, val salario: Double) {
    override fun toString(): String {
        return "Funcionario(nome='$nome', idade=$idade, salario=$salario)"
    }
}
fun maiorSalario(funcionarios: List<Funcionario>): Funcionario {
    var maior = funcionarios[0]
    for (funcionario in funcionarios) {
        if (funcionario.salario > maior.salario) {
            maior = funcionario
        }
    }
    return maior
}
fun testeMaiorSalario() {
    val funcionarios = listOf(
        Funcionario("João", 20, 1000.0),
        Funcionario("Maria", 30, 2000.0),
        Funcionario("José", 18, 800.0)
    )
    println(maiorSalario(funcionarios))
}
// 9. Crie uma função que receba uma lista de números inteiros e retorne uma lista com os números em ordem crescente, sem usar o método de ordenação da linguagem.
fun ordenar(lista: List<Int>): List<Int> {
    val ordenada = mutableListOf<Int>()
    for (elemento in lista) {
        var i = 0
        while (i < ordenada.size && elemento > ordenada[i]) {
            i++
        }
        ordenada.add(i, elemento)
    }
    return ordenada
}
fun testeOrdenar() {
    println("ordenar([1, 2, 3, 4, 5]) = ${ordenar(listOf(1, 2, 3, 4, 5))}")
    println("ordenar([5, 4, 3, 2, 1]) = ${ordenar(listOf(5, 4, 3, 2, 1))}")
}
// 10. Crie uma classe "Triangulo" com os atributos "base" e "altura". Adicione um método chamado "area" que calcula e retorna a área do triângulo.
class Triangulo(val base: Double, val altura: Double) {
    fun area(): Double {
        return base * altura / 2
    }
}
fun testeTriangulo() {
    val triangulo = Triangulo(10.0, 5.0)
    println(triangulo.area()) // 25.0
}
// 11. Crie uma função que receba uma lista de strings e retorne uma lista com todas as strings que começam com a letra "A", em ordem alfabética.
fun comecaComA(strings: List<String>): List<String> {
    val comecaComA = mutableListOf<String>()
    for (string in strings) {
        if (string.startsWith("A")) {
            comecaComA.add(string)
        }
    }
    comecaComA.sort()
    return comecaComA
}
fun testeComecaComA() {
    println("comecaComA(['a', 'ab', 'abc']) = ${comecaComA(listOf("a", "ab", "abc"))}")
    println("comecaComA(['abc', 'ab', 'a']) = ${comecaComA(listOf("abc", "ab", "a"))}")
}
// 12. Utilize um mapa para representar um dicionário de palavras e suas traduções.
fun testeMapa(){
    val dicionario = mapOf("casa" to "house", "gato" to "cat", "verde" to "green")
    println(dicionario["casa"]) // house
    println(dicionario["gato"]) // cat
    println(dicionario["verde"]) // green

}
// 13. Crie uma função de ordem superior chamada operacaoMatematica que aceita dois números e uma função lambda. A função operacaoMatematica deve aplicar a função lambda aos dois números e retornar o resultado. Em seguida, crie algumas funções lambda para realizar operações matemáticas, como soma, subtração, multiplicação e divisão. Use a função de ordem superior para realizar essas operações com diferentes pares de números.
fun operacaoMatematica(a: Int, b: Int, operacao: (Int, Int) -> Int): Int {
    return operacao(a, b)
}
fun testeOperacaoMatematica(){
    println("operacaoMatematica(2, 3, { a, b -> a + b }) = ${operacaoMatematica(2, 3, { a, b -> a + b })}")
    println("operacaoMatematica(2, 3, { a, b -> a - b }) = ${operacaoMatematica(2, 3, { a, b -> a - b })}")
    println("operacaoMatematica(2, 3, { a, b -> a * b }) = ${operacaoMatematica(2, 3, { a, b -> a * b })}")
    println("operacaoMatematica(2, 3, { a, b -> a / b }) = ${operacaoMatematica(2, 3, { a, b -> a / b })}")

}
//14. Crie uma função de extensão chamada isPalindromo para a classe String que verifica se a string é um palíndromo. A função deve ignorar espaços em branco e ser case-insensitive (não distinguir maiúsculas de minúsculas). Em seguida, use essa função para verificar se algumas palavras são palíndromos.
fun String.isPalindromo(): Boolean {
    val texto = this.lowercase().replace(" ", "")
    return texto == texto.reversed()
}
fun testeIsPalindromo(){
    println("ana".isPalindromo()) // true
    println("abacaxi".isPalindromo()) // false
}
//15. Vamos criar um programa que utilize funções de alta ordem para operar em um array de números inteiros. Você deve criar funções de alta ordem para realizar as seguintes operações: filtrarPares: Uma função que filtra e retorna apenas os números pares do array; dobrarValores: Uma função que dobra o valor de cada número no array; somarValores: Uma função que calcula a soma de todos os valores no array. Em seguida, crie um array de números inteiros e utilize as funções de alta ordem para realizar essas operações.
fun altaOrdemNoArray(){
    val numeros = intArrayOf(1, 2, 3, 4, 5)
    val pares = numeros.filter { it % 2 == 0 }
    val dobrados = numeros.map { it * 2 }
    val soma = numeros.reduce { acc, i -> acc + i }
    println(pares) // [2, 4]
    println(dobrados) // [2, 4, 6, 8, 10]
    println(soma) // 15
}
// 16. Crie um programa que utilize coroutines para realizar uma contagem regressiva de 5 a 1, com um intervalo de 1 segundo entre cada contagem. Após a contagem, imprima "Tempo esgotado!".
/*fun testeContagemRegressiva(){
    GlobalScope.launch {
        for (i in 5 downTo 1) {
            println(i)
            delay(1000)
        }
        println("Tempo esgotado!")
    }
    Thread.sleep(6000)
}*/
fun main() {
    testeIsEven()
    testeMaxNumber()
    testePessoa()
    testeIsPalindrome()
    testeMax()
    testeContaBancaria()
    testeLongestString()
    testeMaiorSalario()
    testeOrdenar()
    testeTriangulo()
    testeComecaComA()
    testeMapa()
    testeOperacaoMatematica()
    testeIsPalindromo()
    altaOrdemNoArray()
}