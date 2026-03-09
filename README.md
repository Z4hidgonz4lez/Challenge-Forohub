# ForoHub API

ForoHub es una **API REST desarrollada con Spring Boot** que permite gestionar un sistema de foro donde los usuarios pueden crear tópicos, responder discusiones y organizar contenido mediante categorías y cursos.

La aplicación incluye un sistema de **autenticación y autorización basado en JWT**, lo que permite controlar el acceso a los diferentes recursos del sistema.

Este proyecto fue desarrollado con el objetivo de practicar el desarrollo de **aplicaciones backend seguras y estructuradas**, integrando bases de datos relacionales, autenticación y documentación de APIs.

---

# Objetivo del proyecto

El objetivo de este proyecto fue desarrollar una **API backend para la gestión de un foro**, implementando:

* autenticación segura de usuarios
* gestión de entidades relacionadas con el foro
* persistencia de datos en una base de datos relacional
* documentación de la API

Este proyecto permitió reforzar conceptos importantes del desarrollo backend con **Java y Spring Boot**.

---

# Problema que se busca resolver

Los foros permiten centralizar discusiones, preguntas y respuestas sobre distintos temas. Para que un sistema de foro funcione correctamente, es necesario gestionar múltiples elementos:

* usuarios
* roles o perfiles
* tópicos de discusión
* respuestas
* categorías
* cursos asociados

Este proyecto propone una solución backend que permite **gestionar estas entidades mediante una API REST**, manteniendo seguridad mediante autenticación con tokens.

---

# Arquitectura del sistema

La aplicación está estructurada siguiendo una arquitectura en capas típica de aplicaciones Spring Boot:

```id="foro_arch"
Controller → Service → Repository → Base de datos
```

Flujo general del sistema:

```id="foro_flujo"
Cliente → API REST → Controladores → Servicios → Repositorios → PostgreSQL
```

---
# Tecnologías utilizadas

### Lenguaje de programación

![Java](https://img.shields.io/badge/Java-ED8B00?style=flat&logo=openjdk&logoColor=white)

### Framework backend

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=flat&logo=springboot&logoColor=white)
![Spring Data JPA](https://img.shields.io/badge/Spring%20Data%20JPA-6DB33F?style=flat)
![Spring Security](https://img.shields.io/badge/Spring%20Security-6DB33F?style=flat)

### Autenticación

![JWT](https://img.shields.io/badge/JWT-black?style=flat&logo=jsonwebtokens)

### Base de datos

![PostgreSQL](https://img.shields.io/badge/PostgreSQL-336791?style=flat&logo=postgresql&logoColor=white)

### Documentación de API

![Swagger](https://img.shields.io/badge/Swagger-85EA2D?style=flat&logo=swagger)

### Herramientas

![Visual Studio Code](https://img.shields.io/badge/Visual%20Studio%20Code-0078D4?style=flat&logo=visualstudiocode&logoColor=white)
![Insomnia](https://img.shields.io/badge/Insomnia-4000BF?style=flat&logo=insomnia&logoColor=white)
![Postman](https://img.shields.io/badge/Postman-FF6C37?style=flat&logo=postman&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=flat&logo=apachemaven&logoColor=white)
![Git](https://img.shields.io/badge/Git-F05032?style=flat&logo=git&logoColor=white)
![GitHub](https://img.shields.io/badge/GitHub-181717?style=flat&logo=github&logoColor=white)
# Estructura del proyecto

El proyecto está organizado en distintos paquetes que separan responsabilidades dentro del sistema.

```id="estructura_forohub"
config
controllers
dto
entities
repositories
services
utils
```

### Configuración

Contiene las clases relacionadas con seguridad y configuración del sistema:

* `SecurityConfig`
* `JwtTokenValidador`
* `SwaggerConfig`
* `GlobalHandlerException`

---

### Controllers

Gestionan las solicitudes HTTP de la API.

Ejemplos:

* `AuthController`
* `TopicoController`
* `UsuarioController`
* `CategoriaController`
* `RespuestaController`

---

### DTO (Data Transfer Objects)

Se utilizan para controlar la información enviada y recibida por la API.

Ejemplos:

* `UsuarioRequestDTO`
* `TopicoResponseDTO`
* `CategoriaResponseDTO`

---

### Entities

Representan las tablas de la base de datos.

* Usuario
* Perfil
* Curso
* Categoria
* Topico
* Respuesta

---

### Repositories

Permiten realizar operaciones de persistencia usando **Spring Data JPA**.

Ejemplos:

* `UsuarioRepository`
* `TopicoRepository`
* `RespuestaRepository`

---

### Services

Contienen la lógica de negocio de la aplicación.

Ejemplos:

* `UsuarioService`
* `TopicoService`
* `RespuestaService`

---

# Migraciones de base de datos

La base de datos se inicializa mediante scripts SQL ubicados en:

```id="migraciones"
resources/db/migration
```

Archivos incluidos:

```id="scripts"
V1__create_table_perfiles.sql
V2__create_table_usuarios.sql
V3__create_table_categorias.sql
V4__create_table_cursos.sql
V5__create_table_topicos.sql
V6__create_table_respuestas.sql
```

Esto permite crear automáticamente la estructura inicial de la base de datos.

---

# Funcionalidades de la API

La API permite realizar operaciones sobre diferentes entidades del sistema.

### Autenticación

* registro de usuarios
* autenticación mediante JWT

### Gestión del foro

* crear tópicos
* responder a tópicos
* consultar discusiones

### Administración de contenido

* gestión de usuarios
* gestión de perfiles
* gestión de categorías
* gestión de cursos

---

# Ejecución del proyecto

### Requisitos

* Java 11 o superior
* PostgreSQL
* Maven

---

### Clonar el repositorio

```id="clone_forohub"
git clone https://github.com/tu_usuario/tu_repositorio.git
```

---

### Configurar base de datos

En `application.properties`:

```id="config_db"
spring.datasource.url=jdbc:postgresql://<DB_HOST>/<DB_NAME>
spring.datasource.username=<DB_USER>
spring.datasource.password=<DB_PASSWORD>
```

---

### Ejecutar la aplicación

```id="run_forohub"
mvn spring-boot:run
```

---

# Documentación de la API

Una vez ejecutada la aplicación, la documentación interactiva de la API está disponible en:

```id="swagger_url"
http://localhost:8080/swagger-ui.html
```

Swagger permite probar los endpoints directamente desde el navegador.

---

# Resultados del proyecto

El sistema permite gestionar completamente un foro mediante una API REST, incluyendo:

* autenticación segura
* gestión de usuarios
* creación de tópicos
* respuestas a discusiones
* organización del contenido mediante categorías y cursos

---

# Qué aprendí

Durante el desarrollo de este proyecto se reforzaron varios conceptos importantes del desarrollo backend:

* diseño de APIs REST con Spring Boot
* autenticación y autorización mediante JWT
* manejo de DTOs para el intercambio de datos
* persistencia de datos con Spring Data JPA
* manejo global de excepciones
* documentación de APIs con Swagger

Este proyecto permitió comprender cómo construir **una API backend completa, segura y estructurada**.

---

# Licencia

Este proyecto se encuentra bajo la licencia MIT.
