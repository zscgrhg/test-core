package com.zte.crm.prm.helloprovider;

import com.zte.crm.prm.anno.RemoteServiceProvider;
import com.zte.crm.prm.supportapi.HelloContract;

@RemoteServiceProvider
public class HelloImpl implements HelloContract {
    @Override
    public String hello() {
        return "hello";
    }
}
