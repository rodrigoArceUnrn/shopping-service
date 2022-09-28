package ar.edu.unrn.shoppingservice.repository;

import ar.edu.unrn.shoppingservice.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    Boolean existsSaleByClient_Id(Long idClient);

    Sale findSaleByClient_Id(Long idClient);

}
