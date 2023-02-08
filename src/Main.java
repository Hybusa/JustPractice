import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;


public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        TasksElementary tasksElementary = new TasksElementary();

        Method[] methodsElementary = tasksElementary.getClass().getDeclaredMethods();
/*
        for(Method method : methodsElementary)
        {
            if(Modifier.isPublic(method.getModifiers()) && !method.isVarArgs()) {
                method.invoke(tasksElementary);
                System.out.println();
            }
        }*/

        TasksListsStrings tasksListsStrings = new TasksListsStrings();

        Method[] methodsListsStrings = tasksListsStrings.getClass().getDeclaredMethods();

        for(Method method : methodsListsStrings)
        {
            if(Modifier.isPublic(method.getModifiers()) && !method.isVarArgs()) {
                method.invoke(tasksListsStrings);
                System.out.println();
            }
        }

    }
}