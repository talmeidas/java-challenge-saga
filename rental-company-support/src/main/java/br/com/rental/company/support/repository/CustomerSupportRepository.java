package br.com.rental.company.support.repository;

import br.com.rental.company.support.enumerable.StatusSupport;
import br.com.rental.company.support.model.CustomerSupport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerSupportRepository extends JpaRepository<CustomerSupport, Integer> {
    List<CustomerSupport> findScheduleByCnh(final String cnh);
}
