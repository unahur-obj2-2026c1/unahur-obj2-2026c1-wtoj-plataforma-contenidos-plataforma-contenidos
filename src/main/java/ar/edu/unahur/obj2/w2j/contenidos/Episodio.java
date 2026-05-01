package ar.edu.unahur.obj2.w2j.contenidos;

public class Episodio {

  private final String titulo;
  private final Integer numero;
  private Double costo;

  public Episodio(String titulo, Integer numero, Double costo) {
    this.titulo = titulo;
    this.numero = numero;
    this.costo = costo;
  }

  public String getTitulo() {
    return titulo;
  }

  public Integer getNumero() {
    return numero;
  }

  public Double getCosto() {
    return costo; // devuelve el costo individual del episodio (unidad básica del cálculo)
  }

  // Podria no estar
  public void setCosto(Double costo) {
    this.costo = costo;
  }
}
