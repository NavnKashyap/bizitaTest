package com.bizita.navneettest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bizita.navneettest.model.SuccessDTO;
import com.bizita.navneettest.model.ViewReportDTO;

import java.util.ArrayList;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.MyViewHolder> {

    Context mContext;
    private ArrayList<SuccessDTO> viewReportDTOS;
    private LayoutInflater inflater;

    public ProfileAdapter(Context mContext, ArrayList<SuccessDTO> viewReportDTOS, LayoutInflater inflater) {
        this.mContext = mContext;
        this.viewReportDTOS = viewReportDTOS;
        this.inflater = inflater;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater
                .inflate(R.layout.adapterprofile, parent, false);

        return new MyViewHolder(itemView);


    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

    holder.tvname.setText(viewReportDTOS.get(position).getName());
    holder.tvContact.setText(viewReportDTOS.get(position).getContact());
    holder.tvAddress.setText(viewReportDTOS.get(position).getAddress());
    holder.tvdescription.setText(viewReportDTOS.get(position).getDescription());
    holder.tvEmpCode.setText(viewReportDTOS.get(position).getEmpcode());
    }

    @Override
    public int getItemCount() {

        return viewReportDTOS.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView tvname, tvdescription, tvContact, tvAddress, tvEmpCode;

        public MyViewHolder(View view) {
            super(view);

            tvname = view.findViewById(R.id.tvName);
            tvdescription = view.findViewById(R.id.tvDescription);
            tvContact = view.findViewById(R.id.tvContact);
            tvAddress = view.findViewById(R.id.tvAddress);
            tvEmpCode = view.findViewById(R.id.tvEmpCode);

        }
    }

}
