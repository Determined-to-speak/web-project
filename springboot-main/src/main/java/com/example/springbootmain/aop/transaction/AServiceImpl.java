package com.example.springbootmain.aop.transaction;


import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AServiceImpl implements AService {


    @Override
    @Transactional
    public void a() {
        // this.b();
        // 避免事务未生效
        ((AService) AopContext.currentProxy()).b();
    }

    @Override
    @Transactional
    public void b() {

    }

}
