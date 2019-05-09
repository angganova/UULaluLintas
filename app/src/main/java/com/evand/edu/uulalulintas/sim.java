package com.evand.edu.uulalulintas;

import java.util.List;
import android.database.SQLException;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.evand.edu.uulalulintas.Database.DB;
import com.evand.edu.uulalulintas.Simulasi.Question;
import com.evand.edu.uulalulintas.Simulasi.hasil;

public class sim extends Activity {
    List<Question> quesList;
    int score=0;
    int qid=0;
    Question currentQ;
    TextView txtQuestion;
    RadioButton rda, rdb;
    Button butNext;
    TextView txtid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sim);

        final DB db=new DB(this);
        try {
            db.openDB();
            Log.i("Open DB>>>>>>>>>>>>>>>>>", "Success");
        }catch(SQLException sqle){
            throw sqle;
        }
        db.close();
        quesList=db.getAllQuestions();
        currentQ=quesList.get(qid);
        txtQuestion=(TextView)findViewById(R.id.textView);
        txtid=(TextView)findViewById(R.id.tvid);
        rda=(RadioButton)findViewById(R.id.radio);
        rdb=(RadioButton)findViewById(R.id.radio2);
        butNext=(Button)findViewById(R.id.button1);
        setQuestionView();
        butNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup grp=(RadioGroup)findViewById(R.id.radioGroup1);
                RadioButton answer=(RadioButton)findViewById(grp.getCheckedRadioButtonId());
               if(answer == null)
                {
                    Toast.makeText(getBaseContext(), "Tolong dijawab dulu.", Toast.LENGTH_SHORT).show();
                }else {
                   Log.d("Jawaban DB :",  currentQ.getANSWER() + "|||||||| Jawaban User : " + answer.getText());
                   if(currentQ.getANSWER().equals(answer.getText()))
                   {
                       score++;
                       Log.d("score", "Your score"+score);

                   }


                   if(qid<10){
                       currentQ=quesList.get(qid);
                       setQuestionView();

                   }else{
                       Intent intent = new Intent(sim.this, hasil.class);
                       Bundle b = new Bundle();
                       b.putInt("score", score);
                       b.putInt("score2", score * 10);
                       intent.putExtras(b);
                       startActivity(intent);
                       finish();

                   }

               }

            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_sim, menu);
        return true;
    }
    private void setQuestionView()
    {
        RadioGroup grp=(RadioGroup)findViewById(R.id.radioGroup1);
        txtid.setText("Soal ke-" + currentQ.getID() + " dari 10 soal.");
        txtQuestion.setText(currentQ.getQUESTION());
        rda.setText(currentQ.getOPTA());
        rdb.setText(currentQ.getOPTB());
        grp.clearCheck();
        qid++;
    }
}