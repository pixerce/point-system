package com.point.system.application.port.output;

import com.point.system.data.entity.PointPolicyEntity;
import com.point.system.data.repository.PointPolicyJpaRepository;
import com.point.system.domain.entity.PointPolicy;
import com.point.system.domain.valueobject.PointPolicyAmountType;
import com.point.system.domain.valueobject.PointPolicyIssueMethod;
import com.point.system.domain.valueobject.PointPolicyPointType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
class PointPolicyRepositoryTest {

    @MockitoBean
    private PointPolicyJpaRepository pointPolicyJpaRepository;
    @Autowired
    private PointPolicyRepository pointPolicyRepository;

    @Test
    void shouldNotFindPointPolicyByNo() {

        Exception exception = assertThrows(RuntimeException.class, () -> {
            pointPolicyRepository.findPointPolicyByPolicyId(1L);
        });

        assertEquals("포인트 정책을 찾을 수 없음", exception.getMessage());
    }

    @Test
    void shouldReturnPointPolicyById() {

        PointPolicyEntity pointPolicyEntity = PointPolicyEntity.builder()
                .policyId(1L)
                .pointName("테스트 포인트")
                .pointType(PointPolicyPointType.FREE)
                .amount(3000L)
                .amountType(PointPolicyAmountType.FIXED)
                .issueMethod(PointPolicyIssueMethod.MANUAL)
                .lifeSpan(10)
                .startDate(LocalDateTime.now().plusDays(1))
                .build();

        when(this.pointPolicyJpaRepository.findById(anyLong())).thenReturn(Optional.of(pointPolicyEntity));
        PointPolicy pointPolicy = pointPolicyRepository.findPointPolicyByPolicyId(1L);
        assertThat(pointPolicy).isNotNull();
    }
}