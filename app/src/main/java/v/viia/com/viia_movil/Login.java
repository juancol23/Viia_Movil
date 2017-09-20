package v.viia.com.viia_movil;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private Button mBtnLogin;
    private EditText mEdit_text_user;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        mEdit_text_user = (EditText) findViewById(R.id.edit_text_user);

        mBtnLogin = (Button) findViewById(R.id.btnLogin);

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLogin = new Intent(Login.this, Task.class);
                startActivity(intentLogin);
                String rUser = mEdit_text_user.getText().toString().trim();

                    Log.v("USUARIO",rUser);
                Toast.makeText(getApplicationContext(), rUser, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Login.this, Task.class);
                intent.putExtra("rUser", rUser);
                startActivity(intent);


            }
        });

    }
}
