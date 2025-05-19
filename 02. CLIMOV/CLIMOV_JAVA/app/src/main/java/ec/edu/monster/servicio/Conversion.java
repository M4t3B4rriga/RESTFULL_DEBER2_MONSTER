package ec.edu.monster.servicio;

public class Conversion {
    private double valor;
    private String tipo;

    public Conversion(double valor, String tipo) {
        this.valor = valor;
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public String getTipo() {
        return tipo;
    }
}
