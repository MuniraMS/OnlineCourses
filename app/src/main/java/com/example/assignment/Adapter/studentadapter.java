package com.example.assignment.Adapter;
import android.widget.ArrayAdapter;
import com.example.assignment.model.student;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.assignment.R;
import java.util.ArrayList;
public class studentadapter extends ArrayAdapter<student> {
    Context context;
    public studentadapter (Context context, ArrayList<student>students){
        super (context,R.layout.layout,students);
        this.context=context;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.layout,parent,false);
        student s= getItem (position);
        TextView nameTextView = item.findViewById(R.id.nameval);
        TextView idTextView = item.findViewById(R.id.IDval);
        TextView levelTextView = item.findViewById(R.id.lvlval);
        nameTextView.setText(s.getName());
        idTextView.setText("" +s.getID());
        levelTextView.setText(""+s.getLevel());
        return item;
    }
}
