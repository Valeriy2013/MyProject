package com.sokolovskiy.activities;

import com.perm.kate.api.Api;
import com.sokolovskiy.constants.Constants;
import com.sokolovskiy.mainpackage.Account;
import com.sokolovskiy.ukrbasketsuperleague.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class NewsActivity extends Activity {
    
    private final int REQUEST_LOGIN=1;
    
    Button authorizeButton;
    Button logoutButton;
    Button postButton;
    //EditText messageEditText;
    TextView tv;
    
    Account account=new Account();
    Api vkapi;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        
        setupUI();
        
        //Во�?�?тановление �?охранённой �?е�?�?ии
        account.restore(this);
        
        //Е�?ли �?е�?�?и�? е�?ть �?оздаём API дл�? обращени�? к �?ерверу
        if(account.access_token!=null)
            vkapi=new Api(account.access_token, Constants.API_ID);
        
        showButtons();
    }

    private void setupUI() {
        authorizeButton=(Button)findViewById(R.id.authorizeVK);
        logoutButton=(Button)findViewById(R.id.logout);
        postButton=(Button)findViewById(R.id.post);
        //messageEditText=(EditText)findViewById(R.id.message);
        tv=(TextView)findViewById(R.id.tv);
        authorizeButton.setOnClickListener(authorizeClick);
        logoutButton.setOnClickListener(logoutClick);
        postButton.setOnClickListener(getPostsClick);
    }
    
    private OnClickListener authorizeClick=new OnClickListener(){
        @Override
        public void onClick(View v) {
            startLoginActivity();
        }
    };
    
    private OnClickListener logoutClick=new OnClickListener(){
        @Override
        public void onClick(View v) {
            logOut();
        }
    };
    
    private OnClickListener getPostsClick=new OnClickListener(){
        @Override
        public void onClick(View v) {
            displayNews();
        }
    };
    
    private void startLoginActivity() {
        Intent intent = new Intent();
        intent.setClass(this, LoginActivity.class);
        startActivityForResult(intent, REQUEST_LOGIN);
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_LOGIN) {
            if (resultCode == RESULT_OK) {
                //авторизовали�?ь у�?пешно 
                account.access_token=data.getStringExtra("token");
                account.user_id=data.getLongExtra("user_id", 0);
                account.save(NewsActivity.this);
                vkapi=new Api(account.access_token, Constants.API_ID);
                showButtons();
            }
        }
    }
    
    private void displayNews() {
        //Общение �? �?ервером в отдельном потоке чтобы не блокировать UI поток
    	Intent i = new Intent(getApplicationContext(),ExpandableListActivity.class);
    	startActivity(i);
    /*    new Thread(){
            @Override
            public void run(){
                try {
                    //String text=messageEditText.getText().toString();
                    //api.createWallPost(account.user_id, text, null, null, false, false, false, null, null, null, null);
                    ArrayList<WallMessage> al =  vkapi.getWallMessages(Constants.VK_GROUP_ID, 5, 10,"all");                    
                    final StringBuilder sb = new StringBuilder(); 
                    for (WallMessage wallMessage : al) {                    	                   	
						sb.append(wallMessage.text);
					}
                	//final WallMessage wm =  al.get(0);                  	
                  	//Log.i("First message to display", allPosts);
                    //Показать �?ообщение в UI потоке 
                    //runOnUiThread(successRunnable);
                    runOnUiThread(new Runnable() {
                        public void run() {
                        	tv.setMovementMethod(new ScrollingMovementMethod());
                        	tv.setText(sb.toString()+ "\n\n");
                       }
                   });
                   
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();*/
    }
    
//    Runnable successRunnable=new Runnable(){
//        @Override
//        public void run() {        	
//            Toast.makeText(getApplicationContext(), "Запи�?ь у�?пешно добавлена", Toast.LENGTH_LONG).show();
//        }
//    };
    
   
    
    private void logOut() {
        vkapi=null;
        account.access_token=null;
        account.user_id=0;
        account.save(NewsActivity.this);
        showButtons();
    }
    
    void showButtons(){
        if(vkapi!=null){
            authorizeButton.setVisibility(View.GONE);
            logoutButton.setVisibility(View.VISIBLE);
            postButton.setVisibility(View.VISIBLE);
            //messageEditText.setVisibility(View.VISIBLE);
            tv.setVisibility(View.VISIBLE);
        }else{
            authorizeButton.setVisibility(View.VISIBLE);
            logoutButton.setVisibility(View.GONE);
            postButton.setVisibility(View.GONE);
            //messageEditText.setVisibility(View.GONE);
            tv.setVisibility(View.GONE);
        }
    }
}