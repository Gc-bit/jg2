package cn.kgc.ssm.service;

import cn.kgc.ssm.bean.Provider;
import cn.kgc.ssm.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProviderService {
    /**
     * 根据供应商名称进行模糊查询
     * @param proCode
     * @param proName
     * @return
     */
    public List<Provider> getProviderByproCode(String proCode,String proName);
    /***
     * 增加用户
     * @param provider
     * @return
     */
    Integer addProvider(Provider provider);

    /**
     * 根据Id查具体对象
     * @param pid
     * @return
     */
    Provider getProviderById(Integer pid);

/*    Integer updateUserById(Provider provider);*/

    Integer updateProviderById(Provider provider);
}
