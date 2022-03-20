package client.ui;

public abstract class Action {

    private final int id;
    private final String description;

    protected Action(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public abstract void perform();

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
