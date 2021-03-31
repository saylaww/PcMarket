package uz.pdp.pcmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.pcmarket.entity.Cart;
import uz.pdp.pcmarket.projection.CustomCart;

@RepositoryRestResource(path = "cart", excerptProjection = CustomCart.class)
public interface CartRepository extends JpaRepository<Cart, Integer> {
}
