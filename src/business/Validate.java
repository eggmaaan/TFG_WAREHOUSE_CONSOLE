package business;

import beans.User;
import interfaces.IUserSERVICE;
import service.UserSERVICE;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {

    public static boolean checkEmail(String email){

        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(email);
        return mather.find();

    }

    public static boolean checkName(String name){

        Pattern pattern = Pattern.compile("[a-zA-Z]");
        Matcher mather = pattern.matcher((name));
        return mather.find();

    }

    public static boolean checkNameLength(String name){

        if(name.length() > 2){
            return true;
        }else{
            return false;
        }

    }


    public static boolean checkPass(String password){

        if(password.length() < 8){
            return false;
        }else{
            return true;
        }

    }

    public static User findUserToLogin(String email, String password){

        User user = null;

        try {

            IUserSERVICE userSERVICE = new UserSERVICE();
            user = userSERVICE.findUserToLogin(email, password);

        }catch(Exception e){
            e.printStackTrace();
        }

        return user;
    }

    public static boolean findUserEmail(String email){

        IUserSERVICE userSERVICE = new UserSERVICE();

        User userAux = userSERVICE.findByEmail(email);
        if(userAux == null){
            return false;
        }else{
            return true;
        }

    }


}
