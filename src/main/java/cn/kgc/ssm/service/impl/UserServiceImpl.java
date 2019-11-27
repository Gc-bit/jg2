package cn.kgc.ssm.service.impl;

import cn.kgc.ssm.bean.User;
import cn.kgc.ssm.mapper.UserMapper;
import cn.kgc.ssm.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;
    public User getUserByUserCode(String userCode) {
        return userMapper.getUserByUserCode(userCode);
    }
}
