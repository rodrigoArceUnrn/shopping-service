package ar.edu.unrn.shoppingservice.domain.service.impl;

import ar.edu.unrn.shoppingservice.controller.dto.DetailSaleDTO;
import ar.edu.unrn.shoppingservice.controller.dto.ProductDTO;
import ar.edu.unrn.shoppingservice.controller.dto.SaleDTO;
import ar.edu.unrn.shoppingservice.controller.dto.ShoppingCartDTO;
import ar.edu.unrn.shoppingservice.domain.service.SaleService;
import ar.edu.unrn.shoppingservice.model.Client;
import ar.edu.unrn.shoppingservice.model.Product;
import ar.edu.unrn.shoppingservice.model.Sale;
import ar.edu.unrn.shoppingservice.model.ShoppingCart;
import ar.edu.unrn.shoppingservice.domain.rabbitmq.service.RabbitService;
import ar.edu.unrn.shoppingservice.data.repository.ClientRepository;
import ar.edu.unrn.shoppingservice.data.repository.ProductRepository;
import ar.edu.unrn.shoppingservice.data.repository.SaleRepository;
import ar.edu.unrn.shoppingservice.data.repository.ShoppingCartRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

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

    final RabbitService rabbitService;

    public SaleServiceImpl(RabbitService rabbitService) {
        this.rabbitService = rabbitService;
    }


    @Override
    public boolean existsSaleByClient(Long idClient) {
        return saleRepository.existsSaleByClient_Id(idClient);
    }

    @Override
    public ShoppingCartDTO findShoppingCartByClient(Long idClient) {
        Sale sale = saleRepository.findSaleByClient_Id(idClient);
        return convertToShoppingCartDTO(sale.getShoppingCart());
    }

    @Override
    @Transactional
    public ShoppingCartDTO createNewSaleAndFindShoppingCartByClient(Long idClient) {
        Client client = new Client(idClient);
        Sale sale = new Sale();
        client.addSale(sale);
        clientRepository.save(client);
        return this.findShoppingCartByClient(idClient);
    }

    @Override
    public void addProductToShoppingCartByClient(Long idClient, ProductDTO productDTO) {
        Sale sale = saleRepository.findSaleByClient_Id(idClient);
        Product product = productRepository.save(convertToEntityProduct(productDTO));
        sale.getShoppingCart().getProductList().add(product);
        saleRepository.save(sale);
    }

    @Override
    public void buy(SaleDTO saleDTO) {
        Sale sale = convertToEntitySale(saleDTO);
        Optional<ShoppingCart> shoppingCart = shoppingCartRepository.findById(saleDTO.getShoppingCartId());
        sale.setShoppingCart(shoppingCart.get());
        sale.setClient(clientRepository.save(sale.getClient()));
        Sale result = saleRepository.save(sale);
        DetailSaleDTO detailSale = new DetailSaleDTO(modelMapper.map(result, SaleDTO.class), convertToShoppingCartDTO(shoppingCart.get()).getProductList());
        rabbitService.sendSaleSuccessfullMessage(detailSale);

    }

    private ShoppingCartDTO convertToShoppingCartDTO(ShoppingCart shoppingCart) {
        return modelMapper.map(shoppingCart, ShoppingCartDTO.class);
    }

    private Product convertToEntityProduct(ProductDTO productDTO) {
        return modelMapper.map(productDTO, Product.class);
    }

    private Sale convertToEntitySale(SaleDTO saleDTO) {
        return modelMapper.map(saleDTO, Sale.class);
    }

}