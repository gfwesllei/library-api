package br.com.gfwesllei.library.vo;

import lombok.Data;

/**
 * @author weslleiferreira
 * @project library
 */
@Data
public class BookVO extends BaseVO {

    private Long id;
    private String title;
    private String isbn;
    private Double value;
    private int estoque;
}
