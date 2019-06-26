package com.zte.crm.prm.supportapi;

import com.zte.crm.prm.model.Job;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.util.TraceClassVisitor;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStream resourceAsStream = Job.class
                .getClassLoader()
                .getResourceAsStream("com/zte/crm/prm/model/Job.class");


        ClassReader cr=new ClassReader(resourceAsStream);

        ClassNode cn = new ClassNode();

        cr.accept(new TraceClassVisitor(new PrintWriter(System.out)), 0);
        System.out.println(cn);
    }
}
