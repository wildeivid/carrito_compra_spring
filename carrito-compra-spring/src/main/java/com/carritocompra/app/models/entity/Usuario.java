package com.carritocompra.app.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(nullable = false)
	private String nombre;
	
	@NotBlank
	@Column(nullable = false)
	private String apellido;
	
	@Email
	@NotBlank
	@Size(min=3, max=100)
	private String email;
	
	@NotBlank
	@Size(min=3, max=10)
	@Column(name = "user_name", nullable = false, unique = true)
	private String userName;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fecha_nacimiento")
	private Date fechaNacimiento;
	
	@OneToMany(targetEntity = Carrito.class)
	private List<Carrito> listaCarritos;
	
	
	
	public Usuario() {
		
	}

	public Usuario(@NotBlank String nombre, 
			@NotBlank String apellido,
			@Email @NotBlank @Size(min = 3, max = 100) String email, 
			@NotBlank @Size(min = 3, max = 10) String userName,
			@NotNull Date fechaNacimiento) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.userName = userName;
		this.fechaNacimiento = fechaNacimiento;
	}

	public Usuario(Long id, @NotBlank 
			String nombre, 
			@NotBlank String apellido, 
			@Email @NotBlank @Size(min = 3, max = 100) String email, 
			@NotBlank @Size(min = 3, max = 10) String userName,
			@NotNull Date fechaNacimiento) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.userName = userName;
		this.fechaNacimiento = fechaNacimiento;
	}

	public Usuario(Long id, 
			@NotBlank String nombre, 
			@NotBlank String apellido,
			@Email @NotBlank @Size(min = 3, max = 100) String email, 
			@NotBlank @Size(min = 3, max = 10) String userName,
			@NotNull Date fechaNacimiento, 
			List<Carrito> listaCarritos) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.userName = userName;
		this.fechaNacimiento = fechaNacimiento;
		this.listaCarritos = listaCarritos;
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Carrito> getListaCarritos() {
		return listaCarritos;
	}

	public void setListaCarritos(List<Carrito> listaCarritos) {
		this.listaCarritos = listaCarritos;
	}
	
}