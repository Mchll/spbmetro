package mchll.metro_tabbed;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Objects;

class InitStations {

    static void getPathStations(ArrayList[] adj, ArrayList[] weight) {

        //считываем граф, заданный списком ребер
        int from, to, w;
        from = InitStations.fromStrToInt("Комендантский проспект"); to = InitStations.fromStrToInt("Старая Деревня"); w = 3;
        adj[from].add(to); weight[from].add(w);
        adj[to].add(from); weight[to].add(w);

        from = InitStations.fromStrToInt("Старая Деревня"); to = InitStations.fromStrToInt("Крестовский остров"); w = 3;
        adj[from].add(to); weight[from].add(w);
        adj[to].add(from); weight[to].add(w);

        from = InitStations.fromStrToInt("Крестовский остров"); to = InitStations.fromStrToInt("Чкаловская"); w = 4;
        adj[from].add(to); weight[from].add(w);
        adj[to].add(from); weight[to].add(w);

        from = InitStations.fromStrToInt("Чкаловская"); to = InitStations.fromStrToInt("Спортивная"); w = 2;
        adj[from].add(to); weight[from].add(w);
        adj[to].add(from); weight[to].add(w);

        from = InitStations.fromStrToInt("Спортивная"); to = InitStations.fromStrToInt("Адмиралтейская"); w = 3;
        adj[from].add(to); weight[from].add(w);
        adj[to].add(from); weight[to].add(w);

        from = InitStations.fromStrToInt("Адмиралтейская"); to = InitStations.fromStrToInt("Садовая"); w = 3;
        adj[from].add(to); weight[from].add(w);
        adj[to].add(from); weight[to].add(w);

        from = InitStations.fromStrToInt("Садовая"); to = InitStations.fromStrToInt("Спасская"); w = 3;
        adj[from].add(to); weight[from].add(w);
        adj[to].add(from); weight[to].add(w);

        from = InitStations.fromStrToInt("Садовая"); to = InitStations.fromStrToInt("Сенная площадь"); w = 3;
        adj[from].add(to); weight[from].add(w);
        adj[to].add(from); weight[to].add(w);

        from = InitStations.fromStrToInt("Садовая"); to = InitStations.fromStrToInt("Звенигородская"); w = 4;
        adj[from].add(to); weight[from].add(w);
        adj[to].add(from); weight[to].add(w);

        from = InitStations.fromStrToInt("Звенигородская"); to = InitStations.fromStrToInt("Пушкинская"); w = 2;
        adj[from].add(to); weight[from].add(w);
        adj[to].add(from); weight[to].add(w);

        from = InitStations.fromStrToInt("Звенигородская"); to = InitStations.fromStrToInt("Обводный канал"); w = 3;
        adj[from].add(to); weight[from].add(w);
        adj[to].add(from); weight[to].add(w);

        from = InitStations.fromStrToInt("Обводный канал"); to = InitStations.fromStrToInt("Волковская"); w = 3;
        adj[from].add(to); weight[from].add(w);
        adj[to].add(from); weight[to].add(w);

        from = InitStations.fromStrToInt("Волковская"); to = InitStations.fromStrToInt("Бухарестская"); w = 3;
        adj[from].add(to); weight[from].add(w);
        adj[to].add(from); weight[to].add(w);

        from = InitStations.fromStrToInt("Бухарестская"); to = InitStations.fromStrToInt("Международная"); w = 3;
        adj[from].add(to); weight[from].add(w);
        adj[to].add(from); weight[to].add(w);

        from = InitStations.fromStrToInt("Проспект Ветеранов"); to = InitStations.fromStrToInt("Ленинский проспект"); w = 2;
        adj[from].add(to); weight[from].add(w);
        adj[to].add(from); weight[to].add(w);

        from = InitStations.fromStrToInt("Ленинский проспект"); to = InitStations.fromStrToInt("Автово"); w = 3;
        adj[from].add(to); weight[from].add(w);
        adj[to].add(from); weight[to].add(w);

        from = InitStations.fromStrToInt("Автово"); to = InitStations.fromStrToInt("Кировский завод"); w = 2;
        adj[from].add(to); weight[from].add(w);
        adj[to].add(from); weight[to].add(w);

        from = InitStations.fromStrToInt("Кировский завод"); to = InitStations.fromStrToInt("Нарвская"); w = 4;
        adj[from].add(to); weight[from].add(w);
        adj[to].add(from); weight[to].add(w);

        from = InitStations.fromStrToInt("Нарвская"); to = InitStations.fromStrToInt("Балтийская"); w = 3;
        adj[from].add(to); weight[from].add(w);
        adj[to].add(from); weight[to].add(w);

        from = InitStations.fromStrToInt("Балтийская"); to = InitStations.fromStrToInt("Технологический институт 1"); w = 2;
        adj[from].add(to); weight[from].add(w);
        adj[to].add(from); weight[to].add(w);

        from = InitStations.fromStrToInt("Технологический институт 1"); to = InitStations.fromStrToInt("Технологический институт 2"); w = 1;
        adj[from].add(to); weight[from].add(w);
        adj[to].add(from); weight[to].add(w);

        from = InitStations.fromStrToInt("Технологический институт 1"); to = InitStations.fromStrToInt("Пушкинская"); w = 2;
        adj[from].add(to); weight[from].add(w);
        adj[to].add(from); weight[to].add(w);

        from = InitStations.fromStrToInt("Пушкинская"); to = InitStations.fromStrToInt("Владимирская"); w = 2;
        adj[from].add(to); weight[from].add(w);
        adj[to].add(from); weight[to].add(w);

        from = InitStations.fromStrToInt("Владимирская"); to = InitStations.fromStrToInt("Достоевская"); w = 2;
        adj[from].add(to); weight[from].add(w);
        adj[to].add(from); weight[to].add(w);

        from = InitStations.fromStrToInt("Владимирская"); to = InitStations.fromStrToInt("Площадь Восстания"); w = 2;
        adj[from].add(to); weight[from].add(w);
        adj[to].add(from); weight[to].add(w);

        from = InitStations.fromStrToInt("Площадь Восстания"); to = InitStations.fromStrToInt("Маяковская"); w = 2;
        adj[from].add(to); weight[from].add(w);
        adj[to].add(from); weight[to].add(w);

        from = InitStations.fromStrToInt("Площадь Восстания"); to = InitStations.fromStrToInt("Чернышевская"); w = 2;
        adj[from].add(to); weight[from].add(w);
        adj[to].add(from); weight[to].add(w);

        from = InitStations.fromStrToInt("Чернышевская"); to = InitStations.fromStrToInt("Площадь Ленина"); w = 3;
        adj[from].add(to); weight[from].add(w);
        adj[to].add(from); weight[to].add(w);

        from = InitStations.fromStrToInt("Площадь Ленина"); to = InitStations.fromStrToInt("Выборгская"); w = 2;
        adj[from].add(to); weight[from].add(w);
        adj[to].add(from); weight[to].add(w);

        from = InitStations.fromStrToInt("Выборгская"); to = InitStations.fromStrToInt("Лесная"); w = 3;
        adj[from].add(to); weight[from].add(w);
        adj[to].add(from); weight[to].add(w);

        from = InitStations.fromStrToInt("Лесная"); to = InitStations.fromStrToInt("Площадь Мужества"); w = 3;
        adj[from].add(to); weight[from].add(w);
        adj[to].add(from); weight[to].add(w);

        from = InitStations.fromStrToInt("Площадь Мужества"); to = InitStations.fromStrToInt("Политехническая"); w = 3;
        adj[from].add(to); weight[from].add(w);
        adj[to].add(from); weight[to].add(w);

        from = InitStations.fromStrToInt("Политехническая"); to = InitStations.fromStrToInt("Академическая"); w = 2;
        adj[from].add(to); weight[from].add(w);
        adj[to].add(from); weight[to].add(w);

        from = InitStations.fromStrToInt("Академическая"); to = InitStations.fromStrToInt("Гражданский проспект"); w = 3;
        adj[from].add(to); weight[from].add(w);
        adj[to].add(from); weight[to].add(w);

        from = InitStations.fromStrToInt("Гражданский проспект"); to = InitStations.fromStrToInt("Девяткино"); w = 3;
        adj[from].add(to); weight[from].add(w);
        adj[to].add(from); weight[to].add(w);

        from = InitStations.fromStrToInt("Купчино"); to = InitStations.fromStrToInt("Звёздная"); w = 3;
        adj[from].add(to); weight[from].add(w);
        adj[to].add(from); weight[to].add(w);

        from = InitStations.fromStrToInt("Звёздная"); to = InitStations.fromStrToInt("Московская"); w = 4;
        adj[from].add(to); weight[from].add(w);
        adj[to].add(from); weight[to].add(w);

        from = InitStations.fromStrToInt("Московская"); to = InitStations.fromStrToInt("Парк Победы"); w = 3;
        adj[from].add(to); weight[from].add(w);
        adj[to].add(from); weight[to].add(w);

        from = InitStations.fromStrToInt("Парк Победы"); to = InitStations.fromStrToInt("Электросила"); w = 2;
        adj[from].add(to); weight[from].add(w);
        adj[to].add(from); weight[to].add(w);

        from = InitStations.fromStrToInt("Электросила"); to = InitStations.fromStrToInt("Московские ворота"); w = 2;
        adj[from].add(to); weight[from].add(w);
        adj[to].add(from); weight[to].add(w);

        from = InitStations.fromStrToInt("Московские ворота"); to = InitStations.fromStrToInt("Фрунзенская"); w = 2;
        adj[from].add(to); weight[from].add(w);
        adj[to].add(from); weight[to].add(w);

        from = InitStations.fromStrToInt("Фрунзенская"); to = InitStations.fromStrToInt("Технологический институт 2"); w = 2;
        adj[from].add(to); weight[from].add(w);
        adj[to].add(from); weight[to].add(w);

        from = InitStations.fromStrToInt("Технологический институт 2"); to = InitStations.fromStrToInt("Сенная площадь"); w = 3;
        adj[from].add(to); weight[from].add(w);
        adj[to].add(from); weight[to].add(w);

        from = InitStations.fromStrToInt("Сенная площадь"); to = InitStations.fromStrToInt("Спасская"); w = 3;
        adj[from].add(to); weight[from].add(w);
        adj[to].add(from); weight[to].add(w);

        from = InitStations.fromStrToInt("Сенная площадь"); to = InitStations.fromStrToInt("Невский проспект"); w = 2;
        adj[from].add(to); weight[from].add(w);
        adj[to].add(from); weight[to].add(w);

        from = InitStations.fromStrToInt("Невский проспект"); to = InitStations.fromStrToInt("Гостиный двор"); w = 2;
        adj[from].add(to); weight[from].add(w);
        adj[to].add(from); weight[to].add(w);

        from = InitStations.fromStrToInt("Невский проспект"); to = InitStations.fromStrToInt("Горьковская"); w = 4;
        adj[from].add(to); weight[from].add(w);
        adj[to].add(from); weight[to].add(w);

        from = InitStations.fromStrToInt("Горьковская"); to = InitStations.fromStrToInt("Петроградская"); w = 2;
        adj[from].add(to); weight[from].add(w);
        adj[to].add(from); weight[to].add(w);

        from = InitStations.fromStrToInt("Петроградская"); to = InitStations.fromStrToInt("Чёрная речка"); w = 4;
        adj[from].add(to); weight[from].add(w);
        adj[to].add(from); weight[to].add(w);

        from = InitStations.fromStrToInt("Чёрная речка"); to = InitStations.fromStrToInt("Пионерская"); w = 3;
        adj[from].add(to); weight[from].add(w);
        adj[to].add(from); weight[to].add(w);

        from = InitStations.fromStrToInt("Пионерская"); to = InitStations.fromStrToInt("Удельная"); w = 3;
        adj[from].add(to); weight[from].add(w);
        adj[to].add(from); weight[to].add(w);

        from = InitStations.fromStrToInt("Удельная"); to = InitStations.fromStrToInt("Озерки"); w = 3;
        adj[from].add(to); weight[from].add(w);
        adj[to].add(from); weight[to].add(w);

        from = InitStations.fromStrToInt("Озерки"); to = InitStations.fromStrToInt("Проспект Просвещения"); w = 2;
        adj[from].add(to); weight[from].add(w);
        adj[to].add(from); weight[to].add(w);

        from = InitStations.fromStrToInt("Проспект Просвещения"); to = InitStations.fromStrToInt("Парнас"); w = 3;
        adj[from].add(to); weight[from].add(w);
        adj[to].add(from); weight[to].add(w);

        from = InitStations.fromStrToInt("Спасская"); to = InitStations.fromStrToInt("Достоевская"); w = 4;
        adj[from].add(to); weight[from].add(w);
        adj[to].add(from); weight[to].add(w);

        from = InitStations.fromStrToInt("Достоевская"); to = InitStations.fromStrToInt("Лиговский проспект"); w = 2;
        adj[from].add(to); weight[from].add(w);
        adj[to].add(from); weight[to].add(w);

        from = InitStations.fromStrToInt("Лиговский проспект"); to = InitStations.fromStrToInt("Площадь Александра Невского 2"); w = 2;
        adj[from].add(to); weight[from].add(w);
        adj[to].add(from); weight[to].add(w);

        from = InitStations.fromStrToInt("Площадь Александра Невского 2"); to = InitStations.fromStrToInt("Площадь Александра Невского 1"); w = 2;
        adj[from].add(to); weight[from].add(w);
        adj[to].add(from); weight[to].add(w);

        from = InitStations.fromStrToInt("Площадь Александра Невского 2"); to = InitStations.fromStrToInt("Новочеркасская"); w = 3;
        adj[from].add(to); weight[from].add(w);
        adj[to].add(from); weight[to].add(w);

        from = InitStations.fromStrToInt("Новочеркасская"); to = InitStations.fromStrToInt("Ладожская"); w = 3;
        adj[from].add(to); weight[from].add(w);
        adj[to].add(from); weight[to].add(w);

        from = InitStations.fromStrToInt("Ладожская"); to = InitStations.fromStrToInt("Проспект Большевиков"); w = 3;
        adj[from].add(to); weight[from].add(w);
        adj[to].add(from); weight[to].add(w);

        from = InitStations.fromStrToInt("Проспект Большевиков"); to = InitStations.fromStrToInt("Улица Дыбенко"); w = 2;
        adj[from].add(to); weight[from].add(w);
        adj[to].add(from); weight[to].add(w);

        from = InitStations.fromStrToInt("Приморская"); to = InitStations.fromStrToInt("Василеостровская"); w = 4;
        adj[from].add(to); weight[from].add(w);
        adj[to].add(from); weight[to].add(w);

        from = InitStations.fromStrToInt("Василеостровская"); to = InitStations.fromStrToInt("Гостиный двор"); w = 4;
        adj[from].add(to); weight[from].add(w);
        adj[to].add(from); weight[to].add(w);

        from = InitStations.fromStrToInt("Гостиный двор"); to = InitStations.fromStrToInt("Маяковская"); w = 3;
        adj[from].add(to); weight[from].add(w);
        adj[to].add(from); weight[to].add(w);

        from = InitStations.fromStrToInt("Маяковская"); to = InitStations.fromStrToInt("Площадь Александра Невского 1"); w = 3;
        adj[from].add(to); weight[from].add(w);
        adj[to].add(from); weight[to].add(w);

        from = InitStations.fromStrToInt("Площадь Александра Невского 1"); to = InitStations.fromStrToInt("Елизаровская"); w = 5;
        adj[from].add(to); weight[from].add(w);
        adj[to].add(from); weight[to].add(w);

        from = InitStations.fromStrToInt("Елизаровская"); to = InitStations.fromStrToInt("Ломоносовская"); w = 3;
        adj[from].add(to); weight[from].add(w);
        adj[to].add(from); weight[to].add(w);

        from = InitStations.fromStrToInt("Ломоносовская"); to = InitStations.fromStrToInt("Пролетарская"); w = 3;
        adj[from].add(to); weight[from].add(w);
        adj[to].add(from); weight[to].add(w);

        from = InitStations.fromStrToInt("Пролетарская"); to = InitStations.fromStrToInt("Обухово"); w = 3;
        adj[from].add(to); weight[from].add(w);
        adj[to].add(from); weight[to].add(w);

        from = InitStations.fromStrToInt("Обухово"); to = InitStations.fromStrToInt("Рыбацкое"); w = 4;
        adj[from].add(to); weight[from].add(w);
        adj[to].add(from); weight[to].add(w);

    }

