package com.example.colorcombination;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Spinner colorSpinner;
    private Button generateButton;
    private TextView resultText;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colorSpinner = findViewById(R.id.color_spinner);
        generateButton = findViewById(R.id.generate_combinations);
        resultText = findViewById(R.id.result_text);

        // 색상 배열을 Spinner에 넣기
        final String[] colors = {"Red", "Blue", "Green", "Yellow", "Black", "White"};
        
        // Spinner에 사용할 ArrayAdapter 설정
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, colors);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        colorSpinner.setAdapter(adapter);

        // 버튼 클릭 시 색 조합 추천
        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedColor = colorSpinner.getSelectedItem().toString();
                String recommendedCombination = generateColorCombination(selectedColor);
                resultText.setText(recommendedCombination);
            }
        });
    }

    // 색에 맞는 조합 추천
    private String generateColorCombination(String color) {
        switch (color) {
            case "Red":
                return "Red과 잘 어울리는 색은 White, Black, Blue입니다.";
            case "Blue":
                return "Blue과 잘 어울리는 색은 White, Yellow, Grey입니다.";
            case "Green":
                return "Green과 잘 어울리는 색은 Black, Brown, Beige입니다.";
            case "Yellow":
                return "Yellow과 잘 어울리는 색은 Blue, White, Grey입니다.";
            case "Black":
                return "Black과 잘 어울리는 색은 White, Grey, Red입니다.";
            case "White":
                return "White와 잘 어울리는 색은 Black, Grey, Blue입니다.";
            default:
                return "색 조합을 찾을 수 없습니다.";
        }
    }
}
