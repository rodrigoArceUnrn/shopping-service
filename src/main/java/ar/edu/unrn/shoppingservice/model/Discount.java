package ar.edu.unrn.shoppingservice.model;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "discounts")
public class Discount extends BaseEntity{

    private LocalDateTime StartDate;
    private LocalDateTime endDate;
    private Float amount;

    @ManyToMany(mappedBy = "discountList")
    private List<Product> productList;

    public Discount() {
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
}
