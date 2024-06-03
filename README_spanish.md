
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

- Si se produce una excepción inesperada, se mostrará un mensaje de error detallado y la aplicación continuará funcionando.
  
- Si se ingresa una opción no válida, la aplicación mostrará un mensaje de error y solicitará una nueva entrada.

  ![Screenshot 2024-06-03 at 2 12 19 p m](https://github.com/DulceItamar/LiteratureChallenge/assets/98665735/79cdb280-adaa-439b-b9b3-b2c704febfcf)



## Vista
#### Menu principal
![Screenshot 2024-06-03 at 2 06 00 p m](https://github.com/DulceItamar/LiteratureChallenge/assets/98665735/4edb72b8-0cc1-4998-b38a-7f7a927ce691)

#### Opción 1: Buscar libros por título
![Screenshot 2024-06-03 at 2 19 43 p m](https://github.com/DulceItamar/LiteratureChallenge/assets/98665735/d9d38c32-533d-434e-9175-83a397145081)

Colocando  una palabra clave o el título completo: 
![Screenshot 2024-06-03 at 2 20 26 p m](https://github.com/DulceItamar/LiteratureChallenge/assets/98665735/2eb9593f-8793-4fef-bd62-6344ee865d62)

En caso de poner una palabra clave se obtendrán todos los libros con esa palabra y se despegará otro menú preguntando cual es el libro que busca, (en este ejemplo si desea el libro del título : Pride and Prejudice, a play founded on Jane Austen’s novel, colocar 1).

![Screenshot 2024-06-03 at 2 22 41 p m](https://github.com/DulceItamar/LiteratureChallenge/assets/98665735/afe17d40-a001-44e5-82b2-1400f1b26fc1)

Al escribir 1, se obtiene 

![Screenshot 2024-06-03 at 2 24 10 p m](https://github.com/DulceItamar/LiteratureChallenge/assets/98665735/d7046238-b279-4017-9e8c-35ce30dee161)



#### Opción 2: Listar libros registrados
Arroja todos los libros registrados en la base de datos 

![Screenshot 2024-06-03 at 2 25 14 p m](https://github.com/DulceItamar/LiteratureChallenge/assets/98665735/a064ef06-bcc9-4888-92af-3d9f2cabd7f2)


#### Opción 3: Listar autores registrados
Devuelve todos los autores registrados en la base de datos
![Screenshot 2024-06-03 at 2 26 19 p m](https://github.com/DulceItamar/LiteratureChallenge/assets/98665735/42f622f1-42fd-4c63-a623-9acf288e5f08)


#### Opción 4: Listar autores vivos en un determinado año
Devuelve todos los autores vivos en un determinado año

![Screenshot 2024-06-03 at 2 28 37 p m](https://github.com/DulceItamar/LiteratureChallenge/assets/98665735/b3643463-d682-411b-a068-c543bc795c03)

![Screenshot 2024-06-03 at 2 29 10 p m](https://github.com/DulceItamar/LiteratureChallenge/assets/98665735/127d5d0f-a3ad-4240-aed1-c1fb135292cd)


#### Opción 5: Listar libros por idiomas
Arroja otro menu para seleccionar el idioma de los libros que se desea obtener 
![Screenshot 2024-06-03 at 2 30 04 p m](https://github.com/DulceItamar/LiteratureChallenge/assets/98665735/b2db90a3-0dac-49c5-b430-adec2f0f3402)

Se obtienen todos los libros registrados con ese idioma
![Screenshot 2024-06-03 at 2 30 59 p m](https://github.com/DulceItamar/LiteratureChallenge/assets/98665735/82bacbb8-36de-4a79-a5b7-87dec67908a7)

#### Opción 6: Buscar libros por título en el servidor
Si se escribe una palabra clave se obtendrán todos los libros con esa coincidencia

![Screenshot 2024-06-03 at 2 32 10 p m](https://github.com/DulceItamar/LiteratureChallenge/assets/98665735/7cf1fe0f-a6a0-429a-9aae-103d2a73eeb2)

![Screenshot 2024-06-03 at 2 32 26 p m](https://github.com/DulceItamar/LiteratureChallenge/assets/98665735/c2f8ae0f-67cd-4065-8742-ee3d74488714)

![Screenshot 2024-06-03 at 2 32 38 p m](https://github.com/DulceItamar/LiteratureChallenge/assets/98665735/5cb99bd1-0bc9-4143-b62d-6b5cd175f6d5)

Después de mostrarse las coincidencias, aparecerá un mensaje sobre cuál es el libro que desea almacenar en su base de datos. Para ello, cada libro está representado por números consecutivos en su encabezado (LIBRO 1, LIBRO 2...) , debe escribir el número del libro.


![Screenshot 2024-06-03 at 2 36 46 p m](https://github.com/DulceItamar/LiteratureChallenge/assets/98665735/cf827f91-0eb4-4519-bb89-069467654030)

Aparecerá un mensaje mencionando el título del libro guardado en la base de datos y algunos datos extra sobre él. 

![Screenshot 2024-06-03 at 2 37 59 p m](https://github.com/DulceItamar/LiteratureChallenge/assets/98665735/4504c042-86a7-4e51-b3d6-33aad4859ebe)

Verificando en la base de datos, se observa que el título se ha guardado correctamente
![Screenshot 2024-06-03 at 2 38 46 p m](https://github.com/DulceItamar/LiteratureChallenge/assets/98665735/5fccfdaa-1051-4537-ad51-d1142599a8fe)


## Contribuciones

Si deseas contribuir a este proyecto, por favor abre un issue o envía un pull request con tus cambios propuestos.

