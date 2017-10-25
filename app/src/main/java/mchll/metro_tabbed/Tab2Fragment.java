package mchll.metro_tabbed;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.ViewGroup.LayoutParams;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import ir.mirrajabi.searchdialog.SimpleSearchDialogCompat;
import ir.mirrajabi.searchdialog.core.BaseSearchDialogCompat;
import ir.mirrajabi.searchdialog.core.SearchResultListener;
import ir.mirrajabi.searchdialog.core.Searchable;

public class Tab2Fragment extends Fragment {
    private static final String TAG = "Tab2Fragment";

    private static Button button_from;
    private static Button button_to;
    private static Button button_search;
    private Button fab;
    private LinearLayout linLayout;
    private ListView smallest_path;
    String string_from = "";
    String string_to = "";
    static Boolean enable_from = false;
    static Boolean enable_to = false;
    int[] colors = new int[6];
    DBHelper dbHelper;

    private static ArrayList[] adj; //список смежности
    private static ArrayList[] weight; //вес ребра в орграфе
    public static int n = 69; //количество вершин в орграфе (68)

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tab2_fragment,container,false);
        dbHelper = new DBHelper(getActivity());

        colors[0] = Color.parseColor("#FFFAFAFA");
        colors[1] = Color.parseColor("#FFDB0232");
        colors[2] = Color.parseColor("#FF0277BB");
        colors[3] = Color.parseColor("#FF049652");
        colors[4] = Color.parseColor("#FFE37502");
        colors[5] = Color.parseColor("#FF77237F");

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


        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(1000);
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                long date = System.currentTimeMillis(); //+ 3*60*60*1000;
                                SimpleDateFormat sdf = new SimpleDateFormat(" dd MMMM yyyy \n HH:mm:ss ", Locale.ENGLISH);
                                String dateString = sdf.format(date);
                                fab.setText(dateString);
                            }
                        });
                    }
                } catch (InterruptedException e) {
                    Log.d(TAG, "Tab2Fragment: current time fab");
                }
            }
        };
        t.start();



        button_from = (Button) view.findViewById(R.id.point_from);
        button_from.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getActivity(), "TESTING BUTTON FROM",Toast.LENGTH_SHORT).show();
                new SimpleSearchDialogCompat(getActivity(), "Search...", "What are you looking for...?", null, InitStations.initData(), new SearchResultListener<Searchable>() {
                    @Override
                    public void onSelected(BaseSearchDialogCompat baseSearchDialogCompat, Searchable searchable, int i) {
                        enable_from = true;
                        string_from = ""+searchable.getTitle();
                        button_from.setText(string_from);
                        Toast.makeText(getActivity(), string_from, Toast.LENGTH_SHORT).show();
                        baseSearchDialogCompat.dismiss();
                    }
                }).show();
            }
        });


        button_to = (Button) view.findViewById(R.id.point_to);
        button_to.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getActivity(), "TESTING BUTTON TO",Toast.LENGTH_SHORT).show();
                new SimpleSearchDialogCompat(getActivity(), "Search...", "What are you looking for...?", null, InitStations.initData(), new SearchResultListener<Searchable>() {
                    @Override
                    public void onSelected(BaseSearchDialogCompat baseSearchDialogCompat, Searchable searchable, int i) {
                        enable_to = true;
                        string_to = ""+searchable.getTitle();
                        button_to.setText(string_to);
                        Toast.makeText(getActivity(), string_to, Toast.LENGTH_SHORT).show();
                        baseSearchDialogCompat.dismiss();
                    }
                }).show();
            }
        });

        button_search = (Button) view.findViewById(R.id.to_search);
        //smallest_path = (ListView) view.findViewById(R.id.shortest_path);
        fab = (Button) view.findViewById(R.id.fab);
        linLayout = (LinearLayout) view.findViewById(R.id.linLayout);

        button_search.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {
                //Toast.makeText(getActivity(), "TESTING BUTTON SEARCH",Toast.LENGTH_SHORT).show();

                final ArrayList<String> ans;

                String shortest_time = "";
                if(enable_from && enable_to) {

                    string_from = button_from.getText().toString();
                    string_to = button_to.getText().toString();

                    String s = string_from + " - " + string_to;
                    SQLiteDatabase database = dbHelper.getWritableDatabase();
                    ContentValues contentValues = new ContentValues(); //одна строка таблицы (в виде массива)
                    contentValues.put(DBHelper.KEY_FROM,s);
                    database.delete(DBHelper.TABLE_CONTACTS, DBHelper.KEY_FROM + " = ?", new String[]{s});
                    database.insert(DBHelper.TABLE_CONTACTS, null, contentValues);


                    ans = new ArrayList<String>(SolutionPath.run(InitStations.fromStrToInt(string_from),InitStations.fromStrToInt(string_to)));
                    if(ans.size() > 0) {
                        shortest_time = "Время в пути: " + ans.get(ans.size() - 1) + " мин.";
                        ans.set(ans.size() - 1, shortest_time);
                        ans.set(0, shortest_time);
                        ans.add("");
                        ans.add("");
                        ans.add("");
                    }

                    String[] path = ans.toArray(new String[ans.size()]);


                    /*ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, path);
                    smallest_path.setAdapter(adapter);*/

                    LayoutInflater ltInflater = getActivity().getLayoutInflater();
                    int branch = 0;
                    linLayout.removeAllViews();

                    int current_time = CurrentTime.getCurrentTime();
                    int current_hours = current_time / 100;
                    int current_minutes = (current_time % 100);

                    for (int i = 0; i < path.length; i++) {
                        View item = ltInflater.inflate(R.layout.my_list_item, linLayout, false);
                        branch = InitStations.getBranch(path[i]);

                        TextView text_item = (TextView) item.findViewById(R.id.item_text);
                        text_item.setText(path[i]);

                        Button button_item = (Button) item.findViewById(R.id.item_button);
                        button_item.setBackgroundColor(colors[branch]);

                        Button button_time = (Button) item.findViewById(R.id.button_time);

                        if(i > 1) {
                            int v = InitStations.fromStrToInt(path[i]);
                            int pred = InitStations.fromStrToInt(path[i - 1]);
                            for (int ii = 0; ii < adj[v].size(); ++ii) {
                                int u = (int) adj[v].get(ii);
                                if(u == pred) {
                                    int weightU = (int) weight[v].get(ii);
                                    current_minutes = current_minutes + weightU;
                                    current_hours = (current_hours + current_minutes / 60) % 24;
                                    current_minutes = current_minutes % 60;
                                }
                            }
                        }

                        String time = "";
                        if(current_hours / 10 == 0) {
                            time = time + "0" + String.valueOf(current_hours) + ":";
                        }
                        else {
                            time = time + String.valueOf(current_hours) + ":";
                        }
                        if(current_minutes / 10 == 0) {
                            time = time + "0" + String.valueOf(current_minutes);
                        }
                        else {
                            time = time + String.valueOf(current_minutes);
                        }

                        if(path.length - i > 4 && i != 0) button_time.setText(time);
                        else button_time.setText(" ");

                        item.getLayoutParams().width = LayoutParams.MATCH_PARENT;
                        linLayout.addView(item);
                    }

                }
            }
        });

        /*fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(enable_from && enable_to) {
                    Snackbar.make(view, "Transfers?", Snackbar.LENGTH_SHORT)
                            .setAction("Action", null).show();
                }
            }
        });*/

        dbHelper.close(); //закрываем связь с БД

        return view;
    }

    public static void setDescription(String s) {
        int z = 0;
        String q = "", w = "";
        for(int i = 0; i < s.length(); ++i) {
            if(z == 0) {
                if(s.charAt(i) == ' ' && s.charAt(i + 1) == '-' || s.charAt(i) == '-') {

                }
                else if(s.charAt(i) == ' ' && s.charAt(i - 1) == '-') {
                    z = 1;
                } else {
                    q = q + s.charAt(i);
                }
            }
            else {
                w = w + s.charAt(i);
            }

        }
        button_from.setText(q);
        button_to.setText(w);
        enable_from = true;
        enable_to = true;

        button_search.callOnClick();

    }
}