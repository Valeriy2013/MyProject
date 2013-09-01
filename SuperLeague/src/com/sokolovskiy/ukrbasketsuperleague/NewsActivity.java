package com.sokolovskiy.ukrbasketsuperleague;

import java.util.ArrayList;

import com.perm.kate.api.Api;
import com.perm.kate.api.WallMessage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
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
    Api api;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        
        setupUI();
        
        //Восстановление сохранённой сессии
        account.restore(this);
        
        //Если сессия есть создаём API для обращения к серверу
        if(account.access_token!=null)
            api=new Api(account.access_token, Constants.API_ID);
        
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
                //авторизовались успешно 
                account.access_token=data.getStringExtra("token");
                account.user_id=data.getLongExtra("user_id", 0);
                account.save(NewsActivity.this);
                api=new Api(account.access_token, Constants.API_ID);
                showButtons();
            }
        }
    }
    
    private void displayNews() {
        //Общение с сервером в отдельном потоке чтобы не блокировать UI поток
        new Thread(){
            @Override
            public void run(){
                try {
                    //String text=messageEditText.getText().toString();
                    //api.createWallPost(account.user_id, text, null, null, false, false, false, null, null, null, null);
                    ArrayList<WallMessage> al =  api.getWallMessages(Constants.VK_GROUP_ID, 3, 0,"all");                    
                    final StringBuilder sb = new StringBuilder(); 
                    for (WallMessage wallMessage : al) {                    	                   	
						sb.append(wallMessage.text);
					}
                	//final WallMessage wm =  al.get(0);                  	
                  	//Log.i("First message to display", allPosts);
                    //Показать сообщение в UI потоке 
                    //runOnUiThread(successRunnable);
                    runOnUiThread(new Runnable() {
                        public void run() {
                        	tv.setMovementMethod(new ScrollingMovementMethod());
                        	tv.setText(sb.toString());
                       }
                   });
                   
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
    
//    Runnable successRunnable=new Runnable(){
//        @Override
//        public void run() {        	
//            Toast.makeText(getApplicationContext(), "Запись успешно добавлена", Toast.LENGTH_LONG).show();
//        }
//    };
    
   
    
    private void logOut() {
        api=null;
        account.access_token=null;
        account.user_id=0;
        account.save(NewsActivity.this);
        showButtons();
    }
    
    void showButtons(){
        if(api!=null){
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