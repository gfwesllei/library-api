package br.com.gfwesllei.library.api;

import br.com.gfwesllei.library.entity.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author weslleiferreira
 * @project library
 */
@RestController
@RequestMapping(value = "/book")
public class BookController {

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> create(@RequestBody Book book){

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
