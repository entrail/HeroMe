package de.horstmann.herome.Activities;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import de.horstmann.herome.Fragments.MainFragment;
import de.horstmann.herome.Fragments.PickPowerFragment;
import de.horstmann.herome.R;

public class MainActivity extends AppCompatActivity implements MainFragment.OnFragmentInteractionListener, PickPowerFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = manager.findFragmentById(R.id.mainActivity_framelayout);

        if (fragment == null) {
            fragment = new MainFragment();
            manager.beginTransaction().add(R.id.mainActivity_framelayout, fragment).commit();
        }
    }

    public void loadPowerScreen() {
        PickPowerFragment pickPowerFragment = new PickPowerFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.mainActivity_framelayout, pickPowerFragment).addToBackStack(null).commit();

    }

    public void onFragmentInteraction(Uri uri) {

    }

}
