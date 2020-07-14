package net.sgsl.accesoDatos.controlador;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.sgsl.accesoDatos.entidades.Telefono;
import net.sgsl.accesoDatos.exception.ResourceNotFoundException;
import net.sgsl.accesoDatos.Repository.telefonoServicios;
@RestController
@CrossOrigin
@RequestMapping("/telefono/")
public class telefonoControlador {
	@Autowired
	private telefonoServicios telefonoServicio;
	//crearTelefono
	@PostMapping("{id}")
	public Telefono crearTelefono(@RequestBody Telefono telefono) {
		return this.telefonoServicio.save(telefono);
	}
	//Actualizar
	@PutMapping("tel/{id}")
	public ResponseEntity<Telefono> updateTelefono(@PathVariable(value = "id") Long id_telefono,@Valid @RequestBody Telefono telefonoDetails) throws ResourceNotFoundException{
		Telefono telefono = telefonoServicio.findById(id_telefono)
				.orElseThrow(() -> new ResourceNotFoundException("No existe el Telefono con el id :"+id_telefono));
		telefono.setId_productor(telefonoDetails.getId_productor());
		telefono.setTelefono(telefonoDetails.getTelefono());		
		
		return ResponseEntity.ok(this.telefonoServicio.save(telefono));
	}
}
