class Solution {
    fun checkValid(matrix: Array<IntArray>): Boolean {
    // size pega N numa matriz N x N.
    // linecheck e columncheck serão usados no loop para registrar quando
    // encontrado o valor numa linha ou coluna.
        val size = matrix.size
        var linecheck: Boolean
        var columncheck: Boolean

    // primeiro loop para gerar os valores que sãoesperados em cada linha ou coluna
        for (expected_value in 1..size){
    // segundo loop itera cada linha ou coluna da matriz
            for (a in 0..(size - 1)){
                // reset das 2 variáveis check para false
                linecheck = false
                columncheck = false
    // terceiro loop para iterar cada elemento dentro de uma linha ou coluna
                for (b in 0..(size-1)){
    // se encontrar o valor naquele elemento, linecheck torna-se true
                    if (matrix[a][b] == expected_value){
                        linecheck = true
                    }
    // se encontrar o valor naquele elemento, columncheck torna-se true
                    if (matrix[b][a] == expected_value){
                        columncheck = true
                    }
                    
    // se as duas varáveis são true não há porque continuar iterando dentro da linha e coluna
                    if (linecheck == true && columncheck == true){
                        break
                    }
                }
    // ao fim da iteração de cada linha e coluna, se houver um check false, já retorna false
            if (linecheck == false || columncheck == false ){
                return false
                }
            }
        }
    // depois dos loops, se não encontrar nada falso, é porque é verdadeiro
        return true
    }
}
