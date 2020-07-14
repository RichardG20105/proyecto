package net.sgsl.accesoDatos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.sgsl.accesoDatos.entidades.Cultivo;

@Repository
public interface cultivoServicios extends JpaRepository<Cultivo, Long>{

}
