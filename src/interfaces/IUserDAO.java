package interfaces;

import beans.User;

import java.util.List;


public interface IUserDAO {

    public User findByEmail(String email);
    public User findUserToLogin(String email, String password);
    public void addUser(User newUser);
    public void updateUser(User upUser);
    public void deleteUser(String delUser);
    public List<User> listAllUsers();




}
