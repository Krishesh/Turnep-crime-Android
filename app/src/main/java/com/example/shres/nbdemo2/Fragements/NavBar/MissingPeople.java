package com.example.shres.nbdemo2.Fragements.NavBar;


import android.app.ActivityOptions;
import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import com.example.shres.nbdemo2.Activity.NavigationDrawerActivity;
import com.example.shres.nbdemo2.FirebaseHelper;
import com.example.shres.nbdemo2.GridViewAdaptor;
import com.example.shres.nbdemo2.R;
import com.example.shres.nbdemo2.Spacecraft;
import com.example.shres.nbdemo2.ViewImageActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.security.PrivateKey;


/**
 * A simple {@link Fragment} subclass.
 */
public class MissingPeople extends Fragment

{
   GridView gridView;
    private ArrayAdapter<String> adapter;
/*    private static String[] spacecraft={"hello","bello","cejasd","kjsahd","jksahd"};
    private static String[] help={"hesallo","belsadlo","cejasadsd","kjsadsahd","jksahasdd"};*/
    DatabaseReference db;
    FirebaseHelper helper;
    EditText nameEditTxt,addressEditText,phonenumber;
    public MissingPeople() {

    }

    public static MissingPeople newInstance(){

        MissingPeople missingPeople= new MissingPeople();

        return missingPeople ;


    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_missing_people, container, false);

        gridView = view.findViewById(R.id.grid_view_missing_people);
      /*  gridView.setAdapter(new GridViewAdaptor(this));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



            }
        });*/
        //setup Firebase
        db = FirebaseDatabase.getInstance().getReference();
        helper=new FirebaseHelper(db);

        //adaptor

        adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,helper.retrieve());
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), helper.retrieve().get(position), Toast.LENGTH_SHORT).show();
            }
        });
        FloatingActionButton fab;
        fab=gridView.findViewById(R.id.fab);
      /*  fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayInputDialog();
            }
        });*/










/*

        gridView.setAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,spacecraft));
        gridView.setAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_2,help));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getActivity(),spacecraft[position], Toast.LENGTH_LONG).show();

            }
        });
*/


        return view;
    }
 /*   private void displayInputDialog()
    {
        Dialog d;
        d = new Dialog(getActivity());
        d.setTitle("Save To Firebase");
        d.setContentView(R.layout.input_dialog);

        nameEditTxt= (EditText) d.findViewById(R.id.nameEditText);
        addressEditText= (EditText) d.findViewById(R.id.propellantEditText);
        phonenumber= (EditText) d.findViewById(R.id.descEditText);
        Button saveBtn= (Button) d.findViewById(R.id.saveBtn);

        //SAVE
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //GET DATA
                String name=nameEditTxt.getText().toString();
                String propellant=addressEditText.getText().toString();
                String desc=phonenumber.getText().toString();

                //SET DATA
                Spacecraft s=new Spacecraft();
                s.setName(name);
                s.setAddress(propellant);
                s.setPhonenumber(desc);

                //SIMPLE VALIDATION
                if(name != null && name.length()>0)
                {
                    //THEN SAVE
                    if(helper.save(s))
                    {
                        //IF SAVED CLEAR EDITXT
                        nameEditTxt.setText("");
                        phonenumber.setText("");
                        addressEditText.setText("");

                        adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,helper.retrieve());
                        gridView.setAdapter(adapter);



                    }
                }else
                {
                    Toast.makeText(getActivity(), "Name Must Not Be Empty", Toast.LENGTH_SHORT).show();
                }

            }
        });

        d.show();
    }
*/


    public String toString(){
        return "Missing";
    }



}
