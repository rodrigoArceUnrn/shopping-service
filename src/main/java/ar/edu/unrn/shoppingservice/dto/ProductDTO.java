package ar.edu.unrn.shoppingservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProductDTO {

    private Long id;
    private String title;
    private Float amount;
    private List<ShoppingCartDTO> shoppingCartList;
}