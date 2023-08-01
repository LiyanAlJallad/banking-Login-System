package se2203b.assignments.ifinance;

import java.sql.*;

public class AccountGroupAdapter {

    private final Connection connection;

    public AccountGroupAdapter(Connection connection) {
        this.connection = connection;
    }

    public void createAccountGroupTable() throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS account_groups (groupID INT PRIMARY KEY, groupName VARCHAR(255))");
        }
    }

    public void addAccountGroup(AccountGroup accountGroup) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO account_groups (groupID, groupName) VALUES (?, ?)")) {
            statement.setInt(1, accountGroup.getGroupID());
            statement.setString(2, accountGroup.getGroupName());
            statement.executeUpdate();
        }
    }

    public AccountGroup findAccountGroup(int groupID) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM account_groups WHERE groupID = ?")) {
            statement.setInt(1, groupID);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String groupName = resultSet.getString("groupName");
                return new AccountGroup(groupID, groupName);
            }

            return null;
        }
    }

    public void updateAccountGroup(AccountGroup accountGroup) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("UPDATE account_groups SET groupName = ? WHERE groupID = ?")) {
            statement.setString(1, accountGroup.getGroupName());
            statement.setInt(2, accountGroup.getGroupID());
            statement.executeUpdate();
        }
    }

    public void deleteAccountGroup(int groupID) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("DELETE FROM account_groups WHERE groupID = ?")) {
            statement.setInt(1, groupID);
            statement.executeUpdate();
        }
    }
}
