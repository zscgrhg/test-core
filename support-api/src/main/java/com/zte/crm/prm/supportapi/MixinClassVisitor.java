package com.zte.crm.prm.supportapi;

import org.objectweb.asm.Attribute;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;

public class MixinClassVisitor extends ClassVisitor {
    public MixinClassVisitor(int api) {
        super(api);
    }

    public MixinClassVisitor(int api, ClassVisitor classVisitor) {
        super(api, classVisitor);
    }


    @Override
    public void visitAttribute(Attribute attribute) {
        super.visitAttribute(attribute);
        System.out.println(attribute);
    }

    @Override
    public void visitSource(String source, String debug) {
        super.visitSource(source, debug);
        System.out.println(source);
    }

    @Override
    public FieldVisitor visitField(int access, String name, String descriptor, String signature, Object value) {

        FieldVisitor fieldVisitor = super.visitField(access, name, descriptor, signature, value);
        System.out.println(value);
        return fieldVisitor;
    }

    @Override
    public void visitEnd() {
        super.visitEnd();
        System.out.println();
    }
}
