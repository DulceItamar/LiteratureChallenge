# LiteratureChallenge
Second challenge of the backend specialization offered by Alura.

## Objective
This is a program that allows searching for book titles through an API called Gutendex and also stores that information in a database.

## Functionalities


- **Search books by title**: Allows searching for books in the local database by their title.
- **List registered books**: Displays all the books stored in the database.
- **List registered authors**: Displays all the authors stored in the database.
- **List authors alive in a specific year **: Allows searching for authors who were alive in a specific year.
- **List books by language**: Allows listing books stored in the database according to their language.
- **Search books by title on the server**: Allows searching for books by their title using the Gutendex

## Technologies used
- Java 17 (Programming Language )
- Spring Boot (Framework)
- Maven (Dependency Management Tool)
- Postgresql (Database)

## Created by
- Dulce Itamar Vigueras Ballesteros


## Application Execution

- The main menu is displayed
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

1. **Search by title**
    - Prompts you to enter the title of the book you want to search for in the local database.

2. **List registered books**
    - Displays a list of all books currently registered in the database.

3. **List registered authors**
    - Displays a list of all authors currently registered in the database.

4. **List authors alive in a specific year**
    - Prompts you to enter a year and shows all authors who were alive in that year.

5. **List bookd by language**
    - Allows you to select a language and shows all books registered in that language.

6. **Search books by title on the server**
    - Prompts you to enter the title of the book you want to search for in the Gutendex API and displays the results.


0. **Exit**
    - Ends the application. 

## Exception Handling

- If an invalid option is entered, the application will display an error message and prompt for a new input.
- If an unexpected exception occurs, a detailed error message will be displayed and the application will continue running.

## Overviews
### Menu




## Contributions

If you want to contribute to this project, please open an issue or submit a pull request with your proposed changes.

