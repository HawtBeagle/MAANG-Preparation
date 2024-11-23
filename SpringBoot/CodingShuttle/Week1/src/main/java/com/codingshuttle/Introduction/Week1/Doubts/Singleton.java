package com.codingshuttle.Introduction.Week1.Doubts;

public class Singleton {
    private static Singleton instance;

    public static Singleton createInstance(){
        if(instance != null) return instance;
        else{
            instance = new Singleton();
        }
        return instance;
    }
}
