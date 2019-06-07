package com.zte.crm.prm.supportapi;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.File;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Debug {
     public static void main(String[] args) {

        JavaCompiler javac = ToolProvider.getSystemJavaCompiler();
        File dir=new File("C:\\github\\test-core\\support-api\\out");
        if(!dir.exists()){
            dir.mkdirs();
        }
         File[] jarFiles = new File("C:\\github\\test-core\\support-api\\lib").listFiles();
         String classpath = Stream.of(jarFiles)
                 .map(File::getAbsolutePath)
                 .collect(Collectors.joining(";"));
         System.out.println("classpath="+classpath);
         int rc = javac.run(null, null, null,

                "-classpath", classpath,
                "-d","C:\\github\\test-core\\support-api\\out",
               // "-parameters",
                "C:\\github\\test-core\\support-api\\src\\main\\java\\com\\zte\\crm\\prm\\supportapi\\HelloContract.java",
                 "C:\\github\\test-core\\support-api\\src\\main\\java\\com\\zte\\crm\\prm\\supportapi\\HelloContractProvider.java");
    }
}
