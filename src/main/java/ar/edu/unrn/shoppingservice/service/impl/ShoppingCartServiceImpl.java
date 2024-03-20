package ar.edu.unrn.shoppingservice.service.impl;

import ar.edu.unrn.shoppingservice.repository.ShoppingCartRepository;
import ar.edu.unrn.shoppingservice.service.SaleService;
import ar.edu.unrn.shoppingservice.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    ShoppingCartRepository shoppingCartRepository;

    @Autowired
    SaleService saleService;
}