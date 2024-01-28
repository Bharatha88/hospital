package com.hospital.repository;

import com.hospital.dao.ReviewEntity;
import org.springframework.data.repository.CrudRepository;


public interface ReviewRepository
        extends CrudRepository<ReviewEntity,Long> {

    Iterable<ReviewEntity> findAllByReviewNumber(String reviewNumber);

 }
