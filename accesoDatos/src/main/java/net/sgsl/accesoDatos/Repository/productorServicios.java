package net.sgsl.accesoDatos.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.sgsl.accesoDatos.entidades.Productor;
 

@Repository
public interface productorServicios extends JpaRepository<Productor, Long>{
	
}
