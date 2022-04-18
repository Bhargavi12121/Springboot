package com.wipro.sp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author BH20293715
 *
 */
@Repository
public interface SpRepository extends JpaRepository<StudentSubscriptionModel, Integer> {

}
