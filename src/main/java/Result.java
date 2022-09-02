public class Result {
    private Integer nCuota;
    private double interesPeriodo;
    private double capitalAmortizado;
    private double cuotaPagada;
    private double saldoRemanente;

    public Integer getnCuota() {
        return nCuota;
    }

    public void setnCuota(Integer nCuota) {
        this.nCuota = nCuota;
    }

    public double getInteresPeriodo() {
        return interesPeriodo;
    }

    public void setInteresPeriodo(double interesPeriodo) {
        this.interesPeriodo = interesPeriodo;
    }

    public double getCapitalAmortizado() {
        return capitalAmortizado;
    }

    public void setCapitalAmortizado(double capitalAmortizado) {
        this.capitalAmortizado = capitalAmortizado;
    }

    public double getCuotaPagada() {
        return cuotaPagada;
    }

    public void setCuotaPagada(double cuotaPagada) {
        this.cuotaPagada = cuotaPagada;
    }

    public double getSaldoRemanente() {
        return saldoRemanente;
    }

    public void setSaldoRemanente(double saldoRemanente) {
        this.saldoRemanente = saldoRemanente;
    }

    @Override
    public String toString() {
        return "Result{" +
                "nCuota=" + nCuota +
                ", interesPeriodo=" + interesPeriodo +
                ", capitalAmortizado=" + capitalAmortizado +
                ", cuotaPagada=" + cuotaPagada +
                ", saldoRemanente=" + saldoRemanente +
                '}';
    }
}
