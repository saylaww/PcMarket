package uz.pdp.pcmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.pcmarket.entity.Payment;
import uz.pdp.pcmarket.projection.CustomPayment;

@RepositoryRestResource(path = "payment", excerptProjection = CustomPayment.class)
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
