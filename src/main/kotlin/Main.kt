import java.util.DoubleSummaryStatistics

fun main(args: Array<String>) {


    /*val inputAmount = readLine()
    try {
        val a: Double = inputAmount?.toDouble()
    } catch (exception: Exception) {
        println("The amount should be a number")
        return 0.0
    }*/

//    val time = readLine()

//    println(a)
    val amount = 30_000

    val annualInterestRowOne : Pair<Double, IntRange> = Pair(2.00, IntRange(1, 30))
    val annualInterestRowOTwo : Pair<Double, IntRange> = Pair(2.20, IntRange(31, 60))
    val annualInterestRowThree : Pair<Double, IntRange> = Pair(2.40, IntRange(61, 90))
    val annualInterestRowFour : Pair<Double, IntRange> = Pair(2.60, IntRange(91, 120))
    val annualInterestRowFive : Pair<Double, IntRange> = Pair(2.80, IntRange(121, 180))
    val annualInterestRowSix : Pair<Double, IntRange> = Pair(3.00, IntRange(181, 240))
    val annualInterestRowSeven : Pair<Double, IntRange> = Pair(3.20, IntRange(241, 300))
    val annualInterestRowEigth : Pair<Double, IntRange> = Pair(3.40, IntRange(301, 360))




    for (j in 200..340 step 20) {
        for (i in 30..360 step 30) {
            val annualInterestRate: Double = j.toDouble()
            print("Plazo en dias: $i")
            print(" ")
            print("Tasa de interés anual: ${annualInterestRate / 100}")
            print(" ")
            println("Interés ganado ${(amount * ((annualInterestRate / 100) / 100 * annualInterestRate / 360))}")

        }

    }

}
