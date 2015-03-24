package program.androidheight.recyclerviewdemo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by PRABHU on 22-03-2015.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>  {
    public  RecyclerModal [] modal;
    private int position;
    static Context context;
    ContextMenu.ContextMenuInfo info;
    public RecyclerAdapter(RecyclerModal [] modal, Context context){
        this.modal = modal;
        this.context =context;
    }
    public RecyclerAdapter(){

    }




    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int parent) {
        View itemLayoutView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_layout,viewGroup, false);

        // create ViewHolder

        ViewHolder viewHolder = new ViewHolder(itemLayoutView);

        //set onClick listener on RecyclerView

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int position) {
        //bind the UI in the row Item
        viewHolder.txtViewName.setText(modal[position].getName());
        viewHolder.txtViewNumber.setText(modal[position].getNumber());
        viewHolder.imgViewIcon.setImageResource(modal[position].getImageUrl());

    }

    @Override
    public int getItemCount() {
        return modal.length;
    }



    //ViewHolder is used to hold the reference of each Ui of row Item
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnCreateContextMenuListener {

        public TextView txtViewName,txtViewNumber;
        public ImageView imgViewIcon;


        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            txtViewName = (TextView) itemLayoutView.findViewById(R.id.name);
            txtViewNumber = (TextView) itemLayoutView.findViewById(R.id.Number);
            imgViewIcon = (ImageView) itemLayoutView.findViewById(R.id.image);
            //set onclickListener
            itemLayoutView.setOnClickListener(this);
            //set onContextListener
            itemLayoutView.setOnCreateContextMenuListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context,DetailsActivity.class);
            intent.putExtra("name",txtViewName.getText().toString());
            intent.putExtra("number",txtViewNumber.getText().toString());
           context.startActivity(intent);
           Toast.makeText(RecyclerAdapter.context,"you have clicked Row "+getPosition(),Toast.LENGTH_LONG).show();
            }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            new RecyclerAdapter().info = menuInfo;
            menu.setHeaderTitle("Select The Action");
            menu.add(0, R.id.call, 0, "Call");//groupId, itemId, order, title
            menu.add(0, R.id.msg, 0, "SMS");


        }

    }
    }

