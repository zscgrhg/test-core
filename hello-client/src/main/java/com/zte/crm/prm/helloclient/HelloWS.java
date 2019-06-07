package com.zte.crm.prm.helloclient;

import com.zte.crm.prm.supportapi.HelloContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWS {

    @Autowired
    HelloContract helloContract;
    @RequestMapping("/hellohello")
    public String hellohello(){
        return helloContract.hello();
    }
}
