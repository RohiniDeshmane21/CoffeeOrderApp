package com.packtbpub.practise_app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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
    public void submitOrder(View view)
    {
      /*  display(numberOfCoffee);
        displayPrice(numberOfCoffee * price);*/
        int price = calculatePrice();
        //String printMsg = ;
        displayMsg(createOrderMethod());
    }

    /*
    calculate price
     */
    public int calculatePrice()
    {
        return numberOfCoffee * price;
    }

    /*show some order summery

     */
    public String createOrderMethod()
    {
        String printMsg = " Name : Rohini Deshmane \n Quantity = "+ numberOfCoffee+ "\n Price $" + price + "\n Thank you !!!!";
        return printMsg;
    }
    /*
    this method show some message on screen
     */
    private void displayMsg(String msg)
    {
        TextView priceTextView = (TextView)findViewById(R.id.PriceTextView);
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
        if(numberOfCoffee >= 1 )
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
        if(numberOfCoffee > 1)
        {
            numberOfCoffee--;
            displayQuantity(numberOfCoffee);
           /// displayPrice(numberOfCoffee * price);
        }

    }
}
