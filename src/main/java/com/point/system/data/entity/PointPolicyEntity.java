package com.point.system.data.entity;

import com.point.system.domain.valueobject.IsActiveYn;
import com.point.system.domain.valueobject.PointPolicyAmountType;
import com.point.system.domain.valueobject.PointPolicyIssueMethod;
import com.point.system.domain.valueobject.PointPolicyPointType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Table(name = "point_policy", schema = "point")
public class PointPolicyEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long policyId;
    private Long amount;
    @Enumerated(EnumType.STRING)
    private PointPolicyAmountType amountType;
    private Long minAmount;
    private Long maxAmount;
    @Enumerated(EnumType.STRING)
    private PointPolicyPointType pointType;
    @Enumerated(EnumType.STRING)
    private PointPolicyIssueMethod issueMethod;
    @Enumerated(EnumType.STRING)
    private IsActiveYn isActive;
    private LocalDateTime startDate;
    private Integer lifeSpan;
    private String pointName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
