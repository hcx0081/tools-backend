package com.ooo01.business.repository;

import com.ooo01.business.domain.entity.AAADemo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AAADemoEntityRepository extends JpaRepository<AAADemo, String>, JpaSpecificationExecutor<AAADemo> {

}
