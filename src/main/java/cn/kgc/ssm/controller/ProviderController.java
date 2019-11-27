package cn.kgc.ssm.controller;

import cn.kgc.ssm.bean.Provider;

import cn.kgc.ssm.service.ProviderService;
import com.alibaba.druid.sql.visitor.functions.Substring;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/provider")
public class ProviderController {

    @Resource
    private ProviderService providerService;
    //供应商列表---含分页
    @RequestMapping("/providerList")
    public String providerList(@RequestParam(value = "queryProCode",required = false) String queryProCode,
                               @RequestParam(value = "queryProName",required = false) String queryProName,
                               @RequestParam(value = "pageIndex",required = false) Integer pageIndex,
                               Model model){
        if (pageIndex == null){
            pageIndex = 1;
        }
        Page<Provider> pages = PageHelper.startPage(pageIndex,5);

        List<Provider> providerList = providerService.getProviderByproCode(queryProCode,queryProName);
        model.addAttribute("pages",pages);
        model.addAttribute("providerList",providerList);
        model.addAttribute("queryProCode",queryProCode);
        model.addAttribute("queryProName",queryProName);
        return "providerlist";
    }

    //跳转到供应商添加页面
    @RequestMapping("/provideradd")
    public String provideradd(){
        return "provideradd";

    }

    //添加
    @RequestMapping("/provideraddsave")
    public String provideraddsave(Provider provider,
                                  HttpSession session,
                                  HttpServletRequest request)
    {
     provider.setCreationDate(new Date());
    Integer id = providerService.addProvider(provider);
    if (id != null){
        return "redirect:/provider/providerlist";
    }
     request.setAttribute("error","插入失败");
    return  "provideradd";
    }

    //跳转到修改页面，并做数据回显
    @RequestMapping("/providermodify/{pid}")
    public  String providermodify(Model model, @PathVariable("pid") Integer pid){
      Provider provider = providerService.getProviderById(pid);
      model.addAttribute("provider",provider);
      return "providermodify";
    }
    //修改
    @RequestMapping("/providermodifysave")
    public String providermodifysave(Provider provider, HttpSession session,
                                     HttpServletRequest request){
        Provider p =(Provider)session.getAttribute("providerSession");
        provider.setModifyDate(new Date());
        Integer result = providerService.updateProviderById(provider);
        if (result != 0){
            return "redirect:/provider/providerlist";
        }
        request.setAttribute("error","修改失败");
        return "providermodify";
    }
        //查看
        @RequestMapping("/providerview/{id}")
        public String providerview(Model model,@PathVariable("id") Integer id){
            Provider provider = providerService.getProviderById(id);
            if (provider == null){
                //提示自己补全
            }
            model.addAttribute("provider",provider);
            return "providerview";
        }
}
