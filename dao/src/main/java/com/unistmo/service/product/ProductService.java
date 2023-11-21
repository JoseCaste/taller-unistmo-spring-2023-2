package com.unistmo.service.product;

import com.unistmo.dto.ProductDTO;
import com.unistmo.entity.Product;
import com.unistmo.exception.ControllerException;
import com.unistmo.operation.crud.ICrudOperation;
import com.unistmo.repository.product.ProductRepository;
import com.unistmo.service.ServiceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements ICrudOperation<ProductDTO> {
    private ProductRepository productRepository;
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDTO saveItem(ProductDTO item) {
        Product product = productRepository.save(Product
                .builder()
                .productName(item
                        .getProductName())
                .build());

        item.setCreatedDate(product.getCreatedDate());
        return item;
    }

    @Override
    public void deleteItem(Long idProduct) throws ControllerException {
        Product productToDelete = productRepository.findById(idProduct).orElseThrow(() -> new ControllerException(ServiceUtils.RESOURCE_NOT_FOUND));

        productRepository.delete(productToDelete);
    }

    @Override
    public ProductDTO updateItem(ProductDTO itemToUpdate) {
        return null;
    }
}
