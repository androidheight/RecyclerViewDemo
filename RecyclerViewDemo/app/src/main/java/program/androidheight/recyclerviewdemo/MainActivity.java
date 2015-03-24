package program.androidheight.recyclerviewdemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends Activity {
    Context context;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context= MainActivity.this;
         recyclerView = (RecyclerView)findViewById(R.id.recycler_list);
        RecyclerModal itemsData[] = {new RecyclerModal("Ramesh", "1234567890", R.drawable.ic_launcher),
                new RecyclerModal("suresh", "2222222562", R.drawable.ic_launcher),
                new RecyclerModal("prem", "2344322341", R.drawable.ic_launcher),
                new RecyclerModal("yogesh", "4567765412", R.drawable.ic_launcher),
                new RecyclerModal("niraj", "1234554321", R.drawable.ic_launcher),
        };


        // 2. set layoutManger
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // 3. create an adapter
        RecyclerAdapter mAdapter = new RecyclerAdapter(itemsData,context);
        // 4. set adapter
        recyclerView.setAdapter(mAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


    }
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.call:
                Toast.makeText(context,"You have clicked Call" ,Toast.LENGTH_LONG).show();

                break;
            case R.id.msg:
                Toast.makeText(context,"You have clicked SMS",Toast.LENGTH_LONG).show();
                break;
        }
        return super.onContextItemSelected(item);
    }


}
