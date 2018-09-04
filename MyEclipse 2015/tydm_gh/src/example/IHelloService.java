package example;

import com.ninemax.jpa.system.model.User;

public interface IHelloService {
    public String sayHello(String name);  
    public User getUser(User user);
}