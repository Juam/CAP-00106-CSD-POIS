package ar.com.grupoesfera.csd.pois.controladores;

import ar.com.grupoesfera.csd.pois.modelos.Poi;
import ar.com.grupoesfera.csd.pois.modelos.Pong;
import ar.com.grupoesfera.csd.pois.service.POISService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
