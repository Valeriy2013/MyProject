package com.sokolovskiy.activities;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.sokolovskiy.ukrbasketsuperleague.R;
import com.sokolovskiy.utils.BinderData;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;


public class PlayersActivity extends Activity {

	// XML node keys
	static final String KEY_TAG = "player"; // parent node
    static final String KEY_ID = "id";
    static final String KEY_NAME = "name";
    static final String KEY_POS= "position";
    static final String KEY_AGE = "age";
    static final String KEY_HEIGHT = "_height";
    static final String KEY_WEIGHT = "weight";
    static final String KEY_CITIZ = "citizenship";
    static final String KEY_TEAM = "team";
    static final String KEY_PHOTO = "photo";
    
    // List items 
    ListView list;
    BinderData adapter = null;
    List<HashMap<String,String>> playersDataCollection;
  
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players);
        
		try {
			
			
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
	        Document doc = docBuilder.parse (getAssets().open("playersdata.xml"));

	        playersDataCollection = new ArrayList<HashMap<String,String>>();
	        
	        // normalize text representation
            doc.getDocumentElement ().normalize ();
	                    
            NodeList playerList = doc.getElementsByTagName("player");
            
			HashMap<String,String> map = null;
			
			for (int i = 0; i < playerList.getLength(); i++) {
				 
				   map = new HashMap<String,String>(); 
				   
				   Node firstPlayerNode = playerList.item(i);
		   
//				   static final String KEY_ID = "id";
//				    static final String KEY_NAME = "name";
//				    static final String KEY_POS= "position";
//				    static final String KEY_AGE = "age";
//				    static final String KEY_HEIGHT = "_height";
//				    static final String KEY_WEIGHT = "weight";
//				    static final String KEY_CITIZ = "citizenship";
//				    static final String KEY_TEAM = "team";
//				    static final String KEY_PHOTO = "photo";
				   
	                if(firstPlayerNode.getNodeType() == Node.ELEMENT_NODE){

	                    Element firstPlayerElement = (Element)firstPlayerNode;
	                    //-------
	                    NodeList idList = firstPlayerElement.getElementsByTagName(KEY_ID);
	                    Element firstIdElement = (Element)idList.item(0);
	                    NodeList textIdList = firstIdElement.getChildNodes();	                    
	                    map.put(KEY_ID, ((Node)textIdList.item(0)).getNodeValue().trim());
	                    
	                    //2.-------
	                    NodeList nameList = firstPlayerElement.getElementsByTagName(KEY_NAME);
	                    Element firstNameElement = (Element)nameList.item(0);
	                    NodeList textNameList = firstNameElement.getChildNodes();
	                    map.put(KEY_NAME, ((Node)textNameList.item(0)).getNodeValue().trim());
	                    
	                    NodeList ageList = firstPlayerElement.getElementsByTagName(KEY_AGE);
	                    Element firstAgeElement = (Element)ageList.item(0);
	                    NodeList textAgeList = firstAgeElement.getChildNodes();
	                    map.put(KEY_AGE, ((Node)textAgeList.item(0)).getNodeValue().trim());
	                    
	                    NodeList positionList = firstPlayerElement.getElementsByTagName(KEY_POS);
	                    Element firstPositionElement = (Element)positionList.item(0);
	                    NodeList textPositionList = firstPositionElement.getChildNodes();
	                    map.put(KEY_POS, ((Node)textPositionList.item(0)).getNodeValue().trim());
	                    
	                    NodeList heightList = firstPlayerElement.getElementsByTagName(KEY_HEIGHT);
	                    Element firstHeightElement = (Element)heightList.item(0);
	                    NodeList textHeightList = firstHeightElement.getChildNodes();
	                    map.put(KEY_HEIGHT, ((Node)textHeightList.item(0)).getNodeValue().trim());
	                    
	                    NodeList weightList = firstPlayerElement.getElementsByTagName(KEY_WEIGHT);
	                    Element firstWeightElement = (Element)weightList.item(0);
	                    NodeList textWeightList = firstWeightElement.getChildNodes();
	                    map.put(KEY_WEIGHT, ((Node)textWeightList.item(0)).getNodeValue().trim());
	                    
	                    NodeList citizList = firstPlayerElement.getElementsByTagName(KEY_CITIZ);
	                    Element firstCitizElement = (Element)citizList.item(0);
	                    NodeList textCitizList = firstCitizElement.getChildNodes();
	                    map.put(KEY_CITIZ, ((Node)textCitizList.item(0)).getNodeValue().trim());
	                    
	                    NodeList teamList = firstPlayerElement.getElementsByTagName(KEY_TEAM);
	                    Element firstTeamElement = (Element)teamList.item(0);
	                    NodeList textTeamList = firstTeamElement.getChildNodes();
	                    map.put(KEY_TEAM, ((Node)textTeamList.item(0)).getNodeValue().trim());
	                    
	                    NodeList photoList = firstPlayerElement.getElementsByTagName(KEY_PHOTO);
	                    Element firstPhotoElement = (Element)photoList.item(0);
	                    NodeList textPhotoList = firstPhotoElement.getChildNodes();
	                    map.put(KEY_PHOTO, ((Node)textPhotoList.item(0)).getNodeValue().trim());
	               
	                    //Add to the Arraylist
	                    playersDataCollection.add(map);
				}		
			}
			
	
			BinderData bindingData = new BinderData(this,playersDataCollection);

						
			list = (ListView) findViewById(R.id.list);

			Log.i("BEFORE", "<<------------- Before SetAdapter-------------->>");

			list.setAdapter(bindingData);

			Log.i("AFTER", "<<------------- After SetAdapter-------------->>");

			// Click event for single list row
			list.setOnItemClickListener(new OnItemClickListener() {

				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {

					Intent i = new Intent();
					i.setClass(PlayersActivity.this, PlayerDetailsActivity.class);

					// parameters
					i.putExtra("pos", String.valueOf(position + 1));
					i.putExtra("id", playersDataCollection.get(position).get(KEY_ID));
					i.putExtra("name", playersDataCollection.get(position).get(KEY_NAME));
					i.putExtra("position", playersDataCollection.get(position).get(KEY_POS));
					i.putExtra("age", playersDataCollection.get(position).get(KEY_AGE));
					i.putExtra("_height", playersDataCollection.get(position).get(KEY_HEIGHT));
					i.putExtra("weight", playersDataCollection.get(position).get(KEY_WEIGHT));
					i.putExtra("citizenship", playersDataCollection.get(position).get(KEY_CITIZ));
					i.putExtra("team", playersDataCollection.get(position).get(KEY_TEAM));					
					i.putExtra("photo", playersDataCollection.get(position).get(KEY_PHOTO));

					// start the sample activity
					startActivity(i);
				}
			});

		}
		
		catch (IOException ex) {
			Log.e("Error", ex.getMessage());
		}
		catch (Exception ex) {
			Log.e("Error", "Loading exception");
		}
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.players, menu);
        return true;
    }
}
