package hatim.dhuliawala.SplittheBill;

import hatim.dhuliawala.SplittheBill.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StartingPoint extends Activity implements OnClickListener {
	Button done, exit;
	EditText name = null, noOfPeople = null, total = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_starting_point);
		initialize();

	}

	private void initialize() {
		// TODO Auto-generated method stub
		done = (Button) findViewById(R.id.bDone);
		name = (EditText) findViewById(R.id.etName);
		noOfPeople = (EditText) findViewById(R.id.etNumber);
		total = (EditText) findViewById(R.id.etTotal);
		exit = (Button) findViewById(R.id.bExit);
		done.setOnClickListener(this);
		exit.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.bDone:

			try {
				String personname = name.getText().toString();
				String count = noOfPeople.getText().toString();
				String totalamount = total.getText().toString();
				String result=null;
				int countpeople = Integer.parseInt(count);
				float counttotal = Float.parseFloat(totalamount);
				float main = ((countpeople - 1) * counttotal) / countpeople;
				float individual = counttotal / countpeople;
				String mainround = String.format("%.2f", main);
				String individualround = String.format("%.2f", individual);
				if(countpeople <= 0){
					Toast.makeText(getBaseContext(), "Please Enter a Valid Number", Toast.LENGTH_LONG);
				}else if (countpeople == 1){
					result = ( personname + " will pay total amount of $" + counttotal );	
				}
				else if(countpeople > 0){
				result = (" Each Individual will pay $" + individualround+" \n and "
				+personname + " will recieve total amount of $" + mainround );
				}
				String bread = result;
				Bundle basket = new Bundle();
				basket.putString("key", bread);
				Intent a = new Intent(StartingPoint.this, Result.class);
				a.putExtras(basket);
				startActivity(a);
				this.finish();

				// Hiding Keyboard
				InputMethodManager i = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
				i.hideSoftInputFromInputMethod(total.getWindowToken(), 0);

			} catch (Exception e) {
				e.printStackTrace();
				Toast err = Toast.makeText(StartingPoint.this, "Please Enter all Value", Toast.LENGTH_LONG);
				err.show();
			}
			
		
			break;

		case R.id.bExit:
			  this.finish();
			    Intent intent = new Intent(Intent.ACTION_MAIN);
			    intent.addCategory(Intent.CATEGORY_HOME);
			    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			    startActivity(intent);
			break;
		}

	}
}