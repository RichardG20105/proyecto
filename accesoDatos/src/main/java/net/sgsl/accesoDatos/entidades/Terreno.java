package net.sgsl.accesoDatos.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Terreno")
public class Terreno {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_terreno;
	
	@Column(name = "id_productor")
	private int id_productor;
	
	@Column (name="direccion_terreno")
	private String direccion_terreno ;
	
	@Column (name="cant_hect")
	private int cant_hect;
	
	public Terreno() {
		super();
	}
	
	 public Terreno(int id_productor, String direccion_terreno, int cant_hect) {
		super();
		this.id_productor = id_productor;
		this.direccion_terreno = direccion_terreno;
		this.cant_hect = cant_hect;
	}


	public long getId_terreno() {
		return id_terreno;
	}

	public void setId_terreno(long id_terreno) {
		this.id_terreno = id_terreno;
	}

	public int getId_productor() {
		return id_productor;
	}

	public void setId_productor(int id_productor) {
		this.id_productor = id_productor;
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
}
