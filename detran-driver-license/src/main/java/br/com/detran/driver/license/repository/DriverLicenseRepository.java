package br.com.detran.driver.license.repository;

import br.com.detran.driver.license.model.DriverLicense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverLicenseRepository extends JpaRepository<DriverLicense, String> {
}
