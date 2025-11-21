package com.point.system.application;

import com.point.system.application.dto.issue.PointIssueCommand;
import com.point.system.application.mapper.PointDataMapper;
import com.point.system.application.port.output.PointPolicyRepository;
import com.point.system.application.port.output.PointRepository;
import com.point.system.domain.PointDomainService;
import com.point.system.domain.entity.Point;
import com.point.system.domain.entity.PointPolicy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PointIssueService {

    private final PointDomainService pointDomainService;
    private final PointDataMapper pointDataMapper;
    private final PointRepository pointRepository;
    private final PointPolicyRepository pointPolicyRepository;


    @Transactional
    public void issuePoint(PointIssueCommand issuePointCommand) {
        PointPolicy pointPolicy = checkPointPolicy(issuePointCommand);
        Point point = this.pointDataMapper.issuePointCommandToPoint(issuePointCommand);
        pointDomainService.validateAndInitiateIssuePoint(point, pointPolicy);
        this.pointRepository.save(point);
    }

    /**
     * 포인트 정책 여부를 체크하고 모델로 변경하여 리턴한다.
     * @param issuePointCommand
     */
    private PointPolicy checkPointPolicy(PointIssueCommand issuePointCommand) {
        return this.pointPolicyRepository.findPointPolicyByPolicyId(issuePointCommand.getPointPolicyNo());
    }
}
