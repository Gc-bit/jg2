package cn.kgc.ssm.service;

import cn.kgc.ssm.bean.User;
import org.apache.ibatis.annotations.Param;

public interface UserService {
    /**
     * 根据userCode查询用户
     * @param userCode
     * @return
     */
    public User getUserByUserCode(String userCode);
}
