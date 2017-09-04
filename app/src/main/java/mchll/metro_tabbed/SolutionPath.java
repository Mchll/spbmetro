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

    public static int n = 69; //количество вершин в орграфе (68)
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

        adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; ++i) {
            adj[i] = new ArrayList();
        }
        //инициализация списка, в котором хранятся веса ребер
        weight = new ArrayList[n + 1];
        for (int i = 0; i <= n; ++i) {
            weight[i] = new ArrayList();
        }

        InitStations.getPathStations(adj,weight);
        used = new boolean[n + 1];
        Arrays.fill(used, false);
        pred = new int[n + 1];
        Arrays.fill(pred, -1);
        dist = new int[n + 1];
        Arrays.fill(dist, INF);

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
