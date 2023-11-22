package ar.com.grupoesfera.csd.pois.repositorio;

import ar.com.grupoesfera.csd.pois.modelos.Poi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioDePoi extends JpaRepository<Poi, Long> {
    @Query(value="select p.* from poi p where p.nombre= :nombre", nativeQuery=true)
    Poi findPorNombre(@Param("nombre") String nombre);
}
