package tech.anoxsoft.basundharaneighborhood.BloodBank.BloodGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import tech.anoxsoft.basundharaneighborhood.R;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class BloodFeedActivity extends AppCompatActivity {

    DatabaseReference reference;
    RecyclerView recyclerView;
    ArrayList<BloodModel> mlist;
    BloodAdapter adapter;
    ProgressDialog progressDialog;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_feed);

        String group= getIntent().getStringExtra("BloodGroup");
        Button button = findViewById(R.id.aptitle);

        button.setText(group+ " Blood Donor List");

        recyclerView = findViewById(R.id.bloodlist);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        progressDialog = new ProgressDialog(BloodFeedActivity.this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();


        Query query = FirebaseDatabase.getInstance().getReference("Donor")
                .orderByChild("donorBlood").limitToLast(1000).equalTo(group);


        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                progressDialog.dismiss();
                mlist = new ArrayList<>();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    mlist.add(ds.getValue(BloodModel.class));
                }
                adapter = new BloodAdapter(BloodFeedActivity.this, mlist);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(BloodFeedActivity.this, "Opsss.... Something is wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
