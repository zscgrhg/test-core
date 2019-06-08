package com.zte.crm.prm.supportapi.codegen;

@org.springframework.web.bind.annotation.RestController()
public class DelegateOfHelloContract {
    
    @org.springframework.web.bind.annotation.RequestMapping(value = {"/hello"})
    public java.lang.String hello() {
        return this.provider.hello();
    }
    @org.springframework.beans.factory.annotation.Autowired()
    com.zte.crm.prm.supportapi.HelloContractProvider provider;
}