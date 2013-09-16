package com.sokolovskiy.activities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import org.json.JSONException;

import com.perm.kate.api.Api;
import com.perm.kate.api.KException;
import com.perm.kate.api.WallMessage;
import com.sokolovskiy.constants.Constants;
import com.sokolovskiy.mainpackage.ExpandableListAdapter;
import com.sokolovskiy.mainpackage.Parent;
import com.sokolovskiy.ukrbasketsuperleague.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ExpandableListView;

public class ExpandableListActivity extends Activity
{	
	private ExpandableListView mExpandableList;
	Api vkapi;
	 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_list);
 
 
        mExpandableList = (ExpandableListView)findViewById(R.id.expandable_list);
 
        ArrayList<Parent> arrayParents = new ArrayList<Parent>();
        ArrayList<String> arrayChildren = new ArrayList<String>();
        ArrayList<WallMessage> al = new  ArrayList<WallMessage>();
		try {
			al = vkapi.getWallMessages(Constants.VK_GROUP_ID, Constants.AMOUNT_OF_NEW_POSTS, 0,"all");
			
		} catch (MalformedURLException e) {
			Log.d("t","MalformedURLException");
			e.printStackTrace();
		} catch (IOException e) {
			Log.d("t","IOException");
			e.printStackTrace();
		} catch (JSONException e) {
			Log.d("t","JSONException");
			e.printStackTrace();
		} catch (KException e) {
			Log.d("t","KException");
			e.printStackTrace();
		}                    
        //final StringBuilder sb = new StringBuilder(); 
        //for (WallMessage wallMessage : al) {                    	                   	
		//	sb.append(wallMessage.text);
		//}
 
        //here we set the parents and the children
        for (int i = 0; i < Constants.AMOUNT_OF_NEW_POSTS; i++){
            //for each "i" create a new Parent object to set the title and the children
            Parent parent = new Parent();
            parent.setTitle("News title " + i);
             
            arrayChildren = new ArrayList<String>();
            for (int j = 1; j <= 3; j++) {
                arrayChildren.add("news text " + al.get(i).text.toString()); //+ al.get(1).text);
            }
            parent.setArrayChildren(arrayChildren);
 
            //in this array we add the Parent object. We will use the arrayParents at the setAdapter
            arrayParents.add(parent);
        }
 
        //sets the adapter that provides data to the list.
        mExpandableList.setAdapter(new ExpandableListAdapter(ExpandableListActivity.this, arrayParents));
 
    }
}
