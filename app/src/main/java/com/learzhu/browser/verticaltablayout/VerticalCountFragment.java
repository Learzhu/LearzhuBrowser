package com.learzhu.browser.verticaltablayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.learzhu.browser.R;

/**
 * VerticalCountFragment.java是液总汇的类。
 *
 * @author Learzhu
 * @version 2.0.0 2019-06-06 11:47
 * @update Learzhu 2019-06-06 11:47
 * @updateDes
 * @include {@link }
 * @used {@link }
 */
public class VerticalCountFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = View.inflate(getActivity(), R.layout.fragment_vertical_count, null);
        TextView cte = (TextView) inflate.findViewById(R.id.tv);
        Bundle arguments = getArguments();
        String name = arguments.getString("name");
        Log.e("chen", "onCreateView: ------" + name);
        cte.setText("动态fragment：" + name);
        return inflate;
    }
}
