package com.point.system.domain.entity;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class Point {

    private final Long userId;
    private final Long policyId;
    private final Long amount;
    private final Integer lifeSpan;
    private final String comment;
    private LocalDateTime startDate;
    private LocalDateTime expirationDate;
    private Long balance;

    public void validatePoint() {

    }

    public void initializeToIssuePoint() {
        this.expirationDate = startDate.plusDays(lifeSpan);
        this.balance = this.amount;
    }
}
