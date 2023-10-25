var PI = 3.14f

fun somaDoisAoInt(num:Int) : Int{
    var soma = 2 + num
    return soma
}

fun printNumeroLegal(num:Int){
    println("o numero $num legal é legal: ${num + 5}")
}

open class Aula (var numeroAlunos:Int, var nomeDisciplina:String, var ativa:Boolean = false){
    val nomeDaDisciplinaCompleta:String 
    	get() = "Disciplina: $nomeDisciplina"
    
    constructor(numeroAlunos:Int) :this(numeroAlunos,"",true){
        this.numeroAlunos = numeroAlunos
        nomeDisciplina = ""
    }
    open public fun printDadosDaAula(){
        println("A $nomeDaDisciplinaCompleta tem $numeroAlunos matriculados")
    }
    private var privada = "privada"
    
    companion object{
        fun metodoEstatico(){
            println("metodo estatico")
        }
    }
    
}

class AulaCompleta :Aula(25,"Kotlin"){
    override fun printDadosDaAula(){
        println("A AulaCompleta $nomeDaDisciplinaCompleta tem $numeroAlunos matriculados")
    }
}

interface MinhaInterface{
    val propriedade:Int
    fun funcAbstratas()
    fun funcMinhaInterface(){
        println("func chamada")
	}
}
class OverInterface() : MinhaInterface{
   override     val propriedade:Int = 5
   override fun funcAbstratas(){
        println("func abstrata chamada")
	}  
}

class Disciplina{
    var firstName:String
    
    init{
        firstName = "Mark"
    }
    
    var lastName:String
    
    init{
        lastName = "Joselli"
    }
    
}

fun main() {
    fun somar(a:Int,b:Int) = a + b

  	var kotlin = "🙂"
    kotlin = "Kotlin é muito legal"
    print(kotlin)
    val sentidoDaVida = 42
    println(sentidoDaVida)
    println(somaDoisAoInt(22))
    printNumeroLegal(5)
    println(somar(2,3))
    var aula = Aula(15,"Desenvolvimento Android")
    println(aula.nomeDaDisciplinaCompleta)
    aula.printDadosDaAula()
    var aula2 = Aula(25)
    println(aula2.nomeDaDisciplinaCompleta)
    var aulaCompleta = AulaCompleta()
    aulaCompleta.printDadosDaAula()
    
    var over = OverInterface()
    over.funcMinhaInterface()
    over.funcAbstratas()
    //comentariao de uma linha
    
    /*
     * comentario em bloco
     */
     
     var num = 3
    if(num < 5){
    	num = 8
    }else if(num > 3){
        num = 2
    }else{
        num = 4
    }
    
    var num2 = if(num == 3) 4 else 5
    
    val listaDeCompras = listOf("Omo","Downy","Nescau","Toddy","Tomate","Tobaina","Torrada","Ovo","Leite")
    
    println("----")

    
    listaDeCompras
    		.filter{ it.startsWith("T") }
            .sortedBy{ it }
            .map{ it.uppercase() }
            .forEach{ print("Item: $it -- ") }
    listaDeCompras.forEach{ print(it) }
    println("----")
    
    for (item in listaDeCompras){
        println(item)
    }
     
	for (i in listaDeCompras.indices){
        println("item:$i = ${listaDeCompras[i]}")
    }
    
    var i = 0
    
    while ( i < listaDeCompras.size){
        println("while item:$i = ${listaDeCompras[i]}")
        i++
    }
    //for i=0 ;i<10 ; i+=2
    for (i in 0..10 step 2){
        if(i == 2)
        	continue
        println(i)
        if (i > 5){
            break
        }
    }
    
    when(num2){
        4 -> print(4)
        5 -> print(5)
        else -> {
            print("nem 4 ou 5")
        }
    }
    
    Aula.metodoEstatico()
    
    var sets = setOf("maca","banana","melão")
    
    var maps = mapOf("cachorro" to "animal", "banana" to "fruta")
    
    val listaDeCompras2 = mutableListOf("Omo","Downy","Nescau","Toddy","Tomate","Tobaina","Torrada","Ovo","Leite")

    listaDeCompras2.add("requeijão")
    listaDeCompras2.removeAt(0)
    
    println(listaDeCompras2)
    
	var minhaAulaLegal:Aula?
    
    
    minhaAulaLegal = Aula(15,"Desenvolvimento iOs")

    minhaAulaLegal?.printDadosDaAula()
    
    
    
}