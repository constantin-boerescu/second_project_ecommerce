package com.secondproject.ecommerce.repository;




import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.secondproject.ecommerce.entity.WebOrder;


@Repository
public interface OrderRepository extends JpaRepository<WebOrder, Long> {

	Optional<WebOrder> findActiveOrderByCustomerId(Long customerId);





	

}
