package ar.edu.unrn.shoppingservice.domain.service;

import ar.edu.unrn.shoppingservice.controller.dto.ProductDTO;
import ar.edu.unrn.shoppingservice.controller.dto.SaleDTO;
import ar.edu.unrn.shoppingservice.controller.dto.ShoppingCartDTO;

public interface SaleService {
    boolean existsSaleByClient(Long idClient);

    ShoppingCartDTO findShoppingCartByClient(Long idClient);

    ShoppingCartDTO createNewSaleAndFindShoppingCartByClient(Long idClient);

    void addProductToShoppingCartByClient(Long idClient, ProductDTO productDTO);

    void buy(SaleDTO saleDTO);
}