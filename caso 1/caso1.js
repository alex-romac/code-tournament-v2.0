let monto = 0
let plazo = 0
let rangoPlazo = [1, 30, 60, 90, 120, 180, 240, 300, 360]
let intereses = [0.02, 0.220, 0.0240,0.0260,0.0280,0.03,0.0320,0.0340]
let interesPlazo=0
let interesGanado = 0
let total =0
validarMonto()
validarPlazo()

function validarMonto() {
    leerMonto()
    if (isNaN(monto)) {
        alert("el monto debe ser un numero")
        validarMonto()
    }
    if (monto < 1) {
        alert("ingrese un monto mayor a 0 ")
        validarMonto()
    } else {
        console.log("monto ", monto)
    }
}

function validarPlazo() {
    leerPlazo()
    if (plazo !== "") {
        if (isNaN(plazo)) {
            alert("el plazo ser un numero")
            validarPlazo()
        }
        if (monto < 1 || monto > 360) {
            alert("ingrese un plazo mayor a 0 y menor o igual a 360")
            validarMonto()
        }
        else {
            console.log("plazo ", plazo)
            verificarRango()
            calcularInteresGanado()
            calcularTotal()
            presentarTabla()
        }
    }

}

function leerMonto() {
    monto = prompt("Ingrese el monto de inversion: ");
}

function leerPlazo() {
    plazo = prompt("Ingrese el plazo (opcional): ");
}

//interesGanado = monto * (interesAnual * plazo/360)
//total = interesGanado+monto

function verificarRango() {
    let inicial = 0
    let final = 0
    for (let i = 0; i < rangoPlazo.length; i++) {
        if(plazo >= rangoPlazo[i] && plazo < rangoPlazo[i+1]+1){
            inicial = rangoPlazo[i]
            final = rangoPlazo[i+1]
            interesPlazo= intereses[i]
        }
    }
}

function calcularInteresGanado() {
    interesGanado =  monto * (interesPlazo * plazo/360)
}

function calcularTotal() {
    total = interesGanado + monto
}

function presentarTabla () {
    alert("plazo en dias | tasa ia | interesganado | total \n", plazo, interesPlazo, interesGanado, total)
    console.log("plazo en dias | tasa ia | interesganado | total")
    console.log(plazo, interesPlazo, interesGanado, total)

}