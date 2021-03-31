package uz.pdp.pcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.pcmarket.entity.Cart;
import uz.pdp.pcmarket.entity.Order;
import uz.pdp.pcmarket.entity.User;

import java.util.Date;

@Projection(types = Order.class)
public interface CustomOrder {
    Integer getId();

    Date getDate();

    User getCustomer();

    Cart getCart();
}
