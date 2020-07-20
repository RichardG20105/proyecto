package net.sgsl.accesoDatos.entidades;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "telefono_productor")
public class Telefono {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_telefono;
	@Column(name = "telefono")
	private String telefono;
	
	public Telefono() {
		super();
	}

	public Telefono(String telefono, Productor productor) {
		super();
		this.telefono = telefono;
	}

	public Long getId_telefono() {
		return id_telefono;
	}

	public void setId_telefono(Long id_telefono) {
		this.id_telefono = id_telefono;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}	
}
