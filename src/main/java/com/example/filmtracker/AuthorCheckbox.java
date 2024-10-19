package com.example.filmtracker;

import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class AuthorCheckbox extends CheckBox {
    public AuthorCheckbox(String val) {
        super(val);
    }
    private TextField authorField;

    void toggleAuthorUnknown() {
        if (isSelected()) {
            authorField.setText("AUK");
            authorField.setEditable(false);
        } else {
            authorField.setText("");
            authorField.setEditable(true);
        }
    }

    public void setAuthorField(TextField t) {
        this.authorField = t;
    }
}
