package com.sgt.primoz.macgyversolutions;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import Adapters.MacAdapter;
import MacClasses.MacSolutions;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MacSolutions.init();

        final MacAdapter adapter = new MacAdapter(this,MacSolutions.items);
        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);

        ((EditText)findViewById(R.id.txtFilter)).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                EditText lab = (EditText)findViewById(R.id.txtFilter);
                adapter.getFilter().filter(lab.getText());
            }
        });

        /*(findViewById(R.id.btnSearch)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText lab = (EditText)findViewById(R.id.txtFilter);
                adapter.getFilter().filter(lab.getText());
                //MacSolutions.search((Edit));
            }
        });*/
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
