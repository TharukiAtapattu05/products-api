package uk.ac.westminster.products_api;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private List<Product> products = new ArrayList<>();
    private Long nextId = 1L;

    public List<Product> getAllProducts() {
        return products;
    }

    public Product addProduct(Product product) {
        product.setId(nextId++); // use the value, then add one
        products.add(product);
        return product;
    }

    public Product getById(Long id){
        for(Product product : products){
            if(product.getId().equals(id)){
                return product;
            }
        }
        return null;
    }

    public boolean deleteById(Long id){
        return products.removeIf(product ->
                product.getId().equals(id)
        );
    }

    public List<Product> findByName(String name){
        return products.stream()
                .filter(product ->
                        product.getName().equalsIgnoreCase(name))
                .toList();
    }
}
