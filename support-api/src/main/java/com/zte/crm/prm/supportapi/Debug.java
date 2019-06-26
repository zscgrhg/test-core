package com.zte.crm.prm.supportapi;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.File;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Debug {
     public static void main(String[] args) throws MalformedURLException, ClassNotFoundException {
         System.out.println("fuck22");
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

        System.setProperty("javac.opt.printRounds","true");
         int rc = javac.run(null, null, null,
                "-verbose",
                "-XprintProcessorInfo",
                "-XprintRounds",
                "-classpath", classpath,

                "-d","C:\\github\\test-core\\support-api\\out",
               // "-parameters",
                 "C:\\github\\test-core\\support-api\\src\\main\\debug\\com\\zte\\crm\\prm\\supportapi\\User.java",
                 "C:\\github\\test-core\\support-api\\src\\main\\debug\\com\\zte\\crm\\prm\\supportapi\\Mix1.java",
                "C:\\github\\test-core\\support-api\\src\\main\\debug\\com\\zte\\crm\\prm\\supportapi\\Detail.java");
         URL url = new File("C:\\github\\test-core\\support-api\\out")
                 .toURI()
                 .toURL();
         URLClassLoader classLoader=new URLClassLoader(new URL[]{url},Thread.currentThread().getContextClassLoader());
         Class<?> aClass = classLoader.loadClass("com.zte.crm.prm.supportapi.User");
         assert aClass!=null;
         Field[] declaredFields = aClass.getDeclaredFields();
         Optional<Field> oak = Stream
                 .of(declaredFields)
                 .filter(f -> f
                         .getName()
                         .equals("oak"))
                 .findFirst();
         assert oak.isPresent();
     }
}
