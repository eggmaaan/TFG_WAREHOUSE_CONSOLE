package service;

import beans.User;
import interfaces.IUserDAO;
import interfaces.IUserSERVICE;
import util.TransaccionManager;

import java.util.List;

public class UserSERVICE implements IUserSERVICE {
    @Override
    public User findByEmail(String email) {

        User aux = null;
        TransaccionManager tm= null;
        try{

            tm = new TransaccionManager();
            IUserDAO dao = tm.getUserDAO();
            aux = dao.findByEmail(email);
            tm.closeConnectionOK();

        }catch (Exception q){
            tm.closeConnectionFail();
        }

        return aux;

    }

    @Override
    public User findUserToLogin(String email, String password) {

        User user = null;
        TransaccionManager tm = null;

        try{
            tm = new TransaccionManager();
            IUserDAO dao = tm.getUserDAO();
            user = dao.findUserToLogin(email, password);
            tm.closeConnectionOK();

        }catch (Exception e){
            tm.closeConnectionFail();
        }

        return user;

    }

    @Override
    public void addUser(User newUser) {
        TransaccionManager tm= null;
        try{
            tm = new TransaccionManager();
            IUserDAO dao = tm.getUserDAO();
            dao.addUser(newUser);
            tm.closeConnectionOK();

        }catch (Exception q){
            tm.closeConnectionFail();
        }

    }

    @Override
    public void updateUser(User upUser) {
        TransaccionManager tm= null;
        try{
            tm = new TransaccionManager();
            IUserDAO dao = tm.getUserDAO();
            dao.updateUser(upUser);
            tm.closeConnectionOK();

        }catch (Exception q){
            tm.closeConnectionFail();
        }
    }

    @Override
    public void deleteUser(String delUser) {
        TransaccionManager tm= null;
        try{
            tm = new TransaccionManager();
            IUserDAO dao = tm.getUserDAO();
            dao.deleteUser(delUser);
            tm.closeConnectionOK();

        }catch (Exception q){
            tm.closeConnectionFail();
        }
    }

    @Override
    public List<User> listAllUsers() {

        List<User> users = null;
        TransaccionManager tm= null;
        try{
            tm = new TransaccionManager();
            IUserDAO dao = tm.getUserDAO();
            users = dao.listAllUsers();
            tm.closeConnectionOK();



        }catch (Exception q){
            tm.closeConnectionFail();
        }

        return users;

    }
}
