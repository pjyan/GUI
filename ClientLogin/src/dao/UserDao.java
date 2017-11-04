
/*
 登录和注册类接口
*/
package dao;

import pojo.User;

public interface UserDao {
    
    public abstract boolean logIn(String username,String password);
    public abstract void regist(User user);
    
    
}
