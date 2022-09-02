import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TablaAmortizacion {
    public static void main(String[] args) {

        Scanner lectura = new Scanner (System.in);
        System.out.println("Ingrese Tasa de interés anual (TNA):");
        int numPagoAnioDefecto = Integer.parseInt(lectura.next());

        double tasaInteresAnual = 0.12d;

        System.out.println("Ingrese Valor del préstamo:");
        double valorPrestamo = Double.parseDouble(lectura.next());

        System.out.println("Ingrese Años:");
        int anios = Integer.parseInt(lectura.next());

        System.out.println("Ingrese Pagos por año:");
        int numPagoAnio = Integer.parseInt(lectura.next());

        double _tasaIntresPeriodica = 0;
        int _cuotas = 0;

        if(anios >= 1 && numPagoAnio >=12) {
            _tasaIntresPeriodica = tasaInteresAnual / numPagoAnio;
            _cuotas = anios * numPagoAnio;

            List<Result> resultado = new ArrayList<Result>();

            Result resultBase = new Result();
            resultBase.setnCuota(0);
            resultBase.setSaldoRemanente(valorPrestamo);
            resultBase.setInteresPeriodo(0);
            resultBase.setCapitalAmortizado(0);
            resultBase.setCuotaPagada(0);
            resultado.add(resultBase);

            for(int i = 1; i <= _cuotas; i++) {
                Result result = new Result();
                result.setnCuota(i);
                result.setSaldoRemanente(resultado.get(i-1).getSaldoRemanente() - resultado.get(i-1).getCapitalAmortizado());
                result.setInteresPeriodo(result.getSaldoRemanente() * _tasaIntresPeriodica);
                result.setCapitalAmortizado(valorPrestamo / _cuotas);
                result.setCuotaPagada(result.getInteresPeriodo() + result.getCapitalAmortizado());
                resultado.add(result);
            }
            ImprimirResultado(resultado);
        }

    }

    public static void ImprimirResultado(List<Result> resultado) {
        DecimalFormat f = new DecimalFormat("$##.00");

        System.out.println("N Cuota | Interes del periódo | Capital Amortizado | Cuota a pagar | Saldo Remanente");
        for(Result res: resultado) {
            System.out.println(res.getnCuota() + " | " +
                    f.format(res.getInteresPeriodo()) + " | " +
                    f.format(res.getCapitalAmortizado()) + " | " +
                            f.format(res.getCuotaPagada()) + " | " +
                                    f.format(res.getSaldoRemanente()) + " | "
            );
        }
    }

}
