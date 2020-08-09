package com.example.angularmockproject.products;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    List<Product> products = Arrays.asList(
            new Product(
                    2l, "Garden Cart", "GDN-0023", "March 18, 2019",
                    32.99f,"15 gallon capacity rolling garden cart",
                    3.7f, "assets/images/gallon.jfif"
            ),
            new Product(
                    3l, "Hammer", "TXB-0123", "May 1, 2019",
                    45.99f,"carbon steel hammer excellent for work",
                    2.1f, "assets/images/hammer.jfif"
            ),
            new Product(
                    4l, "Confident", "DLC-007", "June 5, 2016",
                    77.99f,"Demi Lovato 5th studio album",
                    4.2f, "assets/images/confident.png"
            ),
            new Product(
                    5l, "ASUS Laptop ", "ROG-STRIX-G15", "October 2, 2019",
                    22.99f,"Newest asus's gaming laptop, with excellent performances",
                    5.0f, "assets/images/asus.jpg"
            )
    );


    @GetMapping
    public List<Product> getProducts(){
        return this.products;
    }

    @GetMapping("/{id}")
    public Product getById( @PathVariable Long id){
        Product product = null;
        for(Product p : this.products){
            if(p.getProductId() == id){
                product = p;
                break;
            }
        }

        if (product == null)
            throw new ProductNotFoundException(id);

        return product;
    }
}
