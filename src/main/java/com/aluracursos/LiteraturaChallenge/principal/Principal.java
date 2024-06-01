package com.aluracursos.LiteraturaChallenge.principal;


import com.aluracursos.LiteraturaChallenge.exceptions.BookNotFoundException;
import com.aluracursos.LiteraturaChallenge.exceptions.InvalidOptionsException;
import com.aluracursos.LiteraturaChallenge.exceptions.ProgramExitException;
import com.aluracursos.LiteraturaChallenge.model.*;
import com.aluracursos.LiteraturaChallenge.repository.AuthorRepository;
import com.aluracursos.LiteraturaChallenge.repository.BookRepository;
import com.aluracursos.LiteraturaChallenge.service.ConsumeAPI;
import com.aluracursos.LiteraturaChallenge.service.ConvertData;

import java.util.*;
import java.util.stream.Collectors;

public class Principal {


    Scanner keyboard = new Scanner(System.in);
    private ConsumeAPI consumeAPI = new ConsumeAPI();
    private final String URL_BASE = "https://gutendex.com/books/";

    private ConvertData converter = new ConvertData();
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private Boolean isRunningApp = true;

    public Principal(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }


    public void mainApp() {

        while (isRunningApp) {


            try {
                showMenu();

                System.out.print("Ingresa el número de la opción que desea ejecutar:  ");
                int selectedOption = keyboard.nextInt();
                keyboard.nextLine();
                verifyMenuInputIsValid(selectedOption);



                switch (selectedOption){
                    case 1:
                        searchBooksbyTitle();
                        break;
                    case 2:
                        listRegisteredBooks();
                        break;
                    case 3:
                        listRegisteredAuthors();
                        break;
                    case 4:
                        listAuthorsByRangeYear();
                        break;
                    case 5:
                        listBooksByLanguages();
                        break;
                    case 6:
                        getBookAndAuthorDataFromGutendex();
                        break;
                    case 0 :
                        isRunningApp = false;
                        System.out.println("Programa finalizado. Cerrando aplicación...");
                        System.exit(0);


                    default:
                        System.out.println("Opción inválida, intente de nuevo");
                }

            } catch (InputMismatchException e) {
                keyboard.nextLine();
                System.out.println("Error: Entrada inválida. Intente de nuevo.");
            } catch (InvalidOptionsException e) {
                throw new RuntimeException(e);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    //Input data validations for the main menu
    public static void verifyMenuInputIsValid(int input) throws Exception {
        if (input < 0 || input > 6) {
            throw new InvalidOptionsException("Opción inválida, intente de nuevo con las opciones disponibles en el menú.");
        }
    }

    // Data validation for Gutendex
    public static void verifyIsnotNullData(ResultsData data, String bookTitle) throws  BookNotFoundException{
        if (data.results().isEmpty() || data.results() == null){
            throw new BookNotFoundException("Lo sentimos, el libro con título "+ bookTitle + " no se encontró.");
        }
    }

    //Input data validations for books in case we have multiple matches in the Gutendex search
    public static void verifyGutendexInputIsValid(int input, int elementsNumber) throws InvalidOptionsException {
        if (input < 0 || input > elementsNumber) {
            throw new InvalidOptionsException("Opción inválida, intente de nuevo con las opciones disponibles en el menú.");
        } else if (input == 0) {
            System.out.println("Programa finalizado. Cerrando aplicación...");
            System.exit(0);
        }
    }

    public void showMenu (){
        var menu = """
                       ___________ MENU DE OPCIONES __________________
                        
                        1. Buscar libros por título 
                        2. Listar libros registrados
                        3. Listar autores registrados
                        4. Listar autores vivos en un determinado año
                        5. Listar libros por idiomas
                        6. Buscar libros por título en el servidor
                        
                        0. Salir
                        ______________________________________________
                    """;
        System.out.println(menu);

    }


    // 1)
    private  void searchBooksbyTitle(){
        System.out.print("Ingrese el título del libro que desea buscar:  ");
        var searchedBookByTitle = keyboard.next();
        keyboard.nextLine();
        List<Book> booksList = bookRepository.findByTitleContainsIgnoreCase(searchedBookByTitle);

        if (!booksList.isEmpty()){
            for(Book book: booksList){
                System.out.println(
                        "\n------------------- LIBRO "+ " -------------------" +
                                "\n   Título: " + book.getTitle() +
                                "\n   Autor: " + book.getAuthor().getName() +
                                "\n   Idioma: " + book.getLanguage() +
                                "\n   Número de descargas: " + book.getDownloadCount() +
                                "\n------------------- ***** ------------------- \n"
                );

            }


        } else {
            System.out.println("Libro no encontrado en la base de datos");
        }
    }

    // 2)
    private void listRegisteredBooks(){


        List<Book> allRegisteredBooks = bookRepository.findAll();

        if (!allRegisteredBooks.isEmpty()){
            int count = 1;
            System.out.println("\nEstos son todos los libros registrados en la base de datos");
            for(Book book: allRegisteredBooks) {
                System.out.println(
                        "\n------------------- LIBRO "+ count +" -------------------" +
                                "\n   Título: " + book.getTitle() +
                                "\n   Autor: " + book.getAuthor().getName() +
                                "\n   Idioma: " + book.getLanguage() +
                                "\n   Número de descargas: " + book.getDownloadCount() +
                                "\n------------------- ***** ------------------- \n"
                );
                count++;
            }
        } else {
            System.out.println("No hay libros almacenados en la base de datos");
        }
    }
    // 3)
    private void listRegisteredAuthors(){
        List<Author> allAuthors = authorRepository.findAll();

        int count = 1;
        if (!allAuthors.isEmpty()){
            for (Author author: allAuthors){

                System.out.println("\n [" + count + "] \n" +
                        author.toString())
                ;
                count++;
            }
        } else {
            System.out.println("No se encontraron autores registrados en la base de datos.");
        }

    }
    // 4)
    private void listAuthorsByRangeYear(){

    }
    // 5)
    private void listBooksByLanguages(){

    }

    // 6)
    private void getBookAndAuthorDataFromGutendex()  throws InvalidOptionsException {

        ResultsData data = getBookFromAPI();

        //Verify if the ResultData variable is empty
        if (!data.results().isEmpty()) {

            /*
            * If data (ResultData variable) is not empty, we filter to get books are not repeated.
            * foundBookList -  List to have all books info get from Gutendex
            * uniqueTitles  -  Set to save titles that are not repeated
            * uniqueBooks   -  Array to save books that are not repeated
            */

            List<BookData> foundBooksList = data.results();
            Set<String> uniqueTitles = new HashSet<>();
            List<BookData> uniqueBooks = new ArrayList<>();

            //Filtering out duplicate books
            for(BookData book: foundBooksList){
                String title = book.title();
                if (!uniqueTitles.contains(title)){
                    uniqueTitles.add(title);
                    uniqueBooks.add(book);
                }
            }

            System.out.println("\n- | - | - | - | - | - | - ENTRADA A LA BIBLIOTECA - | - | - | - | - | - | -\n");
            int count = 1;
            for(BookData book: uniqueBooks){
                System.out.println(
                        "------------------- LIBRO "+ count+ " -------------------" +


                                "\n   Título: " + book.title() +
                                "\n   Autor: " + book.authors().get(0).name() +
                                "\n   Idioma: " + book.languages().stream().map(LanguagesOptions::getNameByCode)
                                .collect(Collectors.toList()).get(0) +
                                "\n   Número de descargas: " + book.downloadCount() +

                                "\n------------------- ***** ------------------- \n"
                );
                count++;
            }
            System.out.println("\n- | - | - | - | - | - | - SALIDA DE LA BIBLIOTECA - | - | - | - | - | - | -\n");

            /*
             * Cases:
             *   - Only a book in uniqueBooks (array)
             *   - Choosing a book in case the uniqueBooks (array) has more than one option
             *   - Book not found.
             *
             * searchedBook - to save a book data searched by user.
             * verifyGutendexInputIsValid - Verify input data from Gutendex
             * */

            BookData searchedBook = null;

            if (uniqueBooks.stream().count() > 1){
                System.out.print("Inserte el número que se encuentra en el encabezado para almacenar el libro que desea, si desea salir insertar 0: ");
                 var selectedBook = keyboard.nextInt();
                 keyboard.nextLine();

                verifyGutendexInputIsValid(selectedBook, uniqueBooks.size());

                searchedBook = uniqueBooks.get(selectedBook - 1);

            } else if (uniqueBooks.stream().count() == 1){
                searchedBook = uniqueBooks.get(0);
            } else {
                System.out.println("No se encontró ese libro en Gutendex :(");
            }

            /*
            * authorData   - Get author data from the book retrieved from Gutendex
            * isBookInDB   - searching for book in db using the name retrieved from Gutendex
            * isAuthorInDB - searching for author in db using the author name of book  retrieved from Gutendex
            * */
            AuthorData authorData = searchedBook.authors().get(0);
            Book isBookInDB = bookRepository.findByTitle(searchedBook.title());
            Author isAuthorInDB = authorRepository.findByName(authorData.name());

            /*
            * Cases:
            *       - It's not a match with any book in db -> Create an instance to save the retrieved book in database.
            *       - It's a match with a book in db -> Pop Message about the retrieved book is in database
            * */

            if (isBookInDB == null){
                Author author;
                if (isAuthorInDB == null) {

                    author = new Author(authorData);
                    authorRepository.save(author);
                } else {
                    author = isAuthorInDB;
                }

                saveBookData(searchedBook, author);
                showBookData(searchedBook, author);
                
            } else {
                System.out.println("\n--- El libro ya se encuentra en la base de datos.  ---\n");
            }
        } else {
            System.out.println("\nError, no se encontró información sobre el libro o su autor.");
        }
    }

    private ResultsData getBookFromAPI() {

        ResultsData data = null;

        try {
            System.out.print("Ingrese el título del libro que desea : ");

            var bookTitle  = keyboard.nextLine();
            var json = consumeAPI.getData(URL_BASE + "/?search="+bookTitle.replace(" ","%20") );
            System.out.println(json);
            data = converter.getData(json, ResultsData.class);
            verifyIsnotNullData(data, bookTitle);


        } catch (InputMismatchException e) {
            System.out.println( e.getMessage());
        } catch ( BookNotFoundException e){
            System.out.println(e.getMessage());
        }
        return data;
    }

    private void showBookData(BookData book, Author author){

        System.out.println(

          "------------------- LIBRO -------------------" +
                "\n   Título: " + book.title() +
                "\n   Autor: " + author.getName() +
                "\n   Idioma: " + book.languages().stream().map(LanguagesOptions::getNameByCode)
                .collect(Collectors.toList()).get(0) +
                "\n   Número de descargas: " + book.downloadCount() +
                "\n------------------- ***** -------------------\n"
        );
    }


// Save Book and author data in db
    private void saveBookData(BookData book, Author author) {

        Book newBook = new Book(book, author);
        bookRepository.save(newBook);
        System.out.println("--- Se ha guardado el libro "+ book.title() + "en la base de datos. ---");

    }





}
