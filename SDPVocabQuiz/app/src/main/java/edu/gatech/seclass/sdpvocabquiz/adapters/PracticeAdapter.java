package edu.gatech.seclass.sdpvocabquiz.adapters;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import edu.gatech.seclass.sdpvocabquiz.Database.DaoUtility;
import edu.gatech.seclass.sdpvocabquiz.R;
import edu.gatech.seclass.sdpvocabquiz.activities.PracticeQuizActivity;
import edu.gatech.seclass.sdpvocabquiz.edu.gatech.seclass.sdpvocabquiz.designclasses.Quiz;

public class PracticeAdapter extends RecyclerView.Adapter<PracticeAdapter.ViewHolder> {

    List<Quiz> quizzes;
    PracticeQuizActivity activity;
    public PracticeAdapter(List<Quiz> quizzes, PracticeQuizActivity activity) {
        this.quizzes = quizzes;
        this.activity = activity;
    }

    @NonNull
    @Override
    public PracticeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.practice_quiz_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PracticeAdapter.ViewHolder viewHolder, final int i) {
        viewHolder.quiz_name.setText(quizzes.get(i).getName());
        viewHolder.quiz_def.setText(quizzes.get(i).getDescription());

        viewHolder.practice_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String quiz_name = quizzes.get(i).getName();

                //https://stackoverflow.com/questions/36747369/how-to-show-a-pop-up-in-android-studio-to-confirm-an-order
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setCancelable(true);
                builder.setMessage("Do you wish to practice quiz " + quiz_name + "?");
                builder.setPositiveButton("Confirm",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                activity.startQuiz(DaoUtility.getQuizByName(quiz_name));
                            }
                        });
                builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return quizzes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView quiz_name;
        public TextView quiz_def;
        public LinearLayout practice_layout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            quiz_name = itemView.findViewById(R.id.practice_name);
            quiz_def = itemView.findViewById(R.id.practice_def);
            practice_layout = itemView.findViewById(R.id.practice_layout);
        }
    }
}
