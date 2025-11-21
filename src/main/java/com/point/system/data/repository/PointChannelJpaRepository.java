package com.point.system.data.repository;

import com.point.system.data.entity.PointUsageChannelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PointChannelJpaRepository extends JpaRepository<PointUsageChannelEntity, Long> {

    List<PointUsageChannelEntity> findByPointPolicyNo(Long pointPolicyNo);
}
