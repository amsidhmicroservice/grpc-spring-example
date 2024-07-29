package com.amsidh.mvc.model;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class ProductResponseDto implements Serializable {
    private Integer id;
    private String name;
    private Double price;
    private String description;
}
