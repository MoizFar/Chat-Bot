package com.example.chatbot;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class ChatRVAdapter extends RecyclerView.Adapter {
    private ArrayList<MessageModal> messageModalArrayList;
    private Context context;
    public MessageRVAdapter(ArrayList<MessageModal> messageModalArrayList, Context context) {
        this.messageModalArrayList = messageModalArrayList;
        this.context = context;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case 0:

                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_msg, parent, false);
                return new UserViewHolder(view);
            case 1:

                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bot_msg, parent, false);
                return new BotViewHolder(view);
        }
        return null;
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MessageModal modal = messageModalArrayList.get(position);
        switch (modal.getSender()) {
            case "user":

                ((UserViewHolder) holder).userTV.setText(modal.getMessage());
                break;
            case "bot":

                ((BotViewHolder) holder).botTV.setText(modal.getMessage());
                break;
        }
    }

    public int getItemViewType(int position) {

        switch (chatsModalArrayList.get(position).getSender()) {
            case user:
                return 0;
            case "bot":
                return 1;
            default:
                return -1;

        }
    }

    @Override
    public int getItemCount() {
        return messageModalArrayList.size();
    }
    public static class UserViewHolder extends RecyclerView.ViewHolder {


        TextView userTV;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            userTV = itemView.findViewById(R.id.idTVUser);
        }
    }
    public static class BotViewHolder extends RecyclerView.ViewHolder {


        TextView botTV;

        public BotViewHolder(@NonNull View itemView) {
            super(itemView);

            botTV = itemView.findViewById(R.id.idTVBot);
        }
    }

}