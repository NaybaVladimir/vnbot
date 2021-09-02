package org.example.vnbot.message;

import org.example.vnbot.keyboard.KeyboardMain;
import org.example.vnbot.workingWithFiles.FileRead;
import org.springframework.util.ResourceUtils;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;


public class MessageInit {
    private static final String id = new FileRead().propertiesRead("messageInit.id", "init.properties");

    //Создание ответного сообщения
    public static SendMessage sendMsg(String chatId, String text) {
        SendMessage sendMessage = new SendMessage();
        //включение разметки
        sendMessage.enableMarkdown(true);
        //инициализация получателя по чат id
        sendMessage.setChatId(chatId);
        //установка форматирования текста по html
        sendMessage.setParseMode(ParseMode.HTML);
        //Инициализация значения сообщения(Исходящего)
        sendMessage.setText(text);
        //Инициализация кнопок
        KeyboardMain.setButton(sendMessage);
        return sendMessage;
    }

    /*Отправка лога о сообщении на свой id, пример:
     Thu Aug 26 23:58:06 NOVT 2021
     ---------------------------------------
     Пользователь:
    id: Id
    FirstName: Иван
    LastName: Иванов
    UserName: Samy_glavny
    ---------------------------------------
     Написал:
     /run"*/

    public static SendMessage myAcc(Message message) {
        SendMessage sendMessage = new SendMessage();
        String msg = new Date()
                + "\n" + "---------------------------------------"
                + "\n" + " <b>Пользователь:</b> "
                + "\n" + "id: " + message.getFrom().getId() + " "
                + "\n" + "FirstName: " + message.getFrom().getFirstName() + " "
                + "\n" + "LastName: " + message.getFrom().getLastName() + " "
                + "\n" + "UserName: " + message.getFrom().getUserName()
                + "\n" + "---------------------------------------"
                + "\n" + " <b>Написал:</b> "
                + "\n" + message.getText();
        sendMessage.setParseMode(ParseMode.HTML);
        sendMessage.setChatId(id);
        sendMessage.setText(msg);

        return sendMessage;
    }

    public static SendPhoto sendPhoto(String chatId, String text, String imageFileName) throws FileNotFoundException {
        File imageFile = ResourceUtils.getFile("classpath:photo/" + imageFileName);
        SendPhoto sendPhoto = new SendPhoto();
        //инициализация получателя по чат id
        sendPhoto.setCaption(text);
        sendPhoto.setChatId(chatId);
        sendPhoto.setParseMode(ParseMode.HTML);
        sendPhoto.setPhoto(new InputFile(imageFile));
        return sendPhoto;

    }
}
