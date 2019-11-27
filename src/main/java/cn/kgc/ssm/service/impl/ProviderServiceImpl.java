package cn.kgc.ssm.service.impl;

import cn.kgc.ssm.bean.Provider;
import cn.kgc.ssm.mapper.ProviderMapper;
import cn.kgc.ssm.service.ProviderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class ProviderServiceImpl implements ProviderService {

    @Resource
    private ProviderMapper providerMapper;

    public List<Provider> getProviderByproCode(String proCode, String proName) {
        return providerMapper.getProviderByproCode(proCode,proName);
    }

    public Integer addProvider(Provider provider) {
        return providerMapper.addProvider(provider);
    }

    public Provider getProviderById(Integer pid) {
        return providerMapper.getProviderById(pid);
    }

    public Integer updateProviderById(Provider provider) {
        return providerMapper.updateProviderById(provider);
    }

  
}
