package org.example.vnbot.keyboard;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;


public class KeyboardMain {


    public static void setButton(SendMessage sendMessage) {
        //Инициализация клавиатуры
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        //Синхронизация сообщения с клавиатурой
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        //Показывает клавиатуру всем пользователям
        replyKeyboardMarkup.setSelective(true);
        //автоматически выравнивать клавиатуру
        replyKeyboardMarkup.setResizeKeyboard(true);
        //Не скрывать клавиатуру после использования
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        //Лист кнопок клавиатуры
        List<KeyboardRow> keyboardRowsList = new ArrayList<>();
        //Создание ряда кнопок
        KeyboardRow keboardLineOne = new KeyboardRow();
        KeyboardRow keyboardLineTwo = new KeyboardRow();
        //Добавление кнопок клавиатуры
        keboardLineOne.add(new KeyboardButton("О себе \uD83D\uDC82\uD83C\uDFFB\u200D♀️"));
        keboardLineOne.add(new KeyboardButton("Опыт работы \uD83D\uDECC"));
        keyboardLineTwo.add(new KeyboardButton("Возможности \uD83C\uDF81"));
        keyboardLineTwo.add(new KeyboardButton("Ссылки \uD83D\uDEAA"));
        keyboardLineTwo.add(new KeyboardButton("Контакты \uD83D\uDCF2"));
        //Добавление строк клавиатуры в список
        keyboardRowsList.add(keboardLineOne);
        keyboardRowsList.add(keyboardLineTwo);
        //Вывод кнопок на экран
        replyKeyboardMarkup.setKeyboard(keyboardRowsList);
    }
}
