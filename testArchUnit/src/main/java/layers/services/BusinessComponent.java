package layers.services;

import thirdpartydependencies.Component;

import java.lang.reflect.Method;

@Component
public class BusinessComponent {

    ThreadLocal threadLocal=new ThreadLocal();
    Method method=BusinessComponent.class.getMethods()[0];

}
