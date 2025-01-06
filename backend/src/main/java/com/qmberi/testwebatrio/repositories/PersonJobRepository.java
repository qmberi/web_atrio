package com.qmberi.testwebatrio.repositories;

import com.qmberi.testwebatrio.domains.Person;
import com.qmberi.testwebatrio.domains.PersonJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PersonJobRepository extends JpaRepository<PersonJob, Integer> {

    List<PersonJob> findAllByStartDateBetweenAndPersonId(Date startDate, Date startDate2, Integer personId);
}
