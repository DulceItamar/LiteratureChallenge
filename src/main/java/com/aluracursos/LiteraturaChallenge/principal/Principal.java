package com.aluracursos.LiteraturaChallenge.principal;


import com.aluracursos.LiteraturaChallenge.model.*;
import com.aluracursos.LiteraturaChallenge.repository.AuthorRepository;
import com.aluracursos.LiteraturaChallenge.repository.BookRepository;
import com.aluracursos.LiteraturaChallenge.service.ConsumeAPI;
import com.aluracursos.LiteraturaChallenge.service.ConvertData;

import java.util.Scanner;
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


    public void showMenu (){

        int selectedOption = -1;

        while (selectedOption != 0){

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
            System.out.print(" Ingresa el número de la opción que desea ejecutar:  ");
            selectedOption = keyboard.nextInt();
            keyboard.nextLine();


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
                    getBookDataAndAuthorData();

                    break;
                case 0:
                    System.out.println("Cerrando la aplicación");
                    break;
                default:
                    System.out.println("Opción inválida, intente de nuevo");

            }
        }
    }

    private  void searchBooksbyTitle(){
        System.out.print("Ingrese el título del libro que desea buscar:  ");



    }

    private void listRegisteredBooks(){

    }

    private void listRegisteredAuthors(){

    }

    private void listAuthorsByRangeYear(){

    }

    private void listBooksByLanguages(){

    }

    private ResultsData getBookFromAPI(){
        System.out.print("Ingrese el título del libro que desea buscar en Gutendex:  ");
        var bookTitle  = keyboard.nextLine();
        //Get json as a response
        var json = consumeAPI.getData(URL_BASE + "/?search="+bookTitle.replace(" ","%20") );
        System.out.println(json);

        //Mapeando los datos al Result
        var data = converter.getData(json, ResultsData.class);

        return data;

    }

    private void getBookDataAndAuthorData(){

        ResultsData data = getBookFromAPI();


        //Verify if ResultData variable is empty
        if (!data.results().isEmpty()) {

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


    private void saveBookData(BookData book, Author author) {

        Book newBook = new Book(book, author);
        bookRepository.save(newBook);
        System.out.println("Se ha guardado el libro "+ book.title() + "en la base de datos.");


    }





}
