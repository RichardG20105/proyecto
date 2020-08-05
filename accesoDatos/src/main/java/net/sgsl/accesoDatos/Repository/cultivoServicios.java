package net.sgsl.accesoDatos.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.sgsl.accesoDatos.entidades.Cultivo;

@Repository
public interface cultivoServicios extends JpaRepository<Cultivo, Long>{
	@Query(value = "SELECT * FROM cultivo WHERE id_cultivo=?1 AND id_terreno=?2",nativeQuery=true)
	Optional<Cultivo> findByCultivoAndTerreno(Long id_cultivo,Long id_terreno);
}
