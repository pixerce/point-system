package com.point.system.data.entity;

import com.point.system.domain.valueobject.PointPolicyPointType;
import com.point.system.domain.valueobject.StatusType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "point_issue_history", schema = "point")
public class PointIssueHistory {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long issueId;

    private Long userPointId;
    private Long userId;
    private PointPolicyPointType pointType;
    private Long amount;
    private StatusType status;
    private String issueReason;
    private String failureReason;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String issueBy;
}
