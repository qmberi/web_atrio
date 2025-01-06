package com.qmberi.testwebatrio.repositories;

import com.qmberi.testwebatrio.domains.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EnterpriseRepository extends JpaRepository<Enterprise, Integer> {
    Optional<Enterprise> findEnterpriseByName(String name);
}
