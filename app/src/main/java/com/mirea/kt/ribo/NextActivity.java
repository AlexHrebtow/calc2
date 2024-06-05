package com.mirea.kt.ribo;


import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import androidx.appcompat.app.AppCompatActivity;




public class NextActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView operation, result;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.next_activity);

        operation = findViewById(R.id.operation);
        result = findViewById(R.id.result);


        int[] buttons = {
                R.id.b_zero, R.id.b_one, R.id.b_twoo, R.id.b_three, R.id.b_four, R.id.b_five,
                R.id.b_six, R.id.b_seven, R.id.b_eight, R.id.b_nine, R.id.b_plus, R.id.b_minus,
                R.id.b_multiply, R.id.b_palka, R.id.b_sqrt, R.id.b_log10, R.id.b_log,
                R.id.b_leftb, R.id.b_rightb, R.id.b_xy, R.id.b_mod, R.id.b_sin,
                R.id.b_cos, R.id.b_pi, R.id.b_exp, R.id.b_doublezero, R.id.b_dot,
                R.id.b_ravno, R.id.b_AC, R.id.b_back
        };

        for (int id : buttons) {
            findViewById(id).setOnClickListener(this);
        }
    }


    @Override
    public void onClick(View view) {
        int id = view.getId();




        if (id == R.id.b_zero || id == R.id.b_one || id == R.id.b_twoo || id == R.id.b_three || id == R.id.b_four ||
                id == R.id.b_five || id == R.id.b_six || id == R.id.b_seven || id == R.id.b_eight || id == R.id.b_nine) {

            String number = ((TextView) view).getText().toString();
            operation.append(number);

        } else if (id == R.id.b_plus) {
            operation.append("+");

        } else if (id == R.id.b_minus) {
            operation.append("-");

        } else if (id == R.id.b_multiply) {
            operation.append("*");

        } else if (id == R.id.b_palka) {
            operation.append("/");

        } else if (id == R.id.b_sqrt) {
            operation.append("sqrt(");

        } else if (id == R.id.b_log10) {
            operation.append("log10(");

        } else if (id == R.id.b_log) {
            operation.append("log(");

        } else if (id == R.id.b_leftb) {
            operation.append("(");

        } else if (id == R.id.b_rightb) {
            operation.append(")");

        } else if (id == R.id.b_xy) {
            operation.append("^");

        } else if (id == R.id.b_mod) {
            operation.append("%");

        } else if (id == R.id.b_sin) {
            operation.append("sin(");

        } else if (id == R.id.b_cos) {
            operation.append("cos(");

        } else if (id == R.id.b_pi) {
            operation.append("pi");

        } else if (id == R.id.b_exp) {
            operation.append("e");

        } else if (id == R.id.b_doublezero) {
            operation.append("00");

        } else if (id == R.id.b_dot) {
            operation.append(".");

        } else if (id == R.id.b_zero) {
            operation.append("0");

        } else if (id == R.id.b_ravno) {
            String expression = operation.getText().toString();

            result.setText(eval(expression));

        } else if (id == R.id.b_AC) {
            operation.setText("");
            result.setText("");

        } else if (id == R.id.b_back) {
            String currentOperation = operation.getText().toString();
            if (!currentOperation.isEmpty()) {
                operation.setText(currentOperation.substring(0, currentOperation.length() - 1));
            }
        }
    }

    private String eval(String expression) {
        try {
            if (expression == null || expression.isEmpty()) {
                return "Error";
            }
            Expression exp = new ExpressionBuilder(expression).build();
            double result = exp.evaluate();
            return Double.toString(result);
        } catch (Exception e) {
            return "Error";
        }
    }
}
