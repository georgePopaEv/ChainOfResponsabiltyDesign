package Chalange;

public interface ReceiverInterface {
    boolean processMessage(Message msg);
    void setNextChain(ReceiverInterface nextChain);
}

class FaxErrorHandler implements ReceiverInterface{

    private ReceiverInterface nextReceiver;
    @Override
    public void setNextChain(ReceiverInterface nextChain) {
        this.nextReceiver = nextChain;
    }

    @Override
    public boolean processMessage(Message msg) {
        if(msg.text.contains("Fax")){
            System.out.println("FaxErrorHandler processed " + msg.priority + " priority");
            return true;
        }
        else {
            if(nextReceiver != null)
                nextReceiver.processMessage(msg);

        }
        return false;
    }


}

class EmailErrorHandler implements ReceiverInterface{

    private ReceiverInterface nextReceiver;

    @Override
    public boolean processMessage(Message msg) {
        if(msg.text.contains("Email")){
            System.out.println("EmailErrorHandler processed " + msg.priority + " priority issue: " + msg.text);
            return true;
        }
        else {
            if(nextReceiver != null)
                nextReceiver.processMessage(msg);

        }
        return false;
    }

    @Override
    public void setNextChain(ReceiverInterface nextChain) {
        this.nextReceiver = nextChain;
    }
}

