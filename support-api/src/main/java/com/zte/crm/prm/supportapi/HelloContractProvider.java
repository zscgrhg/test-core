package com.zte.crm.prm.supportapi;

import com.zte.crm.prm.anno.RemoteServiceProvider;

@RemoteServiceProvider
public class HelloContractProvider implements HelloContract {
    @Override
    public String hello() {
        return null;
    }
}
