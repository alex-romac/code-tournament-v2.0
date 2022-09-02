import java.text.NumberFormat
import kotlin.math.pow

fun main(args: Array<String>) {


    var loanValue: Double?
    var annualInterestRate: Double?
    var timeInYears: Double?
    val paymentsPerYear = 12

    println("Por favor ingrese la siguiente información")
    do {
        println("Valor del préstamo: ")
        loanValue = readLine()!!.toDoubleOrNull()
        if (loanValue == null) {
            println("No es un valor válido, intente de nuevo")
        }
    } while (loanValue == null)

    do {
        println("Tasa de interes anual: ")
        annualInterestRate = readLine()!!.toDoubleOrNull()
        if (annualInterestRate == null) {
            println("No es un valor válido, intente de nuevo")
        }
    } while (annualInterestRate == null)

    do {
        println("Plazo en años: ")
        timeInYears = readLine()!!.toDoubleOrNull()
        if (timeInYears == null) {
            println("No es un valor válido, intente de nuevo")
        }
    } while (timeInYears == null)

    val monthlyInterest: Double = annualInterestRate / (12 * 100)
    println(monthlyInterest)
    val monthlyPayment: Double =
        loanValue * (monthlyInterest / (1 - (1 + monthlyInterest).pow((timeInYears * -1))))


    val pattern =
        "%" + 20 + "s%" + 20 + "s%" + 20 + "s%" + 20 + "s%" + 20 + "s"

    System.out.printf(
        pattern,
        "N DE CUOTA",
        "INTERÉS DEL PERIODO",
        "CAPITAL AMORTIZADO",
        "CUOTA A PAGAR",
        "SALDO REMANENTE"
    )
    println()

    val nf = NumberFormat.getCurrencyInstance()

    for (quota in 1..paymentsPerYear) {
//        val amountInterest: Double = loanValue!!.times(monthlyInterest)
        val amountInterest: Double = loanValue!!.minus(monthlyInterest)
        val amountPrincipal = monthlyPayment.minus(amountInterest)
        loanValue = loanValue.minus(amountPrincipal)
        System.out.printf(
            pattern,
            quota,
            nf.format(amountInterest),
            nf.format(monthlyInterest),
            nf.format(amountPrincipal),
            nf.format(loanValue)
        )
        println()

    }
}
