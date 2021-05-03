package br.com.gfwesllei.library.api;

import br.com.gfwesllei.library.api.erros.ApiErros;
import br.com.gfwesllei.library.entity.Book;
import br.com.gfwesllei.library.service.BookingService;
import br.com.gfwesllei.library.vo.BookVO;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author weslleiferreira
 * @project library
 */
@RestController
@RequestMapping(value = "/book")
public class BookController {

    private BookingService bookingService;
    private ModelMapper modelMapper;

    public BookController(BookingService bookingService, ModelMapper modelMapper) {
        this.bookingService = bookingService;
        this.modelMapper = modelMapper;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookVO> create(@Valid @RequestBody BookVO bookVO){


        Book book =modelMapper.map(bookVO,Book.class);
        bookingService.save(book);

        BookVO bookVOResult =modelMapper.map(book,BookVO.class);

        return new ResponseEntity<>(bookVOResult,HttpStatus.CREATED);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ApiErros handleApiExceptions(MethodArgumentNotValidException exception){

    }
}
