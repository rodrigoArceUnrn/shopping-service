package ar.edu.unrn.shoppingservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class ShoppingCartDTO {

    private Long id;
    private List<ProductDTO> productList;
}