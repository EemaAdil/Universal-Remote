package com.mitpark.tvremotemaster;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import java.util.List;

public class RemoteAdapter extends RecyclerView.Adapter<RemoteAdapter.MyViewHolder> {

    Context context;
    remoteData data;
    private int lastPosition = -1;
    List<remoteData> studentDataList;

    public RemoteAdapter(List<remoteData> list, Context context2) {
        this.studentDataList = list;
        this.context = context2;
    }

    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.remote_list_row, viewGroup, false));
    }

    public void onBindViewHolder(final MyViewHolder myViewHolder, final int i) {
        this.data = this.studentDataList.get(i);
        myViewHolder.name.setText(this.data.remoteType);
        myViewHolder.subname.setText(this.data.remoteCom);
        setAnimation(myViewHolder.parent, i);
        myViewHolder.output_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("positionnss", "onClick: " + RemoteAdapter.this.data);
                myViewHolder.subparent.setVisibility(0);
            }
        });
        myViewHolder.go_to_remote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RemoteAdapter.this.context.startActivity(new Intent(RemoteAdapter.this.context, RemoteActivity.class));
            }
        });
        myViewHolder.cancel_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myViewHolder.subparent.setVisibility(8);
            }
        });
        myViewHolder.remote_rename.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RemoteAdapter.this.renameDialog(myViewHolder, i);
            }
        });
        myViewHolder.remote_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RemoteAdapter.this.deleteDialog(myViewHolder, i);
            }
        });
    }

    private void setAnimation(View view, int i) {
        if (i > this.lastPosition) {
            view.startAnimation(AnimationUtils.loadAnimation(this.context, 17432578));
            this.lastPosition = i;
        }
    }

    public int getItemCount() {
        Log.e("remotelist_size", "getItemCount: " + this.studentDataList.size());
        return this.studentDataList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView cancel_edit;
        LinearLayout go_to_remote;
        TextView name;
        ImageView output_more;
        RelativeLayout parent;
        RelativeLayout remote_delete;
        RelativeLayout remote_rename;
        TextView subname;
        RelativeLayout subparent;

        public MyViewHolder(View view) {
            super(view);
            this.parent = (RelativeLayout) view.findViewById(R.id.parent);
            this.subparent = (RelativeLayout) view.findViewById(R.id.subparent);
            this.remote_rename = (RelativeLayout) view.findViewById(R.id.remote_rename);
            this.remote_delete = (RelativeLayout) view.findViewById(R.id.remote_delete);
            this.name = (TextView) view.findViewById(R.id.name);
            this.subname = (TextView) view.findViewById(R.id.subname);
            this.output_more = (ImageView) view.findViewById(R.id.output_more);
            this.cancel_edit = (ImageView) view.findViewById(R.id.cancel_edit);
            this.go_to_remote = (LinearLayout) view.findViewById(R.id.go_to_remote);
        }
    }


    public void renameDialog(MyViewHolder myViewHolder, int i) {
        final Dialog dialog = new Dialog(this.context);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.remote_rename);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        final EditText editText = (EditText) dialog.findViewById(R.id.rename_edit);
        dialog.findViewById(R.id.dialog_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        final MyViewHolder myViewHolder2 = myViewHolder;
        final Dialog dialog2 = dialog;
        final int i2 = i;
        dialog.findViewById(R.id.dialog_done).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String obj = editText.getText().toString();
                myViewHolder2.subparent.setVisibility(8);
                dialog2.dismiss();
                RemoteAdapter.this.studentDataList.set(i2, new remoteData(obj, RemoteAdapter.this.data.remoteCom));
                RemoteAdapter.this.notifyDataSetChanged();
                SharedPreferences.Editor edit = RemoteAdapter.this.context.getSharedPreferences("sharedPrefIncomeCategoryList", 0).edit();
                edit.clear();
                edit.putString("incomeCategoryList", new Gson().toJson((Object) RemoteAdapter.this.studentDataList));
                edit.apply();
            }
        });
        dialog.findViewById(R.id.rename_edit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        dialog.show();
    }


    public void deleteDialog(final MyViewHolder myViewHolder, final int i) {
        final Dialog dialog = new Dialog(this.context);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.remote_delete);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        ((TextView) dialog.findViewById(R.id.delete_remote_name)).setText(this.data.remoteCom);
        dialog.findViewById(R.id.delete_no).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.findViewById(R.id.delete_yes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RemoteAdapter.this.studentDataList.remove(i);
                myViewHolder.subparent.setVisibility(8);
                RemoteAdapter.this.notifyDataSetChanged();
                dialog.dismiss();
                SharedPreferences.Editor edit = RemoteAdapter.this.context.getSharedPreferences("sharedPrefIncomeCategoryList", 0).edit();
                edit.putString("incomeCategoryList", new Gson().toJson((Object) RemoteAdapter.this.studentDataList));
                edit.apply();
            }
        });
        dialog.show();
    }
}
