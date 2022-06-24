package com.example.mychat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactsListAdapter extends RecyclerView.Adapter<ContactsListAdapter.ContactViewHolder> {

    class ContactViewHolder extends RecyclerView.ViewHolder{
        private  final TextView nickname;
        private final  TextView last;
        //private final ImageView avatar;

        private ContactViewHolder(View itemView) {
            super(itemView);
            nickname=itemView.findViewById(R.id.nickname);
            last=itemView.findViewById(R.id.last);
            //avatar=itemView.findViewById(R.id.avatar);
        }
    }
    private final LayoutInflater layoutInflater;
    private List<Contact> clist;

    public ContactsListAdapter(Context context) {
        this.layoutInflater = LayoutInflater.from(context);
    }

    public ContactViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View itemView= layoutInflater.inflate(R.layout.contact_layout,parent,false);
        return  new ContactViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        if (clist!=null){
            final Contact current=clist.get(position);
            holder.nickname.setText(current.getName());
            holder.last.setText(current.getLast());
            //holder.avatar.setImageResource(null);
        }
    }


    @Override
    public int getItemCount() {
        if (clist!=null)
            return clist.size();
        return 0;
    }

    public void setContact(List<Contact> contacts){
        clist=contacts;
        notifyDataSetChanged();
    }
    public List<Contact> getContacts(){return clist;}
}
