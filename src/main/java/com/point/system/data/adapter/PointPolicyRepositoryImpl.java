package com.point.system.data.adapter;

import com.point.system.application.port.output.PointPolicyRepository;
import com.point.system.data.entity.PointPolicyEntity;
import com.point.system.data.mapper.PointPersistMapper;
import com.point.system.data.mapper.PointPolicyPersistMapper;
import com.point.system.data.repository.PointPolicyJpaRepository;
import com.point.system.domain.entity.PointPolicy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class PointPolicyRepositoryImpl implements PointPolicyRepository {

    private final PointPolicyJpaRepository jpaRepository;
    private final PointPolicyPersistMapper pointPolicyPersistMapper;

    public PointPolicy findPointPolicyByNo(final Long policyNo) {
        Optional<PointPolicyEntity> optionalPointPolicyEntity = this.jpaRepository.findById(policyNo);
        if (optionalPointPolicyEntity.isEmpty())
            throw new RuntimeException("포인트 정책을 찾을 수 없음");

        return this.pointPolicyPersistMapper.pointPolicyEntityToPointPolicy(optionalPointPolicyEntity.get());
    }
}
