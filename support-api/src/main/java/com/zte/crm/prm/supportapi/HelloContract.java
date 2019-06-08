package com.zte.crm.prm.supportapi;

import com.zte.crm.prm.anno.RemoteServiceContract;
import org.springframework.web.bind.annotation.RequestMapping;


@RemoteServiceContract(name = "zte-crm-prm-common",

        url = "http://localhost:8881"
)
public interface HelloContract {
    @RequestMapping("/hello")
    String hello();
}
