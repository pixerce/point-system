package com.point.system.data.entity;

import com.point.system.domain.valueobject.IsActiveYn;
import com.point.system.domain.valueobject.PointPolicyPointType;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(schema = "point", name = "point_type_limit")
public class PointTypeLimitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pointTypeLimitNo;

    @Enumerated(EnumType.STRING)
    private PointPolicyPointType pointType;
    private Long amountLimit;
    @Enumerated(EnumType.STRING)
    private IsActiveYn isActive;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String description;
}
