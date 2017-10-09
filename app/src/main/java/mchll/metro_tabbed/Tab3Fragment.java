package mchll.metro_tabbed;

import android.graphics.Color;
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
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.ViewGroup.LayoutParams;

import java.util.ArrayList;

import ir.mirrajabi.searchdialog.SimpleSearchDialogCompat;
import ir.mirrajabi.searchdialog.core.BaseSearchDialogCompat;
import ir.mirrajabi.searchdialog.core.SearchResultListener;
import ir.mirrajabi.searchdialog.core.Searchable;

public class Tab3Fragment extends Fragment {
    private static final String TAG = "Tab3Fragment";

    private LinearLayout linLayout_enter;
    private ListView lines;
    private Button button_line;
    Boolean us = false;
    String string_line = "";

    int[] colors = new int[6];

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tab3_fragment,container,false);

        colors[0] = Color.parseColor("#FFFAFAFA");
        colors[1] = Color.parseColor("#FFDB0232");
        colors[2] = Color.parseColor("#FF0277BB");
        colors[3] = Color.parseColor("#FF049652");
        colors[4] = Color.parseColor("#FFE37502");
        colors[5] = Color.parseColor("#FF77237F");

        button_line = (Button) view.findViewById(R.id.button_line);
        linLayout_enter = (LinearLayout) view.findViewById(R.id.linLayout_enter);

        button_line.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getActivity(), "TESTING BUTTON TO",Toast.LENGTH_SHORT).show();

                new SimpleSearchDialogCompat(getActivity(), "Search...", "What are you looking for...?", null, InitStations.initLines(), new SearchResultListener<Searchable>() {
                    @Override
                    public void onSelected(BaseSearchDialogCompat baseSearchDialogCompat, Searchable searchable, int i) {
                        string_line = ""+searchable.getTitle();
                        button_line.setText(string_line);
                        us = true;
                        int j = InitStations.getIntBranch(string_line);
                        ArrayList<String> ans;
                        ans = InitStations.getBranchStations(j);
                        if(ans.size() > 0) {
                            ans.add("");
                            ans.add("");
                            ans.add("");
                        }
                        String[] stat = ans.toArray(new String[ans.size()]);
                        LayoutInflater ltInflater = getActivity().getLayoutInflater();
                        int branche = 0;
                        linLayout_enter.removeAllViews();

                        for (int ii = 0; ii < stat.length; ii++) {
                            View item = ltInflater.inflate(R.layout.my_list_item, linLayout_enter, false);
                            branche = InitStations.getBranch(stat[ii]);

                            TextView text_item = (TextView) item.findViewById(R.id.item_text);
                            text_item.setText(stat[ii]);

                            Button button_item = (Button) item.findViewById(R.id.item_button);
                            button_item.setBackgroundColor(colors[branche]);

                            String time_station = InitStations.getStationTime(stat[ii]);
                            Button button_time = (Button) item.findViewById(R.id.button_time);
                            button_time.setText(time_station);

                            item.getLayoutParams().width = LayoutParams.MATCH_PARENT;
                            linLayout_enter.addView(item);
                        }


                        Toast.makeText(getActivity(), string_line, Toast.LENGTH_SHORT).show();
                        baseSearchDialogCompat.dismiss();
                    }
                }).show();
                
            }
        });

        return view;
    }

}