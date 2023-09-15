package ar.edu.unrn.shoppingservice.controller;

import ar.edu.unrn.shoppingservice.dto.ProductDTO;
import ar.edu.unrn.shoppingservice.dto.SaleDTO;
import ar.edu.unrn.shoppingservice.dto.ShoppingCartDTO;
import ar.edu.unrn.shoppingservice.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping(value = "/shopping-carts")
public class SaleController {
    @Autowired
    SaleService saleService;

    @GetMapping("/{clientId}")
    @PreAuthorize("hasRole('ROLE_CLIENTE')")
    public ResponseEntity<ShoppingCartDTO> getShoppingCartByIdClient(@PathVariable Long clientId) {
        try {
            if (saleService.existsSaleByClient(clientId))
                return ResponseEntity.ok().body(saleService.findShoppingCartByClient(clientId));
            else
                return ResponseEntity.ok().body(saleService.createNewSaleAndFindShoppingCartByClient(clientId));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping("/{clientId}/product")
    @PreAuthorize("hasRole('ROLE_CLIENTE')")
    public ResponseEntity<ShoppingCartDTO> addProductToShoppingCart(@PathVariable Long clientId, @RequestBody ProductDTO productDTO) {
        try {
            saleService.addProductToShoppingCartByClient(clientId, productDTO);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping()
    @PreAuthorize("hasRole('ROLE_CLIENTE')")
    public ResponseEntity<Boolean> buy(@RequestBody SaleDTO saleDTO) {
        try {
            saleService.buy(saleDTO);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

}
