package se2203b.assignments.ifinance;

import java.sql.*;

public class MasterAccountAdapter {

    private final Connection connection;

    public MasterAccountAdapter(Connection connection) {
        this.connection = connection;
    }

    public void createMasterAccountTable() throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS master_accounts (accountName VARCHAR(255) PRIMARY KEY, openingAmount DOUBLE, closingAmount DOUBLE)");
        }
    }

    public void addMasterAccount(MasterAccount masterAccount) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO master_accounts (accountName, openingAmount, closingAmount) VALUES (?, ?, ?)")) {
            statement.setString(1, masterAccount.getAccountName());
            statement.setDouble(2, masterAccount.getOpeningAmount());
            statement.setDouble(3, masterAccount.getClosingAmount());
            statement.executeUpdate();
        }
    }

    public MasterAccount findMasterAccount(String accountName) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM master_accounts WHERE accountName = ?")) {
            statement.setString(1, accountName);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                double openingAmount = resultSet.getDouble("openingAmount");
                double closingAmount = resultSet.getDouble("closingAmount");
                return new MasterAccount(accountName, openingAmount, closingAmount);
            }

            return null;
        }
    }

    public void updateMasterAccount(MasterAccount masterAccount) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("UPDATE master_accounts SET openingAmount = ?, closingAmount = ? WHERE accountName = ?")) {
            statement.setDouble(1, masterAccount.getOpeningAmount());
            statement.setDouble(2, masterAccount.getClosingAmount());
            statement.setString(3, masterAccount.getAccountName());
            statement.executeUpdate();
        }
    }

    public void deleteMasterAccount(String accountName) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("DELETE FROM master_accounts WHERE accountName = ?")) {
            statement.setString(1, accountName);
            statement.executeUpdate();
        }
    }
}
