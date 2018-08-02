package id.co.pln.ipro;

import android.app.ActionBar;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import id.co.pln.ipro.R;
import id.co.pln.ipro.api.ApiGenerator;
import id.co.pln.ipro.api.IproClient;
import id.co.pln.ipro.clsumum.config;
import id.co.pln.ipro.model.LoginClass;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 4741G on 06/12/2017.
 */

public class LoginActivity extends AppCompatActivity {
    TextView mTvUsername, mTvPassword;
    Button mButton;

    IproClient mSourceClient;

    String mMsg;

    private ProgressDialog mProgreesDialog;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        TextInputLayout textInputLayout = (TextInputLayout) findViewById(R.id.EtParent1);
        textInputLayout.setHintTextAppearance(R.style.CustomHintColor);

        TextInputLayout textInputLayout2 = (TextInputLayout) findViewById(R.id.EtParent2);
        textInputLayout2.setHintTextAppearance(R.style.CustomHintColor);

        changeActionBarFont();

        mProgreesDialog = new ProgressDialog(this);
        mProgreesDialog.setMessage("Authenticating...");

        mButton = (Button) findViewById(R.id.btn_login);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                config.getVibrate(LoginActivity.this);
                mProgreesDialog.show();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            CallLoginAPI();
                        } catch (JSONException e) {
                            mProgreesDialog.dismiss();
                            e.printStackTrace();
                        }
                    }
                }, 2000);
            }
        });
    }

    public void CallLoginAPI() throws JSONException {
        if (!validate()) {
            onLoginFailed();
            mProgreesDialog.dismiss();
            return;
        }

        JSONObject ajsonobj = new JSONObject();
        ajsonobj.put("username", mTvUsername.getText().toString());
        ajsonobj.put("password", mTvPassword.getText().toString());

        mSourceClient = ApiGenerator.createService(IproClient.class);
        final Call<LoginClass> call = mSourceClient.LoginUser(ajsonobj.toString());
        call.enqueue(new Callback<LoginClass>() {
            @Override
            public void onResponse(Response<LoginClass> response) {
                config.LOGIN_CLASS = response.body();
                if (config.LOGIN_CLASS != null) {
                    config.LOGIN_CLASS.setUsername(mTvUsername.getText().toString());
                    config.LOGIN_CLASS.setPassword(mTvPassword.getText().toString());
                    if (config.LOGIN_CLASS.getStatus() == 1) {
                        Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(LoginActivity.this, config.LOGIN_CLASS.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(LoginActivity.this, "No Internet Connection", Toast.LENGTH_LONG).show();
                }
                mProgreesDialog.dismiss();
            }

            @Override
            public void onFailure(Throwable t) {
                mProgreesDialog.dismiss();
            }
        });
    }

    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

        mButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        mTvUsername = (EditText) findViewById(R.id.input_username);
        mTvPassword = (EditText) findViewById(R.id.input_password);

        if (mTvUsername.getText().toString().isEmpty()) {
            mTvUsername.setError("enter a valid username");
            valid = false;
        } else {
            mTvUsername.setError(null);
        }

        if (mTvPassword.getText().toString().isEmpty()) {
            mTvPassword.setError("enter a valid password");
            valid = false;
        } else {
            mTvPassword.setError(null);
        }
        return valid;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.logo) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void changeActionBarFont() {
        TextView tv = new TextView(getApplicationContext());
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
        tv.setLayoutParams(lp);
        tv.setText("IPRO");
        tv.setTextSize(14);
        tv.setTextColor(getResources().getColor(R.color.colorBlack));
        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/pacifico.ttf");
        tv.setTypeface(tf);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(tv);
    }
}
