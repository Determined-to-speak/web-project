package com.example.elasticsearchmain;

import com.example.elasticsearchmain.helloLucene.HelloLucene;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class TestHelloLucene {

    @Autowired
    HelloLucene helloLucene;

    @Test
    public void testHelloLucene() {
        helloLucene.index();
    }

    @Test
    public void testSearch() {
        helloLucene.seacher();
    }

    @Test
    public void testQuery() {
        helloLucene.query();
    }

    @Test
    public void testDelete() {
        helloLucene.delete();
    }

    @Test
    public void testforceMergeDeletes() {
        helloLucene.forceMergeDeletes();
    }

}
