package sg.edu.rp.c346.id20008787.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etElement;
    Button btnAdd;
    Button btnDelete;
    Button btnClear;
    ListView lvToDo;
    Spinner spnTodo;
    ArrayList<String>alToDo;
    ArrayAdapter<String>aaTodo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etElement = findViewById(R.id.etElement);
        btnAdd = findViewById(R.id.btnAdd);
        btnDelete = findViewById(R.id.btnDelete);
        btnClear = findViewById(R.id.btnClear);
        lvToDo = findViewById(R.id.lvToDo);
        spnTodo = findViewById(R.id.spnToDo);

        alToDo = new ArrayList<>();
        alToDo.add("E.g Buy Bread Today");

        ArrayAdapter<String>aaTodo;

        aaTodo = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                alToDo);
        lvToDo.setAdapter(aaTodo);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String todo = etElement.getText().toString();
                alToDo.add(todo);
                aaTodo.notifyDataSetChanged();
                etElement.setText("");

            }
        });

        spnTodo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                case 0:
                    if (spnTodo.equals("Add a new task")) {
                        btnDelete.equals(false);
                    }
                    else {
                        btnDelete.equals(true);
                    }

                    case 1:
                        if(spnTodo.equals("Remove a task")){
                            btnAdd.equals(false);
                        }
                        else {
                            btnAdd.equals(true);
                        }
                    }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etElement.setText("");
                alToDo.clear();
                aaTodo.clear();
            }
        });

        lvToDo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,
                        "" ,Toast.LENGTH_LONG).show();
            }
        });

    }
}