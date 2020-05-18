package com.hnu.scw.utils;

import java.util.ArrayList;
import java.util.List;

public class Button {
    private List<AbstractButton> button =new ArrayList<>();

    public Button(List<AbstractButton> button) {
        this.button = button;
    }

    public Button() {

    }

    public List<AbstractButton> getButton() {
        return button;
    }

    public void setButton(List<AbstractButton> button) {
        this.button = button;
    }
}
