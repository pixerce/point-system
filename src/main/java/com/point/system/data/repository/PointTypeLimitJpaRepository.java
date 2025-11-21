package com.point.system.data.repository;

import com.point.system.data.entity.PointTypeLimitEntity;
import com.point.system.domain.valueobject.IsActiveYn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PointTypeLimitJpaRepository extends JpaRepository<PointTypeLimitEntity, Long> {

    List<PointTypeLimitEntity> findByIsActiveEquals(IsActiveYn isActive);
}
