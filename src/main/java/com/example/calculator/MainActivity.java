package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity{
    //创建Button对象
    Button button1,button2,button3,button4,button5,button6,button7,button8,button9,button0;
    Button button_add,button_sub,button_mul,button_div;
    Button button_clear,button_equal,button_del;
    Button button_pot,button_sin,button_fu,button_zheng;
    EditText editT;
    boolean clear_edit;//判断文本框是否清空
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //组件实例化
        setContentView(R.layout.activity_main);
        button0=(Button) findViewById(R.id.button0);
        button1=(Button) findViewById(R.id.button1);
        button2=(Button) findViewById(R.id.button2);
        button3=(Button) findViewById(R.id.button3);
        button4=(Button) findViewById(R.id.button4);
        button5=(Button) findViewById(R.id.button5);
        button6=(Button) findViewById(R.id.button6);
        button7=(Button) findViewById(R.id.button7);
        button8=(Button) findViewById(R.id.button8);
        button9=(Button) findViewById(R.id.button9);
        button_add=(Button) findViewById(R.id.button_add);
        button_clear=(Button) findViewById(R.id.button_clear);
        button_div=(Button) findViewById(R.id.button_div);
        button_equal=(Button) findViewById(R.id.button_equal);
        button_mul=(Button) findViewById(R.id.button_mul);
        button_pot=(Button) findViewById(R.id.button_pot);
        button_sin=(Button) findViewById(R.id.button_sin);
        button_sub=(Button) findViewById(R.id.button_sub);
        button_del=(Button) findViewById(R.id.button_del);
        button_fu=(Button) findViewById(R.id.button_fu);
        button_zheng=(Button) findViewById(R.id.button_zheng);
        editT=(EditText) findViewById(R.id.editT);

        //设置事件
        button0.setOnClickListener((View.OnClickListener) this);
        button1.setOnClickListener((View.OnClickListener) this);
        button2.setOnClickListener((View.OnClickListener) this);
        button3.setOnClickListener((View.OnClickListener) this);
        button4.setOnClickListener((View.OnClickListener) this);
        button5.setOnClickListener((View.OnClickListener) this);
        button6.setOnClickListener((View.OnClickListener) this);
        button7.setOnClickListener((View.OnClickListener) this);
        button8.setOnClickListener((View.OnClickListener) this);
        button9.setOnClickListener((View.OnClickListener) this);
        button_add.setOnClickListener((View.OnClickListener) this);
        button_sub.setOnClickListener((View.OnClickListener) this);
        button_mul.setOnClickListener((View.OnClickListener) this);
        button_div.setOnClickListener((View.OnClickListener) this);
        button_sin.setOnClickListener((View.OnClickListener) this);
        button_pot.setOnClickListener((View.OnClickListener) this);
        button_clear.setOnClickListener((View.OnClickListener) this);
        button_equal.setOnClickListener((View.OnClickListener) this);
        button_del.setOnClickListener((View.OnClickListener) this);
        button_fu.setOnClickListener((View.OnClickListener) this);
        button_zheng.setOnClickListener((View.OnClickListener) this);
    }
    public void onClick(View v) {
        String str=editT.getText().toString();
        switch (v.getId()){
            case R.id.button0:
            case R.id.button1:
            case R.id.button2:
            case R.id.button3:
            case R.id.button4:
            case R.id.button5:
            case R.id.button6:
            case R.id.button7:
            case R.id.button8:
            case R.id.button9:
            case R.id.button_pot:
                if(clear_edit){
                    clear_edit=false;
                    str="";
                    editT.setText("");
                }
                editT.setText(str+((Button)v).getText());
                break;
            case R.id.button_add:
            case R.id.button_sub:
            case R.id.button_mul:
            case R.id.button_div:
                if(clear_edit){
                    clear_edit=false;
                    str="";
                    editT.setText("");
                }
                if(str.contains("+")||str.contains("-")||str.contains("x")||str.contains("/")) {
                    str=str.substring(0,str.indexOf(" "));
                }
                editT.setText(str+" "+((Button)v).getText()+" ");
                break;
            case R.id.button_del://判断是否为空，然后在进行删除
                if(clear_edit){
                    clear_edit=false;
                    str="";
                    editT.setText("");
                }
                else if(str!=null&&!str.equals("")){
                    editT.setText(str.substring(0,str.length()-1));
                }
            case R.id.button_clear:
                if(clear_edit)
                    clear_edit=false;
                    str="";
                editT.setText("");
                break;
            case R.id.button_sin:
            case R.id.button_equal: //单独运算最后结果
                getResult();//调用下面的方法
                break;
            case R.id.button_fu:
                getFu()；
                break;
            case R.id.button_zheng;
                getZheng();
                break;
        }
    }
    private  void getFu(){
        String exp=editT.getText().toString();
        if(exp==null||exp.equals("")) return ;
        if(!exp.contains(" ")){
            return ;
        }
        if(clear_edit){
            clear_edit=false;
            return;
        }
        clear_edit=true;
        double cnt=0-Double.parseDouble(exp);
        editT.setText(cnt+"");
    }
    private void getZheng(){
        String exp=editT.getText().toString();
        if(exp==null||exp.equals("")) return ;
        if(!exp.contains(" ")){
            return ;
        }
        if(clear_edit){
            clear_edit=false;
            return;
        }
        clear_edit=true;
        double D=Double.parseDouble(exp);
        double cnt=0;
        if(D>=0){
            cnt=D;
        }else cnt=0-D;
        editT.setText(cnt+"");
    }
    private void getResult() {
        String exp=editT.getText().toString();
        if(exp==null||exp.equals("")) return ;
        //因为没有运算符所以不用运算
        if(!exp.contains(" ")){
            return ;
        }
        if(clear_edit){
            clear_edit=false;
            return;
        }
        clear_edit=true;
        //截取运算符前面的字符串
        String s1=exp.substring(0,exp.indexOf(" "));
        //截取的运算符
        String op=exp.substring(exp.indexOf(" ")+1,exp.indexOf(" ")+2);
        //截取运算符后面的字符串
        String s2=exp.substring(exp.indexOf(" ")+3);
        double cnt=0;
        if(!s1.equals("")&&!s2.equals("")){
            double d1=Double.parseDouble(s1);
            double d2=Double.parseDouble(s2);
            if(op.equals("+")){
                cnt=d1+d2;
            }
            if(op.equals("-")){
                cnt=d1-d2;
            }
            if(op.equals("x")){
                cnt=d1*d2;
            }
            if(op.equals("/")){
                if(d2==0) cnt=0;
                else cnt=d1/d2;
            }
            if(op.equals("sin")) {
                cnt=Math.sin(d1);
            }
            if(!s1.contains(".")&&!s2.contains(".")&&!op.equals("/")) {
                int res = (int) cnt;
                editT.setText(res+"");
            }else {
               editT.setText(cnt+"");}
        }
        //如果s1是空 s2不是空 就执行下一步
        else if(!s1.equals("")&&s2.equals("")){
            double d1=Double.parseDouble(s1);
            if(op.equals("+")){
                cnt=d1;
            }
            if(op.equals("-")){
                cnt=d1;
            }
            if(op.equals("x")){
                cnt=0;
            }
            if(op.equals("/")){
                cnt=0;
            }
            if(op.equals("sin")) {
                cnt=0;
            }
            if(!s1.contains(".")) {
                int res = (int) cnt;
                editT.setText(res+"");
            }else {
                editT.setText(cnt+"");}
        }
        //如果s1是空 s2不是空 就执行下一步
        else if(s1.equals("")&&!s2.equals("")){
            double d2=Double.parseDouble(s2);
            if(op.equals("+")){
                cnt=d2;
            }
            if(op.equals("-")){
                cnt=0-d2;
            }
            if(op.equals("x")){
                cnt=0;
            }
            if(op.equals("/")){
                cnt=0;
            }
            if(!s2.contains(".")) {
                int res = (int) cnt;
                editT.setText(res+"");
            }else {
                editT.setText(cnt+"");}
        }
        else {
            editT.setText("");
        }
    }
}


