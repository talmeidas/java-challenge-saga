package br.com.security.company.insurance.repository;

import br.com.security.company.insurance.model.InsuranceTypeItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InsuranceTypeItemRepository extends JpaRepository<InsuranceTypeItem, Integer> {
    Optional<List<InsuranceTypeItem>> getAllByTypeId(final Integer typeId);
}
