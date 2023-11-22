package ar.com.grupoesfera.csd.pois.repositorio;

import ar.com.grupoesfera.csd.pois.modelos.Itinerario;
import ar.com.grupoesfera.csd.pois.modelos.Poi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioDeItinerario extends JpaRepository<Itinerario, Long> {

}
