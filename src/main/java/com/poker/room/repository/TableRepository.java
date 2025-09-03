package com.poker.room.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poker.room.entity.Table;

@Repository
public interface TableRepository extends JpaRepository<Table,UUID>{


}
