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
import edu.gatech.seclass.sdpvocabquiz.edu.gatech.seclass.sdpvocabquiz.designclasses.Quiz;

public class RemoveAdapter extends RecyclerView.Adapter<RemoveAdapter.ViewHolder> {
    List<Quiz> quizzes;

    public RemoveAdapter(List<Quiz> quizzes) {
        this.quizzes = quizzes;
    }

    @NonNull
    @Override
    public RemoveAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.remove_quiz_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RemoveAdapter.ViewHolder viewHolder, final int i) {
        viewHolder.quizName.setText(quizzes.get(i).getName());
        viewHolder.quizDef.setText(quizzes.get(i).getDescription());
        viewHolder.remove_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String quiz_name = quizzes.get(i).getName();

                //https://stackoverflow.com/questions/36747369/how-to-show-a-pop-up-in-android-studio-to-confirm-an-order
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setCancelable(true);
                builder.setMessage("Are you sure want to delete " + quiz_name + "?");
                builder.setPositiveButton("Confirm",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Quiz q = DaoUtility.getQuizByName(quiz_name);
                                DaoUtility.removeQuiz(q);
                                quizzes.remove(q);
                                // TODO make sure to also delete corresponding statistics
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
        public TextView quizName;
        public TextView quizDef;
        public LinearLayout remove_layout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            quizName = itemView.findViewById(R.id.remove_quiz_row);
            quizDef = itemView.findViewById(R.id.remove_quiz_def);
            remove_layout = itemView.findViewById(R.id.remove_layout);
        }
    }

}
