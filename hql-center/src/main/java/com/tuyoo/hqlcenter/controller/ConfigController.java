package com.tuyoo.hqlcenter.controller;

import com.tuyoo.hqlcenter.entities.MyAuthConfig;
import com.tuyoo.hqlcenter.entities.TuyooCloud;
import com.tuyoo.hqlcenter.repository.CloudConfigRepository;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/config")
public class ConfigController {

    Map<String, List<MyAuthConfig>> users = new HashMap<String, List<MyAuthConfig>>();
    {
        MyAuthConfig home = new MyAuthConfig(1, "home", "/home");
        MyAuthConfig demo = new MyAuthConfig(2, "hello", "/home/hello");
        List<MyAuthConfig> guestUser = new ArrayList<>();
        List<MyAuthConfig> adminUser = new ArrayList<>();
        guestUser.add(home);
        adminUser.add(home);
        adminUser.add(demo);
        users.put("admin", adminUser);
        users.put("guest", guestUser);
    }

    @Autowired
    CloudConfigRepository cloudConfigRepository;

//    @ApiOperation(value = "获取cloudid列表", notes = "读取当前配置的所有cloud")
    @RequestMapping(value = "/clouds", method = RequestMethod.GET)
    public List<TuyooCloud> clouds(){
        return cloudConfigRepository.findAll();
    }

    @ApiOperation(value = "创建Cloud", notes = "根据Cloud对象保存实例")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cloudId", value = "CLOUDID", required = true, dataType = "int"),
            @ApiImplicitParam(name = "name", value = "CLOUD名称", required = true, dataType = "string"),
            @ApiImplicitParam(name = "ext", value = "CLOUD标识", required = true, dataType = "string"),
            @ApiImplicitParam(name = "desc", value = "CLOUD描述", required = true, dataType = "string")
    })
    @RequestMapping(value = "/cloud", method = RequestMethod.POST)
    public Integer addCloud(TuyooCloud tuyooCloud){
        TuyooCloud save = cloudConfigRepository.save(tuyooCloud);
        return save.getId();
    }

    @RequestMapping(value = "/auth/user/{user}")
    public List<MyAuthConfig> getAuth(@PathVariable("user") String username) {
        if ("admin".equals(username)) {
            return users.get("admin");
        } else {
            return users.get("guest");
        }
    }
}
