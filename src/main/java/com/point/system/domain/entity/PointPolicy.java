package com.point.system.domain.entity;

import com.point.system.domain.valueobject.PointPolicyAmountType;
import com.point.system.domain.valueobject.PointPolicyIssueMethod;
import com.point.system.domain.valueobject.PointPolicyPointType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class PointPolicy {
    private final Long pointPolicyNo;
    private final Long amount;
    private final PointPolicyAmountType amountType;
    private final PointPolicyPointType pointType;
    private final PointPolicyIssueMethod issueMethod;
    private final LocalDateTime startDate;
    private final Integer lifeSpan;

    private final List<PointTypeLimit> pointTypeLimitList;
    private final List<PointDepartment> pointDepartmentList;

}
