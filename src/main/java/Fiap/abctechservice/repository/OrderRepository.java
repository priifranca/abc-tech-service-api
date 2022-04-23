package Fiap.abctechservice.repository;

import Fiap.abctechservice.model.Assistance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssistanceRepository extends JpaRepository<Assistance,Long> {
}
