package br.com.security.company.contract.repository;

import br.com.security.company.contract.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Integer> {
    Optional<Contract> findContractByRentalBookingId(final Integer rentalBookingId);

    Optional<Contract> findContractByRentalContractId(final Integer rentalContractId);
}
