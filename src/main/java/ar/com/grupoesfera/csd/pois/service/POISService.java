package ar.com.grupoesfera.csd.pois.service;

import ar.com.grupoesfera.csd.pois.modelos.Itinerario;
import ar.com.grupoesfera.csd.pois.modelos.Poi;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class POISService {

    private List<Poi> lista = new ArrayList<>(
            Arrays.asList(new Poi(-34.58791299400182,-58.423084840222,"Rapa nui","Una rica heladeria","heladeria"),
                    new Poi(-34.58958675108932,-58.42795175118532,"Freddo","Otra heladeria","heladeria"),
                    new Poi(-34.58428917744298, -58.43766774433044,"Buenos aires verde","Un restaurant verde","restaurant")));
    private List<Itinerario> itinerarios = new ArrayList<>(
            Arrays.asList(new Itinerario("Fiesta1", "Almuerzo y postre", new ArrayList<>(
                    Arrays.asList(new Poi(-34.58428917744298, -58.43766774433044,"Buenos aires verde","Un restaurant verde","restaurant"),
                            new Poi(-34.58791299400182,-58.423084840222,"Rapa nui","Una rica heladeria","heladeria"),
                            new Poi(-34.588097427250915, -58.430480822197964,"Polaris Omakase","Un bar","bar")
                            ))),
            new Itinerario("Paseo", "Cualquier cosa", new ArrayList<>(
                    Arrays.asList(new Poi(-34.59853916136499, -58.38986324256482,"Rincon norteño","Un lugar de empanadas","restaurant"),
                            new Poi(-34.579905299200256, -58.43378348981585,"Jauja","Otra heladeria cerrada permanentemente","heladeria"),
                            new Poi(-34.588097427250915, -58.430480822197964,"Polaris Omakase","Un bar","bar")
                    )))));
    public List<Poi> obtenerPOISDeUnaCategoria(String categoria, Double latitud, Double longitud) {
        if (latitud != null && longitud != null) {
            Poi poi = lista.stream().filter(p -> p.getCategoria().equals(categoria)).min(Comparator.comparing(p -> p.distancia(latitud, longitud))).orElse(null);
            return Arrays.asList(poi);
        } else {
            return lista.stream().filter(p -> p.getCategoria().equals(categoria)).collect(Collectors.toList());
        }
    }

    public Itinerario obtenerItinerarioPorNombre(String nombre) {
        return itinerarios.stream().filter(i -> i.getNombre().equalsIgnoreCase(nombre)).findFirst().orElse(null);
    }
}