    static int fromStrToInt(String s) {
        if(s.equals("Автово")) return 1;
        else if(s.equals("Адмиралтейская")) return 2;
        else if(s.equals("Академическая")) return 3;
        else if(s.equals("Балтийская")) return 4;
        else if(s.equals("Бухарестская")) return 5;
        else if(s.equals("Василеостровская")) return 6;
        else if(s.equals("Владимирская")) return 7;
        else if(s.equals("Волковская")) return 8;
        else if(s.equals("Выборгская")) return 9;
        else if(s.equals("Горьковская")) return 10;
        else if(s.equals("Гостиный двор")) return 11;
        else if(s.equals("Гражданский проспект")) return 12;
        else if(s.equals("Девяткино")) return 13;
        else if(s.equals("Достоевская")) return 14;
        else if(s.equals("Елизаровская")) return 15;
        else if(s.equals("Звёздная")) return 16;
        else if(s.equals("Звенигородская")) return 17;
        else if(s.equals("Кировский завод")) return 18;
        else if(s.equals("Комендантский проспект")) return 19;
        else if(s.equals("Крестовский остров")) return 20;
        else if(s.equals("Купчино")) return 21;
        else if(s.equals("Ладожская")) return 22;
        else if(s.equals("Ленинский проспект")) return 23;
        else if(s.equals("Лесная")) return 24;
        else if(s.equals("Лиговский проспект")) return 25;
        else if(s.equals("Ломоносовская")) return 26;
        else if(s.equals("Маяковская")) return 27;
        else if(s.equals("Международная")) return 28;
        else if(s.equals("Московская")) return 29;
        else if(s.equals("Московские ворота")) return 30;
        else if(s.equals("Нарвская")) return 31;
        else if(s.equals("Невский проспект")) return 32;
        else if(s.equals("Новочеркасская")) return 33;
        else if(s.equals("Обводный канал")) return 34;
        else if(s.equals("Обухово")) return 35;
        else if(s.equals("Озерки")) return 36;
        else if(s.equals("Парк Победы")) return 37;
        else if(s.equals("Парнас")) return 38;
        else if(s.equals("Петроградская")) return 39;
        else if(s.equals("Пионерская")) return 40;
        else if(s.equals("Площадь Александра Невского 1")) return 41;
        else if(s.equals("Площадь Александра Невского 2")) return 42;
        else if(s.equals("Площадь Восстания")) return 43;
        else if(s.equals("Площадь Ленина")) return 44;
        else if(s.equals("Площадь Мужества")) return 45;
        else if(s.equals("Политехническая")) return 46;
        else if(s.equals("Приморская")) return 47;
        else if(s.equals("Пролетарская")) return 48;
        else if(s.equals("Проспект Большевиков")) return 49;
        else if(s.equals("Проспект Ветеранов")) return 50;
        else if(s.equals("Проспект Просвещения")) return 51;
        else if(s.equals("Пушкинская")) return 52;
        else if(s.equals("Рыбацкое")) return 53;
        else if(s.equals("Садовая")) return 54;
        else if(s.equals("Сенная площадь")) return 55;
        else if(s.equals("Спасская")) return 56;
        else if(s.equals("Спортивная")) return 57;
        else if(s.equals("Старая Деревня")) return 58;
        else if(s.equals("Технологический институт 1")) return 59;
        else if(s.equals("Технологический институт 2")) return 60;
        else if(s.equals("Удельная")) return 61;
        else if(s.equals("Улица Дыбенко")) return 62;
        else if(s.equals("Фрунзенская")) return 63;
        else if(s.equals("Чёрная речка")) return 64;
        else if(s.equals("Чернышевская")) return 65;
        else if(s.equals("Чкаловская")) return 66;
        else if(s.equals("Электросила")) return 67;
        else return 0;
    }

