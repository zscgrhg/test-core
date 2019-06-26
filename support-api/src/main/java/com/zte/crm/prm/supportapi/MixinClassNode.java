package com.zte.crm.prm.supportapi;

import org.objectweb.asm.ClassVisitor;

public class MixinClassNode extends ClassVisitor {
    public MixinClassNode(int api) {
        super(api);
    }

    public MixinClassNode(int api, ClassVisitor classVisitor) {
        super(api, classVisitor);
    }


}
