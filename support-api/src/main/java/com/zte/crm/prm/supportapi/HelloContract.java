package com.zte.crm.prm.supportapi;

import com.zte.crm.prm.anno.RemoteServiceContract;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "hello", url = "http://localhost:8881")
@RemoteServiceContract(name = "zte-crm-prm-common")
public interface HelloContract  {
    @RequestMapping("/hello")
    String hello();
}
