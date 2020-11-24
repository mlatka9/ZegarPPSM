package m.latka.timerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import java.time.LocalTime;

public class TimeActivity extends AppCompatActivity {

    TextView textView3;
    TextView textView5;
    TextView textView7;
    TextView textView9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);

        textView3 = findViewById(R.id.textView3);
        textView5 = findViewById(R.id.textView5);
        textView7 = findViewById(R.id.textView7);
        textView9 = findViewById(R.id.textView9);
        content();
    }

    public void content() {
        LocalTime localTime = LocalTime.now();
        textView3.setText(printTime(localTime));
        textView5.setText(printTime(localTime.minusHours(6)));
        textView7.setText(printTime(localTime.minusHours(1)));
        textView9.setText(printTime(localTime.plusHours(10)));

        refresh(1000);
    }

    private String printTime(LocalTime localTime) {

        StringBuilder stringBuilder = new StringBuilder();
        if (localTime.getHour() < 10) {
            stringBuilder.append("0");
        }
        stringBuilder.append(localTime.getHour());
        stringBuilder.append(":");
        if (localTime.getMinute() < 10) {
            stringBuilder.append("0");
        }
        stringBuilder.append(localTime.getMinute());
        stringBuilder.append(":");
        if (localTime.getSecond() < 10) {
            stringBuilder.append("0");
        }
        stringBuilder.append(localTime.getSecond());
        return stringBuilder.toString();
    }

    private void refresh(int milliseconds) {
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                content();
            }
        };
        handler.postDelayed(runnable, milliseconds);
    }


}