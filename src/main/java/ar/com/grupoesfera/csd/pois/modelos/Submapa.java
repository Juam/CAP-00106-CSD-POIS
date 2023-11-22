package ar.com.grupoesfera.csd.pois.modelos;

import javax.persistence.*;
import java.util.List;

@Entity
public class Submapa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String nombre;
    @OneToMany
    List<Poi> pois;

    public Submapa(Long id, String nombre, List<Poi> pois) {
        this.id = id;
        this.nombre = nombre;
        this.pois = pois;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Poi> getPois() {
        return pois;
    }

    public void setPois(List<Poi> pois) {
        this.pois = pois;
    }
}
