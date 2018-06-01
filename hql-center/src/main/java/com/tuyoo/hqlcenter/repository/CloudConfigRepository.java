package com.tuyoo.hqlcenter.repository;

import com.tuyoo.hqlcenter.entities.TuyooCloud;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CloudConfigRepository extends JpaRepository<TuyooCloud, Integer> {
}
