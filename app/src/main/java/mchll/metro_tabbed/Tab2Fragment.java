package mchll.metro_tabbed;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import ir.mirrajabi.searchdialog.SimpleSearchDialogCompat;
import ir.mirrajabi.searchdialog.core.BaseSearchDialogCompat;
import ir.mirrajabi.searchdialog.core.SearchResultListener;
import ir.mirrajabi.searchdialog.core.Searchable;

public class Tab2Fragment extends Fragment {
    private static final String TAG = "Tab2Fragment";

    private Button button_from;
    private Button button_to;
    private Button button_search;
    private Button fab;
    private ListView smallest_path;
    String string_from = "";
    String string_to = "";
    Boolean enable_from = false;
    Boolean enable_to = false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab2_fragment,container,false);


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
        smallest_path = (ListView) view.findViewById(R.id.shortest_path);
        fab = (Button) view.findViewById(R.id.fab);

        button_search.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {
                //Toast.makeText(getActivity(), "TESTING BUTTON SEARCH",Toast.LENGTH_SHORT).show();
                final ArrayList<String> ans;
                String shortest_time = "";
                if(enable_from && enable_to) {
                    ans = new ArrayList<String>(SolutionPath.run(InitStations.fromStrToInt(string_from),InitStations.fromStrToInt(string_to)));
                    if(ans.size() > 0) {
                        shortest_time = "Время пути: " + ans.get(ans.size() - 1) + " мин.";
                        ans.set(ans.size() - 1, shortest_time);
                        ans.add("");
                        ans.add("");
                    }

                    String[] path = ans.toArray(new String[ans.size()]);
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, path);
                    smallest_path.setAdapter(adapter);

                    fab.setVisibility(View.VISIBLE);
                    fab.setText(" " + shortest_time + " ");
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

        return view;
    }

}