package com.test.mysql.redis;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.test.mysql.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Repository
public class RoleRedis {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    public void add(String key, Long time, List<Role> roles) {
        Gson gson = new Gson();
        redisTemplate.opsForValue().set(key, gson.toJson(roles), time, TimeUnit.MINUTES);
    }


    public List<Role> getList(String key) {
        Gson gson = new Gson();
        List<Role> ts = null;
        String listJson = redisTemplate.opsForValue().get(key);
        if(!StringUtils.isEmpty(listJson))
            ts = gson.fromJson(listJson, new TypeToken<List<Role>>(){}.getType());
        return ts;
    }

    public void delete(String key){
        redisTemplate.opsForValue().getOperations().delete(key);
    }
}
