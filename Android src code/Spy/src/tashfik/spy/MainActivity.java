package tashfik.spy;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

	
	TextView name,email,number;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		name=(TextView) findViewById(R.id.name);
		email=(TextView) findViewById(R.id.email);
		number=(TextView) findViewById(R.id.number);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}



	public void send(View v){
		
		 new Send().execute();

	}
	
	
	
	class Send extends AsyncTask<String, Void,Long > {

	   

	    protected Long doInBackground(String... urls) {	
	
	String Name=name.getText().toString();
	String Email=email.getText().toString();
	String Number=number.getText().toString();
	
	HttpClient httpclient = new DefaultHttpClient();
	HttpPost httppost = new HttpPost("http://tashfik.comuv.com/phpcode.php");

	try {
	    // Add your data
	    List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
	    nameValuePairs.add(new BasicNameValuePair("Name", Name));
	    nameValuePairs.add(new BasicNameValuePair("Email", Email));
	    nameValuePairs.add(new BasicNameValuePair("Number", Number));
	    httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

	    
	    
	    // Execute HTTP Post Request
	    HttpResponse response = httpclient.execute(httppost);

	} catch (Exception e) {
	    // TODO Auto-generated catch block
	}
	return null;
	   
}
	    protected void onProgressUpdate(Integer... progress) {
	       
	     }

	     protected void onPostExecute(Long result) {
	         
	     }
	 }
}
	 


