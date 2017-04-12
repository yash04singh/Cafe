package com.example.android.thecafe;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    String namep ="";
    String orderno="";
    String or ="";
    int wc=5,ch=7,hc=20,cc=25,n1=0,n2=0,n3=0,n4=0;
    int t1,t2,t3,t4,t5=0,t11=0,t22=0;
    private void dph(int number) {
        TextView pr = (TextView) findViewById(R.id.hotcoffee_view);
        pr.setText(""+number);
    }
    private void dpc(int number) {
        TextView pr = (TextView) findViewById(R.id.coldcoffee_view);
        pr.setText(""+number);
    }
    private void dpwc(int number) {
        TextView pr = (TextView) findViewById(R.id.whippedcream_view);
        pr.setText(""+number);
    }
    private void dpch(int number) {
        TextView pr = (TextView) findViewById(R.id.chocolate_view);
        pr.setText(""+number);
    }
    private void message(){
        TextView pr = (TextView) findViewById(R.id.price_text_view);
        pr.setText("You Have Exceeded Maximum Number of Coffee/Toppings We Can Make At A Time");
    }
    private void message1(){
        TextView pr = (TextView) findViewById(R.id.price_text_view);
        pr.setText("Please Check The Item and proceed ");
    }
    private void price(int num){
        TextView pr = (TextView) findViewById(R.id.price_text_view);
        pr.setText(""+ NumberFormat.getCurrencyInstance().format(num));
    }
    private void print(String s){
        TextView pr = (TextView) findViewById(R.id.price_text_view);
        pr.setText(s);
    }
    public void increment1(View view) {
        CheckBox chk1 = (CheckBox) findViewById(R.id.hotcoffee);
        if(chk1.isChecked() && n1+n2<26){
            n1 = n1 + 1;
            dph(n1);
            price(n1 * hc + n2 * cc + n3 * wc + n4 * ch);
        }else if(n1+n2>=26){
            message();
        }else{message1();}

    }
    public void increment2(View view) {
        CheckBox chk2 = (CheckBox) findViewById(R.id.coldcoffee);
        if(chk2.isChecked()&& n1+n2<26) {
            n2 = n2 + 1;
            dpc(n2);
            price(n1 * hc + n2 * cc + n3 * wc + n4 * ch);
        }else if(n2+n1>=26){
                message();

            }

        else{
            message1();
        }

    }
    public void increment3(View view) {
        CheckBox chk1 = (CheckBox) findViewById(R.id.hotcoffee);
        CheckBox chk2 = (CheckBox) findViewById(R.id.coldcoffee);
        CheckBox chk3 = (CheckBox) findViewById(R.id.whippedcream);
        if(chk3.isChecked()&&(chk1.isChecked()||chk2.isChecked())){
            n3 = n3 + 1;
            if(n3>n1+n2-n4){
                message();
                n3=n3-1;
                dpwc(n3);
            }
            else {
                price(n1*hc+n2*cc+n3*wc+n4*ch);
                dpwc(n3);
            }
        }else{
            message1();

        }

    }
    public void increment4(View view) {
        CheckBox chk1 = (CheckBox) findViewById(R.id.hotcoffee);
        CheckBox chk2 = (CheckBox) findViewById(R.id.coldcoffee);
        CheckBox chk4 = (CheckBox) findViewById(R.id.chocolate);
        if(chk4.isChecked()&&(chk1.isChecked()||chk2.isChecked())){
            n4 = n4 + 1;
            if(n4>n2+n1-n3){
                message();
                n4=n4-1;
                dpch(n4);
            }
            else {
                price(n1*hc+n2*cc+n3*wc+n4*ch);
                dpch(n4);
            }
        }else{
            message1();

        }

    }
    public void decrement1(View view) {
        CheckBox chk1 = (CheckBox) findViewById(R.id.hotcoffee);
        if(chk1.isChecked()) {
            n1=n1-1;
            dph(n1);
            price(n1 * hc + n2 * cc + n3 * wc + n4 * ch);
            if(n1==0)
              chk1.toggle();
        }else{

            message1();

        }
    }
    public void decrement2(View view) {
        CheckBox chk2 = (CheckBox) findViewById(R.id.coldcoffee);

        if(chk2.isChecked()) {
            n2 = n2 - 1;
            dpc(n2);
            price(n1 * hc + n2 * cc + n3 * wc + n4 * ch);
           if(n2==0)
               chk2.toggle();
        }else{
            message1();
        }

    }
    public void decrement3(View view) {
        CheckBox chk3 = (CheckBox) findViewById(R.id.whippedcream);
        n3 = n3 - 1;
        if(chk3.isChecked()) {

            if (n3 > 0) {
                price(n1 * hc + n2 * cc + n3 * wc + n4 * ch);

                dpwc(n3);
            }else{
                price(n1 * hc + n2 * cc + n3 * wc + n4 * ch);
                dpwc(n3);
                chk3.toggle();}
        }else{
            message1();
        }

    }
    public void decrement4(View view) {
        CheckBox chk4 = (CheckBox) findViewById(R.id.chocolate);
        n4 = n4 - 1;
        if(chk4.isChecked()){

            if(n4>0) {
                price(n1 * hc + n2 * cc + n3 * wc + n4 * ch);

                dpch(n4);
            }else {

                price(n1 * hc + n2 * cc + n3 * wc + n4 * ch);
                dpch(n4);
                chk4.toggle();}
        }else{
            message1();
        }

    }
    private void msg(){
        TextView pr =(TextView)findViewById(R.id.price_text_view);
        pr.setText("Sorry Both The Toppings Cannot Be Provided With One Coffee, And More Coffee. Thank You! ");
    }private void msgtophc(){
        TextView pr =(TextView)findViewById(R.id.toppings);
        pr.setText("Select Topping For Hot Coffee, Press OK");
    }
    private void msgtopcc(){
        TextView pr =(TextView)findViewById(R.id.toppings);
        pr.setText("Select Topping For Cold Coffee, Press OK");
    }
    private void msgt(){
        TextView pr =(TextView)findViewById(R.id.toppings);
        pr.setText("Please Select One Type of Coffee At A Time");
    }


    public void topping(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        CheckBox chk1 = (CheckBox) findViewById(R.id.hotcoffee);
        CheckBox chk2 = (CheckBox) findViewById(R.id.coldcoffee);
        CheckBox chk3 = (CheckBox) findViewById(R.id.whippedcream);
        CheckBox chk4 = (CheckBox) findViewById(R.id.chocolate);

        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.hotcoffee:
                if (checked && !chk2.isChecked()) {

                    n1=1;
                    price(n1 * hc + n2 * cc + n3 * wc + n4 * ch);
                    dph(n1);
                }else if(chk2.isChecked()){
                    if(chk1.isChecked()){
                    msgt();
                    chk1.toggle();}
                }else{ if(chk3.isChecked()){chk3.toggle();n3=0;dpwc(n3);}if(chk4.isChecked()){chk4.toggle();n4=0;dpch(n4);}n1=0;dph(n1);price(n1 * hc + n2 * cc + n3 * wc + n4 * ch);}
                break;
            case R.id.coldcoffee:
                if (checked && !chk1.isChecked()) {

                    n2=1;
                    price(n1 * hc + n2 * cc + n3 * wc + n4 * ch);
                    dpc(n2);
                    }else if(chk1.isChecked()){
                    if(chk2.isChecked()){
                       msgt();
                       chk2.toggle();}
                }else{if(chk3.isChecked()){chk3.toggle();n3=0;dpwc(n3);}if(chk4.isChecked()){chk4.toggle();n4=0;dpch(n4);}n2=0;dpc(n2);price(n1 * hc + n2 * cc + n3 * wc + n4 * ch);}

                break;
            case R.id.whippedcream:
                n3=1;
                if (checked &&(chk1.isChecked()||chk2.isChecked())&& n3+n4<=n1+n2) {
                    //wc=wc+5;
                    n3=1;
                    price(n1 * hc + n2 * cc + n3 * wc + n4 * ch);
                    dpwc(n3);
                    }else if(!chk1.isChecked() || !chk2.isChecked()){ if(chk3.isChecked()){chk3.toggle();}n3=0;dpwc(n3);price(n1 * hc + n2 * cc + n3 * wc + n4 * ch);}
                break;
            case R.id.chocolate:
                n4=1;
                if (checked &&(chk1.isChecked() ||chk2.isChecked())&& n4+n3<=n1+n2) {
                    //ch=ch+7;
                    n4=1;
                    price(n1 * hc + n2 * cc + n3 * wc + n4 * ch);
                    dpch(n4);
                    }else if(!chk1.isChecked() || !chk2.isChecked()){ if(chk4.isChecked()){chk4.toggle();}
                    n4=0;dpch(n4);
                    price(n1 * hc + n2 * cc + n3 * wc + n4 * ch);}
                break;

        }
    }
    public void n11(){
        CheckBox chk1 = (CheckBox) findViewById(R.id.hotcoffee);
        CheckBox chk3 = (CheckBox) findViewById(R.id.whippedcream);
        CheckBox chk4 = (CheckBox) findViewById(R.id.chocolate);
        t11=t11+n1;
        t1=t1+n3;
        t2=t2+n4;
        t5=t5+n1*hc+n2*cc+n3*wc+n4*ch;
        n1=0;n3=0;n4=0;
        dph(n1);dpwc(n3);dpch(n4);
        price(t5);
        chk1.toggle();
        if(chk3.isChecked())chk3.toggle();
        if(chk4.isChecked())chk4.toggle();
    }
    public void n22(){
        CheckBox chk2 = (CheckBox) findViewById(R.id.coldcoffee);
        CheckBox chk3 = (CheckBox) findViewById(R.id.whippedcream);
        CheckBox chk4 = (CheckBox) findViewById(R.id.chocolate);
        t22=t22+n2;
        t3=t3+n3;
        t4=t4+n4;
        t5=t5+n1*hc+n2*cc+n3*wc+n4*ch;
        n2=0;n3=0;n4=0;
        dpc(n2);dpwc(n3);dpch(n4);
        price(t5);
        chk2.toggle();
        if(chk3.isChecked())chk3.toggle();
        if(chk4.isChecked())chk4.toggle();
    }
    public void partialorder(View view){


        if(n1>0){

            n11();
            print(SS());
            or="";


        }else if(n2>0){
            n22();
            print(SS());
            or="";
        }
        else{message1();}

    }
    public String SS(){

        EditText inputTxt = (EditText) findViewById(R.id.name);
        String str = inputTxt.getText().toString();
        inputTxt.setText("",TextView.BufferType.EDITABLE);
        namep=namep+str;
        or=or+"Name: " + namep;
        or=or+"\nHot Coffees : " + t11;
        or=or+"\nWith :";
        or=or+"\nWhipped Cream  " + t1;
        or=or+"\nChocolate  " + t2 ;
        or=or+"\n\nCold Coffees : " + t22;
        or=or+"\nWith :";
        or=or+"\nWhipped Cream  " + t3;
        or=or+"\nChocolate  " + t4 ;
        or=or+"\nTotal" + " : " + NumberFormat.getCurrencyInstance().format(t5) + "\nThank You!";
        return(or);
    }
    public void submitorder(View view){

        orderno=orderno+namep+t5;
        print(SS());
        CheckBox chk1 = (CheckBox) findViewById(R.id.hotcoffee);
        CheckBox chk2 = (CheckBox) findViewById(R.id.coldcoffee);
        CheckBox chk3 = (CheckBox) findViewById(R.id.whippedcream);
        CheckBox chk4 = (CheckBox) findViewById(R.id.chocolate);
        if(chk1.isChecked())chk1.toggle();
        if(chk2.isChecked())chk2.toggle();
        if(chk3.isChecked())chk3.toggle();
        if(chk4.isChecked())chk4.toggle();

        t11=0;t22=0;t5=0;t1=0;t2=0;t3=0;t4=0;n1=0;n2=0;n3=0;n4=0;


    }
    public void gyb(View view) {
        if (orderno != "") {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:")); // only email apps should handle this
            intent.putExtra(Intent.EXTRA_EMAIL, "ptbrocklesner@gmail.com");
            intent.putExtra(Intent.EXTRA_SUBJECT, "Your Coffee Order Invoice no.: " + orderno);
            intent.putExtra(Intent.EXTRA_TEXT, or);

            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }

        }else{print("Please Give Order Before Generating Bill");}
    }
}
