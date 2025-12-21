public class PushNotification implements NotificationSender{
    @Override
    public void send(String message) {
        System.out.println("Push notification: "+message);
    }
}
