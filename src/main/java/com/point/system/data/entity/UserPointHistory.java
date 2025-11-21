package com.point.system.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "user_point_history", schema = "point")
public class UserPointHistory {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long userPointHistoryNo;

    private Long userPointNo;
    private Long orderNo;
    private Long amount;
    private String actionType;
    private LocalDateTime createAt;
    private String updatedBy;
    private String description;
}
