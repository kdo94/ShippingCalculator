package edu.orangecoastcollege.cs273.kdo94.shippingcalculator;

import android.content.Context;
import android.icu.text.NumberFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static NumberFormat currency = NumberFormat.getCurrencyInstance();

    private EditText weightEditText;
    private TextView textBaseCost;
    private TextView textAddedCost;
    private TextView textTotalCost;

    ShipItem currentPackage = new ShipItem();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weightEditText = (EditText) findViewById(R.id.weightEditText);
        textBaseCost = (TextView) findViewById(R.id.textBaseCost);
        textAddedCost = (TextView) findViewById(R.id.textAddedCost);
        textTotalCost = (TextView) findViewById(R.id.textTotalCost);

        weightEditText.requestFocus();
        InputMethodManager forceKeyboard = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        forceKeyboard.toggleSoftInput(InputMethodManager.RESULT_SHOWN, InputMethodManager.RESULT_SHOWN);

        weightEditText.addTextChangedListener(weightEditTextListener);
        textBaseCost.setText(currency.format(currentPackage.getBaseCost()));
        updateViews();
    }

    private TextWatcher weightEditTextListener = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if(s.toString().isEmpty()){
                currentPackage.setPackageWeight(0.0);
            }
            else
            {
                double amount = Double.parseDouble(s.toString());
                currentPackage.setPackageWeight(amount);
                updateViews();
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    /**
     * Will update the views of the AddedCost and TotalShippingCost
     */
    private void updateViews(){
        textAddedCost.setText(currency.format(currentPackage.getAddedCost()));
        textTotalCost.setText(currency.format(currentPackage.getTotalShippingCost()));
    }
}
