package com.point.system.data.entity;

import com.point.system.domain.valueobject.IsActiveYn;
import com.point.system.domain.valueobject.PointPolicyPointType;
import com.point.system.domain.valueobject.PointTypePolicyCumulativePeriod;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "point_type_policy", schema = "point")
public class PointTypePolicyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long typePolicyId;

    @Enumerated(EnumType.STRING)
    private PointPolicyPointType pointType;
    private Long maxCumulativeAmount;
    private PointTypePolicyCumulativePeriod cumulativePeriod;
    @Enumerated(EnumType.STRING)
    private IsActiveYn isActive;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
