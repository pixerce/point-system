package com.point.system.data.adapter;

import com.point.system.application.port.output.PointRepository;
import com.point.system.data.entity.UserPointEntity;
import com.point.system.data.mapper.PointPersistMapper;
import com.point.system.data.repository.UserPointJpaRepository;
import com.point.system.domain.entity.Point;
import org.springframework.stereotype.Component;

@Component
public class PointRepositoryImpl implements PointRepository {

    private final UserPointJpaRepository userPointJpaRepository;
    private final PointPersistMapper pointDataMapper;

    public PointRepositoryImpl(UserPointJpaRepository userPointJpaRepository, PointPersistMapper pointDataMapper) {
        this.userPointJpaRepository = userPointJpaRepository;
        this.pointDataMapper = pointDataMapper;
    }

    @Override
    public Point save(Point point) {
        UserPointEntity userPointEntity = this.pointDataMapper.pointToUserPointEntity(point);
        this.userPointJpaRepository.save(userPointEntity);
        return this.pointDataMapper.userPointEntityToPoint(userPointEntity);
    }
}
