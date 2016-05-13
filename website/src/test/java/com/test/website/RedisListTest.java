package com.test.website;

import com.test.mysql.entity.Department;
import com.test.mysql.redis.DepartmentRedis;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RedisConfig.class, DepartmentRedis.class})
public class RedisListTest {
    private static Logger logger = LoggerFactory.getLogger(RedisListTest.class);

    @Autowired
    DepartmentRedis deparmentRedis;

    @Before
    public void setup(){
        Department deparment = new Department();
        deparment.setName("开发部");

        List<Department> deparments = new ArrayList<>();
        deparments.add(deparment);


        deparmentRedis.delete(this.getClass().getName()+":deparmentAll:");
        deparmentRedis.add(this.getClass().getName()+":deparmentAll:", 10L, deparments);

    }

    @Test
    public void get(){
        List<Department> deparments = deparmentRedis.getList(this.getClass().getName() + ":deparmentAll:");
        Assert.notNull(deparments);
        for(Department deparment : deparments) {
            logger.info("======deparment====== name:{}",
                    deparment.getName());
        }
    }
}
