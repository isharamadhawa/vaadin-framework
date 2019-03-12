package com.gmail.ishara.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gmail.ishara.backend.data.entity.HistoryItem;

public interface HistoryItemRepository extends JpaRepository<HistoryItem, Long> {
}
