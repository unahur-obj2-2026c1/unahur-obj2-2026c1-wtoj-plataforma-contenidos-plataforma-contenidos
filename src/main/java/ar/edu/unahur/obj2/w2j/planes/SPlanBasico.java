package ar.edu.unahur.obj2.w2j.planes;

public class SPlanBasico extends SPlanLimitado {

    public SPlanBasico(Integer limite) {
        super(limite);
    }

    
    @Override
    protected Double aplicarAjuste(Double total) {
        return total;
    }

}