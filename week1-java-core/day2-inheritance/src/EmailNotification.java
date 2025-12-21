
public class EmailNotification implements NotificationSender {
    @Override
    public void send(String message){
        System.out.println("\uD83D\uDCE7 EMAIL sent: "+message);
    }
}
