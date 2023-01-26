package com.example.pion.product.application;

import com.example.pion.product.dao.ProductTempDao;
import com.example.pion.product.domain.Product;
import com.example.pion.product.dto.ProductRequest;
import com.example.pion.product.dto.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductTempService {

    @Autowired
    private ProductTempDao productTempDao;

    public void save(ProductRequest productRequest) {
        productTempDao.save(productRequest.toEntity());
    }
    public ArrayList<ProductResponse> findAll() {
        List<Product> listOfEntity = productTempDao.findAllProduct();

        @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
        ArrayList<ProductResponse> listOfDto = new ArrayList<>();

        listOfEntity.forEach(
                element ->
                        listOfDto.add(ProductResponse.convert(element))
        );

        return listOfDto;
    }
    public List<ProductResponse> findAllProduct() {
        return productTempDao.findAllProduct().stream()
                .map(ProductResponse::convert)
                .collect(Collectors.toList());
    }

    public ProductResponse findProductById(String id) {
        return com.example.pion.product.dto.ProductResponse.convert(productTempDao.findProductById(id));
    }
}