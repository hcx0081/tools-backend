package com.ooo01.business.repository;

import com.ooo01.business.domain.entity.AAADemoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AAADemoEntityRepository extends JpaRepository<AAADemoEntity, String>, JpaSpecificationExecutor<AAADemoEntity> {

}
