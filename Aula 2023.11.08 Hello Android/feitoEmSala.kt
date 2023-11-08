// 1. Crie uma função que receba um número inteiro e retorne verdadeiro se o número for par e falso caso contrário.
fun isEven(num:Int): Boolean{
    return num % 2 == 0
}
// 2. Crie uma função que receba um array de inteiros e retorne o maior número. 
fun maxNumber(numbers: IntArray) : Int{
    var max = numbers[0]
    for (num in numbers){
        if (max < num){
            max = num
        }
    }
    return max
}
// 3. Crie uma classe chamada "Pessoa" com os atributos "nome" e "idade". 
// Em seguida, crie uma lista de objetos "Pessoa" e ordene a lista em ordem alfabética pelo atributo "nome". 

class Pessoa(val nome:String,val idade:Int){
    override fun toString() : String{
        return "$nome : $idade"
    }
}
// 4. Crie uma função que receba uma string e retorne verdadeiro se a string for um palíndromo (ou seja, pode ser lida da mesma forma de trás para frente). 
fun isPalindrome(text:String) : Boolean{
    return text == text.reversed()
}
// 5. Implemente uma função lambda que retorne o maior valor entre dois números.
val max = { a:Int,b:Int -> if(a > b) a else b }

fun maxFunc(a:Int,b:Int) :Int{
    if(a > b) 
    	return a 
    else 
    	return b
}
// 6. Crie uma classe "ContaBancaria" com os atributos "saldo" e "limite". 
// Adicione um método chamado "saque" que recebe um valor como parâmetro e subtrai do saldo da conta. 
// Se o valor do saque for maior que o saldo da conta, o método deve lançar uma exceção com a mensagem "Saldo insuficiente". 
class ContaBancaria(var saldo:Double, var limite:Double){
    var retiradas = 0.0
    constructor(saldo:Double) : this(saldo,1000.0){
        
    }
	fun saque(valor:Double){
        if(valor > saldo + limite){
            throw Exception("Saldo Insuficiente")
        }
        saldo -= valor
        retiradas += valor
    }
}
// 7. Crie uma função que receba uma lista de strings e retorne a string mais longa da lista. 
fun longestString(strings: List<String>) :String{
    var longest = strings[0]
    for(string in strings){
        if(string.length > longest.length){
            longest = string
        }
    }
    return longest
}
// 8. Crie uma classe "Funcionario" com os atributos "nome", "idade" e "salario". 
// Crie uma função que receba uma lista de funcionários e retorne o funcionário com o maior salário. 
data class Funcionario(val nome:String, val idade:Int, val salario:Double)

// 9. Crie uma função que receba uma lista de números inteiros e retorne uma lista com os números em ordem crescente, 
// sem usar o método de ordenação da linguagem.
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
// 10. Crie uma classe "Triangulo" com os atributos "base" e "altura". 
// Adicione um método chamado "area" que calcula e retorna a área do triângulo.
class Triangulo(val base: Double, val altura: Double) {
    fun area(): Double {
        return base * altura / 2
    }
}
fun testeTriangulo() {
    val triangulo = Triangulo(10.0, 5.0)
    println(triangulo.area()) // 25.0
}
// 11. Crie uma função que receba uma lista de strings e retorne uma lista com todas as strings que começam com a letra "A", 
// em ordem alfabética.
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

fun testeOrdenar() {
    println("ordenar([1, 2, 3, 4, 5]) = ${ordenar(listOf(1, 2, 3, 4, 5))}")
    println("ordenar([5, 4, 3, 2, 1]) = ${ordenar(listOf(5, 4, 3, 2, 1))}")
}

// 12. Utilize um mapa para representar um dicionário de palavras e suas traduções.
fun testeMapa(){
    val dicionario = mapOf("casa" to "house", "gato" to "cat", "verde" to "green")
    println(dicionario["casa"]) // house
    println(dicionario["gato"]) // cat
    println(dicionario["verde"]) // green
}
// 13. Crie uma função de ordem superior chamada operacaoMatematica que aceita dois números e uma função lambda. 
// A função operacaoMatematica deve aplicar a função lambda aos dois números e retornar o resultado. 
// Em seguida, crie algumas funções lambda para realizar operações matemáticas, como soma, subtração, multiplicação e divisão. 
// Use a função de ordem superior para realizar essas operações com diferentes pares de números.
fun operacaoMatematica(a:Int,b:Int, operacao: (Int,Int) -> Int ) : Int{
    return operacao(a,b)
}
//14. Crie uma função de extensão chamada isPalindromo para a classe String que verifica se a string é um palíndromo. 
//A função deve ignorar espaços em branco e ser case-insensitive (não distinguir maiúsculas de minúsculas). 
//Em seguida, use essa função para verificar se algumas palavras são palíndromos.
fun String.isPalindromo() :Boolean{
    val texto = this.lowercase().replace(" ","")
    return texto == texto.reversed()
}
fun main(){
    println(isEven(3))
    println(maxNumber(intArrayOf(2,4,22,77,11,55,101,42)))
    val ns = intArrayOf(2,4,22,77,11,55,101,42)
    println(ns.reduce({r, x -> if (x>r) x else r}))
	val pessoas = arrayListOf(Pessoa("Mark",42),Pessoa("Isadora",2),Pessoa("Luiza",0))
    pessoas.sortBy{ it.idade }
    println(pessoas)
    println("${isPalindrome("ana")}")
    println("${max(3,5)}")
    val conta = ContaBancaria(1000.0,500.0)
    conta.saque(500.0)
    println(conta.saldo)
    try{
       	conta.saque(1500.0)
    }catch(e:Exception){
        println(e.message)
    }
    println(conta.retiradas)
	println("${longestString(listOf("a","aaafff","vbbbb","fwefew"))}")
    val mark = Funcionario("Mark",42,50000.0)
    val joselli = Funcionario("joselli",42,15000.0)
	val erik = Funcionario("erik",42,150000.0)
	var maior = listOf(mark,joselli,erik).reduce{r,x -> if(r.salario > x.salario) r else x }
    println("${maior.nome}")
    println("${operacaoMatematica(3,4, { a,b -> a+b })}")
    println("ana".isPalindromo())
}
