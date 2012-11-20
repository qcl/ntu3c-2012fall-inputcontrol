package ntu3c.t2012fall.inputcontrol;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends Activity {

	private Button mBtn1;
	private Button mBtn2;
	private ImageButton mImgBtn;
	private EditText mEditText;
	private CheckBox mCheckBox1;
	private CheckBox mCheckBox2;
	private RadioButton mRadioBtn1;
	private RadioButton mRadioBtn2;
	private ToggleButton mToggleBtn;
	private Spinner mSpinner;
	private SeekBar mSeekBar;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        /* Buttons */
        mBtn1 = (Button)findViewById(R.id.btn1);
        mBtn2 = (Button)findViewById(R.id.btn2);
        mImgBtn = (ImageButton)findViewById(R.id.imgBtn);
    
        mBtn1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(v.getContext(), "Hello,world!", Toast.LENGTH_SHORT).show();
			}
		});
        
        mBtn2.setOnLongClickListener(new View.OnLongClickListener() {
			
			@Override
			public boolean onLongClick(View v) {
				Toast.makeText(v.getContext(), "LONG click!", Toast.LENGTH_LONG).show();
				return false;
			}
		});
        
        /* EditText */
        mEditText = (EditText)findViewById(R.id.editText1);
        mEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
			
			@Override
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				boolean handled = false;
				if(actionId == EditorInfo.IME_ACTION_SEARCH){
					handled = true;
					Toast.makeText(v.getContext(), v.getText(), Toast.LENGTH_SHORT).show();
				}
				return handled;
			}
		});
        
        /* CheckBox */
        mCheckBox1 = (CheckBox)findViewById(R.id.checkBox1);
        mCheckBox2 = (CheckBox)findViewById(R.id.checkBox2);
                
        /* Radio Button */
        mRadioBtn1 = (RadioButton)findViewById(R.id.radioBtn1);
        mRadioBtn2 = (RadioButton)findViewById(R.id.radioBtn2);
        
        /* Toggle Button */
        mToggleBtn = (ToggleButton)findViewById(R.id.toggleBtn);
        mToggleBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				
				if(isChecked){
					//Do something here
				}else{
					//Do something here
				}
				
			}
		});
        
        /* Spinner */
        mSpinner = (Spinner)findViewById(R.id.spinner);
        //create a array adapter from resource
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.qcls_array, android.R.layout.simple_spinner_item);
        //set adapter
        mSpinner.setAdapter(adapter);
        
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View v,
					int pos, long id) {

				CharSequence selected = (CharSequence)parent.getItemAtPosition(pos);
				Toast.makeText(v.getContext(), selected, Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				
			}
        	
		});        
        
        /* SeekBar */
        mSeekBar = (SeekBar)findViewById(R.id.seekBar);
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				
				Toast.makeText(seekBar.getContext(), "progress="+progress, Toast.LENGTH_SHORT).show();
				
			}
		});
        
    }
    
    public void onCheckBoxClicked(View view){
    	boolean checked = ((CheckBox) view).isChecked();
    	
    	switch(view.getId()){
    		case R.id.checkBox1:
    			//Do something here.
    			break;
    		case R.id.checkBox2:
    			//Do something here.
    			break;
    		default:
    			break;
    	}
    }
    
    public void onRadioButtonClicked(View view){
    	boolean checked = ((RadioButton) view).isChecked();
    	
    	switch(view.getId()){
    		case R.id.radioBtn1:
    			//Do something here.
    			break;
    		case R.id.radioBtn2:
    			//Do something here.
    			break;
    		default:
    			break;
    	}
    }
    
  /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
  */  
}
