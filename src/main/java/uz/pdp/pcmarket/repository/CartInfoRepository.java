package uz.pdp.pcmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.pdp.pcmarket.entity.CartInfo;
import uz.pdp.pcmarket.projection.CustomCartInfo;

@RepositoryRestResource(path = "cartInfo", excerptProjection = CustomCartInfo.class)
public interface CartInfoRepository extends JpaRepository<CartInfo, Integer> {
}
