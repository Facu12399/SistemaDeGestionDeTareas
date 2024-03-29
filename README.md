"# SistemaDeGestionDeTareas" 

Proyecto personal. El programa le permite a los usuarios crear, leer, editar y eliminar tareas.

Se implementa un proyecto Maven utilizada en el entorno de Java, para mapear se utiliza Hibernate. En el proyecto tenemos 3 paquetes el paquete principal por defecto donde esta tenemos el main con la clase App, otro paquete llamado entidad donde tenemos las clases Usuario y Tareas y por ultimo la configuración de Hibernate en el paquete llamado dao. En este ultimo paquete armamos la configuracion de modo tal que podamos hacer las funciones basicas de la base de datos, es decir, el acronimo CRUD (create, read, update, delete).

En la entidad usuario utilice como atributos (id_usuario, username, email, password) y para la entidad tareas (id_tarea, name, descripcion, estado (para el caso del estado utilice String, porque la idea era que haya varios tipos de estados que podria lograrlo utilizando una cadena, como por ejemplo En progreso, Completo, Pendiente, etc)).
