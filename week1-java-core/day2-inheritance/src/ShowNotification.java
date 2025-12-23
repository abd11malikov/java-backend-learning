public class ShowNotification {
    public static void main(String[] args) {
        EmailNotification email = new EmailNotification();
        email.send("Welcome to Java Backend!");

        NotificationSender notifier = new SmsNotification();
        notifier.send("Your OTP is 1234");

        notifier = new EmailNotification();
        notifier.send("This is now an email!");

        NotificationSender push = new PushNotification();
        push.send("You have a new friend request!");
    }
}