package com.zte.crm.prm.supportapi;

import com.zte.crm.prm.anno.RemoteServiceContract;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "zte-crm-prm-common",
        url = "http://localhost:8881",
        contextId = "feignclient#25a8dd6bd775732aae7efe76e1300b83")
@RemoteServiceContract
@RequestMapping("/fc/fc/fc")
public interface HelloContract {



    @RequestMapping("/hello")
    String hello();
}
