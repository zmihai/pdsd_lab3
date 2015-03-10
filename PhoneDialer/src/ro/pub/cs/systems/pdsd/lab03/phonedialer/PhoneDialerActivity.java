package ro.pub.cs.systems.pdsd.lab03.phonedialer;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class PhoneDialerActivity extends Activity {
	
	EditText number;
	
	private class ButtonListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			Button b = (Button) v;
			number.setText(number.getText().toString() + b.getText());
		}
   
	}
	
	private class DelButtonListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			String toWrite = number.getText().toString();
			number.setText(toWrite.substring(0, Math.max(0, toWrite.length() - 1)));
		}
   
	}
	
	private class CallButtonListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			Intent intent = new Intent(Intent.ACTION_CALL);
			intent.setData(Uri.parse("tel:"+number.getText().toString()));
			startActivity(intent);
		}
   
	}
	
	private class EndButtonListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			PhoneDialerActivity.this.finish();
		}
   
	}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_dialer);
        
        number = (EditText) this.findViewById(R.id.editText1);
        View button_0 = this.findViewById(R.id.Button07);
        View button_1 = this.findViewById(R.id.Button06);
        View button_2 = this.findViewById(R.id.Button01);
        View button_3 = this.findViewById(R.id.Button05);
        View button_4 = this.findViewById(R.id.button3);
        View button_5 = this.findViewById(R.id.button1);
        View button_6 = this.findViewById(R.id.button2);
        View button_7 = this.findViewById(R.id.Button03);
        View button_8 = this.findViewById(R.id.Button02);
        View button_9 = this.findViewById(R.id.Button04);
        View button_star = this.findViewById(R.id.button4);
        View button_hash = this.findViewById(R.id.Button08);
        View button_call = this.findViewById(R.id.imageButton2);
        View button_end = this.findViewById(R.id.imageButton3);
        View button_del = this.findViewById(R.id.imageButton1);
        
        button_0.setOnClickListener(new ButtonListener());
        button_1.setOnClickListener(new ButtonListener());
        button_2.setOnClickListener(new ButtonListener());
        button_3.setOnClickListener(new ButtonListener());
        button_4.setOnClickListener(new ButtonListener());
        button_5.setOnClickListener(new ButtonListener());
        button_6.setOnClickListener(new ButtonListener());
        button_7.setOnClickListener(new ButtonListener());
        button_8.setOnClickListener(new ButtonListener());
        button_9.setOnClickListener(new ButtonListener());
        button_star.setOnClickListener(new ButtonListener());
        button_hash.setOnClickListener(new ButtonListener());
        button_del.setOnClickListener(new DelButtonListener());
        button_call.setOnClickListener(new CallButtonListener());
        button_end.setOnClickListener(new EndButtonListener());
        

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.phone_dialer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
