package com.example.formationgroupe6janv;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class HomeActivity extends AppCompatActivity {


    private TextView email,cin;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference myRef;
    private FirebaseUser user;

    private ImageView image;
    private Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        email = findViewById(R.id.testEmail);
        cin = findViewById(R.id.testCin);
        image = findViewById(R.id.imageee);

        Picasso.with(this)
                .load("https://firebasestorage.googleapis.com/v0/b/application-ff5b1.appspot.com/o/images%2Fprofile_images%2F0b6hEtG4aTcaZM2xvdt5UL65dsL2.jpg?alt=media&token=0737907a-6d4a-4033-8eb1-4e5d65ce3eed")
                .into(image );


        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();

        user = firebaseAuth.getCurrentUser();
        myRef = firebaseDatabase.getReference().child("Users").child(user.getUid());

        email.setText(user.getEmail());
        
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                cin.setText(snapshot.child("cin").getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(HomeActivity.this, "error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}