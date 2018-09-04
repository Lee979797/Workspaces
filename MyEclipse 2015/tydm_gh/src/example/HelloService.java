package example;

import com.ninemax.jpa.system.model.User;

public class HelloService implements IHelloService{
    public String sayHello(String name){  
        return "Hello, "+name;  
    }  
    public User getUser(User user) {
        User userNew = new User();  
      /*  user.setId("new:"+user.getId());
        userNew.setName("new:"+user.getName());  */
        return userNew;  
    }  
}  