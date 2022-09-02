fun main(args: Array<String>) {


//    val inversionAmount = readLine()
//    val time = readLine()

    val amount = 30_000


    for (i in 30..360 step 30) {

        for (j in 200..340 step 20) {
            val annualInterestRate: Double = j.toDouble()
            print("Plazo en dias: $i")
            print(" ")
            print("Tasa de interés anual: ${annualInterestRate / 100}")
            print(" ")
            println("Interés ganado ${(amount * ((annualInterestRate / 100)/100 * annualInterestRate / 360))}")
        }
    }


}
