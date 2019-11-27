package cn.kgc.ssm.mapper;

import cn.kgc.ssm.bean.Provider;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProviderMapper {
    /**
     * 根据供应商名称进行模糊查询
     * @param proCode
     * @param proName
     * @return
     */
    public List<Provider> getProviderByproCode(@Param("proCode") String proCode,
                                               @Param("proName") String proName);

    /***
     * 增加用户
     * @param provider
     * @return
     */
    Integer addProvider(Provider provider);


    Provider getProviderById(@Param("id") Integer id);

    Integer updateProviderById(Provider provider);
}
