package com.leonardo.tx.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leonardo.tx.entity.PaymentInfo;

public interface PaymentInfoRepository extends JpaRepository<PaymentInfo, String>{

}
