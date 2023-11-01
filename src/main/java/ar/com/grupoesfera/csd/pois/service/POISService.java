package ar.com.grupoesfera.csd.pois.service;

import ar.com.grupoesfera.csd.pois.modelos.Poi;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class POISService {

    private List<Poi> lista = new ArrayList<>(
            Arrays.asList(new Poi(-34.58791299400182,-58.423084840222,"Rapa nui","Una rica heladeria","heladeria"),
                    new Poi(-34.58958675108932,-58.42795175118532,"Freddo","Otra heladeria","heladeria"),
                    new Poi(-34.58428917744298, -58.43766774433044,"Buenos aires verde","Un restaurant verde","restaurant")));;

    public List<Poi> obtenerPOISDeUnaCategoria(String categoria) {
        return lista.stream().filter(p -> p.getCategoria().equals(categoria)).collect(Collectors.toList());
    }
}
