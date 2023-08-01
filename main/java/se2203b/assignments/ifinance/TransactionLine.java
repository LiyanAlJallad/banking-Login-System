package se2203b.assignments.ifinance;

import javafx.beans.property.*;

public class TransactionLine {
    private final IntegerProperty accountNumber;
    private final StringProperty userFullName;
    private final DoubleProperty debitAmount;
    private final DoubleProperty creditAmount;
    private final StringProperty comments;
    private final IntegerProperty ID;
    private MasterAccount firstMasterAccount;
    private MasterAccount secondMasterAccount;

    public TransactionLine(int accountNumber, String userFullName, double debitAmount, double creditAmount, String comments, int ID) {
        this.accountNumber = new SimpleIntegerProperty(accountNumber);
        this.userFullName = new SimpleStringProperty(userFullName);
        this.debitAmount = new SimpleDoubleProperty(debitAmount);
        this.creditAmount = new SimpleDoubleProperty(creditAmount);
        this.comments = new SimpleStringProperty(comments);
        this.ID = new SimpleIntegerProperty(ID);
    }

    public int getAccountNumber() {
        return accountNumber.get();
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber.set(accountNumber);
    }

    public IntegerProperty accountNumberProperty() {
        return accountNumber;
    }

    public String getUserFullName() {
        return userFullName.get();
    }

    public void setUserFullName(String userFullName) {
        this.userFullName.set(userFullName);
    }

    public StringProperty userFullNameProperty() {
        return userFullName;
    }

    public double getDebitAmount() {
        return debitAmount.get();
    }

    public void setDebitAmount(double debitAmount) {
        this.debitAmount.set(debitAmount);
    }

    public DoubleProperty debitAmountProperty() {
        return debitAmount;
    }

    public double getCreditAmount() {
        return creditAmount.get();
    }

    public void setCreditAmount(double creditAmount) {
        this.creditAmount.set(creditAmount);
    }

    public DoubleProperty creditAmountProperty() {
        return creditAmount;
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
}

