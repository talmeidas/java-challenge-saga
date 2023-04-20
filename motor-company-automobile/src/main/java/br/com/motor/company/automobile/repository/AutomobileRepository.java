package br.com.motor.company.automobile.repository;

import br.com.motor.company.automobile.model.Automobile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutomobileRepository extends JpaRepository<Automobile, Integer> {
}
