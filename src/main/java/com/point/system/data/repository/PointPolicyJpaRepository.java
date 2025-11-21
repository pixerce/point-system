package com.point.system.data.repository;

import com.point.system.data.entity.PointPolicyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointPolicyJpaRepository extends JpaRepository<PointPolicyEntity, Long> {
}
