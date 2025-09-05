//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    // 1. Criar estacionamento ✔️
    // 2. Input para procurar ver vagas ✔️
    // 3. Listar vagas disponiveis ✔️
    // 4. selecionar vaga desejada ✔️
    // 5. impedir que as escolhas fujam do escopo ✔️
    // 6. adicionar a feature de outra vaga ️ ️✔️
    // 7. imprimir as vagas escolhidas ⏳
    // 8. ajustar ao terminar na segunda vaga a mensagem de agradecemos sua preferencia

    val vagas = Array(10) { true }


    // Função que vai mostrar as vagas disponiveis
    fun mostraVagas() {
        for (i in vagas.indices) {

            if (vagas[i] != false) {
                println("A vaga ${i + 1} esta disponivel\n---------------------")
            }

        }
    }

    // função para alocar o veiculo
    fun selecionarVaga() {
        println("Digite qual vaga deseja alocar seu veiculo")

        val numero = readln().toInt()
        val vagaEscolhida = numero - 1

        if (vagas[vagaEscolhida] == true) {
            vagas[vagaEscolhida] = false
            println("Você escolheu a vaga $numero")
        }
        else {
            println("A vaga $numero já está ocupada, escolha outra.")
        }

    }

    fun selecionarOutraVaga () {
        println("Você deseja alocar seu veiculo em outra vaga?\n1. sim\n2. não")

        var choice : String = ""

        do {
            println("Digite apenas '1' ou '2'")
            choice = readln()


            when (choice) {
                "1" -> {
                    mostraVagas()
                    selecionarVaga()
                }
                "2" -> println("Certo, agradecemos sua preferencia")
                else -> println("Digite um número válido")
            }
        }
        while (choice != "1" && choice != "2" )


    }
    // funcao que vai executar os demais codigos
    fun forceType () {
        var listar: String
        do {
            println("Digite \"vagas\" para ver as vagas disponiveis")
            listar = readln().lowercase()

            if (listar == "vagas"){
                mostraVagas()
            }
            else {println("Entrada invalida, por favor verifique se você digitou 'vagas' corretamente")}
        }
            while (listar != "vagas")


    }



    forceType()

    selecionarVaga()

    selecionarOutraVaga()
}