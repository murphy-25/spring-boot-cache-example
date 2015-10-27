package com.example;

import java.util.HashMap;

public class DomainObject {

    private HashMap<String, String> entries;
    public HashMap<String, String> getEntries() {
        return entries;
    }
    public void setEntries(HashMap<String, String> entries) {
        this.entries = entries;
    }
}
