package uz.pdp.pcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.pcmarket.entity.*;

import java.util.Date;

@Projection(types = Comment.class)
public interface CustomComment {
    Integer getId();

    User getUser();

    String getMessage();

    Date getDate();

    Integer getMark();

    Product getProduct();

}
