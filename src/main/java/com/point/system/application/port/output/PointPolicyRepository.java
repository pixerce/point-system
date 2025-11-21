package com.point.system.application.port.output;

import com.point.system.domain.entity.PointPolicy;

public interface PointPolicyRepository {
    PointPolicy findPointPolicyByNo(final Long policyNo);
}
