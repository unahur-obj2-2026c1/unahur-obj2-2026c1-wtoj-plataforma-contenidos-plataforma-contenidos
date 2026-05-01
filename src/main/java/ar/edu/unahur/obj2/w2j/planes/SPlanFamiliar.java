package ar.edu.unahur.obj2.w2j.planes;

public class SPlanFamiliar extends SPlanLimitado {
    private Double descuento = 0.15;

    public SPlanFamiliar(Integer limite) {
        super(limite);
    }

    @Override
    protected Double aplicarAjuste(Double total) {
        return total * (1 - descuento);
    }
}