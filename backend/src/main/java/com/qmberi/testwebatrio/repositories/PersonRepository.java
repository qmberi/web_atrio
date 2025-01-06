package com.qmberi.testwebatrio.repositories;

import com.qmberi.testwebatrio.domains.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    @Query(value = "select p.* from person as p \n" +
            "left join person_job pj on p.id = pj.person_id\n" +
            "left outer join enterprise e on e.id = pj.enterprise_id\n" +
            "where e.name = :name", nativeQuery = true)
    List<Person> findAllPersonWorkWithAnEnterprise (@Param("name") String name);
}
