package mchll.metro_tabbed;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

import static mchll.metro_tabbed.R.id.end;


public class SolutionPath {

    private static int INF = Integer.MAX_VALUE / 2;

    private static int n = 69; //количество вершин в орграфе (68)
    //private int m = MNOGO; //количествое дуг в орграфе
    private static ArrayList[] adj; //список смежности
    private static ArrayList[] weight; //вес ребра в орграфе
    private static boolean used[]; //массив для хранения информации о пройденных и не пройденных вершинах
    private static int dist[]; //массив для хранения расстояния от стартовой вершины
    private static int pred[]; //массив предков, необходимых для восстановления кратчайшего пути из стартовой вершины

    //процедура запуска алгоритма Дейкстры из стартовой вершины
    private static void dejkstra(int s) {
        dist[s] = 0; //кратчайшее расстояние до стартовой вершины равно 0
        for (int iter = 1; iter <= n; ++iter) {
            int v = -1; int distV = INF; //выбираем вершину, кратчайшее расстояние до которого еще не найдено
            for (int i = 1; i <= n; ++i) {
                if (used[i]) {
                    continue;
                }
                if (distV < dist[i]) {
                    continue;
                }
                v = i;
                distV = dist[i];
            }
            //рассматриваем все дуги, исходящие из найденной вершины
            for (int i = 0; i < adj[v].size(); ++i) {
                int u = (int) adj[v].get(i);
                int weightU = (int) weight[v].get(i); //релаксация вершины
                if (dist[v] + weightU < dist[u]) {
                    dist[u] = dist[v] + weightU; pred[u] = v;
                }
            } //помечаем вершину v просмотренной, до нее найдено кратчайшее расстояние
            used[v] = true;
        }
    }

    //процедура считывания входных данных
    private static void readData() {

        //инициализация списка смежности
        adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; ++i) {
            adj[i] = new ArrayList();
        }
        //инициализация списка, в котором хранятся веса ребер
        weight = new ArrayList[n + 1];
        for (int i = 0; i <= n; ++i) {
            weight[i] = new ArrayList();
        }

        used = new boolean[n + 1];
        Arrays.fill(used, false);
        pred = new int[n + 1];
        Arrays.fill(pred, -1);
        dist = new int[n + 1];
        Arrays.fill(dist, INF);

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

    //процедура восстановления кратчайшего пути по массиву предком
    static ArrayList<String> printWay(int v) {
        Stack stack = new Stack();
        int j = 0;
        for (int i = v; i != -1; i = pred[i]) {
            stack.push(i);
            /*j++;
            if(j == 70) {
                break;
            }*/
        }
        ArrayList<String> res = new ArrayList<String>();
        while(stack.size() > 0) {
            String s = InitStations.fromIntToString((Integer) stack.pop());
            res.add(s);
        }

        return res;
     }


    public static ArrayList<String> run(int start, int end) {
        readData();
        dejkstra(start);

        String s = String.valueOf(dist[end]);

        ArrayList<String> ans = new ArrayList<String>(printWay(end));
        ans.add(s);
        //ArrayList<String> ans = new ArrayList<String>();

        return ans;
     }

}
