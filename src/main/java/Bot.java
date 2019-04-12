import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class Bot extends TelegramLongPollingBot {
    public void onUpdateReceived(Update update) {

    }

    public String getBotUsername() {
        return "UserOfDayBot";
    }

    public String getBotToken() {
        System.out.println(System.getenv("BOT_TOKEN"));
        return System.getenv("BOT_TOKEN");
    }
}
