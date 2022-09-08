package edu.gatech.seclass.sdpvocabquiz.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import edu.gatech.seclass.sdpvocabquiz.R;
import edu.gatech.seclass.sdpvocabquiz.activities.ViewStatisticsActivity;
import edu.gatech.seclass.sdpvocabquiz.edu.gatech.seclass.sdpvocabquiz.designclasses.Quiz;

public class ViewStatsAdapter extends RecyclerView.Adapter<ViewStatsAdapter.ViewHolder> {
    List<Quiz> quizzes;
    ViewStatisticsActivity activity;

    public ViewStatsAdapter(List<Quiz> quizzes, ViewStatisticsActivity activity) {
        this.quizzes = quizzes;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewStatsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_stats_row, viewGroup, false);
        return new ViewStatsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewStatsAdapter.ViewHolder viewHolder, final int i) {
        viewHolder.quiz_name.setText(quizzes.get(i).getName());
        viewHolder.quiz_def.setText(quizzes.get(i).getDescription());

        viewHolder.view_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String quiz_name = quizzes.get(i).getName();
                activity.viewStatisticsForQuiz(quiz_name);
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
        public LinearLayout view_layout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            quiz_name = itemView.findViewById(R.id.view_stats_name);
            quiz_def = itemView.findViewById(R.id.view_stats_def);
            view_layout = itemView.findViewById(R.id.view_stats_layout);
        }
    }
}
