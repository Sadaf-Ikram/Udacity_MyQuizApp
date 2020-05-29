package android.example.myquizapp;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int score = 0;

    /**
     * Question 1 answer
     * @param view check RadioButton when the team is selected
     */
    public void onRadioButtonClickedQuestion1(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId())  {
            case R.id.hugsy:
                if (checked)
                    getIntent().putExtra("score", 1);
                break;
            case R.id.waggle:
                if (checked)
                    break;
            case R.id.snowflake:
                if (checked)
                    break;
        }
    }

    /**
     * Question 2 answer
     * @param view check RadioButton when the player is selected
     */
    public void onRadioButtonClickedQuestion2(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId())  {
            case R.id.Sally_Roberts:
                if (checked)
                    getIntent().putExtra("score", 1);
                break;
            case R.id.amy_welsh:
                if (checked)
                    break;
            case R.id.valerie_thompson:
                if (checked)
                    break;
        }
    }

    /**
     * Question 3 answer
     * @param view check RadioButton when the player is selected
     */
    public void onRadioButtonClickedQuestion3(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId())  {
            case R.id.key_hook:
                if (checked)
                    break;
            case R.id.coat_hook:
                if (checked)
                    getIntent().putExtra("score", 1);
                break;
            case R.id.frame:
                if (checked)
                    break;
        }
    }

    /**
     * Question 5 answer
     * @param view check RadioButton when the player is selected
     */
    public void onRadioButtonClickedQuestion4(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId())  {
            case R.id.chef:
                getIntent().putExtra("score", 1);
                if (checked)
                    break;
            case R.id.soldier:
                if (checked)
                    break;
            case R.id.firefighter:
                if (checked)
                    break;
        }
    }

    /**
     *
     * Check the correct answers
     * calculate score
     * create Toast message with score
     *
     */

    public void showQuizScore (View view) {

        RadioButton hugsyRadioButton = (RadioButton) findViewById(R.id.hugsy);
        boolean isHugsy = hugsyRadioButton.isChecked();

        RadioButton amyRadioButton = (RadioButton) findViewById(R.id.amy_welsh);
        boolean isAmy = amyRadioButton.isChecked();

        RadioButton frameRadioButton = (RadioButton) findViewById(R.id.frame);
        boolean isFrame = frameRadioButton.isChecked();

        CheckBox guntherCheckBox = (CheckBox) findViewById(R.id.gunther);
        boolean isGunther = guntherCheckBox.isChecked();

        CheckBox chandlerCheckBox = (CheckBox) findViewById(R.id.chandler);
        boolean ischandler = chandlerCheckBox.isChecked();

        CheckBox janiceCheckbox = (CheckBox) findViewById(R.id.janice);
        boolean isjanice = janiceCheckbox.isChecked();

        CheckBox joeyCheckBox = (CheckBox) findViewById(R.id.joey);
        boolean isjoey = joeyCheckBox.isChecked();

        RadioButton soldierRadioButton = (RadioButton) findViewById(R.id.soldier);
        boolean issoldier = soldierRadioButton.isChecked();

        EditText answerQuestion6 = (EditText) findViewById(R.id.edit_text_answer_6);
        boolean isWhiskerson = answerQuestion6.getText().toString().matches("Mrs. Whiskerson");

        EditText answerQuestion7 = (EditText) findViewById(R.id.edit_text_answer_7);
        boolean isgunther = answerQuestion7.getText().toString().matches("Gunther");

        int score = calculateScore(isHugsy, isAmy, isFrame, isGunther, ischandler, isjanice, isjoey, issoldier, isWhiskerson, isgunther);

        Toast.makeText(this, getString(R.string.show_quiz_score) + score + '/'+'7', Toast.LENGTH_LONG).show();

    }

    /**
     *
     * add points for correct answers
     * return real value of points
     */

    private int calculateScore(boolean isHugsy, boolean isAmy, boolean isFrame, boolean isGunther, boolean ischandler,  boolean isjanice, boolean isjoey, boolean issoldier, boolean isWhiskerson, boolean isgunther) {
        int startingScore = 0;

        if (isHugsy) {
            startingScore = startingScore + 1;
        }

        if (isAmy) {
            startingScore = startingScore + 1;
        }
        if (isFrame) {
            startingScore = startingScore + 1;
        }
        if (isGunther &&! ischandler && isjanice &&! isjoey) {
            startingScore = startingScore + 1;
        }
        if (issoldier) {
            startingScore = startingScore + 1;
        }
        if (isWhiskerson) {
            startingScore = startingScore + 1;
        }
        if (isgunther) {
            startingScore = startingScore + 1;
        }

        return score + startingScore;
    }

}