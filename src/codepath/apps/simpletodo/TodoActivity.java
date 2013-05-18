package codepath.apps.simpletodo;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class TodoActivity extends Activity {
	ArrayList<String> items;
	ArrayAdapter<String> itemsAdapter;
	ListView lvItems;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);
        lvItems = (ListView) findViewById(R.id.lvItems);
        items = new ArrayList<String>();
        itemsAdapter = new ArrayAdapter<String>(this, 
        		android.R.layout.simple_list_item_1, items);
        lvItems.setAdapter(itemsAdapter);
        items.add("First Item");
        items.add("Second Item");
        setupListViewListener();
    }
    
    private void setupListViewListener() {
        lvItems.setOnItemLongClickListener(new OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> aView, 
					View item, int pos, long id) {
				items.remove(pos);
				itemsAdapter.notifyDataSetInvalidated();
				return true;
			}
       });
	}

	public void addTodoItem(View v) {
    	EditText etNewItem = (EditText) 
    			findViewById(R.id.etNewItem);
    	itemsAdapter.add(etNewItem.getText().toString());
    	etNewItem.setText("");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.todo, menu);
        return true;
    }
    

}
