package br.com.gfwesllei.library.builder;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

/**
 * @author weslleiferreira
 * @project library
 */
public class RequestBuilder {

    MockHttpServletRequestBuilder mockHttpServletRequestBuilder;
    private RequestBuilder(){}

    public static RequestBuilder onePost(String uri){
        RequestBuilder requestBuilder = new RequestBuilder();
        requestBuilder.mockHttpServletRequestBuilder = post(uri).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
        return requestBuilder;
    }


    public MockHttpServletRequestBuilder now(){
        return this.mockHttpServletRequestBuilder;
    }

    public RequestBuilder withBody(String content) {
        this.mockHttpServletRequestBuilder.content(content);
        return  this;
    }
}
