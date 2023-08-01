package se2203b.assignments.ifinance;

import javafx.beans.property.*;

//Use this
public class NonAdminUser extends IFINANCEUser {
    private StringProperty userAddress;
    private StringProperty userEmail;


    public NonAdminUser(String userAddress, String userEmail) {
        this.userAddress = new SimpleStringProperty(userAddress);
        this.userEmail = new SimpleStringProperty(userEmail);
    }

    public String getUserAddress() {
        return userAddress.get();
    }

    public void setUserAddress(String userAddress) {
        this.userAddress.set(userAddress);
    }

    public StringProperty userAddressProperty() {
        return userAddress;
    }

    public String getUserEmail() {
        return userEmail.get();
    }

    public void setUserEmail(String userEmail) {
        this.userEmail.set(userEmail);
    }

    public StringProperty userEmailProperty() {
        return userEmail;
    }
}

