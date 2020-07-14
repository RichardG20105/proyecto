package net.sgsl.accesoDatos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.sgsl.accesoDatos.entidades.Telefono;
@Repository
public interface telefonoServicios extends JpaRepository<Telefono, Long> {

}
