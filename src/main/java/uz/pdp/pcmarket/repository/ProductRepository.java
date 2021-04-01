package uz.pdp.pcmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import uz.pdp.pcmarket.entity.Product;
import uz.pdp.pcmarket.projection.CustomProduct;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(path = "product", excerptProjection = CustomProduct.class)
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @RestResource(path = "byPrice")
    List<Product> findAllByPriceBetween(@RequestParam("start") Integer start,@RequestParam("end") Integer end);

    @RestResource(path = "byName")
    Optional<Product> findByName(@RequestParam("name") String name);

    @RestResource(path = "byCategory")
    List<Product> findAllByCategory_Name(@RequestParam("category_name") String category_name);


}
