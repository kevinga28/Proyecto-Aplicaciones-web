package Proyecto.Proyecto.service.impl;

import Proyecto.Proyecto.db.IProductRepository;
import Proyecto.Proyecto.entities.Product;
import Proyecto.Proyecto.service.IProductService;
import org.springframework.stereotype.Service;


@Service
public class ProductService extends BaseService<Product, Integer> implements IProductService {
    public ProductService(IProductRepository productRepository) {
        super(productRepository);
    }

}