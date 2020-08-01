package dao;

import beans.User;
import interfaces.IUserDAO;
import org.hibernate.Session;

import javax.persistence.Query;
import java.sql.SQLException;
import java.util.List;

public class UserDAO implements IUserDAO {

    private Session session;

    public UserDAO(Session session){
        this.session = session;
    }

    @Override
    public User findByEmail(String email) {

        User userQuery = null;

        try{
            Query nativeQuery = (Query) session.createNativeQuery("SELECT id, name, email, password FROM users WHERE email = :email");
            nativeQuery.setParameter("email", email.trim());

            userQuery = new User();

            Object[] result = (Object[]) nativeQuery.getSingleResult();
            userQuery.setId((int)result[0]);
            userQuery.setName((String)result[1]);
            userQuery.setEmail((String)result[2]);
            userQuery.setPassword((String)result[3]);

        }catch (Exception e){
            e.printStackTrace();
        }

        return userQuery;

    }

    @Override
    public User findUserToLogin(String email, String password) {
        User userQuery = null;

        try{
            Query nativeQuery = (Query) session.createNativeQuery("SELECT id, name, email, password FROM users WHERE email = :email and password = :password");
            nativeQuery.setParameter("email", email.trim());
            nativeQuery.setParameter("password", password.trim());

            userQuery = new User();

            Object[] result = (Object[]) nativeQuery.getSingleResult();
            userQuery.setId((int)result[0]);
            userQuery.setName((String)result[1]);
            userQuery.setEmail((String)result[2]);
            userQuery.setPassword((String)result[3]);

        }catch (Exception e){
            e.printStackTrace();
        }

        return userQuery;
    }


    @Override
    public void addUser(User newUser) {

        session.save(newUser);
    }

    @Override
    public void updateUser(User upUser) {

        session.update(upUser);
    }

    @Override
    public void deleteUser(String delUser) {

        session.delete(delUser);
    }

    @Override
    public List<User> listAllUsers() {

        Query query = (Query)session.createNativeQuery("Select u.id, u.name, u.email, u.password from USERS u ", User.class);
        List<User> users = query.getResultList();

        return users;


    }
}
