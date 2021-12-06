package com.example.springweb.Service;

import com.example.springweb.entity.BillEntity;

import java.util.concurrent.atomic.AtomicLong;

public interface IBillService {
    public void save(BillEntity billEntity);
    AtomicLong getTimeInSurance(Long productId, Long billId, Long userID);
    Integer findBillId(Long userId,Long productId);
}
