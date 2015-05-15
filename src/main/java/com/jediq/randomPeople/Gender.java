package com.jediq.randomPeople;

/**
 *
 */
public enum Gender {
    
    MALE, FEMALE;

    @Override
    public String toString() {
        return name().substring(0, 1);
    }
}
