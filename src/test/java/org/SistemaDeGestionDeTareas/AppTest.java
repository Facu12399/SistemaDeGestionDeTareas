package org.SistemaDeGestionDeTareas;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.SistemaDeGestionDeTareas.dao.ConfigHibernateDao;
import org.SistemaDeGestionDeTareas.entidad.Tareas;
import org.SistemaDeGestionDeTareas.entidad.Usuario;
import org.junit.jupiter.api.Test;

import com.mysql.cj.Session;

class AppTest {
	
	@Test
    public void testGuardarEntidad() {
        //Crea una instancia de la clase que contiene el método guardarEntidad
        ConfigHibernateDao service = new ConfigHibernateDao();
        
        service.abrirSesion();

        //Crea un objeto para guardar
        Usuario usuario = new Usuario();
        usuario.setUsername("Facu12399");
        usuario.setPassword("Fnm41818");
        usuario.setEmail("facundonahuelmaza@gmail.com");
 
        //Simulo crear tareas
        Tareas tarea1 = new Tareas();
    	tarea1.setName("Tender la cama");
    	tarea1.setDescripcion("Recordar poner bien en los bordes del colchon las sabanas.");
    	tarea1.setEstado("Pendiente");
    	
    	Tareas tarea2 = new Tareas();
    	tarea2.setName("Estudiar programacion");
    	tarea2.setDescripcion("Reforzar la parte practica, la inclusion de try-catch y el testear las aplicaciones.");
    	tarea2.setEstado("Pendiente");
    	
    	usuario.getListaTareas().add(tarea1);
    	usuario.getListaTareas().add(tarea2);
    	
        
        //Verifica que el valor no sea null en ningun atributo del objeto usuario
        assertNotNull("Se esperaba una cadena de texto en el nombre de usuario", usuario.getUsername());
        assertNotNull("Se esperaba una cadena de texto en el email", usuario.getEmail());
        assertNotNull("Se esperaba una cadena de texto en el password", usuario.getPassword());
        for(int i=0; i<usuario.getListaTareas().size();i++) {
        	assertNotNull("Se esperaba una cadena de texto en el nombre de la tarea", usuario.getListaTareas().get(i).getName());
        	assertNotNull("Se esperaba una cadena de texto en la descripcion de la tarea", usuario.getListaTareas().get(i).getDescripcion());
        	assertNotNull("Se esperaba una cadena de texto en el estado de la tarea", usuario.getListaTareas().get(i).getEstado());
        }
        
        // Simula la sesión y se llama al metodo save
        service.guardarEntidad(usuario);
        
    }

}
