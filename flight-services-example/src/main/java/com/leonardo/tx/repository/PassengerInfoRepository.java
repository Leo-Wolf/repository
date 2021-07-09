package com.leonardo.tx.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leonardo.tx.entity.PassengerInfo;

public interface PassengerInfoRepository extends JpaRepository<PassengerInfo, Long> {

}
