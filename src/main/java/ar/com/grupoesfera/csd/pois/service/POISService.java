package ar.com.grupoesfera.csd.pois.service;

import ar.com.grupoesfera.csd.pois.modelos.Itinerario;
import ar.com.grupoesfera.csd.pois.modelos.Poi;
import ar.com.grupoesfera.csd.pois.modelos.Submapa;
import ar.com.grupoesfera.csd.pois.repositorio.RepositorioDeItinerario;
import ar.com.grupoesfera.csd.pois.repositorio.RepositorioDePoi;
import ar.com.grupoesfera.csd.pois.repositorio.RepositorioDeSubmapa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class POISService {

    @Autowired
    RepositorioDePoi repositorioDePoi;
    @Autowired
    RepositorioDeItinerario repositorioDeItinerario;
    @Autowired
    RepositorioDeSubmapa repositorioDeSubmapa;

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
    public List<Poi> obtenerPOISDeUnaCategoria(String categoria, Double latitud, Double longitud, Double distancia) {
        List<Poi> lista = repositorioDePoi.findAll();
        if (latitud != null && longitud != null) {
            if (distancia != null) {
                return lista.stream().filter(p -> p.getCategoria().equals(categoria)).filter(p -> p.distancia(latitud, longitud) < distancia).collect(Collectors.toList());
            } else {
                Poi poi = lista.stream().filter(p -> p.getCategoria().equals(categoria)).min(Comparator.comparing(p -> p.distancia(latitud, longitud))).orElse(null);//Estabamos buscando la maxima distancia en lugar de la minima
                return Arrays.asList(poi);
            }
        } else {
            return lista.stream().filter(p -> p.getCategoria().equals(categoria)).collect(Collectors.toList());
        }
    }

    public Itinerario obtenerItinerarioPorNombre(String nombre) {
        //List<Itinerario> itinerarios = repositorioDeItinerarios.findAll();
        return itinerarios.stream().filter(i -> i.getNombre().equalsIgnoreCase(nombre)).findFirst().orElse(null);
    }

    public Submapa creacionSubmapa(Submapa submapa) {
        if (submapa.getNombre() == null) {
            return null;
        }
        List<Poi> pois = new ArrayList<>();
        for(Poi poi : submapa.getPois()) {
            pois.add(repositorioDePoi.findPorNombre(poi.getNombre()));
        }
        submapa.setPois(pois);
        return repositorioDeSubmapa.save(submapa);
    }

    public Poi creacionPoi(Poi poi) {
        if (poi.getNombre() == null) {
            return null;
        }

        return repositorioDePoi.save(poi);
    }
}
