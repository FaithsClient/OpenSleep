package linxiu.api.events.misc;

import linxiu.api.Event;

public class EventTitle extends Event {
    private final String message;

    public EventTitle(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
