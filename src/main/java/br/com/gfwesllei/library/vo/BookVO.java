package br.com.gfwesllei.library.vo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author weslleiferreira
 * @project library
 */
@Data
public class BookVO extends BaseVO {

    private Long id;

    @NotEmpty
    private String title;

    @NotEmpty
    private String isbn;

    @NotEmpty
    private Double value;

    private int estoque;
}
