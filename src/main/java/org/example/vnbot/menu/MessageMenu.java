package org.example.vnbot.menu;

import org.example.vnbot.keyboard.SecondaryKeyboard;
import org.example.vnbot.main.Bot;
import org.example.vnbot.message.MessageInit;
import org.example.vnbot.rest.Geo;
import org.example.vnbot.rest.Joke;
import org.example.vnbot.rest.Weather;
import org.example.vnbot.workingWithFiles.FileRead;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.FileNotFoundException;
import java.util.List;


public class MessageMenu {

    private static final Bot bot = new Bot();

    public static void menu(Update update) throws TelegramApiException, FileNotFoundException {
        if (update.hasMessage() && update.getMessage().hasText())
            mainMenu(update.getMessage());

        if (update.hasMessage() && update.getMessage().hasLocation())
            locationMenu(update.getMessage());

        if (update.hasCallbackQuery())
            secondaryMenu(update);

    }

    public static void mainMenu(Message message) throws TelegramApiException, FileNotFoundException {
        bot.execute(MessageInit.myAcc(message));
        if (message != null && message.hasText())
            switch (message.getText()) {
                case "/start":
                    SendMessage start = MessageInit.sendMsg(message.getChatId().toString(), new FileRead().txtRead("botInfo/botInfo"));
                    start.setReplyMarkup(SecondaryKeyboard.infoBot());
                    bot.execute(start);
                    break;

                case "О себе \uD83D\uDC82\uD83C\uDFFB\u200D♀️":
                    SendPhoto aboutMe = MessageInit.sendPhoto(message.getChatId().toString(), new FileRead().txtRead("aboutMe/aboutMe"), "main.jpeg");
                    aboutMe.setReplyMarkup(SecondaryKeyboard.aboutMe());
                    bot.execute(aboutMe);
                    break;

                case "Опыт работы \uD83D\uDECC":
                    SendMessage workExp = MessageInit.sendMsg(message.getChatId().toString(),
                            new FileRead().txtRead("workExp/workExp"));
                    workExp.setReplyMarkup(SecondaryKeyboard.workExp());
                    bot.execute(workExp);
                    break;
                case "Возможности \uD83C\uDF81":
                    SendMessage possibilities = MessageInit.sendMsg(message.getChatId().toString(), new FileRead().txtRead("possibilities"));
                    possibilities.setReplyMarkup(SecondaryKeyboard.possibilities());
                    bot.execute(possibilities);
                    break;
                case "Ссылки \uD83D\uDEAA":
                    bot.execute(MessageInit.sendMsg(message.getChatId().toString(), new FileRead().txtRead("link")));
                    break;
                case "Контакты \uD83D\uDCF2":
                    bot.execute(MessageInit.sendMsg(message.getChatId().toString(), new FileRead().txtRead("contacts")));
                    break;
                case "Шутка":
                    SendMessage humor = MessageInit.sendMsg(message.getChatId().toString(), Joke.jokeMain());
                    humor.setReplyMarkup(SecondaryKeyboard.possibilities());
                    bot.execute(humor);
                    break;
                default:
                    bot.execute(MessageInit.sendMsg(message.getChatId().toString(), "Даже не знаю как с этим работать, передам создателю, он разберется\uD83D\uDE04"));
                    break;
            }
    }

