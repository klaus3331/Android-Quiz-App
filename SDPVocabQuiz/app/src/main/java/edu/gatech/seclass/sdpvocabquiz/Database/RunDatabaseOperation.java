package edu.gatech.seclass.sdpvocabquiz.Database;

// A class which runs DatabaseOperation in a new Thread (T is return type of the DB operation)
public class RunDatabaseOperation<T> {
    private DatabaseOperation<T> databaseOperation;

    public RunDatabaseOperation(DatabaseOperation databaseOperation){
        this.databaseOperation = databaseOperation;
    }

    public T execute(){
        Thread newThread = new Thread(databaseOperation);
        newThread.start();
        try {
            newThread.join();
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
        return databaseOperation.value;
    }
}
