package mchll.metro_tabbed;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
    private TextView smallest_path;
    String string_from = "";
    String string_to = "";

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
                        string_to = ""+searchable.getTitle();
                        button_to.setText(string_to);
                        Toast.makeText(getActivity(), string_to, Toast.LENGTH_SHORT).show();
                        baseSearchDialogCompat.dismiss();
                    }
                }).show();
            }
        });

        button_search = (Button) view.findViewById(R.id.to_search);
        smallest_path = (TextView) view.findViewById(R.id.textPath);
        button_search.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {
                //Toast.makeText(getActivity(), "TESTING BUTTON SEARCH",Toast.LENGTH_SHORT).show();
                final ArrayList<String> ans;
                ans = new ArrayList<String>(SolutionPath.run(InitStations.fromStrToInt(string_from),InitStations.fromStrToInt(string_to)));

                String path = "Кратчайший путь: ";
                for (int i = 0; i < ans.size(); i++) {
                    path = path + ans.get(i) + " " + "->" + " ";
                }

                smallest_path.setText(path);

            }
        });

        return view;
    }

}