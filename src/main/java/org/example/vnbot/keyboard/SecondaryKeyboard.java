package org.example.vnbot.keyboard;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class SecondaryKeyboard {
    public static InlineKeyboardMarkup returnBack(String message) {
//Создание клавиатуры
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

//Создание кнопок и установка их наименований
        InlineKeyboardButton whoHelped = new InlineKeyboardButton();
        whoHelped.setText("Назад");

//Установка id Кнопки
        whoHelped.setCallbackData(message);

//Создание ряда кнопок
        List<InlineKeyboardButton> listButton = new ArrayList<>();
        listButton.add(whoHelped);

//Список списков кнопок
        List<List<InlineKeyboardButton>> listRow = new ArrayList<>();
        listRow.add(listButton);

//Помещаем кнопки в клавиатуре
        inlineKeyboardMarkup.setKeyboard(listRow);

        return inlineKeyboardMarkup;
    }

    public static InlineKeyboardMarkup infoBot() {
//Создание клавиатуры
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

//Создание кнопок и установка их наименований
        InlineKeyboardButton whoHelped = new InlineKeyboardButton();
        InlineKeyboardButton technologiesButton = new InlineKeyboardButton();
        whoHelped.setText("Кто помогал");
        technologiesButton.setText("Технологии");

//Установка id Кнопки
        whoHelped.setCallbackData("whoHelped");
        technologiesButton.setCallbackData("technologiesButton");

//Создание ряда кнопок
        List<InlineKeyboardButton> listButton = new ArrayList<>();
        listButton.add(whoHelped);
        listButton.add(technologiesButton);

//Список списков кнопок
        List<List<InlineKeyboardButton>> listRow = new ArrayList<>();
        listRow.add(listButton);

//Помещаем кнопки в клавиатуре
        inlineKeyboardMarkup.setKeyboard(listRow);

        return inlineKeyboardMarkup;
    }


    public static InlineKeyboardMarkup workExp() {
//Создание клавиатуры
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

//Создание кнопок и установка их наименований
        InlineKeyboardButton tourism = new InlineKeyboardButton();
        InlineKeyboardButton fitter = new InlineKeyboardButton();
        InlineKeyboardButton manager = new InlineKeyboardButton();
        InlineKeyboardButton projectManager = new InlineKeyboardButton();

        tourism.setText("Туризм");
        fitter.setText("Монтажник");
        manager.setText("Менеджер");
        projectManager.setText("Проект-менеджер");

//Установка id Кнопки
        tourism.setCallbackData("tourism");
        fitter.setCallbackData("fitter");
        manager.setCallbackData("manager");
        projectManager.setCallbackData("projectManager");

//Создание ряда кнопок
        List<InlineKeyboardButton> listButton1 = new ArrayList<>();
        listButton1.add(tourism);
        listButton1.add(fitter);
        List<InlineKeyboardButton> listButton2 = new ArrayList<>();
        listButton2.add(manager);
        listButton2.add(projectManager);
//Список списков кнопок
        List<List<InlineKeyboardButton>> listRow = new ArrayList<>();
        listRow.add(listButton1);
        listRow.add(listButton2);

//Помещаем кнопки в клавиатуре
        inlineKeyboardMarkup.setKeyboard(listRow);

        return inlineKeyboardMarkup;
    }

    public static InlineKeyboardMarkup aboutMe() {
        //Создание клавиатуры
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

//Создание кнопок и установка их наименований
        InlineKeyboardButton achievements = new InlineKeyboardButton();
        InlineKeyboardButton hobby = new InlineKeyboardButton();
        InlineKeyboardButton programs = new InlineKeyboardButton();
        InlineKeyboardButton technologies = new InlineKeyboardButton();
        achievements.setText("Достижения\uD83D\uDCAA");
        hobby.setText("Хобби⚽️");
        programs.setText("Программы\uD83D\uDDA5");
        technologies.setText("Технологии\uD83D\uDCBB");

//Установка id Кнопки
        achievements.setCallbackData("achievements");
        hobby.setCallbackData("hobby");
        programs.setCallbackData("programsMe");
        technologies.setCallbackData("technologiesMe");

//Создание ряда кнопок
        List<InlineKeyboardButton> listButton = new ArrayList<>();
        listButton.add(achievements);
        listButton.add(hobby);
        List<InlineKeyboardButton> listButton1 = new ArrayList<>();
        List<InlineKeyboardButton> listButton2 = new ArrayList<>();
        listButton1.add(programs);
        listButton2.add(technologies);

//Список списков кнопок
        List<List<InlineKeyboardButton>> listRow = new ArrayList<>();
        listRow.add(listButton);
        listRow.add(listButton1);
        listRow.add(listButton2);

//Помещаем кнопки в клавиатуре
        inlineKeyboardMarkup.setKeyboard(listRow);

        return inlineKeyboardMarkup;
    }

}
