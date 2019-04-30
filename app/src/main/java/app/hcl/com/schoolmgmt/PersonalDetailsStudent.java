package app.hcl.com.schoolmgmt;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class PersonalDetailsStudent extends Fragment implements View.OnClickListener{

    private static final int DATE_PICKER_ID =999 ;
    int year,month,day;
    Button dateButton,dateofregButton,nextButton,cancelButton;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.student_personalinfo,container,false);


        initViews(view);
        dateButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {

        Log.d("My_log","button clicked");
    }


    public void initViews(View view)
    {
        //Button button = view.findViewById();
    }
}
