package com.gmra.gabriel.burn_inamoledtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class how_prevent extends AppCompatActivity {
    ListView listView;

    String[] mobileArray = {
            "1. Lower screen brightness and timeout.",
            "2. Use an immersive full-screen mode",
            "3. Use OLED-friendly wallpapers.",
            "4. Change launcher.",
            "5. Install an OLED friendly dark icons",
            "6. Use dark mode theme.",
            "7. You can even install an OLED-friendly keyboard"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_prevent);



        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.activity_listview, mobileArray);

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }
}
