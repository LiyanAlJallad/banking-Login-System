package se2203b.assignments.ifinance;

import javafx.beans.property.*;

public class AccountGroup {

    private final IntegerProperty groupID;
    private final StringProperty groupName;
    private AccountCategory element;

    public AccountGroup(int groupID, String groupName) {
        this.groupID = new SimpleIntegerProperty(groupID);
        this.groupName = new SimpleStringProperty(groupName);
    }

    public int getGroupID() {
        return groupID.get();
    }

    public void setGroupID(int groupID) {
        this.groupID.set(groupID);
    }

    public IntegerProperty groupIDProperty() {
        return groupID;
    }

    public String getGroupName() {
        return groupName.get();
    }

    public void setGroupName(String groupName) {
        this.groupName.set(groupName);
    }

    public StringProperty groupNameProperty() {
        return groupName;
    }
}