    static String fromIntToString(int i) {
        if(i == 0) return "It can't be ZERO";
        else if(i == 1) return "Автово";
        else if(i == 2) return "Адмиралтейская";
        else if(i == 3) return "Академическая";
        else if(i == 4) return "Балтийская";
        else if(i == 5) return "Бухарестская";
        else if(i == 6) return "Василеостровская";
        else if(i == 7) return "Владимирская";
        else if(i == 8) return "Волковская";
        else if(i == 9) return "Выборгская";
        else if(i == 10) return "Горьковская";
        else if(i == 11) return "Гостиный двор";
        else if(i == 12) return "Гражданский проспект";
        else if(i == 13) return "Девяткино";
        else if(i == 14) return "Достоевская";
        else if(i == 15) return "Елизаровская";
        else if(i == 16) return "Звёздная";
        else if(i == 17) return "Звенигородская";
        else if(i == 18) return "Кировский завод";
        else if(i == 19) return "Комендантский проспект";
        else if(i == 20) return "Крестовский остров";
        else if(i == 21) return "Купчино";
        else if(i == 22) return "Ладожская";
        else if(i == 23) return "Ленинский проспект";
        else if(i == 24) return "Лесная";
        else if(i == 25) return "Лиговский проспект";
        else if(i == 26) return "Ломоносовская";
        else if(i == 27) return "Маяковская";
        else if(i == 28) return "Международная";
        else if(i == 29) return "Московская";
        else if(i == 30) return "Московские ворота";
        else if(i == 31) return "Нарвская";
        else if(i == 32) return "Невский проспект";
        else if(i == 33) return "Новочеркасская";
        else if(i == 34) return "Обводный канал";
        else if(i == 35) return "Обухово";
        else if(i == 36) return "Озерки";
        else if(i == 37) return "Парк Победы";
        else if(i == 38) return "Парнас";
        else if(i == 39) return "Петроградская";
        else if(i == 40) return "Пионерская";
        else if(i == 41) return "Площадь Александра Невского 1";
        else if(i == 42) return "Площадь Александра Невского 2";
        else if(i == 43) return "Площадь Восстания";
        else if(i == 44) return "Площадь Ленина";
        else if(i == 45) return "Площадь Мужества";
        else if(i == 46) return "Политехническая";
        else if(i == 47) return "Приморская";
        else if(i == 48) return "Пролетарская";
        else if(i == 49) return "Проспект Большевиков";
        else if(i == 50) return "Проспект Ветеранов";
        else if(i == 51) return "Проспект Просвещения";
        else if(i == 52) return "Пушкинская";
        else if(i == 53) return "Рыбацкое";
        else if(i == 54) return "Садовая";
        else if(i == 55) return "Сенная площадь";
        else if(i == 56) return "Спасская";
        else if(i == 57) return "Спортивная";
        else if(i == 58) return "Старая Деревня";
        else if(i == 59) return "Технологический институт 1";
        else if(i == 60) return "Технологический институт 2";
        else if(i == 61) return "Удельная";
        else if(i == 62) return "Улица Дыбенко";
        else if(i == 63) return "Фрунзенская";
        else if(i == 64) return "Чёрная речка";
        else if(i == 65) return "Чернышевская";
        else if(i == 66) return "Чкаловская";
        else if(i == 67) return "Электросила";
        else return "Whoops";
    }

