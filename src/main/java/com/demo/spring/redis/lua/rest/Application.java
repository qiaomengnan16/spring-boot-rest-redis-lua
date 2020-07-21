package com.demo.spring.redis.lua.rest;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.ScriptOutputType;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }


//    public static void main(String[] args) {
//        RedisURI redisUri = RedisURI.builder()                    // <1> 创建单机连接的连接信息
//                .withHost("10.0.0.155")
//                .withPort(6379)
//                .withDatabase(0)
//                .withTimeout(Duration.of(10, ChronoUnit.SECONDS))
//                .build();
//        RedisClient redisClient = RedisClient.create(redisUri);   // <2> 创建客户端
//        StatefulRedisConnection<String, String> connection = redisClient.connect();     // <3> 创建线程安全的连接
//        RedisCommands<String, String> redisCommands = connection.sync();                // <4> 创建同步命令
//
//        // 循环一百次，可以验证是否保留了最大长度
//        for (int i = 1; i <= 100; i++) {
//            // key
//            String[] keys = new String[]{"imKey"};
//            // value 、 最大长度 、时间戳
//            String[] values = new String[]{"imValue" + i , "20",new Date().getTime() + ""};
//            String result = redisCommands.eval("local key = KEYS[1]\n" +
//                    "local value = ARGV[1]\n" +
//                    "local maxLen = tonumber(ARGV[2])\n" +
//                    "local score = tonumber(ARGV[3])\n" +
//                    "redis.call(\"ZADD\", key , score , value)\n" +
//                    "local result = redis.call(\"ZCARD\", key)\n" +
//                    "if(result > maxLen)\n" +
//                    "then\n" +
//                    "\tredis.call(\"ZREMRANGEBYRANK\", key , 0 , result - maxLen)\n" +
//                    "end", ScriptOutputType.VALUE, keys, values);
//            System.out.println(result);
//        }
//
//        connection.close();   // <5> 关闭连接
//        redisClient.shutdown();  // <6> 关闭客户端
//    }



}
