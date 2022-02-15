package com.abc.controller;
import com.abc.po.User;
import com.abc.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);// slf4j日志记录器

    @Autowired
    private UserService userService;

    @Autowired
    private DiscoveryClient client;

    @RequestMapping("/say")
    public String say(){
        logger.trace("slf4j trace");
        logger.debug("slf4j debug");
        logger.info("slf4j info");
        logger.warn("slf4j warn");
        logger.error("slf4j error");
        List<String> services = client.getServices();
        return "say";
    }

    @DeleteMapping("/delete")
    public int deleteByPrimaryKey(Integer id){
        return userService.deleteByPrimaryKey(id);
    }

    @PostMapping("/insert")
    public int insertSelective(User record){
        return userService.insertSelective(record);
    }

    @GetMapping("/get")
    public User selectByPrimaryKey(Integer id){
        return userService.selectByPrimaryKey(id);
    }

    @PutMapping("/update")
    public int updateByPrimaryKeySelective(User record){
        return userService.updateByPrimaryKeySelective(record);
    }
}
