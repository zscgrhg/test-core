package com.zte.crm.prm.supportapi;

import lombok.Lombok;

import javax.tools.*;
import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JavacTask {
    public static void main(String[] args) {
        File file=new File(".");
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        File tempDir = getTempDir();
        tempDir.mkdirs();
        List<String> options = Arrays.asList("-proc:none", "-d", tempDir.getAbsolutePath());

        StringWriter captureWarnings = new StringWriter();
        final StringBuilder compilerErrors = new StringBuilder();
        DiagnosticListener<JavaFileObject> diagnostics = new DiagnosticListener<JavaFileObject>() {
            @Override
            public void report(Diagnostic<? extends JavaFileObject> diagnostic) {
                compilerErrors
                        .append(diagnostic.toString())
                        .append("\n");
            }
        };


        JavaCompiler.CompilationTask task = compiler.getTask(captureWarnings, //
                null, diagnostics, options, null, //
                Collections.singleton(new ContentBasedJavaFileObject(file.getPath(), readFileAsString(file))));
        Boolean taskResult = task.call();


    }

    private static File getTempDir() {
        String[] rawDirs = {
                System.getProperty("java.io.tmpdir"),
                "/tmp",
                "C:\\Windows\\Temp"
        };

        for (String dir : rawDirs) {
            if (dir == null) {
                continue;
            }
            File f = new File(dir);
            if (!f.isDirectory()) {
                continue;
            }
            return new File(f, "lombok.bytecode-test");
        }

        return new File("./build/tmp");
    }

    static class ContentBasedJavaFileObject extends SimpleJavaFileObject {
        private final String content;

        protected ContentBasedJavaFileObject(String name, String content) {
            super(new File(name).toURI(), Kind.SOURCE);
            this.content = content;
        }

        @Override
        public CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException {
            return content;
        }
    }

    private static String readFileAsString(File file) {
        try {
            FileInputStream in = new FileInputStream(file);
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
                StringWriter writer = new StringWriter();
                String line = reader.readLine();
                while (line != null) {
                    writer
                            .append(line)
                            .append("\n");
                    line = reader.readLine();
                }
                reader.close();
                writer.close();
                return writer.toString();
            } finally {
                in.close();
            }
        } catch (Exception e) {
            throw Lombok.sneakyThrow(e);
        }
    }
}
