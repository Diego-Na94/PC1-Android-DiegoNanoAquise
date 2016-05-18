package pe.edu.ulima.diegonanoa.pc1_android_diegonanoaquise.Login;


import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import pe.edu.ulima.diegonanoa.pc1_android_diegonanoaquise.Beans.*;
import pe.edu.ulima.diegonanoa.pc1_android_diegonanoaquise.Beans.LoginRequest;
import pe.edu.ulima.diegonanoa.pc1_android_diegonanoaquise.GridView.ListaEquiposActivity;
import pe.edu.ulima.diegonanoa.pc1_android_diegonanoaquise.R;
import pe.edu.ulima.diegonanoa.pc1_android_diegonanoaquise.Remote.AlumnosService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    Button bLogin;
    EditText etUsername, etPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername=(EditText)findViewById(R.id.etUsername);
        etPassword=(EditText)findViewById(R.id.etPassword);
        bLogin = (Button)findViewById(R.id.bLogin);

        bLogin.setOnClickListener(this);

        setTitle("Login");
    }

    @Override
    public void onClick(View view) {
        final String user = etUsername.getText().toString();
        final String pass = etPassword.getText().toString();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://1-dot-pichangers-1307.appspot.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AlumnosService service = retrofit.create(AlumnosService.class);
        LoginRequest loginRequest = new LoginRequest(user,pass);
        service.login(loginRequest).enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                        Log.d("myTag","----------login1----------"+response.body().toString());
                        LoginResponse loginMsg = response.body();
                        Log.d("myTag","----------login2----------"+loginMsg.getMsg());
                        if(loginMsg.getMsg().equals("OK")){
                            Intent intent = new Intent(LoginActivity.this, ListaEquiposActivity.class);
                            //Intent intent = new Intent(LoginActivity.this, InformacionEquipos.class);
                            LoginActivity.this.startActivity(intent);
                        } else {
                            onLoginIncorrecto();
                        }

                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {

                    }
                });

    }

    public void onLoginIncorrecto() {
        Toast.makeText(
                this,
                "Registro incorrecto, intente nuevamente",
                Toast.LENGTH_SHORT
        ).show();
        etUsername.setText("");
        etPassword.setText("");
    }
}
