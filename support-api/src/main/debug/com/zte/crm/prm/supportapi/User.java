package com.zte.crm.prm.supportapi;

import com.zte.crm.prm.anno.Mixin;
import com.zte.crm.prm.model.Job;
import lombok.Data;

@Data
@Mixin(Detail.class)
public class User {
    String username;
    int f1;
}
