package com.example.convert_currency;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.currency_convert.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    int from, to;
    EditText et;
    TextView result;
    double GBPToVND = 30200, EURToVND = 27400, USDToVND = 23175, AUDToVND = 16500, CNYToVND = 3400, BATToVND = 740, RUBToVND = 300, JPYToVND = 220, WONToVND = 20.3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner_From = (Spinner) findViewById(R.id.spinner_1);
        Spinner spinner_To = (Spinner) findViewById(R.id.spinner_2);

        List<String> list_into = new ArrayList<String>();
        list_into.add("Việt Nam Đồng(VND)");
        list_into.add("Bảng Anh()");
        list_into.add("Nhân Dân Tệ(CNY)");
        list_into.add("Dollar Úc(AUD)");
        list_into.add("EURO(EUR)");
        list_into.add("Yên Nhật(JPY)");
        list_into.add("Rúp Nga(RUB)");
        list_into.add("WON Hàn Quốc(WON)");
        list_into.add("Dollar Mỹ(USD)");
        list_into.add("Bạt Thái(BAT)");

        List<String> list_to = new ArrayList<String>();
        list_to.add("Việt Nam Đồng(VND)");
        list_to.add("Bảng Anh(GBP)");
        list_to.add("Nhân Dân Tệ(CNP)");
        list_to.add("Dollar Úc(AUD)");
        list_to.add("EURO(EUR)");
        list_to.add("Yên Nhật(JPY)");
        list_to.add("Rúp Nga(RUB)");
        list_to.add("WON Hàn Quốc(WON)");
        list_to.add("Dollar Mỹ(USD)");
        list_to.add("Bạt Thái(BAT)");

        ArrayAdapter<String> adapter_1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list_into);
        adapter_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_From.setAdapter(adapter_1);

        spinner_From.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                from = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        ArrayAdapter<String> adapter_2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list_to);
        adapter_2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_To.setAdapter(adapter_2);

        spinner_To.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                to = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        et = findViewById(R.id.input);
        result = findViewById(R.id.result);

        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                result.setText(vndToResult(et.getText().toString()) + " ");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public double inputToVND(String s) {
        double s_double = Double.parseDouble(s);
        double vnd = 0.0;
        switch (from) {
            case 0:
                vnd = s_double;
                break;
            case 1:
                vnd = s_double * GBPToVND;
                break;
            case 2:
                vnd = s_double * CNYToVND;
                break;
            case 3:
                vnd = s_double * AUDToVND;
                break;
            case 4:
                vnd = s_double * EURToVND;
                break;
            case 5:
                vnd = s_double * JPYToVND;
                break;
            case 6:
                vnd = s_double * RUBToVND;
                break;
            case 7:
                vnd = s_double * WONToVND;
                break;
            case 8:
                vnd = s_double * USDToVND;
                break;
            case 9:
                vnd = s_double * BATToVND;
                break;
        }
        return vnd;
    }

    public double vndToResult(String s) {
        double vnd = inputToVND(s);
        double result = 0.0;
        switch (to) {
            case 0:
                result = vnd;
                break;
            case 1:
                result = vnd / GBPToVND;
                break;
            case 2:
                result = vnd / CNYToVND;
                break;
            case 3:
                result = vnd / AUDToVND;
                break;
            case 4:
                result = vnd / EURToVND;
                break;
            case 5:
                result = vnd / JPYToVND;
                break;
            case 6:
                result = vnd / RUBToVND;
                break;
            case 7:
                result = vnd / WONToVND;
                break;
            case 8:
                result = vnd / USDToVND;
                break;
            case 9:
                result = vnd / BATToVND;
                break;
        }
        return result;
    }
}