package br.com.security.company.insurance.repository;

import br.com.security.company.insurance.model.InsuranceItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceItemRepository extends JpaRepository<InsuranceItem, Integer> {
}
