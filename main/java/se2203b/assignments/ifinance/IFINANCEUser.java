package se2203b.assignments.ifinance;

//Use this
public class IFINANCEUser {
    private boolean accessControl;
    private int userID;
    private String fullName;
    private UserAccount userAccount;

    public IFINANCEUser(boolean accessControl, int userID, String fullName) {
        this.accessControl = accessControl;
        this.userID = userID;
        this.fullName = fullName;
    }

    public IFINANCEUser() {
    }

    public boolean hasAccessControl() {
        return accessControl;
    }

    public void setAccessControl(boolean accessControl) {
        this.accessControl = accessControl;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}

