package com.map.COVID19.dao;

import com.map.COVID19.model.Point;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointDao extends JpaRepository<Point, Long> {
}
