package sg.edu.rp.c346.practicalquizp12;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Spinner spn;
    WebView wv;
    ArrayList<String> alNumbers;
    ArrayAdapter<String> aaNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spn = findViewById(R.id.spinner);
        wv = findViewById(R.id.WebView);

        alNumbers = new ArrayList<>();

        String[] strNumbers = getResources().getStringArray(R.array.webby);

        alNumbers.addAll(Arrays.asList(strNumbers));

        aaNumbers = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, alNumbers);

        spn.setAdapter(aaNumbers);

        spn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = spn.getSelectedItemPosition();

                if (pos==0) {
                    String url = "https://www.facebook.com";
                    wv.loadUrl(url);
                } else {
                    String url = "https://www.twitter.com";
                    wv.loadUrl(url);
                }
            }
        });
    }
}
