package se2203b.assignments.ifinance;

import javafx.beans.property.*;

public class MasterAccount {

    private final StringProperty accountName;
    private final DoubleProperty openingAmount;
    private final DoubleProperty closingAmount;
    private AccountGroup accountGroup;

    public MasterAccount(String accountName, double openingAmount, double closingAmount) {
        this.accountName = new SimpleStringProperty(accountName);
        this.openingAmount = new SimpleDoubleProperty(openingAmount);
        this.closingAmount = new SimpleDoubleProperty(closingAmount);
    }

    public String getAccountName() {
        return accountName.get();
    }

    public void setAccountName(String accountName) {
        this.accountName.set(accountName);
    }

    public StringProperty accountNameProperty() {
        return accountName;
    }

    public double getOpeningAmount() {
        return openingAmount.get();
    }

    public void setOpeningAmount(double openingAmount) {
        this.openingAmount.set(openingAmount);
    }

    public DoubleProperty openingAmountProperty() {
        return openingAmount;
    }

    public double getClosingAmount() {
        return closingAmount.get();
    }

    public void setClosingAmount(double closingAmount) {
        this.closingAmount.set(closingAmount);
    }

}
