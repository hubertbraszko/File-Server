package server.storage.commands;

import server.storage.Storage;

public abstract class Command {

    Storage storage;

    Command(Storage storage ) {
        this.storage = storage;
    }

    public abstract CommandResult execute();
}
