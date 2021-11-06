package tech.anoxsoft.basundharaneighborhood.BloodBank.BloodGroup;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import tech.anoxsoft.basundharaneighborhood.R;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;


public class BloodAdapter extends RecyclerView.Adapter<BloodAdapter.MyViewHolder> {

    Context context;
    ArrayList<BloodModel> model;

    public BloodAdapter(Context c, ArrayList<BloodModel> m) {
        context = c;
        model = m;
    }

    @NonNull
    @Override
    public BloodAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.donor_listview, parent, false));
    }

    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull final BloodAdapter.MyViewHolder holder, @SuppressLint("RecyclerView") final int pos) {
        holder.name.setText(model.get(pos).getDonorName());
        holder.location.setText("Location:  "+model.get(pos).getDonorLocation());




        String Age = model.get(pos).getDonorAge();


        Date date = new Date();
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date startDate = null;
        try {
            startDate = sdf.parse(Age);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String stringDate = sdf.format(date);
        Date endDate = null;
        try {
            endDate = sdf.parse(stringDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        OffsetDateTime startOdt = startDate.toInstant().atOffset(ZoneOffset.UTC);

        OffsetDateTime endOdt = endDate.toInstant().atOffset(ZoneOffset.UTC);

        int years = Period.between(startOdt.toLocalDate(), endOdt.toLocalDate()).getYears();

        holder.age.setText("Age:  " + String.valueOf(years));


        //Last Donation
        String lDonation = model.get(pos).donorLastDonation;
        Date lastDonation = null;
        try {
            lastDonation = sdf.parse(lDonation);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Date today = null;
        try {
            today = sdf.parse(stringDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        assert lastDonation != null;
        OffsetDateTime Lastdonation = lastDonation.toInstant().atOffset(ZoneOffset.UTC);


        assert today != null;
        OffsetDateTime todayDate = today.toInstant().atOffset(ZoneOffset.UTC);

        int days = Period.between(Lastdonation.toLocalDate(), todayDate.toLocalDate()).getDays();

        String daysAgo = String.valueOf(days);

        holder.lastDate.setText("Last Donation " + daysAgo +" Days Ago");




        final String Phone = model.get(pos).getDonorPhone();


        holder.hCallbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String mphone = model.get(pos).getDonorPhone().toString();

                String s = "tel:" + mphone;
                Intent mintent = new Intent(Intent.ACTION_VIEW);
                mintent.setData(Uri.parse(s));

                try {
                    context.startActivity(mintent);
                } catch (ActivityNotFoundException activityNotFoundException) {
                    Toast.makeText(context, "You Dont have Any Dialar App", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }


    @Override
    public int getItemCount() {
        return model.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView name, age, location,lastDate, hCallbtn;
        public MyViewHolder(View itemView) {
            super(itemView);
            name =  itemView.findViewById(R.id.donorname);
            age =  itemView.findViewById(R.id.donorage);
            location =  itemView.findViewById(R.id.location);
            lastDate =  itemView.findViewById(R.id.lastdate);
            hCallbtn =  itemView.findViewById(R.id.call);
        }

    }
}