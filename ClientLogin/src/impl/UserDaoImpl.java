/*
实现登录和注册类接口
 */

package impl;

import dao.UserDao;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojo.User;


public class UserDaoImpl implements UserDao{
private static File file = new File("User.txt");
 
//类加载时检查文件是否存在，若不存在则创建文件
 static{
    try {
        file.createNewFile();
    } catch (IOException ex) {

    }
  }
    
   //登陆
   @Override
    public boolean logIn(String username, String password) {
        boolean flag = false;
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader(file));
            String line = null;
            while((line=br.readLine())!=null){
                String[] data = line.split("=");
                if(data[0].equals(username)&&data[1].equals(password)){
                    flag=true;
                    break;
                }
            }
        }catch(IOException ex){
                   ex.printStackTrace();
                    }finally{
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
       return flag;
    }
    

    //注册
    @Override
    public void regist(User user) {
         BufferedWriter bw = null;
    try {        
        
        bw =new BufferedWriter(new FileWriter(file,true));
        bw.write(user.getUsername()+"="+user.getPassword());
        bw.newLine();
        bw.flush();
        
    } catch (IOException ex) {
             ex.printStackTrace(); 
    }finally{
             try {
                 bw.close();
             } catch (IOException ex) {
                     ex.printStackTrace(); 
             }
    }
        
        
        
    }
    
    
    
    
    
}
