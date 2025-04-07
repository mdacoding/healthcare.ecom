package com.mdacoding.healthcare.ecom.repositories;

import com.mdacoding.healthcare.ecom.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
