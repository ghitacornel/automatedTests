package layers.services;

import thirdpartydependencies.Service;

import java.lang.reflect.Method;

@Service
public class BusinessService {

    // should be prohibited
    private ThreadLocal threadLocal=new ThreadLocal();
    private Method method=BusinessComponent.class.getMethods()[0];

}
