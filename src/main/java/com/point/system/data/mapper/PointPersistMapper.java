package com.point.system.data.mapper;

import com.point.system.data.entity.UserPointEntity;
import com.point.system.domain.entity.Point;
import org.springframework.stereotype.Component;

@Component
public class PointPersistMapper {
    public UserPointEntity pointToUserPointEntity(Point point) {
        UserPointEntity userPointEntity = UserPointEntity.builder()
                .userNo(point.getUserNo())
                .pointPolicyNo(point.getPointPolicyNo())
                .amount(point.getAmount())
                .balance(point.getBalance())
                .startDate(point.getStartDate())
                .expirationDate(point.getExpirationDate())
                .build();

        return userPointEntity;
    }

    public Point userPointEntityToPoint(UserPointEntity userPointEntity) {
        return null;
    }

}
