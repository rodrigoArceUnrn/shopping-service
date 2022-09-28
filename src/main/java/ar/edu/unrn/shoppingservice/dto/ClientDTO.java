package ar.edu.unrn.shoppingservice.dto;

import java.util.List;

public class ClientDTO {

    private Long id;
    private String name;
    private String email;


    private List<SaleDTO> saleList;

    public ClientDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<SaleDTO> getSaleList() {
        return saleList;
    }

    public void setSaleList(List<SaleDTO> saleList) {
        this.saleList = saleList;
    }
}