    public static void secondaryMenu(Update update) throws TelegramApiException, FileNotFoundException {
        switch (update.getCallbackQuery().getData()) {
            case "whoHelped":
                SendMessage whoHelped = MessageInit.sendMsg(update.getCallbackQuery().getMessage().getChatId().toString(),
                        new FileRead().txtRead("botInfo/whoHelped"));
                whoHelped.setReplyMarkup(SecondaryKeyboard.returnBack("/start"));
                bot.execute(whoHelped);
                break;
            case "technologiesButton":
                SendMessage technologiesButton = MessageInit.sendMsg(update.getCallbackQuery().getMessage().getChatId().toString(),
                        new FileRead().txtRead("botInfo/technologiesButton"));
                technologiesButton.setReplyMarkup(SecondaryKeyboard.returnBack("/start"));
                bot.execute(technologiesButton);
                break;
            case "tourism":
                SendMessage tourism = MessageInit.sendMsg(update.getCallbackQuery().getMessage().getChatId().toString(),
                        new FileRead().txtRead("workExp/tourism"));
                tourism.setReplyMarkup(SecondaryKeyboard.returnBack("Опыт работы \uD83D\uDECC"));
                bot.execute(tourism);
                break;
            case "manager":
                SendMessage manager = MessageInit.sendMsg(update.getCallbackQuery().getMessage().getChatId().toString(),
                        new FileRead().txtRead("workExp/manager"));
                manager.setReplyMarkup(SecondaryKeyboard.returnBack("Опыт работы \uD83D\uDECC"));
                bot.execute(manager);
                break;
            case "fitter":
                SendMessage fitter = MessageInit.sendMsg(update.getCallbackQuery().getMessage().getChatId().toString(),
                        new FileRead().txtRead("workExp/fitter"));
                fitter.setReplyMarkup(SecondaryKeyboard.returnBack("Опыт работы \uD83D\uDECC"));
                bot.execute(fitter);
                break;
            case "projectManager":
                SendMessage projectManager = MessageInit.sendMsg(update.getCallbackQuery().getMessage().getChatId().toString(),
                        new FileRead().txtRead("workExp/projectManager"));
                projectManager.setReplyMarkup(SecondaryKeyboard.returnBack("Опыт работы \uD83D\uDECC"));
                bot.execute(projectManager);
                break;
            case "achievements":
                SendMessage achievements = MessageInit.sendMsg(update.getCallbackQuery().getMessage().getChatId().toString(),
                        new FileRead().txtRead("aboutMe/achievements"));
                achievements.setReplyMarkup(SecondaryKeyboard.returnBack("О себе \uD83D\uDC82\uD83C\uDFFB\u200D♀️"));
                bot.execute(achievements);
                break;
            case "hobby":
                SendMessage hobby = MessageInit.sendMsg(update.getCallbackQuery().getMessage().getChatId().toString(),
                        new FileRead().txtRead("aboutMe/hobby"));
                hobby.setReplyMarkup(SecondaryKeyboard.returnBack("О себе \uD83D\uDC82\uD83C\uDFFB\u200D♀️"));
                bot.execute(hobby);
                break;
            case "programsMe":
                SendMessage programsMe = MessageInit.sendMsg(update.getCallbackQuery().getMessage().getChatId().toString(),
                        new FileRead().txtRead("aboutMe/programsMe"));
                programsMe.setReplyMarkup(SecondaryKeyboard.returnBack("О себе \uD83D\uDC82\uD83C\uDFFB\u200D♀️"));
                bot.execute(programsMe);
                break;
            case "technologiesMe":
                SendMessage technologiesMe = MessageInit.sendMsg(update.getCallbackQuery().getMessage().getChatId().toString(),
                        new FileRead().txtRead("aboutMe/technologiesMe"));
                technologiesMe.setReplyMarkup(SecondaryKeyboard.returnBack("О себе \uD83D\uDC82\uD83C\uDFFB\u200D♀️"));
                bot.execute(technologiesMe);
                break;
            case "humor":
                SendMessage humor = MessageInit.sendMsg(update.getCallbackQuery().getMessage().getChatId().toString(),
                        Joke.jokeMain());
                humor.setReplyMarkup(SecondaryKeyboard.possibilities());
                bot.execute(humor);
                break;
            default:
                Message message = update.getCallbackQuery().getMessage();
                message.setText(update.getCallbackQuery().getData());
                mainMenu(message);
                break;
        }
    }

    public static void locationMenu(Message message) throws TelegramApiException {
        String address = Geo.geoMain(message.getLocation());
        message.setText("<b>Отправлена геолокация</b>\n\n" + "Предположительное местонахождение: \n" + address);
        bot.execute(MessageInit.myAcc(message));
        bot.execute(MessageInit.sendMsg(message.getChatId().toString(), "\uD83C\uDF0F<b>Предположительное местонахождение:</b> \n"
                + address));
        List<String> weatherList = Weather.weatherMain(message.getLocation());
        for (String el : weatherList)
            bot.execute(MessageInit.sendMsg(message.getChatId().toString(), el));
    }


}
