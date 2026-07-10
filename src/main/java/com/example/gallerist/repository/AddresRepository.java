package com.example.gallerist.repository;

import com.example.gallerist.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddresRepository extends JpaRepository<Address, Long> {
}
