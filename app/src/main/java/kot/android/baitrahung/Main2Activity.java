package kot.android.baitrahung;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

import maes.tech.intentanim.CustomIntent;

public class Main2Activity extends AppCompatActivity implements BlankFragment.OnFragmentInteractionListener {
    FrameLayout fragmentContainer;
    EditText editText;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        fragmentContainer = findViewById(R.id.fragment_container);
        editText = findViewById(R.id.edittext);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editText.getText().toString();
                openFragment(text);
            }
        });
    }

    private void openFragment(String text) {
        BlankFragment fragment = BlankFragment.newInstance(text);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        // Add 2 lần để sử dụng cả back button
        fragmentTransaction.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_to_right, R.anim.enter_from_right,R.anim.exit_to_right);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.add(R.id.fragment_container, fragment, "BLANK_FRAGMENT").commit();
    }

    @Override
    public void finish() {
        super.finish();
        CustomIntent.customType(this, "fadein-to-fadeout");
    }

    @Override
    public void onFragmentInteraction(String text) {
        editText.setText(text);
        onBackPressed();
    }
}
