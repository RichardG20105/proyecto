package net.sgsl.accesoDatos.entidades;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


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
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_productor")
	private Set<Telefono> tel = new HashSet<>();
	
	public Productor() {
		super();
	}	
	public Productor(String cedula, String nombre, String apellido, String direccion, String email, Telefono tel) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.email = email;
		this.tel = tel;
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
	public Telefono getTel() {
		return tel;
	}
	public void setTel(Telefono tel) {
		this.tel = tel;
	}
	
}
