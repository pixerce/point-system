package com.point.system.data.mapper;

import com.point.system.data.entity.PointUsagePolicyEntity;
import com.point.system.data.entity.PointPolicyEntity;
import com.point.system.data.entity.PointTypePolicyEntity;
import com.point.system.domain.entity.PointPolicy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class PointPolicyPersistMapper {

    public PointPolicy policyEntitiesToPointPolicy(PointPolicyEntity pointPolicyEntity
            , List<PointUsagePolicyEntity> pointChannelEntityList
            , List<PointTypePolicyEntity> pointTypePolicyEntityList) {

        PointPolicy pointPolicy = PointPolicy.builder()
                .policy_id(pointPolicyEntity.getPolicyId())
                .pointType(pointPolicyEntity.getPointType())
                .amount(pointPolicyEntity.getAmount())
                .amountType(pointPolicyEntity.getAmountType())
                .lifeSpan(pointPolicyEntity.getLifeSpan())
                .startDate(pointPolicyEntity.getStartDate())
                .issueMethod(pointPolicyEntity.getIssueMethod())
                .build();

        Optional<PointTypePolicyEntity> optionalPointTypeLimitEntity = pointTypePolicyEntityList.stream()
                .filter(limit -> limit.getPointType() == pointPolicyEntity.getPointType())
                .findAny();
        if (optionalPointTypeLimitEntity.isPresent())
            pointPolicy.setMaxCumulativeAmount(optionalPointTypeLimitEntity.get().getMaxCumulativeAmount());

        Optional<PointUsagePolicyEntity> optionalPointUsageChannelEntity = pointChannelEntityList.stream()
                .filter(usage -> Objects.equals(usage.getPolicyId(), pointPolicyEntity.getPolicyId()))
                .findAny();
        if (optionalPointUsageChannelEntity.isPresent())
            pointPolicy.setPointUsageChannel(optionalPointUsageChannelEntity.get().getUsageType());

        return pointPolicy;
    }
}
