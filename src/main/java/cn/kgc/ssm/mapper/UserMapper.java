package cn.kgc.ssm.mapper;

import cn.kgc.ssm.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    /**
     * 根据userCode查询用户
     * @param userCode
     * @return
     */
    public User getUserByUserCode(@Param("userCode") String userCode);


}
