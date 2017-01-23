package me.maybewill.weather.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import me.maybewill.weather.Interface.MainInterface;
import me.maybewill.weather.Presenter.MainPresenter;
import me.maybewill.weather.R;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        final EditText edittext = (EditText) findViewById(R.id.edittext);
        button = (Button) findViewById(R.id.button);
        listView = (ListView) findViewById(R.id.listView);
        final MainPresenter mainPresenter = new MainPresenter(mainInterface);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainPresenter.getWeatherInfo(edittext.getText().toString(), listView);
            }
        });
    }

    private MainInterface mainInterface = new MainInterface() {
        @Override
        public void getWeatherInfoSuccess() {
            Toast.makeText(MainActivity.this, "查询天气成功", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void getWeatherInfoFailed() {
            Toast.makeText(MainActivity.this, "查询天气失败", Toast.LENGTH_SHORT).show();
        }
    };
}
