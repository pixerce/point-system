package com.point.system.domain.entity;

import com.point.system.domain.valueobject.PointUsageChannel;
import com.point.system.domain.valueobject.PointPolicyAmountType;
import com.point.system.domain.valueobject.PointPolicyIssueMethod;
import com.point.system.domain.valueobject.PointPolicyPointType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
@Builder
@Setter
public class PointPolicy {
    private final Long pointPolicyNo;
    private final Long amount;
    private final PointPolicyAmountType amountType;
    private final PointPolicyPointType pointType;
    private final PointPolicyIssueMethod issueMethod;
    private final LocalDateTime startDate;
    private final Integer lifeSpan;

    private Long amountLimit;
    private PointUsageChannel pointUsageChannel;

    public Boolean hasAmountLimit() {
        return amountLimit != null;
    }
}
