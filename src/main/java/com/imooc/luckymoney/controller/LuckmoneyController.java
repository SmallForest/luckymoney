package com.imooc.luckymoney.controller;

import com.imooc.luckymoney.entity.Luckmoney;
import com.imooc.luckymoney.repository.LuckymoneyRepository;
import com.imooc.luckymoney.service.LuckymoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
public class LuckmoneyController {
    @Autowired
    private LuckymoneyRepository repository;//数据库操作

    @Autowired
    private LuckymoneyService service;//事务

    /**
     * 获取红包列表
     */
    @GetMapping("/luckymoneys")
    public List<Luckmoney> list() {
        return repository.findAll();
    }

    /**
     * 创建红包
     */
    @PostMapping("/luckymoneys")
    public Luckmoney create(
            @RequestParam("producer") String producer,
            @RequestParam("money") BigDecimal money
    ) {
        Luckmoney luckmoney = new Luckmoney();
        luckmoney.setProducer(producer);
        luckmoney.setMoney(money);
        return repository.save(luckmoney);
    }

    /**
     * 通过ID查询红包
     */
    @GetMapping("/luckymoneys/{id}")
    public Luckmoney findByid(@PathVariable("id") Integer id) {
        return repository.findById(id).orElse(null);
    }

    /**
     * 更新红包(领取红包)
     */
    @PutMapping("/luckymoneys/{id}")
    public Luckmoney update(
            @PathVariable("id") Integer id,
            @RequestParam("consumer") String consumer
    ) {
        //先查询后更新
        Optional<Luckmoney> optional = repository.findById(id);
        if (optional.isPresent()) {
            Luckmoney luckmoney = optional.get();// 获取luckMoney对象
            luckmoney.setConsumer(consumer);
            return repository.save(luckmoney);
        }
        return null;
    }

    //创建多个红包
    @PostMapping("/luckymoneys/two")
    public void createTwo() {
        service.createTwo();
    }

}
