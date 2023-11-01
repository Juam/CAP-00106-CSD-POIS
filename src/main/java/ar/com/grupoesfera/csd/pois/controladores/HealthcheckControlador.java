package ar.com.grupoesfera.csd.pois.controladores;

import ar.com.grupoesfera.csd.pois.modelos.Itinerario;
import ar.com.grupoesfera.csd.pois.modelos.Poi;
import ar.com.grupoesfera.csd.pois.modelos.Pong;
import ar.com.grupoesfera.csd.pois.service.POISService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class HealthcheckControlador {

    @Autowired
    POISService poisService;

    @GetMapping("/ping")
    public ResponseEntity<Pong> obtengoElPongDeLaAplicacion(){
        return ResponseEntity.ok(new Pong());
    }

    @GetMapping("/categoria/{categoria}/pois")
    public ResponseEntity<List<Poi>> obtengoLosPoisDeUnaCategoria(@PathVariable("categoria") String categoria){
        return ResponseEntity.ok(poisService.obtenerPOISDeUnaCategoria(categoria));
    }

    @GetMapping("/itinerario/{nombre}")
    public ResponseEntity<?> obtengoUnItinerarioPorNombre(@PathVariable("nombre") String nombre){
        Itinerario itinerario = poisService.obtenerItinerarioPorNombre(nombre);
        if (itinerario != null) {
            return ResponseEntity.ok(itinerario);
        } else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{ \"mensaje\": \"Itinerario no encontrado\" }");
    }
}
