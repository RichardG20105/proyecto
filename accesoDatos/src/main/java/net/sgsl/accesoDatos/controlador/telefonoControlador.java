package net.sgsl.accesoDatos.controlador;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.*;

import net.sgsl.accesoDatos.entidades.Telefono;
import net.sgsl.accesoDatos.exception.ResourceNotFoundException;
import net.sgsl.accesoDatos.Repository.productorServicios;
import net.sgsl.accesoDatos.Repository.telefonoServicios;
@RestController
@CrossOrigin
@RequestMapping("/productores/")
public class telefonoControlador {
	@Autowired
	private telefonoServicios telefonoServicio;
	@Autowired
	private productorServicios productorServicio;
	//buscartelefono
	@GetMapping("{id_prod}/buscartelefono")
	public Optional<Telefono> getTelefono(@PathVariable(value = "id_prod") Long id_productor){
		return this.telefonoServicio.findById(id_productor);
	}
	//crearTelefono
	@PostMapping("{id_prod}/telefono")
	public Telefono crearTelefono(@PathVariable(value = "id_prod") Long id_productor,@Valid @RequestBody Telefono telefono) throws ResourceNotFoundException {
		productorServicio.findById(id_productor).orElseThrow(()->new ResourceNotFoundException("Productor no Encontrado"));
		return telefonoServicio.save(telefono);
	}
	//Actualizar
	@PutMapping("{id_prod}tel/{id_tel}")
	public ResponseEntity<Telefono> updateTelefono(@PathVariable(value = "id") Long id_telefono,@Valid @RequestBody Telefono telefonoDetails) throws ResourceNotFoundException{
		Telefono telefono = telefonoServicio.findById(id_telefono)
				.orElseThrow(() -> new ResourceNotFoundException("No existe el Telefono con el id :"+id_telefono));
		telefono.setTelefono(telefonoDetails.getTelefono());		
		
		return ResponseEntity.ok(this.telefonoServicio.save(telefono));
	}
}
