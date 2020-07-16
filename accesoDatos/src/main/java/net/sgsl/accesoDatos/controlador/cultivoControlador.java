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

import net.sgsl.accesoDatos.Repository.cultivoServicios;
import net.sgsl.accesoDatos.entidades.Cultivo;
import net.sgsl.accesoDatos.exception.ResourceNotFoundException;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/cultivos/")
public class cultivoControlador {
	@Autowired
	private cultivoServicios cultivoServicio;
	
	//getCultivos
		@GetMapping("buscarcultivo")
		public List<Cultivo> getCultivos(){
			return this.cultivoServicio.findAll();
		}
		
		//getPCultivoId
		@GetMapping("/buscarcultivo/{id}")
		public ResponseEntity<Cultivo> getCultivoId(@PathVariable(value = "id") Long id_cultivo)
			throws ResourceNotFoundException{
				Cultivo cultivo = cultivoServicio.findById(id_cultivo)
				.orElseThrow(() -> new ResourceNotFoundException("No existe el Cultivo con el id ::"+id_cultivo));
				return ResponseEntity.ok().body(cultivo);
		}
		
		//crearCultivo
		@PostMapping("cultivo")
		public Cultivo crearCultivo(@RequestBody Cultivo cultivo) {
			return this.cultivoServicio.save(cultivo);
		}
		
		//updateCultivo
		@PutMapping("cultivo/{id}")
		public ResponseEntity<Cultivo> updateCultivo(@PathVariable(value = "id") Long id_cultivo,@Valid @RequestBody Cultivo cultivoDetails) throws ResourceNotFoundException{
			Cultivo cultivo = cultivoServicio.findById(id_cultivo)
					.orElseThrow(() -> new ResourceNotFoundException("No existe el Cultivo con el id :"+id_cultivo));
			cultivo.setCant_cult(cultivoDetails.getCant_cult());	
			cultivo.setDetalle_cult(cultivoDetails.getDetalle_cult());
			cultivo.setFecha_cult(cultivoDetails.getFecha_cult());
			cultivo.setNombre_cult(cultivoDetails.getNombre_cult());
			
			return ResponseEntity.ok(this.cultivoServicio.save(cultivo));
		}
		//deleteCultivo
}
