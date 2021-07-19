package com.example.taskcademia.Models;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.taskcademia.Interfaces.OnSignupFinishListener;
import com.example.taskcademia.View.SignUpView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.jetbrains.annotations.NotNull;

public class SignUpModel extends Activity implements com.example.taskcademia.Interfaces.SignUpModel {
    private FirebaseAuth mAuth;

    @Override
    public void userCreation(String user, String password1, String password2, OnSignupFinishListener presenter) {
        mAuth = FirebaseAuth.getInstance();
        if (password1.equals(password2)) {
            mAuth.createUserWithEmailAndPassword(user, password1)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Log.d("tag", "createUserWithEmail: success");
                                FirebaseUser user = mAuth.getCurrentUser();
                                updateUI(user);
                            } else {
                                Log.w("Tag", "createUserWithEmail:failure", task.getException());
                                Toast.makeText(SignUpModel.this, "Authentication failure", Toast.LENGTH_SHORT).show();
                                updateUI(null);
                            }
                        }

                        private void updateUI(Object o) {
                        }
                    });
        }

    }
}
