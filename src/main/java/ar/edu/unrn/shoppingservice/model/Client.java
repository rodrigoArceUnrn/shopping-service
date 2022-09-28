package ar.edu.unrn.shoppingservice.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    private String name;
    private String email;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Sale> saleList;

    public Client() {
    }

    public Client(Long id) {
        setId(id);
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

    public List<Sale> getSaleList() {
        return saleList;
    }

    public void setSaleList(List<Sale> saleList) {
        this.saleList = saleList;
    }
}
