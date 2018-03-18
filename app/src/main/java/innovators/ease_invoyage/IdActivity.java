package innovators.ease_invoyage;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.firebase.auth.FirebaseAuth;

public class IdActivity extends AppCompatActivity implements View.OnClickListener {

    private GoogleSignInClient mGoogleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_id);
        Intent id = getIntent();
        TextView tv= findViewById(R.id.textView20);
        TextView tv1= findViewById(R.id.textView21);
        Button so = findViewById(R.id.button11);
        String message = id.getStringExtra("EXTRA_MESSAGE");
        String message2 = id.getStringExtra("EXTRA_MESSAGE2");

        tv.setText(message);
        tv1.setText("Bus No. - "+message2);

        findViewById(R.id.button11).setOnClickListener(this);


    }


    public void onClick(View view) {
        if(view.getId() == R.id.button11){
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(this,LoginActivity.class));
        }

    }




}
