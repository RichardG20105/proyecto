package net.sgsl.accesoDatos.controlador;

import java.util.List;

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

import net.sgsl.accesoDatos.Repository.productorServicios;
import net.sgsl.accesoDatos.entidades.Productor;
import net.sgsl.accesoDatos.controlador.telefonoControlador;
import net.sgsl.accesoDatos.exception.ResourceNotFoundException;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/productores/")
public class productorControlador {
	
	@Autowired
	private productorServicios productorServicio;
	
	//getProductores
	@GetMapping("buscarproductor")
	public List<Productor> getProductores(){
		return this.productorServicio.findAll();
	}
	
	//getProductorCedula
	@GetMapping("/buscarproductor/{id}")
	public ResponseEntity<Productor> getProductorId(@PathVariable(value = "id") Long id_productor)
		throws ResourceNotFoundException{
			Productor productor = productorServicio.findById(id_productor)
			.orElseThrow(() -> new ResourceNotFoundException("No existe Productor con el id ::"+id_productor));
			return ResponseEntity.ok().body(productor);
	}
	
	//crearProductor
	@PostMapping("productor")
	public Productor crearProductor(@Valid @RequestBody Productor productor) {
		return this.productorServicio.save(productor);
	}
	
	//updateProductor
	@PutMapping("productor/{id}")
	public ResponseEntity<Productor> updateProductor(@PathVariable(value = "id") Long id_productor,@Valid @RequestBody Productor productorDetails) throws ResourceNotFoundException{
		Productor productor = productorServicio.findById(id_productor)
				.orElseThrow(() -> new ResourceNotFoundException("No existe Productor con el id :"+id_productor));
		productor.setCedula(productorDetails.getCedula());
		productor.setNombre(productorDetails.getNombre());
		productor.setApellido(productorDetails.getApellido());
		productor.setDireccion(productorDetails.getDireccion());
		productor.setEmail(productorDetails.getEmail());		
		
		return ResponseEntity.ok(this.productorServicio.save(productor));
	}
	//deleteProductor
}
