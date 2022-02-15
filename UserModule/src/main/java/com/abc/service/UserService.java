package com.abc.service;

import com.abc.dao.UserMapper;
import com.abc.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
    @Autowired
    UserMapper mapper;

    @Autowired
    private RestTemplate restTemplate;


    public User select(Integer id){
        User user = mapper.selectByPrimaryKey(id);
        String url="http://userservice/user/"+user.getId();
        User userObject = restTemplate.getForObject(url, User.class);
        return userObject;
    }

    public int deleteByPrimaryKey(Integer id){
        return mapper.deleteByPrimaryKey(id);
    }

    public int insertSelective(User record){
        return mapper.insertSelective(record);
    }

    public User selectByPrimaryKey(Integer id){
        return mapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(User record){
        return mapper.updateByPrimaryKeySelective(record);
    }
}
