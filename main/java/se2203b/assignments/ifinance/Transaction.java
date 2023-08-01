package se2203b.assignments.ifinance;

import javafx.beans.property.*;

public class Transaction {

    private final StringProperty transactionDate;
    private final StringProperty comments;
    private final IntegerProperty ID;
    private TransactionLine lines;
    private NonAdminUser author;

    public Transaction(String transactionDate, String comments, int ID) {
        this.transactionDate = new SimpleStringProperty(transactionDate);
        this.comments = new SimpleStringProperty(comments);
        this.ID = new SimpleIntegerProperty(ID);
    }

    public String getTransactionDate() {
        return transactionDate.get();
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate.set(transactionDate);
    }

    public StringProperty transactionDateProperty() {
        return transactionDate;
    }

    public String getComments() {
        return comments.get();
    }

    public void setComments(String comments) {
        this.comments.set(comments);
    }

    public StringProperty commentsProperty() {
        return comments;
    }

    public int getID() {
        return ID.get();
    }

    public void setID(int ID) {
        this.ID.set(ID);
    }

    public IntegerProperty IDProperty() {
        return ID;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionDate=" + transactionDate +
                ", comments=" + comments +
                ", ID=" + ID +
                '}';
    }
}
