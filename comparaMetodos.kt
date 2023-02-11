// importação necessária para medir tempo
import kotlin.system.measureNanoTime

//matriz 3x3
val entryData: Array<Array<Int>> = arrayOf(
    		arrayOf<Int>(1,2,3),
    		arrayOf<Int>(3,1,2),
    		arrayOf<Int>(2,3,1))
            

// matriz 8x8, se quiser usar, tirar marcas de comentário e comentar a matriz 3x3
/*val entryData: Array<Array<Int>> = arrayOf(
    		arrayOf<Int>(1,2,3,4,5,6,7,8),
    		arrayOf<Int>(2,3,4,5,6,7,8,1),
    		arrayOf<Int>(3,4,5,6,7,8,1,2),
    		arrayOf<Int>(4,5,6,7,8,1,2,3),
        	arrayOf<Int>(5,6,7,8,1,2,3,4),
        	arrayOf<Int>(6,7,8,1,2,3,4,5),
        	arrayOf<Int>(7,8,1,2,3,4,5,6),
        	arrayOf<Int>(8,1,2,3,4,5,6,7),
)*/

// com debug em true imprime algumas variáveis para cheque do código
val debug: Boolean = false

fun main() {
     
    println("Iniciando método Tosco")
    var elapsed = measureNanoTime {
        metodoTosco()
    }
    println("Tempo decorrido em Tosco foi ${elapsed/1000} microsegundos")
    
    println("Iniciando método Oxe")
    elapsed = measureNanoTime {
        metodoOxe()
    }
    println("Tempo decorrido em Oxe foi ${elapsed/1000} microsegundos")
}

fun metodoOxe() {
    var expectedSqSum: Int = 0
    for (i in 1..entryData.size) expectedSqSum += i*i
    if (debug == true) println ("Soma dos quadrados de cada linha/ coluna deve ser $expectedSqSum")
    
    var div: Int = 0
    var rem: Int = 0
    val N: Int = entryData.size
    val NSq: Int = N * N
    var lineSqSum: Int = 0
    var columnSqSum: Int = 0
    var result: Boolean = true
    
    for (i in 0 until NSq){
        div = i / N
        rem = i % N

        lineSqSum += entryData[div][rem] * entryData[div][rem]
        columnSqSum += entryData[rem][div] * entryData[rem][div]

        if (rem == N-1){
            if (lineSqSum != expectedSqSum || columnSqSum != expectedSqSum){
                if (debug == true) println (" falhou!")
                result = false
                break
            }
            if (debug == true){
                println("Para a linha e coluna $div")
            	println("soma dos quadrados $lineSqSum e $columnSqSum")
            }
            lineSqSum = 0
            columnSqSum = 0
        }
    }
    println("matriz é $result")
}

fun metodoTosco() {
    
    val matrixObject = classeMatriz(entryData) //cria objeto classe matriz
    var lineCheck: Boolean = false
    var columnCheck: Boolean = false
    
    // for para procurar cada número em um array
    for (expectedValue in 1..matrixObject.N){
        if (debug == true) println("valor procurado $expectedValue")
    	lineCheck = false
    	columnCheck = false
        
        // for para cada linha e coluna na matriz
    	for (i in 1..matrixObject.N){
            lineCheck = expectedValue in matrixObject.linha(i)
       		columnCheck = expectedValue in matrixObject.coluna(i)
            if (debug == true) println("lin/col $i resultado $lineCheck $columnCheck")
            if (lineCheck == false || columnCheck == false){
                break
            }
        }
        if (lineCheck == false || columnCheck == false){
            if (debug == true) println ("Não passou no teste 1")
            break
        }
        if (debug == true) println (" ")
    }
    if (lineCheck == false || columnCheck == false){
        println ("matriz falsa")
    }
    else println ("matriz verdadeira")
}

class classeMatriz (val matriz: Array<Array<Int>>){
    val N: Int = matriz.size
    
    // devolve N da matriz
    fun tamanho(): Int{
        return N
    }
    // devolve um array da linha número (lin)
    fun linha(lin: Int): IntArray{
        var result = IntArray(N)
        for (i in 0 until N){
            result[i]=matriz[lin-1][i]
        }
        return result
    }
    
    // devolve um array da coluna (col)
    fun coluna(col: Int): IntArray{
        var result = IntArray(N)
        for (i in 0 until N){
            result[i]=matriz[i][col-1]
        }
        return result
    }
    
    // verifica se há algum número fora dos limites, elem<1 ou elem>N
    fun validarElementos(): Boolean{
        for (i in 0 until N){
            for (j in 0 until N){
                if (matriz[i][j] < 1 || matriz[i][j] > N){
                    return false
                }
            }
        }
        return true
    }
    
}