    static ArrayList<SearchModel> initData() {

        ArrayList<SearchModel> items = new ArrayList<>();
        items.add(new SearchModel("Автово"));
        items.add(new SearchModel("Адмиралтейская"));
        items.add(new SearchModel("Академическая"));
        items.add(new SearchModel("Балтийская"));
        items.add(new SearchModel("Бухарестская"));
        items.add(new SearchModel("Василеостровская"));
        items.add(new SearchModel("Владимирская"));
        items.add(new SearchModel("Волковская"));
        items.add(new SearchModel("Выборгская"));
        items.add(new SearchModel("Горьковская"));
        items.add(new SearchModel("Гостиный двор"));
        items.add(new SearchModel("Гражданский проспект"));
        items.add(new SearchModel("Девяткино"));
        items.add(new SearchModel("Достоевская"));
        items.add(new SearchModel("Елизаровская"));
        items.add(new SearchModel("Звёздная"));
        items.add(new SearchModel("Звенигородская"));
        items.add(new SearchModel("Кировский завод"));
        items.add(new SearchModel("Комендантский проспект"));
        items.add(new SearchModel("Крестовский остров"));
        items.add(new SearchModel("Купчино"));
        items.add(new SearchModel("Ладожская"));
        items.add(new SearchModel("Ленинский проспект"));
        items.add(new SearchModel("Лесная"));
        items.add(new SearchModel("Лиговский проспект"));
        items.add(new SearchModel("Ломоносовская"));
        items.add(new SearchModel("Маяковская"));
        items.add(new SearchModel("Международная"));
        items.add(new SearchModel("Московская"));
        items.add(new SearchModel("Московские ворота"));
        items.add(new SearchModel("Нарвская"));
        items.add(new SearchModel("Невский проспект"));
        items.add(new SearchModel("Новочеркасская"));
        items.add(new SearchModel("Обводный канал"));
        items.add(new SearchModel("Обухово"));
        items.add(new SearchModel("Озерки"));
        items.add(new SearchModel("Парк Победы"));
        items.add(new SearchModel("Парнас"));
        items.add(new SearchModel("Петроградская"));
        items.add(new SearchModel("Пионерская"));
        items.add(new SearchModel("Площадь Александра Невского 1"));
        items.add(new SearchModel("Площадь Александра Невского 2"));
        items.add(new SearchModel("Площадь Восстания"));
        items.add(new SearchModel("Площадь Ленина"));
        items.add(new SearchModel("Площадь Мужества"));
        items.add(new SearchModel("Политехническая"));
        items.add(new SearchModel("Приморская"));
        items.add(new SearchModel("Пролетарская"));
        items.add(new SearchModel("Проспект Большевиков"));
        items.add(new SearchModel("Проспект Ветеранов"));
        items.add(new SearchModel("Проспект Просвещения"));
        items.add(new SearchModel("Пушкинская"));
        items.add(new SearchModel("Рыбацкое"));
        items.add(new SearchModel("Садовая"));
        items.add(new SearchModel("Сенная площадь"));
        items.add(new SearchModel("Спасская"));
        items.add(new SearchModel("Спортивная"));
        items.add(new SearchModel("Старая Деревня"));
        items.add(new SearchModel("Технологический институт 1"));
        items.add(new SearchModel("Технологический институт 2"));
        items.add(new SearchModel("Удельная"));
        items.add(new SearchModel("Улица Дыбенко"));
        items.add(new SearchModel("Фрунзенская"));
        items.add(new SearchModel("Чёрная речка"));
        items.add(new SearchModel("Чернышевская"));
        items.add(new SearchModel("Чкаловская"));
        items.add(new SearchModel("Электросила"));

        return items;
    }

