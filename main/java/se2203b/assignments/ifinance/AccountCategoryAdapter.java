package se2203b.assignments.ifinance;

import java.sql.*;

public class AccountCategoryAdapter {

    private final Connection connection;

    public AccountCategoryAdapter(Connection connection) {
        this.connection = connection;
    }

    public void createAccountCategoryTable() throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS account_categories (type VARCHAR(255), categoryName VARCHAR(255), PRIMARY KEY (type, categoryName))");
        }
    }

    public void addAccountCategory(AccountCategory accountCategory) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO account_categories (type, categoryName) VALUES (?, ?)")) {
            statement.setString(1, accountCategory.getType());
            statement.setString(2, accountCategory.getCategoryName());
            statement.executeUpdate();
        }
    }

    public AccountCategory findAccountCategory(String type, String categoryName) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM account_categories WHERE type = ? AND categoryName = ?")) {
            statement.setString(1, type);
            statement.setString(2, categoryName);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new AccountCategory(type, categoryName);
            }

            return null;
        }
    }

    public void updateAccountCategory(AccountCategory accountCategory) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("UPDATE account_categories SET type = ?, categoryName = ? WHERE type = ? AND categoryName = ?")) {
            statement.setString(1, accountCategory.getType());
            statement.setString(2, accountCategory.getCategoryName());
            statement.setString(3, accountCategory.getType());
            statement.setString(4, accountCategory.getCategoryName());
            statement.executeUpdate();
        }
    }

    public void deleteAccountCategory(String type, String categoryName) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("DELETE FROM account_categories WHERE type = ? AND categoryName = ?")) {
            statement.setString(1, type);
            statement.setString(2, categoryName);
            statement.executeUpdate();
        }
    }
}
