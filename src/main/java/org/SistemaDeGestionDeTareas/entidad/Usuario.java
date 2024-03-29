package org.SistemaDeGestionDeTareas.entidad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_usuario;
	private String username;
	private String email;
	private String password;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Tareas> listaTareas;
	
	public Usuario() {
	}
	
	public Usuario(Long id_usuario, String username, String email, String password, List<Tareas> listaTareas) {
		this.id_usuario = id_usuario;
		this.username = username;
		this.email = email;
		this.password = password;
		this.listaTareas = listaTareas;
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
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Tareas> getListaTareas() {
        if (listaTareas == null) {
            listaTareas = new ArrayList<>();
        }
        return listaTareas;
    }

	public void setListaTareas(List<Tareas> listaTareas) {
		this.listaTareas = listaTareas;
	}

	@Override
	public String toString() {
		return "Usuario [id_usuario=" + id_usuario + ", username=" + username + ", email=" + email + ", password="
				+ password + ", listaTareas=" + listaTareas + "]";
	}
	
}
