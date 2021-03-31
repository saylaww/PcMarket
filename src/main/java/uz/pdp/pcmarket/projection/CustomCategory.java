package uz.pdp.pcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.pcmarket.entity.Attachment;
import uz.pdp.pcmarket.entity.Cart;
import uz.pdp.pcmarket.entity.Category;
import uz.pdp.pcmarket.entity.User;

import java.util.Date;
import java.util.List;

@Projection(types = Category.class)
public interface CustomCategory {

    Integer getId();

    String getName();

    String getDescription();

    List<Category> getParent();

    Attachment getPhoto();

}
