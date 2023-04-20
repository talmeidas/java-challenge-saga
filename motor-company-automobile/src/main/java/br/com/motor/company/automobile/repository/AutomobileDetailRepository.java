package br.com.motor.company.automobile.repository;

import br.com.motor.company.automobile.model.Automobile;
import br.com.motor.company.automobile.model.AutomobileDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AutomobileDetailRepository extends JpaRepository<AutomobileDetail, Integer> {
    Optional<AutomobileDetail> findDetailByAutomobileId(final Integer automobileId);
}
