package com.packtbpub.practise_app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int numberOfCoffee = 0;
    int price = 20;


    /*
    Display order form to order coffee
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /*
    call when click on order button
     */
    boolean checkboxStatus;
    boolean chocolateStatus;

    public void submitOrder(View view)
    {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Coffee Order");

        EditText name = (EditText)findViewById(R.id.edittextName);
        String nameString = name.getText().toString();

        CheckBox cbox = (CheckBox)findViewById(R.id.checkBox);
        if (cbox.isChecked()) {
            checkboxStatus = true;
        } else {
            checkboxStatus = false;
        }

        CheckBox chocolatebox = (CheckBox)findViewById(R.id.checkBoxChoclate);
        if (chocolatebox.isChecked()) {
            chocolateStatus = true;
        } else {
            chocolateStatus = false;
        }

        String printMsg = createOrderMethod(checkboxStatus, chocolateStatus,nameString);
        intent.putExtra(Intent.EXTRA_TEXT, printMsg);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

       /* int price = calculatePrice();

        CheckBox cbox = (CheckBox)findViewById(R.id.checkBox);
        if (cbox.isChecked()) {
            checkboxStatus = true;
        } else {
            checkboxStatus = false;
        }

        CheckBox chocolatebox = (CheckBox)findViewById(R.id.checkBoxChoclate);
        if (chocolatebox.isChecked()) {
            chocolateStatus = true;
        } else {
            chocolateStatus = false;
        }

        EditText name = (EditText)findViewById(R.id.edittextName);
        String nameString = name.getText().toString();
        displayMsg(createOrderMethod(checkboxStatus,chocolateStatus,nameString));*/

    }

    /*
    calculate price
     */
    public int calculatePrice()
    {
        int cream = 0;
        int choco = 0;
        if(checkboxStatus == true)
        {
            cream = 1;
        }
        else if(chocolateStatus == true)
        {
            choco =2;
        }
        return numberOfCoffee * price + cream + choco;
    }

    /*show some order summery

     */
    public String createOrderMethod(boolean checkboxStatus, boolean chocolateStatus,String name)
    {
        TextView orderSummery = (TextView)findViewById(R.id.textViewOrderSummery);
        orderSummery.setText("Order Summery");

        String printMsg = getString(R.string.order_summery_name, name);
        printMsg += getString(R.string.order_summery_added_choco,checkboxStatus);
        printMsg += getString(R.string.order_summery_added_chocolate,chocolateStatus);
        printMsg += getString(R.string.order_summery_quantity,numberOfCoffee);
        int price = calculatePrice();
        printMsg += getString(R.string.order_summery_price,price);

       /* printMsg += "\n Added Chocolate ?  "+ chocolateStatus;
        printMsg += "\n Quantity = "+ numberOfCoffee;
        printMsg += "\n Price $" + calculatePrice();
        printMsg += "\n Thank you !!!!";*/
        return printMsg;
    }
    /*
    this method show some message on screen
     */
    private void displayMsg(String msg)
    {
        TextView priceTextView = (TextView)findViewById(R.id.textViewOrderSummery);
        priceTextView.setText(msg);
    }

    /*
    this display given quantity on screen
     */
    private void displayQuantity(int number)
    {
        TextView quantityTextView = (TextView)findViewById(R.id.QuantityTextView);
        quantityTextView.setText("" + number);
    }

    /*
    display price depends on quantity
     */
   /* private void displayPrice(int number)
    {
        TextView priceTextView = (TextView)findViewById(R.id.PriceTextView);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }*/
    /*
    Increment quantity funtion
     */
    public void incrementQuantity(View view)
    {
        if(numberOfCoffee >= 0 )
        {
            numberOfCoffee++;
            displayQuantity(numberOfCoffee);
          //  displayPrice(numberOfCoffee * price);
        }

    }

    /*
    Decrement quantity funtion
     */
    public void decrementQuantity(View view)
    {
        if(numberOfCoffee > 0)
        {
            numberOfCoffee--;
            displayQuantity(numberOfCoffee);
           /// displayPrice(numberOfCoffee * price);
        }

    }
}
