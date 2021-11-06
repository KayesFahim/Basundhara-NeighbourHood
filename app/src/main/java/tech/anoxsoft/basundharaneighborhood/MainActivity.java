package tech.anoxsoft.basundharaneighborhood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import tech.anoxsoft.basundharaneighborhood.BloodBank.BloodBankActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void BloodRequest(View view) {

    }

    public void BloodBank(View view) {
        startActivity(new Intent(this, BloodBankActivity.class));
    }

    public void Hospital(View view) {
    }

    public void FlatRent(View view) {

    }

    public void Pharmacy(View view) {
    }

    public void Electritian(View view) {
    }

    public void Plumber(View view) {
    }

    public void GasMechanic(View view) {
    }

    public void Bua(View view) {
    }

    public void Resturant(View view) {

    }

    public void CoffeeShop(View view) {
    }

    public void HelpLine(View view) {
    }
}