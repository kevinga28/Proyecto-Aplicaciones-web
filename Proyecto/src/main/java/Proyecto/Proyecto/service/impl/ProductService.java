package Proyecto.Proyecto.service.impl;

import Proyecto.Proyecto.db.IProductRepository;
import Proyecto.Proyecto.entities.Product;
import Proyecto.Proyecto.service.IProductService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductService extends BaseService<Product, Integer> implements IProductService {
private final IProductRepository productRepository;

 

    public ProductService(IProductRepository productRepository) {
        super(productRepository);
        this.productRepository = productRepository;
    }
     public List<Product> getProductsWithNombre(Optional<String> nombre){
         if(nombre.isPresent()){
        return productRepository.findAllByNombre("nombre");
    }
     return (List<Product>) this.productRepository.findAll();
     }
}