package com.point.system.data.mapper;

import com.point.system.data.entity.PointUsageChannelEntity;
import com.point.system.data.entity.PointPolicyEntity;
import com.point.system.data.entity.PointTypeLimitEntity;
import com.point.system.domain.entity.PointPolicy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PointPolicyPersistMapper {

    public PointPolicy policyEntitiesToPointPolicy(PointPolicyEntity pointPolicyEntity
            , List<PointUsageChannelEntity> pointChannelEntityList
            , List<PointTypeLimitEntity> pointTypeLimitEntityList) {

        PointPolicy pointPolicy = PointPolicy.builder()
                .pointPolicyNo(pointPolicyEntity.getPointPolicyNo())
                .pointType(pointPolicyEntity.getPointType())
                .amount(pointPolicyEntity.getAmount())
                .amountType(pointPolicyEntity.getAmountType())
                .lifeSpan(pointPolicyEntity.getLifeSpan())
                .startDate(pointPolicyEntity.getStartDate())
                .issueMethod(pointPolicyEntity.getIssueMethod())
                .build();

        Optional<PointTypeLimitEntity> optionalPointTypeLimitEntity = pointTypeLimitEntityList.stream()
                .filter(limit -> limit.getPointType() == pointPolicyEntity.getPointType())
                .findAny();
        if (optionalPointTypeLimitEntity.isPresent())
            pointPolicy.setAmountLimit(optionalPointTypeLimitEntity.get().getAmountLimit());

        Optional<PointUsageChannelEntity> optionalPointUsageChannelEntity = pointChannelEntityList.stream()
                .filter(channel -> channel.getPointPolicyNo() == pointPolicyEntity.getPointPolicyNo())
                .findAny();
        if (optionalPointUsageChannelEntity.isPresent())
            pointPolicy.setPointUsageChannel(optionalPointUsageChannelEntity.get().getPointChannel());

        return pointPolicy;
    }
}
