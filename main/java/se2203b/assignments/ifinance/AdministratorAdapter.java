package se2203b.assignments.ifinance;

import java.sql.*;

public class AdministratorAdapter {
    private final Connection connection;

    public AdministratorAdapter(String dbUrl) throws SQLException {
        connection = DriverManager.getConnection(dbUrl);
        createTable();
        //should create 2 data bases, 1 for acc and 1 for pass
        // 2 tables (user acc), (admin acc//admins info)
        //add admin account to both databases
    }

    private void createTable() throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS administrators (creationDate VARCHAR(50) PRIMARY KEY)");
        }
    }

    public void addAdministrator(Administrator administrator) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO administrators (creationDate) VALUES (?)")) {
            statement.setString(1, administrator.getCreationDate());
            statement.executeUpdate();
        }
    }

    public Administrator findAdministrator(String creationDate) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM administrators WHERE creationDate = ?")) {
            statement.setString(1, creationDate);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Administrator(resultSet.getString("creationDate"));
                } else {
                    return null;
                }
            }
        }
    }

    public void updateAdministrator(Administrator administrator) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("UPDATE administrators SET creationDate = ? WHERE creationDate = ?")) {
            statement.setString(1, administrator.getCreationDate());
            statement.setString(2, administrator.getCreationDate());
            statement.executeUpdate();
        }
    }

    public void deleteAdministrator(String creationDate) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("DELETE FROM administrators WHERE creationDate = ?")) {
            statement.setString(1, creationDate);
            statement.executeUpdate();
        }
    }
}
