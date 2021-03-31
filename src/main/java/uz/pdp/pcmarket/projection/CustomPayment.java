package uz.pdp.pcmarket.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.pcmarket.entity.*;

import java.util.Date;

@Projection(types = Payment.class)
public interface CustomPayment {
    Integer getId();

    Double getPrice();

    User getCustomer();

    Invoice getInvoice();

    Date getDate();

}
