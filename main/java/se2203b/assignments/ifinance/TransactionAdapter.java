package se2203b.assignments.ifinance;

import java.sql.*;

public class TransactionAdapter {

    private final Connection connection;

    public TransactionAdapter(Connection connection) {
        this.connection = connection;
    }

    public void createTransactionTable() throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS transactions (ID INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY, transactionDate VARCHAR(255), comments VARCHAR(255))");
        }
    }

    public void addTransaction(Transaction transaction) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO transactions (transactionDate, comments) VALUES (?, ?)")) {
            statement.setString(1, transaction.getTransactionDate());
            statement.setString(2, transaction.getComments());
            statement.executeUpdate();
        }
    }

    public Transaction findTransaction(int ID) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM transactions WHERE ID = ?")) {
            statement.setInt(1, ID);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String transactionDate = resultSet.getString("transactionDate");
                String comments = resultSet.getString("comments");
                int foundID = resultSet.getInt("ID");
                return new Transaction(transactionDate, comments, foundID);
            }

            return null;
        }
    }

    public void updateTransaction(Transaction transaction) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("UPDATE transactions SET transactionDate = ?, comments = ? WHERE ID = ?")) {
            statement.setString(1, transaction.getTransactionDate());
            statement.setString(2, transaction.getComments());
            statement.setInt(3, transaction.getID());
            statement.executeUpdate();
        }
    }

    public void deleteTransaction(int ID) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("DELETE FROM transactions WHERE ID = ?")) {
            statement.setInt(1, ID);
            statement.executeUpdate();
        }
    }
}
