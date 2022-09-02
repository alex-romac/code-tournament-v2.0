const readline = require("readline");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let ammount: number;
let interest: number;
let termYears: number;
let paymentsNumber: number = 12;

const userInputCmd = (
  message: string,
  condition: (value: string) => boolean,
  errorMsg: string,
  successFn: (value: number) => void
) => {
  rl.question(message, (value: string) => {
    if (!condition(value)) {
      console.log(errorMsg);
      return userInputCmd(message, condition, errorMsg, successFn);
    }
    return successFn(Number(value));
  });
};

const calcAmortTable = () => {
  userInputCmd(
    "Ingrese cantidad préstamo: ",
    (value) => !isNaN(Number(value)) && Number(value) > 0,
    "El valor ingresado debe ser un número mayor a 0",
    (value) => {
      ammount = value;
      enterInterest();
    }
  );
};
const enterInterest = () => {
  userInputCmd(
    "Ingrese tasa de interés anual: ",
    (value) =>
      !isNaN(Number(value)) && Number(value) > 0 && Number(value) <= 100,
    "El valor ingresado debe ser un número mayor a 0",
    (value) => {
      interest = value;
      enterTermYears();
    }
  );
};
const enterTermYears = () => {
  userInputCmd(
    "Ingrese plazo en años: ",
    (value) => !isNaN(Number(value)) && Number(value) >= 1,
    "El valor ingresado debe ser un número mayor o igual a 1",
    (value) => {
      termYears = value;
      enterPaymentsNumber();
    }
  );
};
const enterPaymentsNumber = () => {
  userInputCmd(
    "Ingrese número de pagos por año: ",
    (value) => !value || (!isNaN(Number(value)) && Number(value) >= 12),
    "El valor ingresado debe ser un número mayor o igual a 12",
    (value) => {
      if (value) paymentsNumber = value;
      console.log("Ingreso de datos exitoso");
      rl.close();
      console.table(amortTable());
    }
  );
};

const amortTable = () => {
  const table: any = {};
  let remainAmmount = ammount;
  for (let feeNumber = 1; feeNumber <= paymentsNumber; feeNumber++) {
    const periodInterest = remainAmmount * (interest / paymentsNumber / 100);
    const amortizedCapital =
      remainAmmount < 0.05 ? 0 : ammount / paymentsNumber;
    table[feeNumber] = {
      interesPeriodo: `\$${periodInterest.toFixed(2)}`,
      capitalAmortizado: `\$${amortizedCapital.toFixed(2)}`,
      cuota: `\$${(periodInterest + amortizedCapital).toFixed(2)}`,
      saldo: `\$${remainAmmount.toFixed(2)}`,
    };
    remainAmmount = remainAmmount - amortizedCapital;
  }
  return table;
};

export { calcAmortTable };
