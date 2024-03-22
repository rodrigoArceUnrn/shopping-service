package ar.edu.unrn.shoppingservice.controller.dto;

import ar.edu.unrn.shoppingservice.model.Product;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class DiscountDTO {

    private Long id;
    private LocalDateTime StartDate;
    private LocalDateTime endDate;
    private Float amount;
    private List<ProductDTO> productList;
}