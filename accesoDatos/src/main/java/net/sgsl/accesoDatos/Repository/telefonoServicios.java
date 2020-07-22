package net.sgsl.accesoDatos.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.sgsl.accesoDatos.entidades.Telefono;
@Repository
public interface telefonoServicios extends JpaRepository<Telefono, Long> {
	//Optional(Telefono) findByIdAndProductorId(Long id_telefono,Long id_productor);
}
