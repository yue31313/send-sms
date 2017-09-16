package Sms.tension.Activity;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class sendSms extends Activity {
	private EditText mobiletext;
	private EditText contexttext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
      mobiletext = (EditText)this.findViewById(R.id.mobile);
      contexttext = (EditText)this.findViewById(R.id.content);
      Button button = (Button)this.findViewById(R.id.button);
      button.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
		String moblie= mobiletext.getText().toString();
		String content = contexttext.getText().toString();
		SmsManager smsmanager = SmsManager.getDefault();
		
		if(content.length()>70){
			List<String> contents = smsmanager.divideMessage(content);
			
			for(String sms : contents){
				
				smsmanager.sendTextMessage(moblie, null, sms, null, null);
			}	
		}
		else{
			smsmanager.sendTextMessage(moblie, null, content, null, null);	
		}
		Toast.makeText(sendSms.this, "·¢ËÍ³É¹¦",Toast.LENGTH_LONG).show();
		}
	});
        
        
        
    }
}