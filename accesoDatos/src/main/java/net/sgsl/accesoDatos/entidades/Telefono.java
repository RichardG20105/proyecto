package net.sgsl.accesoDatos.entidades;

import javax.persistence.*;

@Entity
@Table(name = "telefono_productor")
public class Telefono {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_telefono;
	
	@Column(name = "id_productor")
	private Long id_productor;
	@Column(name = "telefono")
	private String telefono;
	
	public Telefono() {
		super();
	}
	public Telefono(Long id_productor, String telefono) {
		super();
		this.id_productor = id_productor;
		this.telefono = telefono;
	}
	public Long getId_telefono() {
		return id_telefono;
	}
	public void setId_telefono(Long id_telefono) {
		this.id_telefono = id_telefono;
	}
	public Long getId_productor() {
		return id_productor;
	}
	public void setId_productor(Long id_productor) {
		this.id_productor = id_productor;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
}
