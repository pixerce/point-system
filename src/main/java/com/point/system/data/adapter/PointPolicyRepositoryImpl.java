package com.point.system.data.adapter;

import com.point.system.application.port.output.PointPolicyRepository;
import com.point.system.data.entity.PointPolicyEntity;
import com.point.system.data.mapper.PointPolicyPersistMapper;
import com.point.system.data.repository.PointChannelJpaRepository;
import com.point.system.data.repository.PointPolicyJpaRepository;
import com.point.system.data.repository.PointTypeLimitJpaRepository;
import com.point.system.domain.entity.PointPolicy;
import com.point.system.domain.valueobject.IsActiveYn;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class PointPolicyRepositoryImpl implements PointPolicyRepository {

    private final PointPolicyJpaRepository pointPolicyJpaRepository;
    private final PointPolicyPersistMapper pointPolicyPersistMapper;
    private final PointChannelJpaRepository pointChannelJpaRepository;
    private final PointTypeLimitJpaRepository pointTypeLimitJpaRepository;

    public PointPolicy findPointPolicyByNo(final Long policyNo) {
        Optional<PointPolicyEntity> optionalPointPolicyEntity = this.pointPolicyJpaRepository.findById(policyNo);
        if (optionalPointPolicyEntity.isEmpty())
            throw new RuntimeException("포인트 정책을 찾을 수 없음");

        return this.pointPolicyPersistMapper.policyEntitiesToPointPolicy(optionalPointPolicyEntity.get()
                , this.pointChannelJpaRepository.findByPointPolicyNo(policyNo)
                , this.pointTypeLimitJpaRepository.findByIsActiveEquals(IsActiveYn.Y));
    }
}
