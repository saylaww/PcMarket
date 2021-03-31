package uz.pdp.pcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.pcmarket.entity.*;

import java.util.Date;

@Projection(types = Invoice.class)
public interface CustomInvoice {
    Integer getId();

    User getCustomer();

    Order getOrder();

    Double getPrice();

    Date getCreatedDate();

    Date getDurDate();

    Boolean getStatus();

}
