package net.sgsl.accesoDatos.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import net.sgsl.accesoDatos.entidades.Terreno;
import net.sgsl.accesoDatos.entidades.Usuario;

@Repository

public interface terrenoServicios extends JpaRepository< Terreno , Long> {

	boolean existsByDireccionTerreno(String direccion_terreno);
	
}
