
# LiteratureChallenge
Segundo desaafío de la espcialización de backedn ofertado por Alura 

## Objectivo
Este es un programa que permite uscar títulos de libros através de una API llamada Gutendex y que también almacena esa información en una base de datos. 

## Funcionalidades


- **Buscar libros por título**: Permite buscar libros en la base de datos local por su título.
- **Listar libros registrados**: Muestra todos los libros almacenados en la base de datos.
- **Listar autores registrados**: Muestra todos los autores almacenados en la base de datos.
- **Listar autores vivos en un determinado año**: Permite buscar autores que estaban vivos en un año específico.
- **Listar libros por idiomas**: Permite listar libros almacenados en la base de datos según su idioma.
- **Buscar libros por título en el servidor**: Permite buscar libros por su título utilizando la API de Gutendex.

## Tecnologías empleadoas
- Java 17 (Lenguaje de programación )
- Spring Boot (Framework)
- Maven (Gestor de Dependencias)
- Postgresql (Base de datos)

## Creado por 
- Dulce Itamar Vigueras Ballesteros


## Ejecución de la aplicación.

- Se muestra un menú principal 
<p>     
        ___________ MENU DE OPCIONES __________________

                        1. Buscar libros por título 
                        2. Listar libros registrados
                        3. Listar autores registrados
                        4. Listar autores vivos en un determinado año
                        5. Listar libros por idiomas
                        6. Buscar libros por título en el servidor
                        
                        0. Salir


</p>

### Opciones del menú

1. **Buscar libros por título**
    - Te pedirá ingresar el título del libro que deseas buscar en la base de datos local.

2. **Listar libros registrados**
    - Muestra una lista de todos los libros actualmente registrados en la base de datos.

3. **Listar autores registrados**
    - Muestra una lista de todos los autores actualmente registrados en la base de datos.

4. **Listar autores vivos en un determinado año**
    - Te pedirá ingresar un año y mostrará todos los autores que estaban vivos en ese año.

5. **Listar libros por idiomas**
    - Te permitirá seleccionar un idioma y mostrará todos los libros registrados en ese idioma.

6. **Buscar libros por título en el servidor**
    - Te pedirá ingresar el título del libro que deseas buscar en la API de Gutendex y mostrará los resultados.

0. **Salir**
    - Finaliza la aplicación

## Manejo de Excepciones

- Si se ingresa una opción no válida, la aplicación mostrará un mensaje de error y solicitará una nueva entrada.
- Si se produce una excepción inesperada, se mostrará un mensaje de error detallado y la aplicación continuará funcionando.

## Vista
### Menu de opciones




## Contribuciones

Si deseas contribuir a este proyecto, por favor abre un issue o envía un pull request con tus cambios propuestos.

