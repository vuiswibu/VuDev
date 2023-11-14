package vn.huynhnamvu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MonAnAdapter extends BaseAdapter {
    private ArrayList<MonAn> dsMonAn;
    private LayoutInflater layoutInflater;
    private Context context;

    public MonAnAdapter(ArrayList<MonAn> dsMonAn, Context _context) {
        this.dsMonAn = dsMonAn;
        this.context = _context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return dsMonAn.size();
    }

    @Override
    public Object getItem(int i) {
        return dsMonAn.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //view hinh anh
        View viewHienHAnh = view;
        //Kiem tra
        if(viewHienHAnh == null)
            viewHienHAnh = layoutInflater.inflate(R.layout.item_monan, null);
        //Lay du lieu
        MonAn monAnHienTai = dsMonAn.get(i);
        //Truyen hinh anh
        TextView textView_MonAn = (TextView) viewHienHAnh.findViewById(R.id.tenMonAn);
        TextView textView_DonGia = (TextView) viewHienHAnh.findViewById(R.id.donGia);
        TextView textView_MoTa = (TextView) viewHienHAnh.findViewById(R.id.mo_Ta);
        ImageView imageView = (ImageView) viewHienHAnh.findViewById(R.id.anhDaiDien);

        textView_MonAn.setText(monAnHienTai.getMonAn());
        textView_DonGia.setText(String.valueOf(monAnHienTai.getDonGia()));
        textView_MoTa.setText(monAnHienTai.getMoTa());
        imageView.setImageResource(monAnHienTai.getImage());

        return viewHienHAnh;
    }
}

