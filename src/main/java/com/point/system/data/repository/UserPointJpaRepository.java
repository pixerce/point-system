package com.point.system.data.repository;

import com.point.system.data.entity.UserPointEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPointJpaRepository extends JpaRepository<UserPointEntity, Long> {
}
