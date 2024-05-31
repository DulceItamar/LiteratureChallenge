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

    public Principal(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }


    public void mainApp() {

        while (true) {


            try {
                //showMenu();
                var menu = """
                       ___________ MENU DE OPCIONES __________________
                        
                        1. Buscar libros por título.
                        2. Listar libros registrados.
                        3. Listar autores registrados.
                        4. Listar autores vivos en un determinado año.
                        5. Listar libros por idiomas.
                        6. Buscar libros por título en el servidor.
                        
                        0. Salir.
                        Ingresa el número de la opción que desea ejecutar:  
                    """;
                System.out.println(menu);


                //System.out.print("Ingresa el número de la opción que desea ejecutar:  ");
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

    //Input data validations
    public static void verifyMenuInputIsValid(int input) throws Exception {
        if (input < 0 || input > 6) {
            throw new InvalidOptionsException("Opción inválida, intente de nuevo con las opciones disponibles en el menú.");
        } else if (input == 0) {
            throw new ProgramExitException("Programa finalizado. Cerrando aplicación...");
        }
    }

    //Gutendex data validation
    public static void verifyIsnotNullData(ResultsData data, String bookTitle) throws  BookNotFoundException{
        if (data.results().isEmpty() || data.results() == null){
            throw new BookNotFoundException("Lo sentimos, el libro con título "+ bookTitle + " no se encontró.");
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
                        
                    """;
        System.out.println(menu);

    }


    // 1)
    private  void searchBooksbyTitle(){
        System.out.print("Ingrese el título del libro que desea buscar:  ");
        var searchedBookByTitle = keyboard.next();
        keyboard.nextLine();

    }

    private void listRegisteredBooks(){

    }

    private void listRegisteredAuthors(){

    }

    private void listAuthorsByRangeYear(){

    }

    private void listBooksByLanguages(){

    }

    private ResultsData getBookFromAPI() {

        ResultsData data = null;

        try {
            System.out.print("Ingrese el título del libro que desea : ");
            var input = keyboard.nextInt();
            keyboard.nextLine();

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



    private void getBookAndAuthorDataFromGutendex(){

        ResultsData data = getBookFromAPI();


        //Verify if ResultData variable is empty
        if (!data.results().isEmpty()) {


            List<BookData> foundBooksList = data.results();
            Set<String> uniqueTitles = new HashSet<>();
            List<BookData> uniqueBooks = new ArrayList<>();


            for(BookData book: foundBooksList){
                String title = book.title();
                if (!uniqueTitles.contains(title)){
                    uniqueTitles.add(title);
                    uniqueBooks.add(book);

                }

            }



            for(BookData book: uniqueBooks){
                System.out.println(

                        "------------------- LIBRO -------------------" +
                                "\n   Título: " + book.title() +
                                "\n   Autor: " + book.authors().get(0) +
                                "\n   Idioma: " + book.languages().stream().map(LanguagesOptions::getNameByCode)
                                .collect(Collectors.toList()).get(0) +
                                "\n   Número de descargas: " + book.downloadCount() +
                                "\n------------------- ***** -------------------\n"
                );


            }



            System.out.println("This is uniquebooks" + uniqueBooks);

            if (uniqueBooks.stream().count() > 1){
                System.out.println("¿Encontro el libro que buscaba?");
            }

            /*
            BookData searchedBook = data.results().get(0);
            AuthorData authorData = searchedBook.authors().get(0);

            Book isBookInDB = bookRepository.findByTitle(searchedBook.title());
            Author isAuthorInDB = authorRepository.findByName(authorData.name());

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
                System.out.println("El libro ya se encuentra en la base de datos");
            }


             */

        } else {
            System.out.println("Error, no se encontró información sobre el libro o su autor.");
        }
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
        System.out.println("Se ha guardado el libro "+ book.title() + "en la base de datos.");

    }





}
