package com.example.activity1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.appcompat.R.id;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.os.Build;

public class MainActivity extends ActionBarActivity {
	Button bt1 = null;
	Button bt2 = null;
	Button bt3 = null;
	Button bt4 = null;
	Button bt5 = null;
	Button bt6 = null;
	Button bt7 = null;
	Button bt8 = null;
	Button bt9 = null;
	Button bt10 = null;
	Button bt11 = null;
	Button bt12 = null;
	Button bt13 = null;
	Button bt14 = null;
	Button bt15 = null;
	Button bt16 = null;

	TextView tx1= null;
	TextView tx2= null;
	TextView tx3= null;
	TextView tx4= null;
	TextView tx5= null;
	TextView tx6= null;
	TextView tx7= null;
	TextView tx8= null;
	TextView tx9= null;
	TextView tx10= null;
	
	Handler handler = null;
	String cmd = null;
	String out = null;
	String IP  = null;
	mylistener mls = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
        
		SystemInit();
		Intent intent = getIntent();
		IP = intent.getExtras().getString("IP");
		tx1.setText(IP);
//        bt1.setOnClickListener(new OnClickListener(){
//        	
//			@Override
//			public void onClick(View arg0) {
//				// TODO Auto-generated method stub
//				handler.post(thread);
//			}
//        	
//        });
    }
    
    class mylistener implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			switch(arg0.getId()){
				case R.id.button1:
					cmd = "00";
					handler.post(thread);
					break;
				case R.id.button2:
					cmd = "01";
					handler.post(thread);
					break;
				case R.id.button3:
					cmd = "10";
					handler.post(thread);
					break;
				case R.id.button4:
					cmd = "11";
					handler.post(thread);
					break;
				case R.id.button5:
					cmd = "20";
					handler.post(thread);
					break;
				case R.id.button6:
					cmd = "21";
					handler.post(thread);
					break;
				case R.id.button7:
					cmd = "30";
					handler.post(thread);
					break;
				case R.id.button8:
					cmd = "31";
					handler.post(thread);
					break;
				case R.id.button9:
					cmd = "40";
					handler.post(thread);
					break;
				case R.id.button10:
					cmd = "41";
					handler.post(thread);
					break;
				case R.id.button11:
					cmd = "50";
					handler.post(thread);
					break;
				case R.id.button12:
					cmd = "51";
					handler.post(thread);
					break;
				case R.id.button13:
					cmd = "60";
					handler.post(thread);
					break;
				case R.id.button14:
					cmd = "61";
					handler.post(thread);
					break;
				case R.id.button15:
					cmd = "70";
					handler.post(thread);
					break;
				case R.id.button16:
					cmd = "71";
					handler.post(thread);
					break;
			}
		}
    	
    }
    
    public void SystemInit(){
    	handler = new Handler();
    	mls = new mylistener();
    	bt1 = (Button) findViewById(R.id.button1);
    	bt2 = (Button) findViewById(R.id.button2);
    	bt3 = (Button) findViewById(R.id.button3);
    	bt4 = (Button) findViewById(R.id.button4);
    	bt5 = (Button) findViewById(R.id.button5);
    	bt6 = (Button) findViewById(R.id.button6);
    	bt7 = (Button) findViewById(R.id.button7);
    	bt8 = (Button) findViewById(R.id.button8);
    	bt9 = (Button) findViewById(R.id.button9);
    	bt10 = (Button) findViewById(R.id.button10);
    	bt11 = (Button) findViewById(R.id.button11);
    	bt12 = (Button) findViewById(R.id.button12);
    	bt13 = (Button) findViewById(R.id.button13);
    	bt14 = (Button) findViewById(R.id.button14);
    	bt15 = (Button) findViewById(R.id.button15);
    	bt16 = (Button) findViewById(R.id.button16);
    	
        tx1 = (TextView) findViewById(R.id.textView1);
        tx2 = (TextView) findViewById(R.id.textView2);
        tx3 = (TextView) findViewById(R.id.textView3);
        tx4 = (TextView) findViewById(R.id.textView4);
        tx5 = (TextView) findViewById(R.id.textView5);
        tx6 = (TextView) findViewById(R.id.textView6);
        tx7 = (TextView) findViewById(R.id.textView7);
        tx8 = (TextView) findViewById(R.id.textView8);
        tx9 = (TextView) findViewById(R.id.textView9);
        tx10= (TextView) findViewById(R.id.textView10);
        
        bt1.setOnClickListener(mls);
        bt2.setOnClickListener(mls);
        bt3.setOnClickListener(mls);
        bt4.setOnClickListener(mls);
        bt5.setOnClickListener(mls);
        bt6.setOnClickListener(mls);
        bt7.setOnClickListener(mls);
        bt8.setOnClickListener(mls);
        bt9.setOnClickListener(mls);
        bt10.setOnClickListener(mls);
        bt11.setOnClickListener(mls);
        bt12.setOnClickListener(mls);
        bt13.setOnClickListener(mls);
        bt14.setOnClickListener(mls);
        bt15.setOnClickListener(mls);
        bt16.setOnClickListener(mls);
        
    }
    
    
    Runnable thread = new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			String s = HttpRequest("http://"+IP+"/msg?msg=",cmd);
			byte[] bytes = s.getBytes();
			if(bytes.length==8)
			{
				String v = "";
				if(bytes[0]=='0'){
					v+="1:�� ";
					tx2.setText("��");
				}else{
					v+="1:�� ";
					tx2.setText("��");
				}
				
				if(bytes[1]=='0'){
					v+="2:�� ";
					tx3.setText("��");
				}else{
					v+="2:�� ";
					tx3.setText("��");
				}
				
				if(bytes[2]=='0'){
					v+="3:�� ";
					tx4.setText("��");
				}else{
					v+="3:�� ";
					tx4.setText("��");
				}
				
				if(bytes[3]=='0'){
					v+="4:�� ";
					tx5.setText("��");
				}else{
					v+="4:�� ";
					tx5.setText("��");
				}
				
				if(bytes[4]=='0'){
					v+="5:�� ";
					tx6.setText("��");
				}else{
					v+="5:�� ";
					tx6.setText("��");
				}
				
				if(bytes[5]=='0'){
					v+="6:�� ";
					tx7.setText("��");
				}else{
					v+="6:�� ";
					tx7.setText("��");
				}
				
				if(bytes[6]=='0'){
					v+="7:�� ";
					tx8.setText("��");
				}else{
					v+="7:�� ";
					tx8.setText("��");
				}
				
				if(bytes[7]=='0'){
					v+="8:�� ";
					tx9.setText("��");
				}else{
					v+="8:�� ";
					tx9.setText("��");
				}
				tx10.setText(v);
			}
			else
				tx10.setText("ʧ��");
			System.out.println(s);
			
		}
	};
    
	public String HttpRequest(String IP,String value){
		 try {
			//1.��ˮԴ--����URL
	            URL url = new URL(IP+value);
	            //2.��ˮբ--openConnection
	            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
	            //3.���ܵ�--InputStream
	            InputStream inputStream = httpURLConnection.getInputStream();
	            //4.����ˮ����ˮ--InputStreamReader
	            InputStreamReader reader = new InputStreamReader(inputStream,"UTF-8");
	            //5.ˮͰʢˮ--BufferedReader
	            BufferedReader bufferedReader = new BufferedReader(reader);
	 
	            StringBuilder stringBuilder = new StringBuilder();
	            String temp = null;
	 
	            while ((temp = bufferedReader.readLine())!=null){
	                stringBuilder.append(temp);
	            }
	            bufferedReader.close();
	            reader.close();
	            inputStream.close();
	            Log.e("MAIN",stringBuilder.toString());
	            return stringBuilder.toString();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "frfgrfdtgrt";
		
	}
	
    public void click(){
    	
    }

}
