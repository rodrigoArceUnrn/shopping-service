package ar.edu.unrn.shoppingservice.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SaleDTO {

    private Long id;
    private Float totalAmount;
    private LocalDateTime datePurchase;
    private ClientDTO client;
    private Long shoppingCartId;
}