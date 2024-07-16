
# Foro Hub API

## 📝 Descripción
**Foro Hub** es una API construida con **Spring Boot** que permite la gestión de un foro, incluyendo autenticación de usuarios, manejo de perfiles, cursos, categorías y respuestas a tópicos. Utiliza **PostgreSQL** como base de datos y **JWT** para la autenticación.

---

## 🚀 Características
- **Autenticación y autorización** mediante JWT.
- **CRUD** para usuarios, perfiles, cursos, categorías y respuestas.
- **Documentación** de la API usando Swagger.
- **Manejo de excepciones** globales.

---

## 🛠️ Tecnologías Utilizadas
- **Java**: Lenguaje de programación.
- **Spring Boot**: Framework para construir aplicaciones Java.
- **PostgreSQL**: Base de datos.
- **Spring Security**: Para la seguridad y autenticación.
- **JWT**: Para la autenticación basada en tokens.
- **Swagger**: Para la documentación de la API.

---

## 📋 Requisitos
- Java 11 o superior.
- PostgreSQL.
- Maven o Gradle (dependiendo de tu configuración).

---

## 📥 Instalación

1. **Clona el repositorio**:
   ```bash
   git clone https://github.com/tu_usuario/tu_repositorio.git
   cd tu_repositorio
   ```

2. **Configura las credenciales** en `application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://<DB_HOST>/<DB_NAME>
   spring.datasource.username=<DB_USER>
   spring.datasource.password=<DB_PASSWORD>
   ```

3. **Ejecuta las migraciones** de la base de datos si las tienes configuradas.

4. **Construye el proyecto**:
   ```bash
   mvn clean install
   ```

5. **Ejecuta la aplicación**:
   ```bash
   mvn spring-boot:run
   ```

---

## 🖥️ Uso
- La API está disponible en `http://localhost:8080/api`.
- Accede a la documentación de Swagger en `http://localhost:8080/swagger-ui.html`.

---

## 🤝 Contribuciones
Las contribuciones son bienvenidas. Por favor, abre un `issue` o envía un `pull request` para sugerir cambios o mejoras.

---

## 📄 Licencia
Este proyecto está bajo la Licencia MIT. Consulta el archivo [LICENSE](LICENSE) para más detalles.

```

### Instrucciones
1. **Reemplaza** los valores en `<DB_HOST>`, `<DB_NAME>`, `<DB_USER>`, `<DB_PASSWORD>`, y la URL del repositorio con la información correspondiente a tu proyecto.
2. **Agrega o ajusta** cualquier sección según la estructura específica de tu proyecto y necesidades.
