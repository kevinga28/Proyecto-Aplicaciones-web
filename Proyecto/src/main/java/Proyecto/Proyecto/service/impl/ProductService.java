package Proyecto.Proyecto.service.impl;

import Proyecto.Proyecto.db.IProductRepository;
import Proyecto.Proyecto.entities.Product;
import Proyecto.Proyecto.service.IProductService;
import org.springframework.stereotype.Service;



@Service
public class ProductService extends BaseService<Product, Integer> implements IProductService {

    //here we have to create this variable because of syntax we can't see the this.repository as a IproductRepository
    private final IProductRepository productRepository;

    public ProductService(IProductRepository productRepository) {
        super(productRepository);
        this.productRepository = productRepository;
    }

}
