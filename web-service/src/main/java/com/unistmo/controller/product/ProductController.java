package com.unistmo.controller.product;

import com.unistmo.dto.ProductDTO;
import com.unistmo.operation.crud.ICrudOperation;
import static com.unistmo.ws.ConstantsWs.BASE_PRODUCT_PATH_WS;
import static com.unistmo.ws.ConstantsWs.PRODUCT_DELETE;
import static com.unistmo.ws.ConstantsWs.PRODUCT_GET_ALL;
import static com.unistmo.ws.ConstantsWs.PRODUCT_SAVE;
import static com.unistmo.ws.ConstantsWs.PRODUCT_UPDATE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(BASE_PRODUCT_PATH_WS)
public class ProductController{
    private ICrudOperation productService;

    @Autowired
    public ProductController(ICrudOperation productService) {
        this.productService = productService;
    }

    @PostMapping(PRODUCT_SAVE)
    public ResponseEntity<ProductDTO> saveItem(@RequestBody ProductDTO item) {
        return ResponseEntity.status(HttpStatus.CREATED).body((ProductDTO) productService.saveItem(item));
    }

    @DeleteMapping(PRODUCT_DELETE)
    public ResponseEntity<?> deleteItem(@PathVariable(name = "productId") Long idProduct) {
        productService.deleteItem(idProduct);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @PutMapping(PRODUCT_UPDATE)
    public ResponseEntity<?> updateItem(Object itemToUpdate) {
        return null;
    }

    @GetMapping(PRODUCT_GET_ALL)
    public ResponseEntity<List<?>> getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }
}
