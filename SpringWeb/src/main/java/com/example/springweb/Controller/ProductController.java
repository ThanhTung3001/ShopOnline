package com.example.springweb.Controller;

import com.example.springweb.Service.ICategoryService;
import com.example.springweb.Service.IProductService;
import com.example.springweb.dto.CategoryDto;
import com.example.springweb.dto.ProductDto;
import com.example.springweb.entity.CategoryEntity;
import com.example.springweb.entity.ImageEntity;
import com.example.springweb.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/Admin/products")
public class ProductController {
    @Autowired
    ICategoryService categoryService;
    @Autowired
    IProductService productService;
    @PostMapping()
    public ModelAndView addProduct(@RequestParam String name,
                                   @RequestParam String img
                                , @RequestParam String price
                                  , @RequestParam String Quatity,
                                   @RequestParam String category,@RequestParam String img1,
                                   @RequestParam String img2,@RequestParam String img3,@RequestParam String img4,
                                   @RequestParam String img5,
                                   @RequestParam String description
    ){
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(name);
        productEntity.setPrice(Long.valueOf(price));
        productEntity.setImage(img);
        CategoryEntity categoryEntity  =new CategoryEntity();
        categoryEntity.setId(Long.valueOf(category));
        productEntity.setCategoryEntity(categoryEntity);
        productEntity.setQuantity(Integer.parseInt(Quatity));
        productEntity.images.add(new ImageEntity(img1));
        productEntity.images.add(new ImageEntity(img2));
        productEntity.images.add(new ImageEntity(img3));
        productEntity.images.add(new ImageEntity(img4));
        productEntity.images.add(new ImageEntity(img5));
        productEntity.setDescription(description);
        productService.addProduct(productEntity);
        return new ModelAndView("redirect:products");
    }
    @GetMapping()
    public String adminPage(Model model){
        List<CategoryDto> CategoryList = categoryService.findAll();
        model.addAttribute("CategoryList",CategoryList);
        List<ProductDto> ProductList=productService.findAll();
        model.addAttribute("ProductList",ProductList);
        return "admin";
    }


}
