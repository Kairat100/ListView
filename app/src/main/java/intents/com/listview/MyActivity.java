package intents.com.listview;

import android.app.ListActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MyActivity extends ListActivity {

    String[] presidents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        ListView lstView = getListView();
        lstView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        lstView.setTextFilterEnabled(true);

        presidents = getResources().getStringArray(R.array.presidents_array);

        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, presidents));
    }

    public void onListItemClick(ListView parent, View v, int position, long id)
    {
        Toast.makeText(this, "You have selected "+ presidents[position], Toast.LENGTH_SHORT).show();
    }

    public void onClick(View v)
    {
        ListView lstView = getListView();

        String itemsSelected = "Selected items: \n";

        for (int i = 0; i < lstView.getCount(); i++)
        {
            if (lstView.isItemChecked(i))
            {
                itemsSelected += lstView.getItemAtPosition(i) + "\n";
            }
        }

        Toast.makeText(this, itemsSelected, Toast.LENGTH_LONG).show();
    }
}
