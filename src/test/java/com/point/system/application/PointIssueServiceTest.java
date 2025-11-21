package com.point.system.application;

import com.point.system.application.dto.issue.PointIssueCommand;
import com.point.system.application.port.output.PointPolicyRepository;
import com.point.system.data.entity.UserPointEntity;
import com.point.system.data.repository.UserPointJpaRepository;
import com.point.system.domain.entity.PointPolicy;
import com.point.system.domain.valueobject.PointPolicyAmountType;
import com.point.system.domain.valueobject.PointPolicyIssueMethod;
import com.point.system.domain.valueobject.PointPolicyPointType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
class PointIssueServiceTest {

    @Autowired
    private PointIssueService pointIssueService;
    @Autowired
    private UserPointJpaRepository userPointJpaRepository;
    @MockitoBean
    public PointPolicyRepository pointPolicyRepository;

    @Test
    public void shouldIssuePoint() {

        PointPolicy pointPolicy
                = new PointPolicy(1L, 1000L, PointPolicyAmountType.FIXED
                , 1000L, 1000L
                , PointPolicyPointType.FREE
                , PointPolicyIssueMethod.MANUAL, LocalDateTime.now(), 10, null, null);
        when(this.pointPolicyRepository.findPointPolicyByPolicyId(anyLong())).thenReturn(pointPolicy);

        PointIssueCommand issuePointCommand
                = new PointIssueCommand(1L, pointPolicy.getPolicy_id(), pointPolicy.getAmount(), pointPolicy.getLifeSpan(), "포인트 지급 테스트");
        this.pointIssueService.issuePoint(issuePointCommand);

        List<UserPointEntity> userPointEntityList = this.userPointJpaRepository.findAll();
        assertThat(userPointEntityList).hasSize(1);

        UserPointEntity userPointEntity = userPointEntityList.getFirst();
        Assertions.assertEquals(issuePointCommand.getPointPolicyNo(), userPointEntity.getPolicyId());
        Assertions.assertEquals(issuePointCommand.getAmount(), userPointEntity.getAmount());
    }
}