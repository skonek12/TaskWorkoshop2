package pl.coderslab.entity;

import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;


public class UserDao {

    public User user;
    private static final String CREATE_USER_QUERY =
            "INSERT INTO users(user_email, user_name, password) VALUES (?, ?, ?)";

    private static final String UPDATE_All_USER_DATA =
            "UPDATE users SET user_email = ?, user_name = ? ,password = ? WHERE id = ?";

    private static final String GET_ALL_USER_DATA =
            "SELECT * FROM users WHERE id = ?";


    // arguments: id
    private static final String DELETE_QUERY =
            "DELETE FROM users where id = ?";


    public static User create(User user) {

        try (Connection conn = DbUtil.connect()) {

            PreparedStatement statement = conn.prepareStatement(CREATE_USER_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getUserName());
            statement.setString(3, hashPassword(user.getPassword()));
            statement.executeUpdate();

            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                user.setId(resultSet.getInt(1));
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static User read(int userId) {
        User user1 = new User();
        try (Connection conn = DbUtil.connect()) {
            PreparedStatement statement = conn.prepareStatement(GET_ALL_USER_DATA);
            statement.setString(1, String.valueOf(userId));
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user1.setId(resultSet.getInt(1));
                user1.setEmail(resultSet.getString(2));
                user1.setUserName(resultSet.getString(3));
                user1.setPassword(resultSet.getString(4));
            }
            return user1;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void update(User user) {

        try (Connection conn = DbUtil.connect()) {
            PreparedStatement statement = conn.prepareStatement(UPDATE_All_USER_DATA);
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getUserName());
            statement.setString(3, hashPassword(user.getPassword()));
            statement.setString(4, String.valueOf(user.getId()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }

    }


    private static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
}
