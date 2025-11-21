package com.point.system.data.entity;

import com.point.system.domain.valueobject.IsActiveYn;
import com.point.system.domain.valueobject.PointUsageChannel;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(schema = "point", name = "point_usage_policy")
public class PointUsagePolicyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usagePolicyId;
    private Long policyId;
    @Enumerated(EnumType.STRING)
    private PointUsageChannel usageType;
    private IsActiveYn isActive;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String description;
}
