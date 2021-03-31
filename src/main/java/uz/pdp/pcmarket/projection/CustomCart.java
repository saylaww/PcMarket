package uz.pdp.pcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.pcmarket.entity.Cart;
import uz.pdp.pcmarket.entity.User;

import java.util.Date;

@Projection(types = Cart.class)
public interface CustomCart {

    Integer getId();

    User getCustomer();

    Date getCreatedDate();

}
