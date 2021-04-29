package br.com.gfwesllei.library.api;

import br.com.gfwesllei.library.builder.RequestBuilder;
import br.com.gfwesllei.library.entity.Book;
import br.com.gfwesllei.library.service.BookingService;
import br.com.gfwesllei.library.vo.BookVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static br.com.gfwesllei.library.builder.BookBuilder.oneBook;
import static br.com.gfwesllei.library.builder.RequestBuilder.onePost;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author weslleiferreira
 * @project library
 */
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@WebMvcTest
@AutoConfigureMockMvc
class BookingControllerTest {

    @TestConfiguration
    static class TestConfigration{

        @Bean
        public ModelMapper modelMapper(){
            return new ModelMapper();
        }
    }

    public static final String BOOK_API = "/book";

    @Autowired
    MockMvc mockMvc;

    @MockBean
    BookingService bookingService;

    @Autowired
    ModelMapper modelMapper;


    @Test
    @DisplayName("Validate if is possible, create on book and return 201")
    void shouldCreateBookWithSucess() throws Exception {

        Book book = oneBook().withId(11L).build();

        BookVO bookVO = modelMapper.map(book,BookVO.class);

        Mockito.when(bookingService.save(Mockito.any(Book.class))).thenReturn(book);

        mockMvc.perform(onePost(BOOK_API).withBody(bookVO.asJson()).now())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("id").isNotEmpty())
                .andExpect(jsonPath("title").value(book.getTitle()));

    }

    @Test
    @DisplayName("Should return 400, if content not presence")
    void shouldReturnBadRequestWhenNoContent() throws Exception {
        mockMvc.perform(onePost(BOOK_API).now()).andExpect(status().isBadRequest());
    }



}
