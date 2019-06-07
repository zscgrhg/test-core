package com.zte.crm.prm.supportapi.codegen;

@org.springframework.web.bind.annotation.RestController()
@org.springframework.cloud.openfeign.FeignClient(name = "hello", url = "http://localhost:8881")
public class DelegateOfHelloContract {
    
    @org.springframework.web.bind.annotation.RequestMapping(value = {"/hello"})
    public java.lang.String hello() {
        return this.producer.hello();
    }
    @org.springframework.beans.factory.annotation.Autowired()
    com.zte.crm.prm.supportapi.HelloContract producer;
}