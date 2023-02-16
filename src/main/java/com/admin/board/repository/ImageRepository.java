package com.admin.board.repository;

import com.admin.board.entity.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<ImageEntity, String> {
    public ImageEntity findById(int id);
}
