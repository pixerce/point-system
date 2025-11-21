package com.point.system.data.entity;

import com.point.system.domain.valueobject.PointUsageChannel;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(schema = "point", name = "point_usage_channel")
public class PointUsageChannelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pointUsageChannelNo;
    private Long pointPolicyNo;
    @Enumerated(EnumType.STRING)
    private PointUsageChannel pointChannel;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String description;
}
