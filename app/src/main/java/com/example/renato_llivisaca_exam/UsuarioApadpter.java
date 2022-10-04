package com.example.renato_llivisaca_exam;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

public class UsuarioApadpter extends ListAdapter<Usuarios, UsuarioApadpter, EqViewHolder> {

    public static final DiffUtil.ItemCallback<Usuarios> DIFF_CALLBACK= new DiffUtil.ItemCallback<Usuarios>() {
        @Override
        public boolean areItemsTheSame(@NonNull Usuarios oldItem, @NonNull Usuarios newItem) {
            return false;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Usuarios oldItem, @NonNull Usuarios newItem) {
            return false;
        }
    };

    @NonNull
    @Override
    public UsuarioApadpter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioApadpter holder, int position) {

    }
}
