# LiteratureChallenge
The second challenge of the backend specialization offered by Alura.

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
    - Prompts you to enter the book title you want to search for in the local database.

2. **List registered books**
    - Displays a list of all books currently registered in the database.

3. **List registered authors**
    - Displays a list of all authors currently registered in the database.

4. **List authors alive in a specific year**
    - Prompts you to enter a year and shows all authors alive that year.

5. **List book by language**
    - Allows you to select a language and shows all books registered there.

6. **Search books by title on the server**
    - Prompts you to enter the book title you want to search for in the Gutendex API and displays the results.


0. **Exit**
    - Ends the application. 

## Exception Handling

- If an unexpected exception occurs, a detailed error message will be displayed and the application will continue running.
- If an invalid option is entered, the application will display an error message and prompt for a new input.
  
   ![Screenshot 2024-06-03 at 2 12 19 p m](https://github.com/DulceItamar/LiteratureChallenge/assets/98665735/79cdb280-adaa-439b-b9b3-b2c704febfcf)


## Views

#### Menu 

![Screenshot 2024-06-03 at 2 06 00 p m](https://github.com/DulceItamar/LiteratureChallenge/assets/98665735/4edb72b8-0cc1-4998-b38a-7f7a927ce691)

#### Option 1: Search books by title

![Screenshot 2024-06-03 at 2 19 43 p m](https://github.com/DulceItamar/LiteratureChallenge/assets/98665735/d9d38c32-533d-434e-9175-83a397145081)

Entering a keyword of the full title

![Screenshot 2024-06-03 at 2 20 26 p m](https://github.com/DulceItamar/LiteratureChallenge/assets/98665735/2eb9593f-8793-4fef-bd62-6344ee865d62)

If you enter a keyword, all books with that keyword will be retrieved, and another menu will appear asking which book you are looking for. (In this example, if you want the book titled: Pride and Prejudice, a play founded on Jane Austen’s novel, enter 1).

![Screenshot 2024-06-03 at 2 22 41 p m](https://github.com/DulceItamar/LiteratureChallenge/assets/98665735/afe17d40-a001-44e5-82b2-1400f1b26fc1)

Entering 1, you get:

![Screenshot 2024-06-03 at 2 24 10 p m](https://github.com/DulceItamar/LiteratureChallenge/assets/98665735/d7046238-b279-4017-9e8c-35ce30dee161)



#### Option 2: List all registered books
Displays all books registered in the database

![Screenshot 2024-06-03 at 2 25 14 p m](https://github.com/DulceItamar/LiteratureChallenge/assets/98665735/a064ef06-bcc9-4888-92af-3d9f2cabd7f2)


#### Option 3: List all registered authors
Returns all authors registered in the database

![Screenshot 2024-06-03 at 2 26 19 p m](https://github.com/DulceItamar/LiteratureChallenge/assets/98665735/42f622f1-42fd-4c63-a623-9acf288e5f08)


#### Option 4: List authors alive in a certain year
Returns all authors alive in a certain year

![Screenshot 2024-06-03 at 2 28 37 p m](https://github.com/DulceItamar/LiteratureChallenge/assets/98665735/b3643463-d682-411b-a068-c543bc795c03)

![Screenshot 2024-06-03 at 2 29 10 p m](https://github.com/DulceItamar/LiteratureChallenge/assets/98665735/127d5d0f-a3ad-4240-aed1-c1fb135292cd)


#### Option 5: List books by language
Displays another menu to select the language of the books you want to get 

![Screenshot 2024-06-03 at 2 30 04 p m](https://github.com/DulceItamar/LiteratureChallenge/assets/98665735/b2db90a3-0dac-49c5-b430-adec2f0f3402)

All books registered in that language are obtained 

![Screenshot 2024-06-03 at 2 30 59 p m](https://github.com/DulceItamar/LiteratureChallenge/assets/98665735/82bacbb8-36de-4a79-a5b7-87dec67908a7)

#### Option6 6: Search for books by title on the server
If you enter a keyword, all books with that match will be obtained

![Screenshot 2024-06-03 at 2 32 10 p m](https://github.com/DulceItamar/LiteratureChallenge/assets/98665735/7cf1fe0f-a6a0-429a-9aae-103d2a73eeb2)

![Screenshot 2024-06-03 at 2 32 26 p m](https://github.com/DulceItamar/LiteratureChallenge/assets/98665735/c2f8ae0f-67cd-4065-8742-ee3d74488714)

![Screenshot 2024-06-03 at 2 32 38 p m](https://github.com/DulceItamar/LiteratureChallenge/assets/98665735/5cb99bd1-0bc9-4143-b62d-6b5cd175f6d5)

After showing the matches, a message will appear asking which book you want to store in your database. For this, each book is represented by consecutive numbers in its header (BOOK 1, BOOK 2...), you must enter the number of the book.

![Screenshot 2024-06-03 at 2 36 46 p m](https://github.com/DulceItamar/LiteratureChallenge/assets/98665735/cf827f91-0eb4-4519-bb89-069467654030)

A message will appear mentioning the title of the book saved in the database and some additional data about it.

![Screenshot 2024-06-03 at 2 37 59 p m](https://github.com/DulceItamar/LiteratureChallenge/assets/98665735/4504c042-86a7-4e51-b3d6-33aad4859ebe)

By checking the database, you can see that the title has been saved correctly

![Screenshot 2024-06-03 at 2 38 46 p m](https://github.com/DulceItamar/LiteratureChallenge/assets/98665735/5fccfdaa-1051-4537-ad51-d1142599a8fe)






## Contributions

If you want to contribute to this project, please open an issue or submit a pull request with your proposed changes.

