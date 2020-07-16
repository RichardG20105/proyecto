package net.sgsl.accesoDatos.controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.sgsl.accesoDatos.Repository.terrenoServicios;
import net.sgsl.accesoDatos.exception.ResourceNotFoundException;

import net.sgsl.accesoDatos.entidades.Terreno;

@RestController
@RequestMapping("/terrenos/")
public class terrenoControlador {
	
	@Autowired
	private terrenoServicios terrrenoServicio;
	
	 // listado de todos los terrenos
	
	@GetMapping ("terrenos")
	public List< Terreno > getTerrenos(){
		 return this.terrrenoServicio.findAll();
	} 
	
	// listar el terreno buscado por su id
	@GetMapping ("/buscarTerreno/{id}")
	public ResponseEntity<Terreno> getTerrenoId(@PathVariable(value = "id") Long id_terreno)
			throws ResourceNotFoundException{
				Terreno terrenos = terrrenoServicio.findById(id_terreno)
				.orElseThrow(() -> new ResourceNotFoundException("No existe el terreno con el id ::"+ id_terreno));
				return ResponseEntity.ok().body(terrenos);
	}
	
	// save terreno
	
	@PostMapping("terreno")
	public Terreno crearTerreno (@RequestBody Terreno terreno) {
		return this.terrrenoServicio.save(terreno);
	}
	
	// update terreno mediante su id
	
	@PutMapping("modificarTerreno/{id}")
	public ResponseEntity<Terreno> updateTerreno(@PathVariable(value = "id") Long id_terreno ,@Valid @RequestBody Terreno terrenoDetails) throws ResourceNotFoundException{
		Terreno terreno = terrrenoServicio.findById(id_terreno)
				.orElseThrow(() -> new ResourceNotFoundException("No existe el terreno con el id :"+ id_terreno));
		terreno.setId_productor(terrenoDetails.getId_productor());
	    terreno.setDireccion_terreno(terrenoDetails.getDireccion_terreno());
		terreno.setCant_hect(terrenoDetails.getCant_hect());
		
		return ResponseEntity.ok(this.terrrenoServicio.save(terreno));
	}
	
	// delete terreno mediante su id 
	@DeleteMapping("eliminarTerreno/{id}")
	public Map<String,Boolean> deleteTerreno(@PathVariable(value = "id") Long id_terreno) throws ResourceNotFoundException{
		
		Terreno terreno = terrrenoServicio.findById(id_terreno)
				.orElseThrow(() -> new ResourceNotFoundException("No existe el terreno con el id :"+ id_terreno));
		        this.terrrenoServicio.delete(terreno);
		        
		        Map<String,Boolean> response = new HashMap<>();
		        response.put("delete", Boolean.TRUE);
		   return response;
	}
	

}
