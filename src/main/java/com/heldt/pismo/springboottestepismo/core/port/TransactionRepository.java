package com.heldt.pismo.springboottestepismo.core.port;

import com.heldt.pismo.springboottestepismo.infra.database.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {

}
