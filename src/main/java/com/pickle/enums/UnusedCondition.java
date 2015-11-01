package com.pickle.enums;

/**
 * Created by Yanuar Wicaksana on 11/1/15.
 */
public enum UnusedCondition {
    GOOD, BAD, NEW, UNSPECIFIED;

    @Override
    public String toString() {
        switch (this){
            case GOOD: return "Good";
            case BAD: return "Bad";
            case NEW: return "New";
            default: return "Unspecified";
        }
    }
}