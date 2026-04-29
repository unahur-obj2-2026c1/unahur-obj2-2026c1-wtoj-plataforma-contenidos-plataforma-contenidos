package ar.edu.unahur.obj2.wtoj.contenido;

public class IDRA {

    private static IDRA instance = new IDRA();
    private Double valor = 0.5;

    private IDRA() {
    }

    public static IDRA getInstance() {
        return instance;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

}