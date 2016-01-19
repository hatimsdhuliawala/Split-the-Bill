package hatim.dhuliawala.SplittheBill;

import hatim.dhuliawala.SplittheBill.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Result extends Activity implements OnClickListener {
	Button back, exitR;
	// EditText name, noOfPeople, total;
	TextView result;
	String gotBread;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.result);
		initialize();
	}

	private void initialize() {
		// TODO Auto-generated method stub
		result = (TextView) findViewById(R.id.tvResult);
		back = (Button) findViewById(R.id.bBack);
		exitR = (Button) findViewById(R.id.bExitResult);
		back.setOnClickListener(Result.this);
		exitR.setOnClickListener(Result.this);
		Bundle gotBasket = getIntent().getExtras();
		gotBread = gotBasket.getString("key");

		result.setText(gotBread);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.bBack:
			this.finish();
			Intent newIntent = new Intent("hatim.dhuliawala.SplittheBill.STARTINGPOINT");
			startActivity(newIntent);
			break;
			
		case R.id.bExitResult:
			this.finish();
		    Intent intent = new Intent(Intent.ACTION_MAIN);
		    intent.addCategory(Intent.CATEGORY_HOME);
		    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		    startActivity(intent);
		    break;

		}

	}
}
