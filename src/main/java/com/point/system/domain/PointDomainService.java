package com.point.system.domain;

import com.point.system.domain.entity.Point;
import com.point.system.domain.entity.PointPolicy;
import org.springframework.stereotype.Service;

@Service
public class PointDomainService {

    public void validateAndInitiateIssuePoint(Point point, PointPolicy pointPolicy) {
        point.setStartDate(pointPolicy.getStartDate());
        point.initializeToIssuePoint();
    }
}
