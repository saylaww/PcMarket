package uz.pdp.pcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.pcmarket.entity.*;

@Projection(types = Detail.class)
public interface CustomDetail {
    Integer getId();

    Product getProduct();

    Feature getFeature();

    String getValue();


}
