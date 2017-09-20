package v.viia.com.viia_movil;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {
    private Button mBtnLogin;
    private EditText mEdit_text_user;

    SharedPreferences sp_usuario = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sp_usuario = getSharedPreferences("LOL", MODE_PRIVATE);

        mEdit_text_user = (EditText) findViewById(R.id.edit_text_user);

        mBtnLogin = (Button) findViewById(R.id.btnLogin);

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLogin = new Intent(Login.this, Task.class);
                startActivity(intentLogin);
                String rUser = mEdit_text_user.getText().toString();
                sp_usuario.edit().putString("usuario", rUser).commit();


            }
        });

    }
}
