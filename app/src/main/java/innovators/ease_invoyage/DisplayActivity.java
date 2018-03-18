package innovators.ease_invoyage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class DisplayActivity extends BookActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        Intent disp = getIntent();
        TextView tv = findViewById(R.id.textView3);
        Button b = findViewById(R.id.button4);
        TextView tv2 = findViewById(R.id.textView5);
        Button b1 = findViewById(R.id.button5);
        TextView tv3 = findViewById(R.id.textView7);
        Button b2 = findViewById(R.id.button6);
        TextView tv4 = findViewById(R.id.textView4);
        tv4.setVisibility(View.GONE);
        String message = disp.getStringExtra("EXTRA_MESSAGE");
        String message2 = disp.getStringExtra("EXTRA_MESSAGE2");

        String msg1=message+" To "+message2;
        tv4.setText(msg1);

        b.setOnClickListener(this);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);

        if(message.equalsIgnoreCase("Potheri") && message2.equalsIgnoreCase("Tambaram")){
            tv.setText("Bus No. 118R         8:05 - 8:40");
            tv2.setText("Bus No. 118R         10:15 - 10:50");
            tv3.setText("Bus No. 118R         11:05 - 11:40");
            b.setText("118R");
            b1.setText("118R");
            b2.setText("118R");
        }
        else if(message.equalsIgnoreCase("Tambaram") && message2.equalsIgnoreCase("Guindy")){
            tv.setText("Bus No. 21G         10:15 - 10:53");
            tv2.setText("Bus No. 1B         11:05 - 11:43");
            tv3.setText("Bus No. 18M         12:47 - 13:25");
            b.setText("21G");
            b1.setText("1B");
            b2.setText("18M");
        }
        else if(message.equalsIgnoreCase("Tambaram") && message2.equalsIgnoreCase("Tirusalam")){
            tv.setText("Bus No. E18         9:10 - 9:40");
            tv2.setText("Bus No. G70         14:05 - 14:36");
            tv3.setText("Bus No. 118P         20:40 - 21:10");
            b.setText("E18");
            b1.setText("G70");
            b2.setText("118P");
        }
        else if(message.equalsIgnoreCase("Guindy") && message2.equalsIgnoreCase("Egmore")){
            tv.setText("Bus No. 17D         8:05 - 8:40");
            tv2.setText("Bus No. 17E         10:15 - 10:50");
            tv3.setText("Bus No. 17K         11:05 - 11:40");
            b.setText("17D");
            b1.setText("17E");
            b2.setText("17K");
        }
        else{
            tv.setText("N.A.");
            tv2.setText("N.A.");
            tv3.setText("N.A.");
            b.setEnabled(false);
            b1.setEnabled(false);
            b2.setEnabled(false);
        }
    }

    public void onClick(View view){
        Button b = findViewById(R.id.button4);
        Button b1 = findViewById(R.id.button5);
        Button b2 = findViewById(R.id.button6);
        if(view==b) {
            Intent cnf = new Intent(this, ConfirmActivity.class);
            TextView tv4 = findViewById(R.id.textView4);
            String message = tv4.getText().toString();
            String msg = ((Button) view).getText().toString();
            cnf.putExtra("EXTRA_MESSAGE", message);
            cnf.putExtra("EXTRA_MESSAGE3", msg);
            startActivity(cnf);
        }
        if(view==b1) {
            Intent cnf = new Intent(this, ConfirmActivity.class);
            TextView tv4 = findViewById(R.id.textView4);
            String message = tv4.getText().toString();
            String msg = ((Button) view).getText().toString();
            cnf.putExtra("EXTRA_MESSAGE", message);
            cnf.putExtra("EXTRA_MESSAGE3", msg);
            startActivity(cnf);
        }
        if(view==b2) {
            Intent cnf = new Intent(this, ConfirmActivity.class);
            TextView tv4 = findViewById(R.id.textView4);
            String message = tv4.getText().toString();
            String msg = ((Button) view).getText().toString();
            cnf.putExtra("EXTRA_MESSAGE", message);
            cnf.putExtra("EXTRA_MESSAGE3", msg);
            startActivity(cnf);
        }
    }


}
