package ar.edu.unrn.shoppingservice.service;

import ar.edu.unrn.shoppingservice.dto.ProductDTO;
import ar.edu.unrn.shoppingservice.dto.ShoppingCartDTO;

public interface SaleService {
    boolean existsSaleByClient(Long idClient);

    ShoppingCartDTO findShoppingCartByClient(Long idClient);

    ShoppingCartDTO createNewSale(Long idClient);

    ShoppingCartDTO addProductToShoppingCartByClient(Long idClient, ProductDTO productDTO);
}