package com.example.itsplit;

import androidx.appcompat.app.AppCompatActivity;
        import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;

        import android.os.Bundle;
        import android.text.TextUtils;
        import android.view.View;
        import android.widget.ArrayAdapter;
        import android.widget.AutoCompleteTextView;
        import android.widget.ImageButton;
        import android.widget.Toast;

import com.example.itsplit.R;
import com.google.android.material.button.MaterialButton;

        import org.json.JSONArray;
        import org.json.JSONObject;

        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;

public class MainActivity5 extends AppCompatActivity {

    AutoCompleteTextView total_number;
    ImageButton add_number;
    RecyclerView elements_view;
    MaterialButton split_btn;
    String current_number;

    String[] numbers ={
            "1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        total_number=findViewById(R.id.Dtotal_number);
        add_number=findViewById(R.id.Dadd_number);
        elements_view=findViewById(R.id.Delements_view);
        split_btn=findViewById(R.id.Dsplit_btn);

        List<user> userList = new ArrayList<>();

        userAdapter userAdapter=new userAdapter(userList, this);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,numbers);
        total_number.setAdapter(adapter);
        elements_view.setLayoutManager(new LinearLayoutManager(this));
        elements_view.setAdapter(userAdapter);
        total_number.setOnItemClickListener((adapterView, view, i, l) -> {
            current_number = adapterView.getItemAtPosition(i).toString();
            total_number.setText(current_number);
        });

        add_number.setOnClickListener(view -> {
            current_number=total_number.getText().toString().trim();
            if(TextUtils.isEmpty(current_number)) {
                Toast.makeText(getApplicationContext(), "Please enter a number of persons..!!", Toast.LENGTH_SHORT).show();
            }
            else {
                int Total_number=Integer.parseInt(current_number);
                for (int i = 0; i < Total_number; i++) {
                    userList.add(new user());
                    userAdapter.notifyDataSetChanged();
                }

                Toast.makeText(getApplicationContext(), "Total "+current_number+" user added.", Toast.LENGTH_SHORT).show();
            }
            total_number.setText("");
        });

        split_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<user> users = userAdapter.getUsers();///////////////////////////////

                JSONArray userAll=new JSONArray();
                for (int j3 = 0; j3 < users.size(); j3++) {
                    Map<String, String> userData= new HashMap<>();

//                    userData.put("name",itemWithId.get(String.valueOf(users.get(j3).I_Name)));//todo
//                    userData.put("payment",String.valueOf(users.get(j3).T_no));

//                    Log.d("8777777777777777",Wid);
                    userAll.put(new JSONObject(userData));

                }

                List totalUserData= new ArrayList();
                Map<String, String> userData= new HashMap<>();
                userData.put("name",users.get(0).getU_name());
                userData.put("payment",users.get(0).getU_payment());

//                Log.d("898989",u1);
            }
        });
    }
}