package Fiap.abctechservice.repository;

import Fiap.abctechservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

//    @Query('')
//    public List<Order> findByOperatorId(Long id);
}
