package innovators.ease_invoyage;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ViewData extends AppCompatActivity implements View.OnClickListener{


    private Button btn;
    private Button btnso;
    private FirebaseAuth firebaseauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);
        btn = (Button) findViewById(R.id.button10);
        btnso = (Button) findViewById(R.id.btnso);

        btn.setOnClickListener(this);


        firebaseauth = FirebaseAuth.getInstance();

        if(firebaseauth.getCurrentUser()==null){
            finish();
            startActivity(new Intent(this, AdminLogin.class));
        }

        FirebaseUser user = firebaseauth.getCurrentUser();
        btnso.setOnClickListener(this);

    }

    public void onClick(View view) {
        btn = (Button) findViewById(R.id.button10);
        //calling register method on click
        if(view == btn){
            Uri uri = Uri.parse("https://docs.google.com/spreadsheets/d/1j4ZSobt9BnUcszsn7_qTHzUI7u031dmQo8SyW-qVrtc/edit?usp=sharing");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
        if(view==btnso){
            firebaseauth.signOut();
            finish();
            startActivity(new Intent(this, AdminLogin.class));
        }
    }
}
