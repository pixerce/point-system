package com.point.system.data.repository;

import com.point.system.data.entity.PointPolicyEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
class PointPolicyJpaRepositoryTest {

    @Autowired
    private PointPolicyJpaRepository pointPolicyJpaRepository;

    @Test
    public void shouldReadAnyPointPolicy() {
        List<PointPolicyEntity> results = this.pointPolicyJpaRepository.findAll();
        assertThat(results).isNotEmpty();
    }
}