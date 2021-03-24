package com.example.daggertraining

import dagger.Binds
import dagger.Component
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import java.lang.annotation.ElementType

@Module(subcomponents={ MyActivitySubComponent.class })
public abstract class ApplicationBinders {
    // Provide the builder to be included in a mapping used for creating the builders.
    @Binds @IntoMap @SubcomponentKey(MyActivitySubComponent.Builder.class)
            SubcomponentBuilder myActivity(MyActivitySubComponent.Builder impl)
}

@Component(modules={..., ApplicationBinders.class})
public interface ApplicationComponent {
    // Returns a map with all the builders mapped by their class.
    Map<Class<?>, Provider<SubcomponentBuilder>> subcomponentBuilders();
}

// Needed only to create the above mapping
@MapKey
@Target({ ElementType.METHOD}) @Retention(AnnotationRetention.RUNTIME)
public @interface SubcomponentKey {
    Class<?> value();
}