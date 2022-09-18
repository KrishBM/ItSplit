package com.example.itsplit;

import android.annotation.SuppressLint;
        import android.content.Context;
        import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;

import androidx.annotation.NonNull;
        import androidx.annotation.RequiresApi;
        import androidx.recyclerview.widget.RecyclerView;

import com.example.itsplit.R;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

public class userAdapter extends RecyclerView.Adapter<userAdapter.MyViewHolder>{

    List<user> mUsers;
    Context mContext;
//    OnItemClickListener onItemClickListener;

    public userAdapter(List<user> mUsers, Context mContext) {
        this.mUsers = mUsers;
        this.mContext = mContext;
//        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_person, parent, false);
        return new MyViewHolder(v);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        user users = mUsers.get(position);
        holder.nm.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                users.setU_name(charSequence.toString());//TODO

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        holder.pm.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                users.setU_payment(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }
    public interface OnItemClickListener{
        void onDelete(int position);
    }
    @Override
    public int getItemCount() {
        return mUsers.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextInputEditText nm,pm;

        public MyViewHolder(View v) {
            super(v);

            nm=v.findViewById(R.id.Dname);
            pm=v.findViewById(R.id.Dpayment);
        }

    }

    public List<user> getUsers(){
        return mUsers;
    }
}

