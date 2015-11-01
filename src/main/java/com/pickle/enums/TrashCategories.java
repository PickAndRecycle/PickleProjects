package com.pickle.enums;

/**
 * Created by Yanuar Wicaksana on 11/1/15.
 */

public enum TrashCategories {
    UNUSED, GENERAL, RECYCLED, GREEN, UNSPECIFIED;

    @Override
    public String toString() {

        switch (this) {

            case UNUSED:
                return "Unused Goods";
            case GENERAL:
                return "General Waste";
            case RECYCLED:
                return "Recycleable Waste";
            case GREEN:
                return "Green Waste";
            default:
                return "Unspecified";

        }
    }
}