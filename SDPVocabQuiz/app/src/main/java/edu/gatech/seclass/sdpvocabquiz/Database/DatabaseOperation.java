package edu.gatech.seclass.sdpvocabquiz.Database;

// A class which adds a return value to Runnable interface
public abstract class DatabaseOperation<T> implements Runnable{
    public volatile T value;
}
