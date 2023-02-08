import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;


public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        Tasks tasks = new Tasks();

        Method[] methods = tasks.getClass().getDeclaredMethods();

        for(Method method : methods)
        {
            if(Modifier.isPublic(method.getModifiers()) && !method.isVarArgs()) {
                method.invoke(tasks);
                System.out.println();
            }
        }
    }
}