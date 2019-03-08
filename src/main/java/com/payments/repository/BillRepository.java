package com.payments.repository;

import com.payments.model.BillModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends CrudRepository<BillModel, Long> {

}
