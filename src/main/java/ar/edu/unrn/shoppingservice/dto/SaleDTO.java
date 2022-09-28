package ar.edu.unrn.shoppingservice.dto;

import ar.edu.unrn.shoppingservice.model.ShoppingCart;

import java.time.LocalDateTime;

public class SaleDTO {

    private Long id;
    private Float totalAmount;
    private LocalDateTime datePurchase;

    private ClientDTO client;

    private ShoppingCartDTO shoppingCart;

    public SaleDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public LocalDateTime getDatePurchase() {
        return datePurchase;
    }

    public void setDatePurchase(LocalDateTime datePurchase) {
        this.datePurchase = datePurchase;
    }

    public ClientDTO getClient() {
        return client;
    }

    public void setClient(ClientDTO client) {
        this.client = client;
    }

    public ShoppingCartDTO getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCartDTO shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
}
