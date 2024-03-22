package ar.edu.unrn.shoppingservice.controller.dto;

import lombok.Data;

@Data
public class ProductDTO {

    private Long id;
    private String title;
    private Float amount;
}