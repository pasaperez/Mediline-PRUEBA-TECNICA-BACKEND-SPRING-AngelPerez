# Mediline PRUEBA TÉCNICA BACKEND SPRING
## Angel Perez

### Acerca
El siguiente proyecto es un desafió de la organización Mediline.

* El sistema ha sido implementado en Java con el Framework Spring (data, boot, jpa) con la utilización de maven como manejador de dependencias.

* Se ha utilizado como base de datos H2

### Patrones/Arquitectura
Se ha utilizado la arquitectura MVC (Modelo Vista Controlador)

Se define un modelo de datos que en este caso incluyen clase/tabla/entidad las cuales son "Movie/Persona/Parametro".

En la capa de vista se ha implementado de forma que responda a una API REST,
por lo que toda respuesta del sistema viene en este formato de texto plano,
con detalles del estado consultado a la API (status HTTP).

En la capa controlador, como ya se adelantó es una API REST que recibe parámetros en forma de body, y de path.
Se puede dividir en el modelo de 3 capas: Controller, Service, Repository.
* Capa Controller, recibe las solicitudes del usuario desde la Vista.
* Capa Service, maneja la lógica de negocio.
* Capa Repository, es la interfase con la capa de Modelo.

#### Detalles extras de implementación
Se manejan todos los errores producidos por ingreso de parte del usuario con excepciones de Java.
Se utiliza el patron DTO para el paso de mensajes y datos entre la capa de Vista y Controlador.
##### Se utiliza Swagger 3 para la documentación de la API Rest

### Instrucciones para correr o levantar el entorno

Clonar Repositorio de GitHub

> git clone https://github.com/pasaperez/Mediline-PRUEBA-TECNICA-BACKEND-SPRING-AngelPerez

* 1 Abrir con un IDE y ejecutar el módulo desde el archivo main:

> PersonasMoviesApplication.java

* 1' O abrir con un IDE y correr el comando en la carpeta root dentro del proyecto:

> mvn clean package

* 1'.1 - Si se corrió con el comando anterior se generó él .jar ejecutarlo con java:

> java -jar target/PersonasMoviesApplication-*.jar

* 2 - Acceder al siguiente link:

> http://localhost:9001/documentacion

* Se podrán observar los endpoints creados y probarlos
  *  Personas
    - Listar todas las personas (debe retornar el listado ordenado por apellido, nombre)
        - GET api/v1/personas/
    - Buscar una persona por id
        - GET api/v1/personas/{id}
    - Buscar una persona por nombre
        - GET api/v1/personas/name/{nombre}
    - Crear una persona
        - POST api/v1/personas/
    - Modificar una persona (solo se deben modificar los datos enviados. Si un dato no se envia, no se debe modificar)
        - PUT api/v1/personas/{id}
    - Eliminar una persona
        - DELETE api/v1/personas/{id}

  * Películas de Personas
    - Mostrar las películas de una persona
        - GET api/v1/movie/movies/{id} (id de la persona)
    - Agregar una película a una persona
        - POST api/v1/movie/{idPersona}
    - Quitar una película de una persona
        - DELETE api/v1/movie/{idPersona}/{idMovie}
  * Parametros
      - Se debe parametrizar el número máximo de películas por persona. Un valor entero que determina la máxima cantidad de películas que puede tener asociada una persona.
        - PUT api/v1/parametros/{id} (id puede ser cualquier numero, inicialmente la cantidad es infinita hasta que se actualice en este endpoint)


Se puede acceder desde una nueva pestaña o ventana del navegador

Se puede ejecutar desde la misma página de swagger.

Se puede acceder desde POSTMAN

### Se puede acceder a la base de datos

Ingresando al siguiente link:

> http://localhost:9001/h2

Cadena: jdbc:h2:mem:testdb
Usuario: sa
Password: password
