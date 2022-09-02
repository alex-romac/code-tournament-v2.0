let valorPrestamo = 0
let tasaAnual = 0
let plazo = 0
let numeroPagosAnual = 12

validarValorPrestamo()
validarTasaAnual()
validarPlazo()
validarPagosAnual()

//calculos
let tasaIntPer = calcularTasaIntPer(tasaAnual, numeroPagosAnual)
let cuota = calcularCuota(plazo, numeroPagosAnual)
console.log(tasaIntPer, " ", cuota)
calcularAmortizacion()

function calcularAmortizacion() {
    let interesPeriodo = 0
    let capAmortizado = 0
    let cuotaAPagar = 0
    let saldoRemanente = valorPrestamo

    let amortizacionCalculada = []

    console.log("N cuota | Interes del periodo | capital amortizado | cuota a pagar | saldo remanente")
    tasaAnual = tasaAnual/100
    for (let i = 0; i < cuota; i++) {
        interesPeriodo = calcularIntPeriodo(tasaIntPer, saldoRemanente)
        saldoRemanente = calcularSaldoRemanente(saldoRemanente, capAmortizado)
        capAmortizado = calcularValorAmortizado(saldoRemanente,valorPrestamo, cuota)
        cuotaAPagar = calcularCuotasAPagar(interesPeriodo, capAmortizado)

        console.log(i+1, " | ", interesPeriodo, " | ", capAmortizado, " | ", cuotaAPagar, " | ", saldoRemanente)

    }
}

function validarValorPrestamo() {
    leerValorPrestamo()
    if (isNaN(valorPrestamo)) {
        alert("el valorPrestamo debe ser un numero")
        validarValorPrestamo()
    }
    if (valorPrestamo < 1) {
        alert("ingrese un valor mayor a 0 ")
        validarValorPrestamo()
    } else {
        console.log("valorPrestamo ", valorPrestamo)
    }
}

function validarTasaAnual() {
    leerTasaAnual()
    if (isNaN(tasaAnual)) {
        alert("tasaAnual debe ser un numero")
        validarTasaAnual()
    }
    if (tasaAnual < 1) {
        alert("ingrese un valor mayor a 0 ")
        validarTasaAnual()
    } else {
        console.log("tasaAnual ", tasaAnual)
    }
}

function validarPlazo() {
    leerPlazo()
    if (isNaN(plazo)) {
        alert("el plazo debe ser un numero")
        validarPlazo()
    }
    if (plazo < 1) {
        alert("ingrese un valor mayor a 0 ")
        validarPlazo()
    } else {
        console.log("plazo ", plazo)
    }
}

function validarPagosAnual() {
    leerNumeroPagos()
    if (numeroPagosAnual !== "") {
        if (isNaN(numeroPagosAnual)) {
            alert("el valorPrestamo debe ser un numero")
            validarPagosAnual()
        }
        if (numeroPagosAnual < 12) {
            alert("ingrese un valor mayor o igual a 12 ")
            validarPagosAnual()
        } else {
            console.log("numeroPagosAnual ", numeroPagosAnual)
        }
    }

}

function leerValorPrestamo() {
    valorPrestamo = prompt("Ingrese el valor del prestamo: ");
}

function leerTasaAnual() {
    tasaAnual = prompt("Ingrese tasa anual %): ");
}
function leerPlazo() {
    plazo = prompt("Ingrese el plazo en anios: ");
}
function leerNumeroPagos() {
    numeroPagosAnual = prompt("Ingrese numero de pagos anual: ");
}

//tasa de interes periodica tasaIntPer = TasaAnual/N pagos por anio

function calcularTasaIntPer(tna, pa) {
    return tna / pa
}

//cuotas = plazo*N pagos anio

function calcularCuota(plazo, numeroPagosAnual) {
    return plazo * numeroPagosAnual
}

//capital amortizado si saldo remanente <0.05? 0 : valorprestamo/numeroCuotas
function calcularValorAmortizado(saldoRemanente, valorPrestamo, numeroCuotas) {
    if (saldoRemanente < 0.05) {
        return 0
    } else {
        return valorPrestamo / numeroCuotas
    }
}

//saldo remanente (inicial)= valor prestamo
//saldo remanente = saldoRemanenteanterior- capital amortizado anterior

function calcularSaldoRemanente(saldoAnterior, capAmortAnterior) {
    return saldoAnterior - capAmortAnterior
}

//interes periodo = tasaIntPer * saldo remanente

function calcularIntPeriodo(tasaIntPer, saldoRemanente) {
    return tasaIntPer * saldoRemanente
}

//cuota a pagar = interes periodo + capital amortizado

function calcularCuotasAPagar(interesPeriodo, capAmortizado) {
    return interesPeriodo + capAmortizado
}