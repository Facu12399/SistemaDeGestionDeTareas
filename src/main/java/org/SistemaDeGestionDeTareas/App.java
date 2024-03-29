package org.SistemaDeGestionDeTareas;

import java.util.ArrayList;
import java.util.List;

import org.SistemaDeGestionDeTareas.dao.ConfigHibernateDao;
import org.SistemaDeGestionDeTareas.entidad.Tareas;
import org.SistemaDeGestionDeTareas.entidad.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {	
    	
    	ConfigHibernateDao service = new ConfigHibernateDao();
    	
    	Usuario usuario1 = new Usuario();
    	usuario1.setUsername("Facu12399");
    	usuario1.setEmail("facundonahuelmaza@gmail.com");
    	usuario1.setPassword("Facu123");
    	
    	Usuario usuario2 = new Usuario();
    	usuario2.setUsername("Mati99");
    	usuario2.setEmail("matias12maza@gmail.com");
    	usuario2.setPassword("popia123");
    	
    	Tareas tarea1 = new Tareas();
    	tarea1.setName("Tender la cama");
    	tarea1.setDescripcion("Recordar poner bien en los bordes del colchon las sabanas.");
    	tarea1.setEstado("Pendiente");
    	
    	Tareas tarea2 = new Tareas();
    	tarea2.setName("Estudiar programacion");
    	tarea2.setDescripcion("Reforzar la parte practica, la inclusion de try-catch y el testear las aplicaciones.");
    	tarea2.setEstado("Pendiente");
    	
    	Tareas tarea3 = new Tareas();
    	tarea3.setName("Ir a trabajar");
    	tarea3.setDescripcion("Recordar llevar todo lo que sea necesario en cuanto a la planificacion de clases que se hizo.");
    	tarea3.setEstado("Pendiente");
    	
    	Tareas tarea4 = new Tareas();
    	tarea4.setName("Practicar piano");
    	tarea4.setDescripcion("Sacar nuevas canciones que expandan el horizonte de los acordes. Tal vez alguna cancion modal.");
    	tarea4.setEstado("Completa");
    	
    	//Guardamos datos de usuario 1
    	tarea1.setUsuario(usuario1);
    	tarea2.setUsuario(usuario1);
    	usuario1.getListaTareas().add(tarea1);
    	usuario1.getListaTareas().add(tarea2);
    	
    	//Guardamos datos de usuario 2
    	tarea3.setUsuario(usuario2);
    	tarea4.setUsuario(usuario2);
    	usuario2.getListaTareas().add(tarea3);
    	usuario2.getListaTareas().add(tarea4);
    	
    	//Abrimos la sesion de Hibernate
    	service.abrirSesion();
    	
    	//Solo hace falta guardar la entidad usuario, esta guardara tambien la entidad de las tareas automaticamente
    	service.guardarEntidad(usuario1);
    	service.guardarEntidad(usuario2);
    	
    	//Leemos todos los usuarios y sus tareas
    	service.leerEntidadUsuario();
    	
    	//Eliminamos una tarea (Si eliminaramos un usuario se borrarian todas las tareas de ese usuario)
    	service.deleteTarea(4L);
    	
    	//Editamos el usuario 1
    	service.editUsuario(1L, "Facu12399", "facundonahuelmaza@gmail.com", "Fnm41818#");
    	
    	//Editamos una tarea del usuario 1
    	service.editTarea(2L, "Practicar Programacion", "Reforzar la parte practica, la inclusion de try-catch y el testear las aplicaciones.", "En progreso");
    	
    	//Volvemos a leer todos los usuarios y sus tareas con sus respectivos cambios
    	service.leerEntidadUsuario();
    	
    	//Cerramos la sesion de Hibernate
    	service.cerrarSesion();
    	
    }
}
