package com.point.system.domain.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class PointPolicy {
    private final Long pointPolicyNo;
    private final Long amount;
    private final String amountType;
    private final String pointType;
    private final String issueMethod;
    private final LocalDateTime startDate;
    private final Integer lifeSpan;

    private final List<PointTypeLimit> pointTypeLimitList;
    private final List<PointDepartment> pointDepartmentList;

}
