package net.sgsl.accesoDatos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import net.sgsl.accesoDatos.entidades.Terreno;

@Repository

public interface terrenoServicios extends JpaRepository< Terreno , Long> {

}
