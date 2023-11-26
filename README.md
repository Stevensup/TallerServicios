# Proyecto Task

Este proyecto implementa un sistema de servicios REST utilizando el patrón MVC (Modelo-Vista-Controlador). Proporciona servicios relacionados con tareas y sigue una estructura modular con componentes como Repository y Service.

## Requisitos

- JDK 17 o superior

## Ejecución

Para ejecutar el proyecto, simplemente ejecuta el método `main` en la clase principal.

## Estructura del Proyecto

La estructura del proyecto sigue el patrón MVC:

- `src/main/java/co/edu/unbosque/Task/controller`: Contiene controladores REST.
- `src/main/java/co/edu/unbosque/Task/model`: Contiene modelos de datos.
- `src/main/java/co/edu/unbosque/Task/repository`: Contiene la capa de acceso a datos.
- `src/main/java/co/edu/unbosque/Task/service`: Contiene la lógica de negocio.

## Autor

- Brayan Steven Useche Palomino

## Licencia

Este proyecto está bajo la licencia.

## Respuestas a las preguntas:

# ¿Qué implica usar @RestController en lugar de @Controller?

@Controller: Señala que mi clase opera como un controlador Spring MVC, y cada función regresa una vista, ya sea en formato HTML o JSON.

@RestController: Representa una variante especializada de @Controller y @ResponseBody. Describo que mi clase actúa como un controlador REST, y cada función proporciona datos directamente en lugar de una vista. Esta especificación resulta práctica para la implementación de servicios web RESTful.

En pocas palabras, @RestController simplifica el proceso de desarrollo de servicios REST al eliminar la obligación de anotar cada función con @ResponseBody.

# ¿Cuál es la función de @Service en el contexto de un servicio REST?

@Service: Establece que la clase actúa como un servicio de negocios. En el contexto de un servicio REST, esta clase, etiquetada con @Service, albergará la lógica empresarial antes de llevar a cabo operaciones de persistencia a través del repositorio.

En resumen, @Service se emplea para segregar la lógica de negocios del controlador y la capa de persistencia.

# ¿Cuál es la función de @Repository en el contexto de un servicio REST?


@Repository: Declara que la clase funciona como un componente de acceso a datos. Dentro de un servicio REST, la clase etiquetada con @Repository asume la responsabilidad de las operaciones de persistencia y emplea tecnologías como JPA y Spring Data para interactuar con la base de datos.

En esencia, @Repository se utiliza con el propósito de desvincular las operaciones de persistencia y consulta de la lógica de negocios.

# ¿Qué hace @ControllerAdvice y por qué se utiliza?

@ControllerAdvice: Se emplea con el propósito de consolidar la gestión de excepciones en un conjunto de controladores. Facilita la definición de métodos globales que afectan a todos los controladores marcados con @RestController o @Controller.

Esta anotación resulta beneficiosa al proporcionar un control centralizado sobre el manejo de excepciones en una aplicación. Permite la personalización de respuestas de error, la inclusión de información adicional sobre los errores y garantiza una gestión coherente de las excepciones en toda la aplicación.
