package com.jorry.task.design_03.proxy.dynamicproxy.tproxy;
import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class TProxy {

    private static final String str = "\r\n";

    // 该类主要生成代码
    public static Object newProxyInstance(TClassLoader classLoader, Class <?>[] interfaces, TInvocationHandler h) {
        try {

            // 1. 动态生成源代码 java 文件
            String src = generateSrc(interfaces);

            // 2. java文件输出到磁盘
            String filePath = TProxy.class.getResource("").getPath();
            File f = new File(filePath + "$Proxy0.java");
            FileWriter fw = new FileWriter(f);
            fw.write(src);
            fw.flush();
            fw.close();


//            package com.jorry.task.design_03.proxy.dynamicproxy.tproxy;
//            import com.jorry.task.design_03.proxy.Person;
//            import java.lang.reflect.Method;
//
//            public class $Proxy0 implements com.jorry.task.design_03.proxy.Person {
//                TInvocationHandler h;
//
//                public $Proxy0(TInvocationHandler h) {
//                    this.h = h;
//                }
//
//                public void findLove() {
//                    try {
//                        Method m = com.jorry.task.design_03.proxy.Person.class.getMethod("findLove", new Class[]{});
                          // 这里this.h 就是 TMeipo 代理类，从而调用 TMeipo 的 invoke 方法
//                        return this.h.invoke(this, m, new Object[]{});
//                    } catch (Throwable e) {
//                        e.printStackTrace();
//                    }
//                    return null;
//                }
//            }

            // 3. 把生成的 .java 文件编译成 .class文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manage = compiler.getStandardFileManager(null, null, null);
            Iterable iterable = manage.getJavaFileObjects(f);

            JavaCompiler.CompilationTask task = compiler.getTask(null, manage, null, null, null, iterable);
            task.call();
            manage.close();

            //4、编译生成的.class文件加载到JVM中来
            Class proxyClass = classLoader.findClass("$Proxy0");
            Constructor c = proxyClass.getConstructor(TInvocationHandler.class);
            f.delete();

            return c.newInstance(h);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String generateSrc(Class <?>[] interfaces) {
        // 用代码写代码
        StringBuffer sb = new StringBuffer();
        sb.append("package com.jorry.task.design_03.proxy.dynamicproxy.tproxy;" + str);
        sb.append("import com.jorry.task.design_03.proxy.Person;" + str);
        sb.append("import java.lang.reflect.Method;" + str);
        sb.append("public class $Proxy0 implements " + interfaces[0].getName() + "{" + str);
        sb.append("TInvocationHandler h;" + str);
        sb.append("public $Proxy0(TInvocationHandler h) {" + str);
        sb.append("this.h = h;" + str);
        sb.append("}" + str);

        // 这里值获取第一个接口类的所有方法
        for (Method m : interfaces[0].getMethods()) {

            // 获取方法类型
            Class <?>[] params = m.getParameterTypes();

            // 拿到方法参数
            StringBuffer paramNames = new StringBuffer();
            StringBuffer paramValues = new StringBuffer();
            StringBuffer paramClasses = new StringBuffer();

            for (int i = 0; i < params.length; i++) {
                Class clazz = params[i];
                String type = clazz.getName();
                String paramName = toLowerFirstCase(clazz.getSimpleName());
                paramNames.append(type + " " + paramName);
                paramValues.append(paramName);
                paramClasses.append(clazz.getName() + ".class");
                if (i > 0 && i < params.length - 1) {
                    paramNames.append(",");
                    paramClasses.append(",");
                    paramValues.append(",");
                }
            }

            sb.append("public " + m.getReturnType().getName() + " " + m.getName() + "(" + paramNames.toString() + ") {" + str);
            sb.append("try{" + str);

            sb.append("Method m = " + interfaces[0].getName() + ".class.getMethod(\"" + m.getName() + "\",new Class[]{" + paramClasses.toString() + "});" + str);
            sb.append((hasReturn(m.getReturnType()) ? "return " : "") + getCaseCode("this.h.invoke(this,m,new Object[]{" + paramValues + "})", m.getReturnType()) + ";" + str);

            sb.append("} catch (Throwable e) {" + str);
            sb.append("e.printStackTrace();" + str);
            sb.append("}" + str);
            sb.append(getReturnEmptyCode(m.getReturnType()));
            sb.append("}" + str);
        }
        sb.append("}");

        return sb.toString();
    }

    private static Map <Class, Class> mappings = new HashMap <Class, Class>();

    static {
        mappings.put(int.class, Integer.class);
    }

    private static String getReturnEmptyCode(Class <?> returnClass) {
        if (mappings.containsKey(returnClass)) {
            return "return 0;";
        } else if (returnClass == Void.class) {
            return "";
        } else {
            return "return null;";
        }
    }

    private static String getCaseCode(String code, Class <?> returnClass) {
        if (mappings.containsKey(returnClass)) {
            return "((" + mappings.get(returnClass).getName() + ")" + code + ")." + returnClass.getSimpleName() + "Value()";
        }
        return code;
    }

    private static boolean hasReturn(Class <?> clazz) {
        return clazz != Void.class;
    }

    private static String toLowerFirstCase(String src) {
        char[] chars = src.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }

}
