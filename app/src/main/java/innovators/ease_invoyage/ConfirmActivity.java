package innovators.ease_invoyage;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.net.URLEncoder;

public class ConfirmActivity extends DisplayActivity {


    final String myTag = "DocsUpload";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        Intent cnf = getIntent();
        TextView tv9= findViewById(R.id.textView9);
        TextView tv12= findViewById(R.id.textView12);
        TextView tv13= findViewById(R.id.textView13);
        String message = cnf.getStringExtra("EXTRA_MESSAGE");
        String msg = cnf.getStringExtra("EXTRA_MESSAGE3");

        tv12.setText(message);

        tv13.setText("Bus No. - "+msg);

        Log.i(myTag, "OnCreate()");
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                postData();

            }
        });
        t.start();


    }

    public void postData() {

        String fullUrl = "https://docs.google.com/forms/d/e/1FAIpQLScVIPYtyy1aZk4QEjn5N7u5Da2FP5upl68L68rIfx7KlH2ozg/formResponse";
        HttpRequest mReq = new HttpRequest();
        TextView tv9= findViewById(R.id.textView9);
        TextView tv12= findViewById(R.id.textView12);
        TextView tv13= findViewById(R.id.textView13);
        String col1 = tv9.getText().toString();
        String col2 = tv12.getText().toString();
        String col3 = tv13.getText().toString();

        String data = "entry.1548946172=" + URLEncoder.encode(col1) + "&" +
                "entry.1945115898=" + URLEncoder.encode(col2) + "&" +
                "entry.163084447=" + URLEncoder.encode(col3);
        String response = mReq.sendPost(fullUrl, data);
        Log.i(myTag, response);
    }

    public void pay(View View){
        TextView tv= (TextView) findViewById(R.id.textView12);
        Intent payt = new Intent(this,PayActivity.class);
        TextView tv2 = (TextView) findViewById(R.id.textView13);
        String message = tv.getText().toString();
        String message2 = tv2.getText().toString();
        payt.putExtra("EXTRA_MESSAGE", message);
        payt.putExtra("EXTRA_MESSAGE2", message2);
        startActivity(payt);
    }
}
