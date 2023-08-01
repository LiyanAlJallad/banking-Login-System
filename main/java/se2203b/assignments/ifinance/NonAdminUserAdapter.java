package se2203b.assignments.ifinance;

import java.sql.*;

public class NonAdminUserAdapter {
    private final Connection connection;

    public NonAdminUserAdapter(String dbUrl) throws SQLException {
        connection = DriverManager.getConnection(dbUrl);
        createTableIfNotExists();
    }

    private void createTableIfNotExists() throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS nonadmin_users (userAddress VARCHAR(100), userEmail VARCHAR(100), PRIMARY KEY(userEmail))");
        }
    }

    public void addNonAdminUser(NonAdminUser nonAdminUser) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO nonadmin_users (userAddress, userEmail) VALUES (?, ?)")) {
            statement.setString(1, nonAdminUser.getUserAddress());
            statement.setString(2, nonAdminUser.getUserEmail());
            statement.executeUpdate();
        }
    }

    public NonAdminUser findNonAdminUser(String userEmail) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM nonadmin_users WHERE userEmail = ?")) {
            statement.setString(1, userEmail);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new NonAdminUser(resultSet.getString("userAddress"), resultSet.getString("userEmail"));
                } else {
                    return null;
                }
            }
        }
    }

    public void updateNonAdminUser(NonAdminUser nonAdminUser) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("UPDATE nonadmin_users SET userAddress = ? WHERE userEmail = ?")) {
            statement.setString(1, nonAdminUser.getUserAddress());
            statement.setString(2, nonAdminUser.getUserEmail());
            statement.executeUpdate();
        }
    }

    public void deleteNonAdminUser(String userEmail) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("DELETE FROM nonadmin_users WHERE userEmail = ?")) {
            statement.setString(1, userEmail);
            statement.executeUpdate();
        }
    }
}
