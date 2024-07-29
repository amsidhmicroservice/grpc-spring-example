package com.amsidh.mvc.model;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class ProductRequestDto implements Serializable {
    private Integer id;
    private String name;
    private Double price;
    private String description;
}
