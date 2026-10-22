fun main() {
    val nome = "Ana"
    val numero = 10

    funcion1(nome, numero)
}

fun funcion1(nome: String, numero: Int) {
    val mensaxe = "Ola, $nome"
    val valor1 = numero + 5

    println("Nivel 1: $mensaxe")
    funcion2(nome, valor1, mensaxe)
}

fun funcion2(nome: String, valor: Int, mensaxe: String) {
    val valor2 = valor * 2
    val contexto = "$mensaxe. Estamos no nivel 2."

    println("Nivel 2: $contexto")
    funcion3(nome, valor2, contexto)
}

fun funcion3(nome: String, valor: Int, contexto: String) {
    val resultado = valor + 10

    println("Nivel 3: $nome")
    println("Contexto recibido: $contexto")
    println("Resultado final: $resultado")
}