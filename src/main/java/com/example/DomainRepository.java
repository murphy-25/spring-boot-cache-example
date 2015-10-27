package com.example;

import java.util.HashMap;

public interface DomainRepository {

    HashMap<String, String> getEntriesFromBp(String id);
    void resetCache();
}
