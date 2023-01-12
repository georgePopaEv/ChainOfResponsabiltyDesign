package Chalange;

public class Client {
    public static void main(String[] args) {
        System.out.println("<<< Chalange of Chain of Responsability >>>");

        ReceiverInterface faxHandler = new FaxErrorHandler();
        ReceiverInterface emailHandler = new EmailErrorHandler();

        faxHandler.setNextChain(emailHandler);

        IssueRaiser issueRaiser = new IssueRaiser(faxHandler);
        Message m1 = new Message("Fax is reaching late to the destination", MessagePriority.Normal);
        Message m2 = new Message("Email is not going", MessagePriority.High);
        Message m3 = new Message("In Email, BCC field is disabled occasionally", MessagePriority.Normal);
        Message m4 = new Message("Fax is not reaching to the destination", MessagePriority.High);

        issueRaiser.raiseMessage(m1);
        issueRaiser.raiseMessage(m2);
        issueRaiser.raiseMessage(m3);
        issueRaiser.raiseMessage(m4);

    }
}
