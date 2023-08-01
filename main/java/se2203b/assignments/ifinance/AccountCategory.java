package se2203b.assignments.ifinance;

import javafx.beans.property.*;

public class AccountCategory {

    private final StringProperty type;
    private final StringProperty categoryName;

    public AccountCategory(String type, String categoryName) {
        this.type = new SimpleStringProperty(type);
        this.categoryName = new SimpleStringProperty(categoryName);
    }

    public String getType() {
        return type.get();
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public StringProperty typeProperty() {
        return type;
    }

    public String getCategoryName() {
        return categoryName.get();
    }

    public void setCategoryName(String categoryName) {
        this.categoryName.set(categoryName);
    }

    public StringProperty categoryNameProperty() {
        return categoryName;
    }
}
