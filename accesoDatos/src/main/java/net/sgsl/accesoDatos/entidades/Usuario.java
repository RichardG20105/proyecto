package net.sgsl.accesoDatos.entidades;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_usuario")
	private Long id_usuario;
	@Column(name = "username")
	private String username;
	
	@Column(name ="password")
	private String password;
	
	@ManyToOne
	@JoinColumn(name="id_rol")
	private Rol roles;
	
	public Usuario() {
		super();
	}
	public Usuario(long id_usuario ,String username, String password) {
		super();
		this.id_usuario = id_usuario;
		this.username = username;
		this.password = password;
	}
	
	
	
	public Long getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Rol getRoles() {
		return roles;
	}
	public void setRoles(Rol roles) {
		this.roles = roles;
	}
}
