package org.SistemaDeGestionDeTareas.dao;

import java.util.List;

import org.SistemaDeGestionDeTareas.entidad.Tareas;
import org.SistemaDeGestionDeTareas.entidad.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class ConfigHibernateDao {

    private SessionFactory sessionFactory;

    public ConfigHibernateDao() {
        // Configuración de Hibernate
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    public Session abrirSesion() {
        // Abrir sesion
        return sessionFactory.openSession();
    }

    public void guardarEntidad(Object entidad) {
    	//Guardar la entidad
        Session session = abrirSesion();
        session.beginTransaction();

        try {
            session.save(entidad);
            System.out.println("La entidad se ha guardado con éxito.");
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Error al guardar la entidad: " + e.getMessage());
        } finally {
            session.close();
        }
    }
    
    public void leerEntidadUsuario() {
    	Session session = abrirSesion();
    	session.beginTransaction();
    	
    	try {
    		List<Usuario> lista = (List<Usuario>) session.createQuery("FROM Usuario").list();
    		
    		for(Usuario usuario:lista) {
    			System.out.println("Usuario: " + usuario.getUsername());
    			System.out.println("Password: " + usuario.getPassword());
    			System.out.println("Email: " + usuario.getEmail());
    			System.out.println("Tareas: ");
    			for(int i=0; i<usuario.getListaTareas().size();i++) {
    				System.out.println((i+1) + ")");
    				System.out.println("Nombre: " + usuario.getListaTareas().get(i).getName());
    				System.out.println("Descripcion: " + usuario.getListaTareas().get(i).getDescripcion());
    				System.out.println("Estado: " + usuario.getListaTareas().get(i).getEstado());
    			}
    			System.out.println();
    		}
    	}catch (Exception e) {
    		session.getTransaction().rollback();
            System.err.println("Error al leer la entidad: " + e.getMessage());
    	}finally {
    		session.close();
    	}
    }
    
    public void leerUsuario(Long id) {
        Session session = abrirSesion();
        session.beginTransaction();
		try {	
			Usuario usuario = (Usuario) session.get(Usuario.class, id);
			System.out.println("Username: " + usuario.getUsername());
			System.out.println("Email: " + usuario.getEmail());
			System.out.println("Password: " + usuario.getPassword());
			
			session.getTransaction().commit();
		}catch (Exception e) {
    		session.getTransaction().rollback();
            System.err.println("Error al leer la entidad: " + e.getMessage());
    	}finally {
    		session.close();
    	}
		
	}
    
	public void deleteUsuario(Long id) {
        Session session = abrirSesion();
        session.beginTransaction();
		try {
			
			Usuario usuario = (Usuario) session.get(Usuario.class, id);
			session.delete(usuario);
			System.out.println("El usuario " + usuario.getUsername() + " ha sido eliminado con exito.");
	        
			
			session.getTransaction().commit();
		}catch (Exception e) {
    		session.getTransaction().rollback();
            System.err.println("Error al leer la entidad: " + e.getMessage());
    	}finally {
    		session.close();
    	}
		
	}
	
	public void deleteTarea(Long id) {
        Session session = abrirSesion();
        session.beginTransaction();
		try {
			
			Tareas tarea = (Tareas) session.get(Tareas.class, id);
			session.delete(tarea);
			System.out.println("La tarea " + tarea.getName() + " ha sido eliminada con exito.");
	        
			
			session.getTransaction().commit();
		}catch (Exception e) {
    		session.getTransaction().rollback();
            System.err.println("Error al leer la entidad: " + e.getMessage());
    	}finally {
    		session.close();
    	}
		
	}

	public void editUsuario(Long id_usuario, String nuevo_username, String nuevo_email, String nuevo_password) {
		Session session = abrirSesion();
        session.beginTransaction();
        
		try {	
			Usuario usuario = (Usuario) session.get(Usuario.class, id_usuario); 
			usuario.setUsername(nuevo_username);
			usuario.setEmail(nuevo_email);
			usuario.setPassword(nuevo_password);
			
			session.update(usuario);
	        System.out.println("Se ha actualizado el usuario");
			
			session.getTransaction().commit();
		}catch (Exception e) {
    		session.getTransaction().rollback();
            System.err.println("Error al leer la entidad: " + e.getMessage());
    	}finally {
    		session.close();
    	}
	}
	
	public void editTarea(Long id_tarea, String nuevo_name, String nueva_descripcion, String nuevo_estado) {
		Session session = abrirSesion();
        session.beginTransaction();
        
		try {	
			Tareas tarea = (Tareas) session.get(Tareas.class, id_tarea); 
			tarea.setName(nuevo_name);
			tarea.setDescripcion(nueva_descripcion);
			tarea.setEstado(nuevo_estado);
			
			session.update(tarea);
	        System.out.println("Se ha actualizado el usuario");
			
			session.getTransaction().commit();
		}catch (Exception e) {
    		session.getTransaction().rollback();
            System.err.println("Error al leer la entidad: " + e.getMessage());
    	}finally {
    		session.close();
    	}
	}

    public void cerrarSesion() {
        // Cierra la sesión
        sessionFactory.close();
    }
    
}