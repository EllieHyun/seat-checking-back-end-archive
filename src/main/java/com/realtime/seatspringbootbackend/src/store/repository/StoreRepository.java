package com.realtime.seatspringbootbackend.src.store.repository;

import com.realtime.seatspringbootbackend.src.store.domain.StoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<StoreEntity, Long> {}
