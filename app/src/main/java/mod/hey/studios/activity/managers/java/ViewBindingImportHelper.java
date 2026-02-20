package mod.hey.studios.activity.managers.java;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

public class ViewBindingImportHelper {

    public static <B extends ViewBinding> B inflate(@NonNull ViewBindingFactory<B> factory, @NonNull View view) {
        return factory.create(view);
    }

    public interface ViewBindingFactory<B> {
        B create(View view);
    }

    public static boolean isViewBindingAvailable(Class<?> clazz) {
        // Check if the class is a ViewBinding subclass
        return ViewBinding.class.isAssignableFrom(clazz);
    }

    public static boolean processImportedClasses(String[] importedClasses) {
        for (String className : importedClasses) {
            try {
                Class<?> clazz = Class.forName(className);
                if (isViewBindingAvailable(clazz)) {
                    // Process the ViewBinding class (implementation here can be customized)
                    System.out.println("Processing ViewBinding class: " + className);
                }
            } catch (ClassNotFoundException e) {
                System.out.println("Class not found: " + className);
            }
        }
        return true;
    }
}
