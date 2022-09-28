package ar.edu.unrn.shoppingservice.controller;

import ar.edu.unrn.shoppingservice.dto.ProductDTO;
import ar.edu.unrn.shoppingservice.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping(value = "/shopping-carts")
public class SaleController {
    @Autowired
    SaleService saleService;

    @GetMapping("/{clientId}")
    public ResponseEntity getShoppingCartByIdClient(@PathVariable Long clientId) {
        try {
            if (saleService.existsSaleByClient(clientId))
                return ResponseEntity.ok().body(saleService.findShoppingCartByClient(clientId));
            else
                return ResponseEntity.ok().body(saleService.createNewSale(clientId));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{clientId}/product")
    public ResponseEntity addProductToShoppingCart(@PathVariable Long clientId, @RequestBody ProductDTO productDTO) {
        try {
            return ResponseEntity.ok().body(saleService.addProductToShoppingCartByClient(clientId, productDTO));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}
