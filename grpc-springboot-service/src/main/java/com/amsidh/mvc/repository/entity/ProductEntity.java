package com.amsidh.mvc.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
@Entity
@Table(name = "PRODUCT_INFO")
public class ProductEntity implements Serializable {

    @Id
    private Integer id;
    private String name;
    private Double price;
    private String description;
}
