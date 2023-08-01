package se2203b.assignments.ifinance;

import javafx.beans.property.*;

import javafx.beans.property.*;

//USE THIS
public class Administrator extends IFINANCEUser {
    private final StringProperty creationDate;

    public Administrator(String creationDate) {
        this.creationDate = new SimpleStringProperty(creationDate);
    }

    public String getCreationDate() {
        return creationDate.get();
    }

    public void setCreationDate(String creationDate) {
        this.creationDate.set(creationDate);
    }

    public StringProperty creationDateProperty() {
        return creationDate;
    }
}
