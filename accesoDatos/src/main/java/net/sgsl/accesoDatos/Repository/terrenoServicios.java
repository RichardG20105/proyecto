package net.sgsl.accesoDatos.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import net.sgsl.accesoDatos.entidades.Terreno;

@Repository
public interface terrenoServicios extends JpaRepository<Terreno, Long> {
	@Query(value = "SELECT * FROM terreno WHERE id_productor=?1",nativeQuery=true)
	List<Terreno> findByIdProductor(Long id_productor);
}
