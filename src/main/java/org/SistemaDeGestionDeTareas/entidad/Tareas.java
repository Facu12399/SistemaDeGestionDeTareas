package org.SistemaDeGestionDeTareas.entidad;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tareas")
public class Tareas implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_tarea;
	private String name;
	private String descripcion;
	private String estado;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	public Tareas() {}

	public Tareas(Long id_tarea, String name, String descripcion, String estado, Usuario usuario) {
		super();
		this.id_tarea = id_tarea;
		this.name = name;
		this.descripcion = descripcion;
		this.usuario = usuario;
		this.estado = estado;
	}



	public Long getId_tarea() {
		return id_tarea;
	}

	public void setId_tarea(Long id_tarea) {
		this.id_tarea = id_tarea;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Tareas [id_tarea=" + id_tarea + ", name=" + name + ", descripcion=" + descripcion + ", estado=" + estado
				+ ", usuario=" + usuario + "]";
	}
	
}
