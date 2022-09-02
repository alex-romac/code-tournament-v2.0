import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

public class Torneo {
    public static void main(String[] args) {
        GenerarData generarData = new GenerarData(30000, 30);
    }
}

class GenerarData {
    private static void init() {
        rates.add(Rate.builder().rate(2.00f).min(1).max(30).build());
        rates.add(Rate.builder().rate(2.20f).min(31).max(60).build());
        rates.add(Rate.builder().rate(2.40f).min(61).max(90).build());
        rates.add(Rate.builder().rate(2.60f).min(91).max(120).build());
        rates.add(Rate.builder().rate(2.80f).min(121).max(180).build());
        rates.add(Rate.builder().rate(3.00f).min(181).max(240).build());
        rates.add(Rate.builder().rate(3.20f).min(241).max(300).build());
        rates.add(Rate.builder().rate(3.40f).min(301).max(360).build());

    }

    private static List<Rate> rates = getRate(null);

    private static List<Rate> getRate(Integer days) {
        List<Rate> ratesLocal = new ArrayList<>();
        if (!validValues(days)) {
            return null;
        }
        for (Rate rate : rates) {
            if (days == null || rate.getMin() <= days && days <= rate.getMax()) {
                ratesLocal.add(rate);
            }
        }

        return ratesLocal;
    }

    private static boolean validValues(Integer value) {
        return value == null || (value > 0 && value <= 360);
    }

    public GenerarData(double monto, Integer plazo) {
        init();
        if(isValid(plazo)) {
            List<Rate> rates = getRate(plazo);
            imprimirSalida(calcularDatos(monto,plazo,rates.get(0).getRate()));
        }
    }

    public GenerarData(double monto) {
        if(isValid(monto)) {
            int dias[] = new int[]{30,60,90,120,180,240,300,360};
            float tazas[] = new float[]{2.00f,2.20f,2.40f,2.60f,2.80f,3.00f,3.20f,3.40f };


        }
    }

    private boolean isValid(double valor) {
        if(valor > 0 && valor <= 360) {
            return true;
        }
        return false;
    }

    private String[] calcularDatos(double monto, Integer plazo, float taza) {
        String resultado[] = new String[4];
        double interes  = Math.round(monto * (taza * plazo/360));
        double total = Math.round(interes + monto);
        resultado[0] = String.valueOf(plazo);
        resultado[1] = String.valueOf(taza);
        resultado[2] = String.valueOf(interes);
        resultado[3] = String.valueOf(total);

        return resultado;
    }

    private void imprimirSalida(String[] datos) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        System.out.println("Plazo en día    |   Tasa de interés anual   | Intéres ganado USD    |   Total a recibir monto más interess USD");
        System.out.println("" + datos[0] + "    " + datos[1] + "    " + datos[2] + "    " + datos[3]);
    }
}
