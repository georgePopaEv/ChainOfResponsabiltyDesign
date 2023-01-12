package Chalange;

public class IssueRaiser {
    public ReceiverInterface setFirstReceiver;

    public IssueRaiser(ReceiverInterface setFirstReceiver) {
        this.setFirstReceiver = setFirstReceiver;
    }

    public void raiseMessage(Message msg){
        if(setFirstReceiver != null){
            setFirstReceiver.processMessage(msg);
        }
    }
}
