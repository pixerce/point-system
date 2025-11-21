package com.point.system.application.port.output;

import com.point.system.domain.entity.Point;


public interface PointRepository {

    Point save(Point point);

}
