package org.dync.time;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int state=1;
    private MyCountDownTimer m;
    long time;
    Button t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        m=new MyCountDownTimer(30000,1000);
        t= (Button) findViewById(R.id.a);

        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (state==1){
                    Toast.makeText(MainActivity.this, "发送了", Toast.LENGTH_SHORT).show();
                    m.start();
                    state=2;
                }else{
                    Toast.makeText(MainActivity.this, time+"秒后才可以点击~", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    class MyCountDownTimer extends CountDownTimer{

        /**
         * @param millisInFuture    The number of millis in the future from the call
         *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
         *                          is called.
         * @param countDownInterval The interval along the way to receive
         *                          {@link #onTick(long)} callbacks.
         */
        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            time=millisUntilFinished/1000;
            t.setText(time+"");
        }

        @Override
        public void onFinish() {
            state=1;
        }
    }
}
