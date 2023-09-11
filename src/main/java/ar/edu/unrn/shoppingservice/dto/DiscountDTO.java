package ar.edu.unrn.shoppingservice.dto;

import ar.edu.unrn.shoppingservice.model.Product;

import java.time.LocalDateTime;
import java.util.List;


public class DiscountDTO {

    private Long id;
    private LocalDateTime StartDate;
    private LocalDateTime endDate;
    private Float amount;
    private List<Product> productList;

    public DiscountDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getStartDate() {
        return StartDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        StartDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}