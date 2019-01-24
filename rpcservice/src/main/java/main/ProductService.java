package main;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: ${description}
 * @author: WangYuFei
 * @create: 2019-01-23 19:51
 **/
public class ProductService implements IProductService {


    public static final List<Product> products;
    static {
        products = new ArrayList<Product>();
        products.add(new Product("0xad123","mac-book",12222.11));
        products.add(new Product("0xad456","apple",5.5));
        products.add(new Product("0xad789","pen",6.7));
        products.add(new Product("test","test",0.12));

    }


    public Product findById(String id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst().get();
    }
}
