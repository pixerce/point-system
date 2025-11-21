package com.point.system.data.repository;

import com.point.system.data.entity.PointUsagePolicyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PointUsagePolicyJpaRepository extends JpaRepository<PointUsagePolicyEntity, Long> {

    List<PointUsagePolicyEntity> findByPolicyId(Long policyId);
}
