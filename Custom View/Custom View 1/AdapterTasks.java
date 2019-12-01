package in.bitcode.customview2;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterTasks extends BaseAdapter  {

    private Context mContext;
    private ArrayList<Task> mListTasks;

    public AdapterTasks( Context context, ArrayList<Task> tasks ) {
        mContext = context;
        mListTasks = tasks;
    }

    @Override
    public int getCount() {
        return mListTasks.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        TaskView taskView;

        if( convertView == null ) {
            taskView = new TaskView( mContext );
        }
        else {
            taskView = (TaskView) convertView;
        }

        Task task = mListTasks.get( position );

        taskView.setTask( task );

        return taskView;
    }
}
