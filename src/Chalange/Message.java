package Chalange;

//Through this example we want to treat an example of fixxing error from witing a message
//Let me explain more detailed in next step will be

enum MessagePriority{
    Normal,
    High
}

public class Message {
    public String text;
    public MessagePriority priority;

    public Message(String text, MessagePriority priority)   {
        this.text = text;
        this.priority = priority;
    }
}
