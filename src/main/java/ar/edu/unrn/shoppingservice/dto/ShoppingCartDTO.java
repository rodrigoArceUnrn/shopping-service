package ar.edu.unrn.shoppingservice.dto;

import java.util.List;

public class ShoppingCartDTO {

    private Long id;
    private List<ProductDTO> productList;

    public ShoppingCartDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ProductDTO> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductDTO> productList) {
        this.productList = productList;
    }
}
