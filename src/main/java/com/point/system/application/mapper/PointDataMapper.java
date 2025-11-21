package com.point.system.application.mapper;

import com.point.system.application.dto.issue.PointIssueCommand;
import com.point.system.domain.entity.Point;
import org.springframework.stereotype.Component;

@Component
public class PointDataMapper {

    public Point issuePointCommandToPoint(PointIssueCommand issuePointCommand) {
        Point point = Point.builder()
                .policyId(issuePointCommand.getPointPolicyNo())
                .amount(issuePointCommand.getAmount())
                .lifeSpan(issuePointCommand.getLifeSpan())
                .userId(issuePointCommand.getUserNo())
                .build();
        return point;
    }
}
