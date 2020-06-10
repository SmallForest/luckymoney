package com.imooc.luckymoney.repository.service;

import com.imooc.luckymoney.controller.entity.Luckmoney;
import com.imooc.luckymoney.repository.LuckymoneyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class LuckymoneyService {

    @Autowired
    private LuckymoneyRepository repository;

    /**
     * mysql需要支持事务
     */
    @Transactional
    public void createTwo(){
        Luckmoney luckmoney1 = new Luckmoney();
        luckmoney1.setProducer("老王");//发送者
        luckmoney1.setMoney(new BigDecimal("520"));//发送金额
        repository.save(luckmoney1);

        Luckmoney luckmoney2 = new Luckmoney();
        luckmoney2.setProducer("老li");//发送者
        luckmoney2.setMoney(new BigDecimal("1314"));//发送金额
        repository.save(luckmoney2);
    }
}
