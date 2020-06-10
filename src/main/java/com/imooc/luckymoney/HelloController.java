package com.imooc.luckymoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 这是个例子代码
 * @Controller+@ResponseBody=@RestController
 */
@RestController
@RequestMapping("/hello")
public class HelloController {
    //获取并使用application.yml中自定义值
    @Autowired
    protected LimitConfig limitConfig;

// 适合http://localhost:8081/luckymoney/hello/say/333格式
//    @GetMapping("/say/{id}") //此处可以支持数组command+p查看参数
//    public String say(@PathVariable("id") Integer id) { //@PathVariable获取get参数
//        return "说明：" + limitConfig.getDescription()+",id:"+id;
//    }

    //适合http://localhost:8081/luckymoney/hello/say?id=234格式 明文ID
//    @GetMapping("/say") //此处可以支持数组command+p查看参数
//    public String say(@RequestParam(value = "id",required = false,defaultValue = "0") Integer myid) { //@RequestParam获取get参数明文id
//        return "说明：" + limitConfig.getDescription() + ",id:" + myid;
//    }

    @PostMapping("/say") //post body urlencode方式
    public String say(@RequestParam(value = "id",required = false,defaultValue = "0") Integer myid) { //@RequestParam获取get参数明文id
        return "说明：" + limitConfig.getDescription() + ",id:" + myid;
    }
}
