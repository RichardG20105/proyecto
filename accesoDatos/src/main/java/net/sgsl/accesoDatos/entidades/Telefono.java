package net.sgsl.accesoDatos.entidades;

import javax.persistence.*;

@Entity
@Table(name = "telefono_productor")
public class Telefono {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_telefono;
	@Column(name = "telefono")
	private String telefono;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name  = "id_productor")
	private Productor productor;
	
	public Telefono() {
		super();
	}
	public Telefono(String telefono) {
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
	public void setProductor(Productor productor) {
		this.productor = productor;
	}
	
}
