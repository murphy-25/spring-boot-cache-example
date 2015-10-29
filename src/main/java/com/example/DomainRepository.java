package com.example;

public interface DomainRepository {

    String getEntriesFromBp(String id);
    void resetCache();
}
