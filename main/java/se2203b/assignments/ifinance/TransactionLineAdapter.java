package se2203b.assignments.ifinance;

import java.sql.*;

public class TransactionLineAdapter {
    private final Connection connection;

    public TransactionLineAdapter(String dbUrl) throws SQLException {
        connection = DriverManager.getConnection(dbUrl);
        createTable();
    }

    private void createTable() throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS transaction_lines (ID INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY, accountNumber INT, userFullName VARCHAR(100), debitAmount DOUBLE, creditAmount DOUBLE, comments VARCHAR(100))");
        }
    }

    public void addTransactionLine(TransactionLine transactionLine) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO transaction_lines (accountNumber, userFullName, debitAmount, creditAmount, comments) VALUES (?, ?, ?, ?, ?)")) {
            statement.setInt(1, transactionLine.getAccountNumber());
            statement.setString(2, transactionLine.getUserFullName());
            statement.setDouble(3, transactionLine.getDebitAmount());
            statement.setDouble(4, transactionLine.getCreditAmount());
            statement.setString(5, transactionLine.getComments());
            statement.executeUpdate();
        }
    }

    public TransactionLine findTransactionLine(int ID) throws SQLException {

        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM transaction_lines WHERE ID = ?")) {
            statement.setInt(1, ID);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int accountNumber = resultSet.getInt("accountNumber");
                String userFullName = resultSet.getString("userFullName");
                double debitAmount = resultSet.getDouble("debitAmount");
                double creditAmount = resultSet.getDouble("creditAmount");
                String comments = resultSet.getString("comments");
                int foundID = resultSet.getInt("ID");
                return new TransactionLine(accountNumber, userFullName, debitAmount, creditAmount, comments, foundID);
            }

            return null;
        }
    }

    public void updateTransactionLine(TransactionLine transactionLine) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("UPDATE transaction_lines SET accountNumber = ?, userFullName = ?, debitAmount = ?, creditAmount = ?, comments = ? WHERE ID = ?")) {
            statement.setInt(1, transactionLine.getAccountNumber());
            statement.setString(2, transactionLine.getUserFullName());
            statement.setDouble(3, transactionLine.getDebitAmount());
            statement.setDouble(4, transactionLine.getCreditAmount());
            statement.setString(5, transactionLine.getComments());
            statement.setInt(6, transactionLine.getID());
            statement.executeUpdate();
        }
    }

    public void deleteTransactionLine(int ID) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("DELETE FROM transaction_lines WHERE ID = ?")) {
            statement.setInt(1, ID);
            statement.executeUpdate();
        }
    }
}
