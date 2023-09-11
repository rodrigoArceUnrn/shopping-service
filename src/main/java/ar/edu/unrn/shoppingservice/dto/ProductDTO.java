package ar.edu.unrn.shoppingservice.dto;

import java.util.List;

public class ProductDTO {

    private Long id;
    private String title;
    private Float amount;
    private List<ShoppingCartDTO> shoppingCartList;

    public ProductDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public List<ShoppingCartDTO> getShoppingCartList() {
        return shoppingCartList;
    }

    public void setShoppingCartList(List<ShoppingCartDTO> shoppingCartList) {
        this.shoppingCartList = shoppingCartList;
    }
}