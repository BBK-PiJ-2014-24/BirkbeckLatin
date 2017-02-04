package layout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.snewnham.birkbecklatin.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NounGameFragment extends Fragment {


    // Constructor
    // -----------
    public NounGameFragment() {
        // Required empty public constructor
    }

    // newInstance()
    // -------------
    public static NounGameFragment newInstance(){
        return new NounGameFragment();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_verb_game, container, false);  // Inflate the layout for this mFragment


     //   TextView textView = new TextView(getActivity());
     //   textView.setText(R.string.hello_blank_fragment);


        return view;
    }

}
