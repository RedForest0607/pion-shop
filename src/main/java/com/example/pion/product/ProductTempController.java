package com.example.pion.product;

import com.example.pion.product.application.ProductTempService;
import com.example.pion.product.dto.ProductRequest;
import com.example.pion.product.dto.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/main")
public class ProductTempController {

    @Autowired
    private ProductTempService productTempService;

    @GetMapping("/string")
    public String getString() {
        return "index";
    }

    @GetMapping()
    public String temp(Model md) {
        md.addAttribute("name", "상품 A");
        return "/product/ProductTemp";
    }

    @GetMapping("/model")
    public ModelAndView getModel() {
        ModelAndView mv = new ModelAndView("/main/model");
        mv.addObject("name", "model");
        return mv;
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseStatus(HttpStatus.PERMANENT_REDIRECT)
    public String saveProduct(ProductRequest productRequest) {
        productTempService.save(productRequest);
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.setLocation(URI.create("/"));
//        return new ResponseEntity<>(httpHeaders, HttpStatus.MOVED_PERMANENTLY);
        return "redirect:add/success";
    }

    @GetMapping("/add/success")
    public String saveSuccess() {
        return "/success";
    }

    @GetMapping("/find/all")
    @ResponseStatus(code = HttpStatus.OK)
    @ResponseBody
    public List<ProductResponse> findAllProduct(){
        return productTempService.findAllProduct();
    }

    @GetMapping("/find/{id}")
    public String getProductById(@PathVariable String id) {
        return "/product/productList";
    }

    @GetMapping("/list")
    public ModelAndView getList() {

        ArrayList<ProductResponse> result = productTempService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("list", result);
        mv.setViewName("product/productList");
        return mv;
    }

    @GetMapping("/detail/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ModelAndView getDetailById(@PathVariable String id) {
        ModelAndView mv = new ModelAndView("/product/productDetail");
        mv.addObject("product", productTempService.findProductById(id));
        return mv;
    }

    @GetMapping("/exception")
    public void throwError() {
        throw new RuntimeException();
    }

    @ExceptionHandler(value = RuntimeException.class)
    public String handleException() {
        return "error";
    }
}
