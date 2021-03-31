package uz.pdp.pcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.pcmarket.entity.Cart;
import uz.pdp.pcmarket.entity.CartInfo;
import uz.pdp.pcmarket.entity.Product;

@Projection(types = CartInfo.class)
public interface CustomCartInfo {

    Integer getId();

    Product getProduct();

    Cart getCart();

    Integer getQuantity();

}
