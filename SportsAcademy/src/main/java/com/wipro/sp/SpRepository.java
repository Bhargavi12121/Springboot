package com.wipro.sp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpRepository extends JpaRepository<StudentSubscriptionModel, Integer> {

}
