package innovators.ease_invoyage;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        Intent payt = getIntent();
        TextView tv2= findViewById(R.id.textView2);
        TextView tv8= findViewById(R.id.textView8);
        String message = payt.getStringExtra("EXTRA_MESSAGE");
        String msg = payt.getStringExtra("EXTRA_MESSAGE2");
        tv8.setVisibility(View.GONE);
        TextView tv3=  findViewById(R.id.textView2);
        tv3.setVisibility(View.GONE);
        tv2.setText(message);

        tv8.setText(msg);
    }

    public void id(View View) {
        Intent id = new Intent(this, IdActivity.class);
        TextView tv8= (TextView) findViewById(R.id.textView8);
        TextView tv2= (TextView) findViewById(R.id.textView2);
        String message = tv2.getText().toString();
        String message2 = tv8.getText().toString();
        id.putExtra("EXTRA_MESSAGE", message);
        id.putExtra("EXTRA_MESSAGE2", message2);
        startActivity(id);
        String button_text;
        button_text = ((Button) View).getText().toString();
        if (button_text.equals("Pay")) {



            Intent intent = new Intent(getApplicationContext(), IdActivity.class);
            PendingIntent pIntent = PendingIntent.getActivity(getApplicationContext(),
                    (int) System.currentTimeMillis(), intent, 0);

            NotificationCompat.Builder mBuilder =
                    (NotificationCompat.Builder) new NotificationCompat.Builder(getApplicationContext())
                            .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                            .setSmallIcon(R.drawable.eiv1)
                            .setContentTitle("Ticket Details")
                            .setContentText("Ticket ID: IN2819")
                            .setContentIntent(pIntent);

            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(0, mBuilder.build());

        }
    }
}
