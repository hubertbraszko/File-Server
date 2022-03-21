package server.storage.commands;

import client.request.Request;
import server.storage.Storage;

public abstract class Command {

    protected Storage storage;

    protected Request context;

    Command(Storage storage ) {
        this.storage = storage;
    }

    public abstract CommandResult execute();

    public void setContext(Request context) {
        this.context = context;
    }
}
