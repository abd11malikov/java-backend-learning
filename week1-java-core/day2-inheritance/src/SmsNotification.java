public class SmsNotification implements NotificationSender{
    @Override
    public void send(String message) {
        System.out.println("\uD83D\uDCF1 SMS sent: "+message);
    }
}
