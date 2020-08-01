package net.sgsl.accesoDatos.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="terreno")
public class Terreno {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_terreno")
	private long id_terreno;
	
	@Column (name="direccion_terreno")
	private String direccion_terreno ;
	
	@Column (name="cant_hect")
	private int cant_hect;
	
	@ManyToOne
	@JoinColumn(name="id_productor")
	private Productor productor;
	
	public Terreno() {
		super();
	}
	
	 public Terreno(String direccion_terreno, int cant_hect) {
			super();
			
			this.direccion_terreno = direccion_terreno;
			this.cant_hect = cant_hect;
			
		}
	public long getId_terreno() {
		return id_terreno;
	}
	
	public String getDireccion_terreno() {
		return direccion_terreno;
	}

	public void setDireccion_terreno(String direccion_terreno) {
		this.direccion_terreno = direccion_terreno;
	}

	public int getCant_hect() {
		return cant_hect;
	}

	public void setCant_hect(int cant_hect) {
		this.cant_hect = cant_hect;
	}

	public Productor getProductor() {
		return productor;
	}

	public void setProductor(Productor productor) {
		this.productor = productor;
	}
	
	
}
