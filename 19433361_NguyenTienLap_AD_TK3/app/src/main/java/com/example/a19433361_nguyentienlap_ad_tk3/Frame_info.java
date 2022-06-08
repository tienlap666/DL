package com.example.a19433361_nguyentienlap_ad_tk3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

public class Frame_info extends Fragment {

//    int[] hinhs = {R.drawable.img1, R.drawable.ic_launcher_foreground};
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fame_info,container,false);
        ImageView img           = view.findViewById(R.id.img_ct_hinh);
        TextView txtTen         = view.findViewById(R.id.txt_ct_ten);
        TextView txtGia         = view.findViewById(R.id.txt_ct_gia);
        TextView txtChatLieu    = view.findViewById(R.id.txt_ct_chatLieu);
        TextView txtTrongLuong  = view.findViewById(R.id.txt_ct_trongLuong);
        TextView txtMoTa        = view.findViewById(R.id.txt_ct_moTa);

        getParentFragmentManager().setFragmentResultListener("data", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                img.setImageResource(result.getInt("hinh"));
                txtTen.setText(result.getString("ten").toString());
                txtGia.setText(result.getString("gia").toString());
                txtChatLieu.setText(result.getString("chatL").toString());
                txtTrongLuong.setText(result.getString("trongL").toString());
                txtMoTa.setText(result.getString("moTa").toString());
            }
        });
        return view;

    }
}
