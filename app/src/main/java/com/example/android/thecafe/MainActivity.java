package com.example.android.thecafe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    int wc=0,ch=0,hc=0,cc=0,n1=0,n2=0,n3=0,n4=0;
    boolean t1,t2,t3,t4;
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
        pr.setText("Please Check The Box and proceed ");
    }
    private void price(int num){
        TextView pr = (TextView) findViewById(R.id.price_text_view);
        pr.setText(""+ NumberFormat.getCurrencyInstance().format(num));
    }
    public void increment1(View view) {
        CheckBox chk1 = (CheckBox) findViewById(R.id.hotcoffee);
        if(chk1.isChecked()){
            n1 = n1 + 1;
            if(n1+n2>=26){
                message();
                n1=n1-1;

            }
            else {
                price(n1*hc+n2*cc+n3*wc+n4*ch);

                dph(n1);
            }
        }else{
            message1();
        }

    }
    public void increment2(View view) {
        CheckBox chk2 = (CheckBox) findViewById(R.id.coldcoffee);
        if(chk2.isChecked()){
            n2 = n2 + 1;
            if(n2+n1>=26){
                message();
                n2=n2-1;

            }
            else {
                price(n1*hc+n2*cc+n3*wc+n4*ch);

                dpc(n2);
            }
        }else{
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
        n1=n1-1;
        if(chk1.isChecked()){

            if(n1>0){
                price(n1 * hc + n2 * cc + n3 * wc + n4 * ch);

            dph(n1);
            }
            else{
                hc=hc-20;
                price(n1 * hc + n2 * cc + n3 * wc + n4 * ch);

                chk1.toggle();
            }
        }else{
            message1();
        }


    }
    public void decrement2(View view) {
        CheckBox chk2 = (CheckBox) findViewById(R.id.coldcoffee);
        n2 = n2 - 1;
        if(chk2.isChecked()){

            if(n2>0) {
                price(n1 * hc + n2 * cc + n3 * wc + n4 * ch);

                dpc(n2);
            }else{
                cc=cc-25;
                price(n1 * hc + n2 * cc + n3 * wc + n4 * ch);

                chk2.toggle();}
        }else{
            message1();
        }

    }
    public void decrement3(View view) {
        CheckBox chk3 = (CheckBox) findViewById(R.id.whippedcream);
        n3 = n3 - 1;
        if(chk3.isChecked()){

            if(n3>0) {
                price(n1 * hc + n2 * cc + n3 * wc + n4 * ch);

                dpwc(n3);
            }else{
                wc=wc-5;
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
                ch=ch-7;
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
        pr.setText("select topping for hot coffee, press OK");
    }
    private void msgtopcc(){
        TextView pr =(TextView)findViewById(R.id.toppings);
        pr.setText("select topping for cold coffee, press OK");
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
                if (checked) {
                    hc = hc + 20;
                    t1 = true;
                    n1=1;
                    dph(1);
                    msgtophc();
                    price(n1 * hc + n2 * cc + n3 * wc + n4 * ch);


                } else if(chk2.isChecked()) {
                    if(chk3.isChecked()&&chk4.isChecked()){
                        chk3.toggle();
                        chk4.toggle();
                        n3=0;n4=0;
                        dpch(0);
                        dpwc(0);
                        msg();
                    }
                    if(hc>0)
                        hc = hc - 20;
                    t1 = false;
                    n1=0;
                    dph(0);
                    price(n1 * hc + n2 * cc + n3 * wc + n4 * ch);

                }else{
                    if(hc>0)
                       hc = hc - 20;
                    t1 = false;
                    n1=0;
                    dph(0);
                    dpwc(0);
                    dpch(0);
                    if(wc>0)
                        wc=wc-5;
                    if(ch>0)
                        ch=ch-7;
                    chk3.toggle();
                    chk4.toggle();
                    if(chk3.isChecked()){chk3.toggle();}
                    if(chk4.isChecked()){chk4.toggle();}
                    price(n1 * hc + n2 * cc + n3 * wc + n4 * ch);}
                break;
            case R.id.coldcoffee:
                if (checked) {
                    cc = cc + 25;
                    t2 = true;
                    n2=1;
                    dpc(1);
                    price(n1 * hc + n2 * cc + n3 * wc + n4 * ch);

                } else if(chk1.isChecked()){
                    if(chk3.isChecked()&&chk4.isChecked()){
                        chk3.toggle();
                        chk4.toggle();
                        n3=0;n4=0;
                        dpch(0);
                        dpwc(0);
                        msg();
                    }
                    if(cc>0)
                       cc = cc - 25;
                    t2 = false;
                    n2=0;
                    dpc(0);
                    price(n1 * hc + n2 * cc + n3 * wc + n4 * ch);

                }else{
                    if(cc>0)
                      cc = cc - 25;
                    t2 = false;
                    n2=0;
                    dpc(0);
                    dpwc(0);
                    dpch(0);
                    if(wc>0)
                        wc=wc-5;
                    if(ch>0)
                        ch=ch-7;
                    chk3.toggle();
                    chk4.toggle();
                    if(chk3.isChecked()){chk3.toggle();}
                    if(chk4.isChecked()){chk4.toggle();}
                    price(n1 * hc + n2 * cc + n3 * wc + n4 * ch);}

                break;
            case R.id.whippedcream:
                n3=1;
                if (checked &&(chk1.isChecked()||chk2.isChecked())&& n3+n4<=n1+n2) {
                    wc=wc+5;
                    t3 = true;
                    n3=1;
                    dpwc(1);
                    price(n1 * hc + n2 * cc + n3 * wc + n4 * ch);

                } else if((chk1.isChecked()||chk2.isChecked())){
                    wc=wc-5;
                    t3 = false;
                    n3=0;
                    dpwc(0);
                    price(n1 * hc + n2 * cc + n3 * wc + n4 * ch);
                } else{t3 = true;
                    n3=0;
                    t3=false;
                    dpwc(0);
                    message1();
                    chk3.toggle();}
                break;
            case R.id.chocolate:
                n4=1;
                if (checked &&(chk1.isChecked() ||chk2.isChecked())&& n4+n3<=n1+n2) {
                    ch=ch+7;
                    t4=true;
                    n4=1;
                    dpch(1);
                    price(n1*hc+n2*cc+n3*wc+n4 * ch);

                } else if ((chk1.isChecked() || chk2.isChecked())) {


                    ch=ch-7;
                    t4=false;
                    n4=0;
                    dpch(0);
                    price(n1 * hc + n2 * cc + n3 * wc + n4 * ch);
                }else{
                    t4=false;
                    n4=0;
                    dpch(0);
                    message1();
                    chk4.toggle();}
                break;

        }
    }
}
