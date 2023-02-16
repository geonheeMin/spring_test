package com.admin.board.repository;

import com.admin.board.domain.Board;
import com.admin.board.entity.CRUDEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Tuple;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface CRUDRepository extends JpaRepository<CRUDEntity, Board> {
    public Optional<CRUDEntity> findById(Long id);
    public CRUDEntity findByDate(String date);
}
