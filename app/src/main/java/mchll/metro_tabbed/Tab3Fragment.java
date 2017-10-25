package mchll.metro_tabbed;

import android.database.Cursor;
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

import java.util.ArrayList;
import java.util.Collections;

import ir.mirrajabi.searchdialog.SimpleSearchDialogCompat;
import ir.mirrajabi.searchdialog.core.BaseSearchDialogCompat;
import ir.mirrajabi.searchdialog.core.SearchResultListener;
import ir.mirrajabi.searchdialog.core.Searchable;

public class Tab3Fragment extends Fragment {
    private static final String TAG = "Tab3Fragment";

    private LinearLayout linLayout_enter;
    private ListView lines;
    private Button button_clear;
    Boolean us = false;
    String string_line = "";
    DBHelper dbHelper;

    int[] colors = new int[6];

    public interface OnSelectedButtonListener {
        void onButtonSelected(String s);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tab3_fragment,container,false);

        linLayout_enter = (LinearLayout) view.findViewById(R.id.linLayout_enter);

        dbHelper = new DBHelper(getActivity());



        button_clear = (Button) view.findViewById(R.id.button_clear);
        button_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getActivity(), "TESTING BUTTON FROM",Toast.LENGTH_SHORT).show();
                SQLiteDatabase database = dbHelper.getWritableDatabase();
                database.delete(DBHelper.TABLE_CONTACTS, null, null);
                linLayout_enter.removeAllViews();
            }
        });

        SQLiteDatabase database = dbHelper.getWritableDatabase();
        Cursor cursor = database.query(DBHelper.TABLE_CONTACTS, null, null, null, null, null, null); //имя, список запрашиваемых полей, условия выборки, группировка, сортировка
        ArrayList<String> ans = new ArrayList<>();
        if (cursor.moveToFirst()) { //есть ли вообще строки и делает запись курсора активной
            int idIndex = cursor.getColumnIndex(DBHelper.KEY_ID);
            int fromIndex = cursor.getColumnIndex(DBHelper.KEY_FROM);
            do {
                String s = cursor.getString(fromIndex);
                ans.add(s);
            } while (cursor.moveToNext());
        } else
            Log.d("mLog","0 rows");

        cursor.close();

        Collections.reverse(ans);
        if(ans.size() > 0) {
            ans.add("");
            ans.add("");
            ans.add("");
        }
        String[] stat = ans.toArray(new String[ans.size()]);
        LayoutInflater ltInflater = getActivity().getLayoutInflater();

        linLayout_enter.removeAllViews();

        for (int ii = 0; ii < stat.length; ii++) {
            if(ii < 12 && !stat[ii].equals("")) {
                View item = ltInflater.inflate(R.layout.my_list_history, linLayout_enter, false);

                final Button button_history = (Button) item.findViewById(R.id.button_history);
                button_history.setText(stat[ii]);
                button_history.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String s = button_history.getText().toString();
                        Toast.makeText(getActivity(), s, Toast.LENGTH_SHORT).show();

                        Log.d("mLog","here tab3");
                        OnSelectedButtonListener listener = (OnSelectedButtonListener) getActivity();
                        listener.onButtonSelected(s);

                    }
                });

                item.getLayoutParams().width = LayoutParams.MATCH_PARENT;
                linLayout_enter.addView(item);
            }
            else if(stat[ii].equals("")) {
                View item = ltInflater.inflate(R.layout.my_list_history, linLayout_enter, false);

                final Button button_history = (Button) item.findViewById(R.id.button_history);
                button_history.setText(stat[ii]);

                item.getLayoutParams().width = LayoutParams.MATCH_PARENT;
                linLayout_enter.addView(item);
            } else {
                    database.delete(DBHelper.TABLE_CONTACTS, DBHelper.KEY_FROM + " = ?", new String[]{stat[ii]});
                }
        }


        //Toast.makeText(getActivity(), string_line, Toast.LENGTH_SHORT).show();


        dbHelper.close();

        return view;
    }

}