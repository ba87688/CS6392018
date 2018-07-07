package com.example.evanmaroge.stateslistproject;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class StateAdapter extends RecyclerView.Adapter<StateAdapter.StateViewHolder>{

    private Context context;
    private String[] states;

    public StateAdapter(Context context, String[] states) {
        this.context = context;
        this.states = states;
    }

    @NonNull
    @Override
    public StateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //create layout inflater
        LayoutInflater inflater = LayoutInflater.from(context);

        // now we create a view of the layout we created
        View view = inflater.inflate(R.layout.list_layout,null);

        //now createa stateviewholder instance
        StateViewHolder holder = new StateViewHolder(view);


        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull StateViewHolder holder, final int position) {

        String state = states[position];

        holder.textView.setText(state);
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("hey man, we doing this: " +position);

                if(position==4){
                    Uri url = Uri.parse("geo:38.5816,-121.4944");
                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, url);
                    mapIntent.setPackage("com.google.android.apps.maps");
                    System.out.println("hey man, we doing this: " +position);
                    context.startActivity(mapIntent);}

                if(position==7){
                    Uri url = Uri.parse("geo:39.1582,-75.5244");
                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, url);
                    mapIntent.setPackage("com.google.android.apps.maps");
                    System.out.println("hey man, we doing this: " +position);
                    context.startActivity(mapIntent);}


                if(position==8){
                    Uri url = Uri.parse("geo:30.4383,-84.2807");
                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, url);
                    mapIntent.setPackage("com.google.android.apps.maps");
                    System.out.println("hey man, we doing this: " +position);
                    context.startActivity(mapIntent);}

                else{
                    Toast.makeText(context, "Please select Deleware or Florida!", Toast.LENGTH_LONG).show();                }
            }



        });

    }

    @Override
    public int getItemCount() {
        return states.length;
    }

    class StateViewHolder extends RecyclerView.ViewHolder{

        //create UI elements to bind them
        TextView textView;
        RelativeLayout relativeLayout;

        public StateViewHolder(View itemView){
            super(itemView);

            //set the textview value
            textView = itemView.findViewById(R.id.textView);
            relativeLayout=itemView.findViewById(R.id.cons);
        }
    }

}
