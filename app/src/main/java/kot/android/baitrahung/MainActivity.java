package kot.android.baitrahung;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import maes.tech.intentanim.CustomIntent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openActivity2(View v) {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
        CustomIntent.customType(this, "fadein-to-fadeout");
    }
}
