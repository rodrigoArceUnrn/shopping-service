package ar.edu.unrn.shoppingservice.service.impl;

import ar.edu.unrn.shoppingservice.dto.ProductDTO;
import ar.edu.unrn.shoppingservice.dto.SaleDTO;
import ar.edu.unrn.shoppingservice.dto.ShoppingCartDTO;
import ar.edu.unrn.shoppingservice.model.Client;
import ar.edu.unrn.shoppingservice.model.Product;
import ar.edu.unrn.shoppingservice.model.Sale;
import ar.edu.unrn.shoppingservice.model.ShoppingCart;
import ar.edu.unrn.shoppingservice.repository.ClientRepository;
import ar.edu.unrn.shoppingservice.repository.ProductRepository;
import ar.edu.unrn.shoppingservice.repository.SaleRepository;
import ar.edu.unrn.shoppingservice.repository.ShoppingCartRepository;
import ar.edu.unrn.shoppingservice.service.SaleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleServiceImpl implements SaleService {

    @Autowired
    SaleRepository saleRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ShoppingCartRepository shoppingCartRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    private SaleDTO convertToDTO(Sale sale) {
        return modelMapper.map(sale, SaleDTO.class);
    }

    private Product convertToEntity(ProductDTO productDTO) {
        return modelMapper.map(productDTO, Product.class);
    }

    @Override
    public boolean existsSaleByClient(Long idClient) {
        return saleRepository.existsSaleByClient_Id(idClient);
    }

    @Override
    public ShoppingCartDTO findShoppingCartByClient(Long idClient) {
        SaleDTO saleDTO = convertToDTO(saleRepository.findSaleByClient_Id(idClient));
        return saleDTO.getShoppingCart();
    }

    @Override
    public ShoppingCartDTO createNewSale(Long idClient) {
        Client client = clientRepository.save(new Client(idClient));
        ShoppingCart shoppingCart = shoppingCartRepository.save(new ShoppingCart());
        Sale newSale = new Sale();
        newSale.setClient(client);
        newSale.setShoppingCart(shoppingCart);
        Sale sale = saleRepository.save(newSale);
        SaleDTO saleDTO = convertToDTO(sale);
        return saleDTO.getShoppingCart();
    }

    @Override
    public ShoppingCartDTO addProductToShoppingCartByClient(Long idClient, ProductDTO productDTO) {
        Sale sale = saleRepository.findSaleByClient_Id(idClient);

        Product product = productRepository.save(convertToEntity(productDTO));
        sale.getShoppingCart().getProductList().add(product);
        saleRepository.save(sale);
        return convertToDTO(sale).getShoppingCart();
    }
}
