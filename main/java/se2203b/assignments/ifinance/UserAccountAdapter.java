package se2203b.assignments.ifinance;

import java.sql.*;

public class UserAccountAdapter {

    private Connection connection;
    private UserAccount userAccount;

    public UserAccountAdapter(Connection connection, boolean b) throws SQLException {
        this.connection = connection;
        if (b) {
            Statement stmt = connection.createStatement();
            try {
                stmt.execute("DROP TABLE IF EXISTS user_accounts");
//                stmt.execute("DROP TABLE Teams");
            } catch (SQLException ex) {
            } finally {
                stmt.execute("CREATE TABLE user_accounts ("
                        + "userName VARCHAR(50) NOT NULL PRIMARY KEY, "
                        + "password VARCHAR(50) NOT NULL, "
                        + "accType VARCHAR(50) NOT NULL)");
//                addUserAccount(userAccount);
//                stmt.execute("CREATE TABLE Teams ("
//                        + "TeamName CHAR(15) NOT NULL PRIMARY KEY, "
//                        + "Wins INT, Losses INT, Ties INT)");
                populateSampls();
            }
        }
    }

    private void populateSampls() throws SQLException {
        UserAccount userAcc = new UserAccount("admin", "admin", "Admin");
        this.addUserAccount(userAcc);
        // Add some teams
//        this.insertTeam("Astros");
//        this.insertTeam("Marlins");
//        this.insertTeam("Brewers");
//        this.insertTeam("Cubs");
    }

    public int insertRecord(UserAccount data) throws SQLException {
        Statement stmt = connection.createStatement();
        int rows = stmt.executeUpdate("INSERT INTO UserAccount ( uName,  encryptedPassword,  passwordExpiryTime, passwordExpiryDate, accountType) "
                + "VALUES ('"
                + data.getUserName() + "', '"
                + data.getPassword() + "', '"
                + data.getAccType() + "' )"
        );
        return rows;
    }

    public void createUserAccountTable() throws SQLException {
        try (Statement statement = connection.createStatement()) {
        }
    }

    public void addUserAccount(UserAccount userAccount) throws SQLException {
        if (connection == null) {
            throw new SQLException("Connection is null.");
        }

        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO user_accounts (userName, password, accType) VALUES (?, ?, ?)")) {
            statement.setString(1, userAccount.getUserName());
            statement.setString(2, userAccount.getPassword());
            statement.setString(3, userAccount.getAccType());
            statement.executeUpdate();
        }
    }

    public UserAccount findUserAccount(String userName) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM user_accounts WHERE userName = ?")) {
            statement.setString(1, userName);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new UserAccount(
                        resultSet.getString("userName"),
                        resultSet.getString("password"),
                        resultSet.getString("accType")
                );
            }

            return null;
        }
    }

    public void updateUserAccount(UserAccount userAccount) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("UPDATE user_accounts SET password = ?, accType = ? WHERE userName = ?")) {
            statement.setString(1, userAccount.getPassword());
            statement.setString(2, userAccount.getAccType());
            statement.setString(3, userAccount.getUserName());
            statement.executeUpdate();
        }
    }

    public void deleteUserAccount(String userName) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("DELETE FROM user_accounts WHERE userName = ?")) {
            statement.setString(1, userName);
            statement.executeUpdate();
        }
    }
}
