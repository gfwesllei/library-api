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
public class Book extends BaseEntity {

    private String title;
    private String sbn;
    private Double value;
    private int estoque;

    public Book(String title, String sbn, Double value,int estoque) {
        this.title = title;
        this.sbn = sbn;
        this.value = value;
        this.estoque = estoque;
    }
}
