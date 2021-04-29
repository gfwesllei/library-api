package br.com.gfwesllei.library.api;

import br.com.gfwesllei.library.builder.RequestBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static br.com.gfwesllei.library.builder.BookBuilder.oneBook;
import static br.com.gfwesllei.library.builder.RequestBuilder.onePost;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

    public static final String BOOK_API = "/book";

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Validate if is possible, create on book and return 201")
    void shouldCreateBookWithSucess() throws Exception {

        String book = oneBook().build().asJson();
        mockMvc.perform(onePost(BOOK_API).withBody(book).now()).andExpect(status().isCreated());

    }

    @Test
    @DisplayName("Should return 400, if content not presence")
    void shouldReturnBadRequestWhenNoContent() throws Exception {
        mockMvc.perform(onePost(BOOK_API).now()).andExpect(status().isBadRequest());
    }



}
