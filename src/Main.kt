// 1. Criar estacionamento ✔️
// 2. Input para procurar ver vagas ✔️
// 3. Listar vagas disponiveis ✔️
// 4. selecionar vaga desejada ✔️
// 5. impedir que as escolhas fujam do escopo ✔️
// 6. adicionar a feature de outra vaga ️ ️✔️
// 7. imprimir as vagas escolhidas ✔️
// 7.5 Ajustar a mensagem das vagas escolhidas e provalveelmente colocar uma função para isso ✔️
// 8. ajustar ao terminar na segunda vaga a mensagem de agradecemos sua preferencia ✔️
// 9. Ter a opção de querer editar ou não a vaga escolhida ✔️
// 10. Trocar a vaga selecionada ✔️
// 11.

fun main() {
    val vagas = Array(10) { true }
    val emojis = arrayOf("1️⃣", "2️⃣", "3️⃣", "4️⃣", "5️⃣", "6️⃣", "7️⃣", "8️⃣", "9️⃣", "🔟")
    val vagasEscolhidas = mutableListOf<Int>()

    fun mostraVagas() {
        println("\n=== VAGAS DISPONÍVEIS ===")
        for (i in vagas.indices) {
            if (vagas[i]) println("${emojis[i]} ➟ Vaga ${i + 1} disponível")
        }
        println("=========================\n")
    }

    fun selecionarVaga() {
        while (true) {
            println("Digite o número da vaga desejada (1-10):")
            val input = readln()
            val numero = input.toIntOrNull()
            if (numero == null || numero < 1 || numero > 10) {
                println("Vaga inválida! Escolha entre 1 e 10.")
            } else if (!vagas[numero - 1]) {
                println("❌ A vaga $numero já está ocupada.")
                mostraVagas()
            } else {
                vagas[numero - 1] = false
                vagasEscolhidas.add(numero)
                println("✅ Vaga $numero reservada com sucesso!")
                break
            }
        }
    }

    fun selecionarOutraVaga() {
        while (true) {
            println("Você deseja alocar seu veículo em outra vaga?\n1. sim\n2. não")
            val choice = readln()
            if (choice == "1") {
                mostraVagas()
                selecionarVaga()
            } else if (choice == "2") {
                break
            } else {
                println("Digite apenas '1' ou '2'")
            }
        }
        println("Agradecemos sua preferência!\n")
    }

    fun forceType() {
        while (true) {
            println("Digite \"vagas\" para ver as vagas disponíveis")
            val listar = readln().lowercase()
            if (listar == "vagas") {
                mostraVagas()
                break
            } else {
                println("Entrada inválida, por favor digite 'vagas' corretamente.")
            }
        }
    }

    fun imprimeVagasEscolhidas() {
        if (vagasEscolhidas.isEmpty()) {
            println("Nenhuma vaga foi escolhida.")
        } else {
            val mensagem = vagasEscolhidas.joinToString(", ") { "${emojis[it - 1]} Vaga $it" }
            println("Vagas escolhidas: $mensagem")
        }
    }

    fun editaVaga() {
        while (true) {
            println("Você deseja editar a(s) vaga(s) escolhida(s)?\n1. sim\n2. não")
            val choice = readln()
            if (choice == "1") {
                vagasEscolhidas.forEach { vagas[it - 1] = true }
                vagasEscolhidas.clear()
                println("Vagas liberadas. Escolha novamente:")
                mostraVagas()
                selecionarVaga()
                selecionarOutraVaga()
                imprimeVagasEscolhidas()
                println("Agradecemos sua preferência!")
                break
            } else if (choice == "2") {
                println("Certo, agradecemos sua preferência!")
                break
            } else {
                println("Digite apenas '1' ou '2'")
            }
        }
    }

    fun executar() {
        forceType()
        selecionarVaga()
        selecionarOutraVaga()
        imprimeVagasEscolhidas()
        editaVaga()
    }

    executar()
}
