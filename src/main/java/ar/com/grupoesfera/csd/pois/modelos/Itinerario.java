package ar.com.grupoesfera.csd.pois.modelos;

import javax.persistence.*;
import java.util.List;

@Entity
public class Itinerario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    @OneToMany
    private List<Poi> listaDePois;

    public Itinerario() {
    }

    public Itinerario(String nombre, String descripcion, List<Poi> listaDePois) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.listaDePois = listaDePois;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Poi> getListaDePois() {
        return listaDePois;
    }

    public void setListaDePois(List<Poi> listaDePois) {
        this.listaDePois = listaDePois;
    }
}
