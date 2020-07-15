package net.sgsl.accesoDatos.entidades;

import javax.persistence.*;

@Entity
@Table(name="Productor")
public class Productor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_productor;
	
	@Column(name = "cedula")
	private String cedula;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "apellido")
	private String apellido;
	@Column(name = "direccion")
	private String direccion;
	@Column(name = "email")
	private String email;
	
	public Productor() {
		super();
	}
	public Productor(String cedula, String nombre, String apellido, String direccion, String email) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.email = email;
	}
	
	public long getId_productor() {
		return id_productor;
	}
	public void setId_productor(long id_productor) {
		this.id_productor = id_productor;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}