package br.com.gfwesllei.library.builder;


import br.com.gfwesllei.library.entity.Book;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author weslleiferreira
 * @project library
 */
public class BookBuilder {

    private Book book;

    private BookBuilder(){}

    public static BookBuilder oneBook(){
        BookBuilder bookBuilder = new BookBuilder();
        bookBuilder.book = new Book("Title","Sbn",20d,5);
        return bookBuilder;
    }

    public BookBuilder withId(Long id){
        this.book.setId(id);
        return this;
    }

    public Book build(){
        return this.book;
    }

    public String asJson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this.book);
    }
}
