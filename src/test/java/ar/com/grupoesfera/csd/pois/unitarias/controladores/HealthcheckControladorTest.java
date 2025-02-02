package ar.com.grupoesfera.csd.pois.unitarias.controladores;

import ar.com.grupoesfera.csd.pois.controladores.HealthcheckControlador;
import ar.com.grupoesfera.csd.pois.modelos.Poi;
import ar.com.grupoesfera.csd.pois.modelos.Pong;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class HealthcheckControladorTest {

    @InjectMocks
    private HealthcheckControlador controlador;

    @Test
    public void seDevuelveUnPongAlConsultarElPing(){

        ResponseEntity<Pong> respuesta = controlador.obtengoElPongDeLaAplicacion();

        Pong cuerpo = respuesta.getBody();

        assertThat(respuesta.getStatusCode().value()).isEqualTo(200);
        assertThat(cuerpo).isNotNull();
        assertThat(cuerpo.getMensaje()).isEqualTo("pong");
    }

    @Test
    public void verificarQueLaDistanciaEntreUnPoiYUnaUbicacionEs1() {
        Poi poi = new Poi(1,1,"Rapa nui","Una rica heladeria","heladeria");
        Double distancia = poi.distancia(Double.valueOf(2),Double.valueOf(2));

        assertThat(distancia).isEqualTo(Math.sqrt(2));
    }
}
