package com.point.system.data.entity;

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
    private Long pointPolicyNo;
    private Long amount;
    private String amountType;
    private String pointType;
    private String issueMethod;
    private LocalDateTime startDate;
    private Integer lifeSpan;
    private String pointName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
