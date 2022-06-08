package com.example.a19433361_nguyentienlap_ad_tk3;

import android.app.ListFragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class Frame_List extends Fragment {

    ArrayList<SanPham> arrSP;
    SanPhamAdapter SPadapter;
    int[] hinhs = {R.drawable.sp1,R.drawable.sp2,R.drawable.sp3,R.drawable.sp4,R.drawable.sp5,R.drawable.sp6 };
    GridView grV_ListSP;
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        arrSP = new ArrayList<>();
        AddSP();
        View view = inflater.inflate(R.layout.frame_list,container,false);
        grV_ListSP = view.findViewById(R.id.grv_ListSP);
        SPadapter = new SanPhamAdapter(Frame_List.this.getContext(),arrSP);
        grV_ListSP.setAdapter(SPadapter);
        grV_ListSP.deferNotifyDataSetChanged();

        grV_ListSP.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int orientation = getResources().getConfiguration().orientation;
                if (orientation == Configuration.ORIENTATION_PORTRAIT){
                    Intent intent = new Intent(Frame_List.this.getContext(),Activity_ChiTietSanPham.class);
                    intent.putExtra("id",arrSP.get(i).getId());
                    intent.putExtra("hinh",arrSP.get(i).getHinh());
                    intent.putExtra("ten",arrSP.get(i).getTen());
                    intent.putExtra("gia",arrSP.get(i).getGia());
                    intent.putExtra("chatL",arrSP.get(i).getChatLieu());
                    intent.putExtra("trongL",arrSP.get(i).getTrongLuong());
                    intent.putExtra("moTa",arrSP.get(i).getMoTa());
                    startActivity(intent);
                }else {
                    Bundle bundle=new Bundle();
                    bundle.putInt("id",arrSP.get(i).getId());
                    bundle.putInt("hinh",arrSP.get(i).getHinh());
                    bundle.putString("ten",arrSP.get(i).getTen());
                    bundle.putString("gia",arrSP.get(i).getGia());
                    bundle.putString("chatL",arrSP.get(i).getChatLieu());
                    bundle.putString("trongL",arrSP.get(i).getTrongLuong());
                    bundle.putString("moTa",arrSP.get(i).getMoTa());
                    getParentFragmentManager().setFragmentResult("data",bundle);
                }
            }
        });

        return view;
    }
    private void  AddSP(){
        arrSP.add(new SanPham(1, hinhs[0], "HG 1/144 ARCHE", "400.000d", "Nhựa", "750g", "Mô hình lắp ráp HG 1/144 ARCHE GUNDAM Bandai\n" +
                "-       Sản phậm nhựa cao cấp với độ sắc nét cao\n" +
                "-\tSản xuất bởi Bandai Namco – Nhật Bản Chính hãng\n" +
                "-\tAn toàn với trẻ em\n" +
                "-\tPhát triển trí não cho trẻ hiệu quả đi đôi với niềm vui thích bất tận\n" +
                "-\tRèn luyện tính kiên nhẫn cho người chơi\n" +
                "-\tPhân phối bởi Mô Hình GDC\n" +
                "-\tThông tin cơ bản :\n" +
                "o\tMô hình gundam (gunpla) là một loại mô hình nhựa được gọi là Model kit, bao gồm nhiều mảnh nhựa rời được gọi là part (bộ phận), khi lắp ráp các part lại với nhau sẽ được mô hình hoàn chỉnh. Các mảnh nhựa rời này được gắn trên khung nhựa gọi là runner. Mỗi một hộp sản phẩm Gunpla bao gồm nhiều runner và các phụ kiện liên quan, một tập sách nhỏ (manual) bên trong giới thiệu sơ lược về mẫu Gundam trong hộp và phần hướng dẫn cách lắp ráp.\n" +
                "o\tDòng gundam với các chi tiết hoàn hảo.\n" +
                "o\tCác khớp cử động linh hoạt theo ý muốn.\n" +
                "o\tNgười chơi sẽ thỏa sức sáng tạo và đam mê."));
        arrSP.add(new SanPham(2, hinhs[1], "HG Trans AM Raiser", "170.000d", "Nhựa", "750g", "Mô hình lắp ráp HG Trans AM Raiser\n" +
                "-       Sản phậm nhựa cao cấp với độ sắc nét cao\n" +
                "-\tAn toàn với trẻ em\n" +
                "-\tPhát triển trí não cho trẻ hiệu quả đi đôi với niềm vui thích bất tận\n" +
                "-\tRèn luyện tính kiên nhẫn cho người chơi\n" +
                "-\tPhân phối bởi Mô Hình GDC\n" +
                "-\tThông tin cơ bản :\n" +
                "o\tMô hình gundam (gunpla) là một loại mô hình nhựa được gọi là Model kit, bao gồm nhiều mảnh nhựa rời được gọi là part (bộ phận), khi lắp ráp các part lại với nhau sẽ được mô hình hoàn chỉnh. Các mảnh nhựa rời này được gắn trên khung nhựa gọi là runner. Mỗi một hộp sản phẩm Gunpla bao gồm nhiều runner và các phụ kiện liên quan, một tập sách nhỏ (manual) bên trong giới thiệu sơ lược về mẫu Gundam trong hộp và phần hướng dẫn cách lắp ráp.\n" +
                "o\tDòng gundam với các chi tiết hoàn hảo.\n" +
                "o\tCác khớp cử động linh hoạt theo ý muốn.\n" +
                "o\tNgười chơi sẽ thỏa sức sáng tạo và đam mê."));
        arrSP.add(new SanPham(3, hinhs[2], "MG LAUNCHER", "450.000d", "Nhua", "750g", "Mô hình lắp ráp MG LAUNCHER & SWORD STRIKE GUNDAM 6630S Daban\n" +
                "-       Sản phậm nhựa cao cấp với độ sắc nét cao\n" +
                "-\tAn toàn với trẻ em\n" +
                "-\tPhát triển trí não cho trẻ hiệu quả đi đôi với niềm vui thích bất tận\n" +
                "-\tRèn luyện tính kiên nhẫn cho người chơi\n" +
                "-\tPhân phối bởi Mô Hình GDC\n" +
                "-\tThông tin cơ bản :\n" +
                "o\tMô hình gundam (gunpla) là một loại mô hình nhựa được gọi là Model kit, bao gồm nhiều mảnh nhựa rời được gọi là part (bộ phận), khi lắp ráp các part lại với nhau sẽ được mô hình hoàn chỉnh. Các mảnh nhựa rời này được gắn trên khung nhựa gọi là runner. Mỗi một hộp sản phẩm Gunpla bao gồm nhiều runner và các phụ kiện liên quan, một tập sách nhỏ (manual) bên trong giới thiệu sơ lược về mẫu Gundam trong hộp và phần hướng dẫn cách lắp ráp.\n" +
                "o\tDòng gundam với các chi tiết hoàn hảo.\n" +
                "o\tCác khớp cử động linh hoạt theo ý muốn.\n" +
                "o\tNgười chơi sẽ thỏa sức sáng tạo và đam mê."));
        arrSP.add(new SanPham(4, hinhs[3], "1/100 MSF-007 MK-III", "350.000d", "Nhựa", "500g", "Mô hình lắp ráp 1/100 Gundam MSF-007 MK-III Daban\n" +
                "-       Sản phậm nhựa cao cấp với độ sắc nét cao\n" +
                "-\tAn toàn với trẻ em\n" +
                "-\tPhát triển trí não cho trẻ hiệu quả đi đôi với niềm vui thích bất tận\n" +
                "-\tRèn luyện tính kiên nhẫn cho người chơi\n" +
                "-\tPhân phối bởi Mô Hình GDC\n" +
                "-\tThông tin cơ bản :\n" +
                "o\tMô hình gundam (gunpla) là một loại mô hình nhựa được gọi là Model kit, bao gồm nhiều mảnh nhựa rời được gọi là part (bộ phận), khi lắp ráp các part lại với nhau sẽ được mô hình hoàn chỉnh. Các mảnh nhựa rời này được gắn trên khung nhựa gọi là runner. Mỗi một hộp sản phẩm Gunpla bao gồm nhiều runner và các phụ kiện liên quan, một tập sách nhỏ (manual) bên trong giới thiệu sơ lược về mẫu Gundam trong hộp và phần hướng dẫn cách lắp ráp.\n" +
                "o\tDòng gundam với các chi tiết hoàn hảo.\n" +
                "o\tCác khớp cử động linh hoạt theo ý muốn.\n" +
                "o\tNgười chơi sẽ thỏa sức sáng tạo và đam mê."));
        arrSP.add(new SanPham(5, hinhs[4], "MG Infinite Justice TThongli", "5500.000d", "Nhua", "750g", "Mô Hình Lắp Ráp Gundam MG Infinite Justice TThongli\n" +
                "-       Sản phậm nhựa cao cấp với độ sắc nét cao\n" +
                "-\tAn toàn với trẻ em\n" +
                "-\tPhát triển trí não cho trẻ hiệu quả đi đôi với niềm vui thích bất tận\n" +
                "-\tRèn luyện tính kiên nhẫn cho người chơi\n" +
                "-\tPhân phối bởi Mô Hình GDC\n" +
                "-\tThông tin cơ bản :\n" +
                "o\tMô hình gundam (gunpla) là một loại mô hình nhựa được gọi là Model kit, bao gồm nhiều mảnh nhựa rời được gọi là part (bộ phận), khi lắp ráp các part lại với nhau sẽ được mô hình hoàn chỉnh. Các mảnh nhựa rời này được gắn trên khung nhựa gọi là runner. Mỗi một hộp sản phẩm Gunpla bao gồm nhiều runner và các phụ kiện liên quan, một tập sách nhỏ (manual) bên trong giới thiệu sơ lược về mẫu Gundam trong hộp và phần hướng dẫn cách lắp ráp.\n" +
                "o\tDòng gundam với các chi tiết hoàn hảo.\n" +
                "o\tCác khớp cử động linh hoạt theo ý muốn.\n" +
                "o\tNgười chơi sẽ thỏa sức sáng tạo và đam mê.\n"));
        arrSP.add(new SanPham(6, hinhs[5], "MG Hyaku Shiki Daban 6648", "550.000d", "Nhựa", "750g", "Mô hình Gundam MG Hyaku Shiki Daban\n" +
                "-       Sản phậm nhựa cao cấp với độ sắc nét cao\n" +
                "-\tAn toàn với trẻ em\n" +
                "-\tPhát triển trí não cho trẻ hiệu quả đi đôi với niềm vui thích bất tận\n" +
                "-\tRèn luyện tính kiên nhẫn cho người chơi\n" +
                "-\tPhân phối bởi Mô Hình GDC\n" +
                "-\tThông tin cơ bản :\n" +
                "o\tMô hình gundam (gunpla) là một loại mô hình nhựa được gọi là Model kit, bao gồm nhiều mảnh nhựa rời được gọi là part (bộ phận), khi lắp ráp các part lại với nhau sẽ được mô hình hoàn chỉnh. Các mảnh nhựa rời này được gắn trên khung nhựa gọi là runner. Mỗi một hộp sản phẩm Gunpla bao gồm nhiều runner và các phụ kiện liên quan, một tập sách nhỏ (manual) bên trong giới thiệu sơ lược về mẫu Gundam trong hộp và phần hướng dẫn cách lắp ráp.\n" +
                "o\tDòng gundam với các chi tiết hoàn hảo.\n" +
                "o\tCác khớp cử động linh hoạt theo ý muốn.\n" +
                "o\tNgười chơi sẽ thỏa sức sáng tạo và đam mê."));
    }
}
