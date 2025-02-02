package ar.com.grupoesfera.csd.pois.modelos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Poi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double latitud;
    private double longitud;
    private String nombre;
    private String descripcion;
    private String categoria;

    public Poi() {}

    public Poi(double latitud, double longitud, String nombre, String descripcion, String categoria) {
        this.latitud = latitud;
        this.longitud = longitud;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
    }

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double distancia(Double latitud, Double longitud) {
        return Math.sqrt(Math.pow(this.latitud - latitud, 2) + Math.pow(this.longitud - longitud, 2));
    }
}