    static int getBranch(String s) {
        if(s.equals("Девяткино")) return 1;
        else if(s.equals("Гражданский проспект")) return 1;
        else if(s.equals("Академическая")) return 1;
        else if(s.equals("Политехническая")) return 1;
        else if(s.equals("Площадь Мужества")) return 1;
        else if(s.equals("Лесная")) return 1;
        else if(s.equals("Выборгская")) return 1;
        else if(s.equals("Площадь Ленина")) return 1;
        else if(s.equals("Чернышевская")) return 1;
        else if(s.equals("Площадь Восстания")) return 1;
        else if(s.equals("Владимирская")) return 1;
        else if(s.equals("Пушкинская")) return 1;
        else if(s.equals("Технологический институт 1")) return 1;
        else if(s.equals("Балтийская")) return 1;
        else if(s.equals("Нарвская")) return 1;
        else if(s.equals("Кировский завод")) return 1;
        else if(s.equals("Автово")) return 1;
        else if(s.equals("Ленинский проспект")) return 1;
        else if(s.equals("Проспект Ветеранов")) return 1;

        else if(s.equals("Парнас")) return 2;
        else if(s.equals("Проспект Просвещения")) return 2;
        else if(s.equals("Озерки")) return 2;
        else if(s.equals("Удельная")) return 2;
        else if(s.equals("Пионерская")) return 2;
        else if(s.equals("Чёрная речка")) return 2;
        else if(s.equals("Петроградская")) return 2;
        else if(s.equals("Горьковская")) return 2;
        else if(s.equals("Невский проспект")) return 2;
        else if(s.equals("Сенная площадь")) return 2;
        else if(s.equals("Технологический институт 2")) return 2;
        else if(s.equals("Фрунзенская")) return 2;
        else if(s.equals("Московские ворота")) return 2;
        else if(s.equals("Электросила")) return 2;
        else if(s.equals("Парк Победы")) return 2;
        else if(s.equals("Московская")) return 2;
        else if(s.equals("Звёздная")) return 2;
        else if(s.equals("Купчино")) return 2;

        else if(s.equals("Приморская")) return 3;
        else if(s.equals("Василеостровская")) return 3;
        else if(s.equals("Гостиный двор")) return 3;
        else if(s.equals("Маяковская")) return 3;
        else if(s.equals("Площадь Александра Невского 1")) return 3;
        else if(s.equals("Елизаровская")) return 3;
        else if(s.equals("Ломоносовская")) return 3;
        else if(s.equals("Пролетарская")) return 3;
        else if(s.equals("Обухово")) return 3;
        else if(s.equals("Рыбацкое")) return 3;

        else if(s.equals("Спасская")) return 4;
        else if(s.equals("Достоевская")) return 4;
        else if(s.equals("Лиговский проспект")) return 4;
        else if(s.equals("Площадь Александра Невского 2")) return 4;
        else if(s.equals("Новочеркасская")) return 4;
        else if(s.equals("Ладожская")) return 4;
        else if(s.equals("Проспект Большевиков")) return 4;
        else if(s.equals("Улица Дыбенко")) return 4;

        else if(s.equals("Комендантский проспект")) return 5;
        else if(s.equals("Старая Деревня")) return 5;
        else if(s.equals("Крестовский остров")) return 5;
        else if(s.equals("Чкаловская")) return 5;
        else if(s.equals("Спортивная")) return 5;
        else if(s.equals("Адмиралтейская")) return 5;
        else if(s.equals("Садовая")) return 5;
        else if(s.equals("Звенигородская")) return 5;
        else if(s.equals("Обводный канал")) return 5;
        else if(s.equals("Волковская")) return 5;
        else if(s.equals("Бухарестская")) return 5;
        else if(s.equals("Международная")) return 5;

        else return 0;
    }
}