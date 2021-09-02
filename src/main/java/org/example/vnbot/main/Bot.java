package org.example.vnbot.main;

import org.example.vnbot.menu.MessageMenu;
import org.example.vnbot.workingWithFiles.FileRead;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.FileNotFoundException;


public class Bot extends TelegramLongPollingBot {


    @Override
    public String getBotUsername() {
        return new FileRead().propertiesRead("bot.name", "init.properties");
    }

    @Override
    public String getBotToken() {
        return new FileRead().propertiesRead("bot.token", "init.properties");
    }

    @Override
    public void onUpdateReceived(Update update) {
        try {
            MessageMenu.menu(update);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }


}



