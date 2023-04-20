package br.com.security.company.insurance.repository;

import br.com.security.company.insurance.model.InsuranceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceTypeRepository extends JpaRepository<InsuranceType, Integer> {
}
