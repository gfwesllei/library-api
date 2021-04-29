package br.com.gfwesllei.library.entity;

import lombok.*;

/**
 * @author weslleiferreira
 * @project library
 */

@Data
@Builder
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Book extends BaseEntity {

    private Long id;
    private String title;
    private String isbn;
    private Double value;
    private int estoque;

    public Book(String title, String isbn, Double value,int estoque) {
        this.title = title;
        this.isbn = isbn;
        this.value = value;
        this.estoque = estoque;
    }
}
