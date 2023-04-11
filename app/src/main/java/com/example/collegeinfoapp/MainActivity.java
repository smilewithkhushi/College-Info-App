package com.example.collegeinfoapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private TextView textView;

    private String[] courses = {"Physics", "Chemistry", "Maths", "Computer Science", "Biochemistry"};
    private String[] teachers = {"Mr Anuj", "Mrs Tulika", "Mrs Puneeta Saxena", "Mrs Aakanksha", "Mr Sanjeev"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        textView = findViewById(R.id.textView);

        // Create an ArrayAdapter to populate the ListView with courses
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, courses);
        listView.setAdapter(adapter);

        // Set an OnItemClickListener on the ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected course and update the TextView with the teacher-in-charge
                String selectedCourse = courses[position];
                String selectedTeacher = teachers[position];
                textView.setText("Teacher-in-charge of " + selectedCourse + ": " + selectedTeacher);
            }
        });
    }
}
