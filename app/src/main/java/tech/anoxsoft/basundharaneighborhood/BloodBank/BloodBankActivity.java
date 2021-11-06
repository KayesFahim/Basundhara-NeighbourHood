package tech.anoxsoft.basundharaneighborhood.BloodBank;

import androidx.appcompat.app.AppCompatActivity;

import tech.anoxsoft.basundharaneighborhood.BloodBank.BloodGroup.BloodFeedActivity;
import tech.anoxsoft.basundharaneighborhood.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class BloodBankActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_bank);

    }

    public void APositive(View view) {
        Intent i = new Intent(BloodBankActivity.this, BloodFeedActivity.class);
        i.putExtra("BloodGroup","A+");
        startActivity(i);
    }
    public void ANegative(View view) {
        Intent i = new Intent(BloodBankActivity.this, BloodFeedActivity.class);
        i.putExtra("BloodGroup","A-");
        startActivity(i);
    }

    public void ABPositive(View view) {
        Intent i = new Intent(BloodBankActivity.this, BloodFeedActivity.class);
        i.putExtra("BloodGroup","AB+");
        startActivity(i);
    }


    public void ABNegative(View view) {
        Intent i = new Intent(BloodBankActivity.this, BloodFeedActivity.class);
        i.putExtra("BloodGroup","AB-");
        startActivity(i);
    }

    public void BeDonor(View view) {
        startActivity(new Intent(BloodBankActivity.this, BloodFeedActivity.class));

    }

    public void BPositive(View view) {
        Intent i = new Intent(BloodBankActivity.this, BloodFeedActivity.class);
        i.putExtra("BloodGroup","B+");
        startActivity(i);
    }

    public void BNegative(View view) {
        Intent i = new Intent(BloodBankActivity.this, BloodFeedActivity.class);
        i.putExtra("BloodGroup","B-");
        startActivity(i);
    }

    public void OPositive(View view) {
        Intent i = new Intent(BloodBankActivity.this, BloodFeedActivity.class);
        i.putExtra("BloodGroup","O+");
        startActivity(i);
    }

    public void ONegative(View view) {
        Intent i = new Intent(BloodBankActivity.this, BloodFeedActivity.class);
        i.putExtra("BloodGroup","O-");
        startActivity(i);
    }
}