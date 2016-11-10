package com.psmodel.user;

public final class Admin {
    /*
    This class creates just one instances of the Admin class is created 
    This class also provides a global access of that instance.
    Constructors are declared private.
    It also gives a static method that returns a reference of the instance.
    You can store this instances in a private variable.
    */
    private static final Admin INSTANCE = new Admin();
    private Admin() {}

    public static Admin getInstance() {
        return INSTANCE;
    }
}