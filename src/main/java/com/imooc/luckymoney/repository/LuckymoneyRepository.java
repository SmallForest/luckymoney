package com.imooc.luckymoney.repository;

import com.imooc.luckymoney.entity.Luckmoney;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LuckymoneyRepository extends JpaRepository<Luckmoney,Integer> {
}
