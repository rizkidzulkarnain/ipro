package id.co.pln.ipro.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import id.co.pln.ipro.FormUjiActivity;
import id.co.pln.ipro.MainActivity;
import id.co.pln.ipro.R;
import id.co.pln.ipro.model.MenuClass;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MyViewHolder> {
    private Context mContext;
    private List<MenuClass> menuList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView aTitle;
        public ImageView aIconMenu;
        public CardView cardView;

        public MyViewHolder(View view) {
            super(view);
            aTitle = (TextView) view.findViewById(R.id.titleMenu);
            aIconMenu = (ImageView) view.findViewById(R.id.iconMenu);
            cardView = (CardView) view.findViewById(R.id.card_viewmenu);
        }
    }

    public MenuAdapter(Context mContext, List<MenuClass> menuList) {
        this.mContext = mContext;
        this.menuList = menuList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_menu_layout, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        MenuClass menuClass = menuList.get(position);
        holder.aTitle.setText(menuClass.getTitle());
        Glide.with(mContext).load(menuClass.getIconMenu()).into(holder.aIconMenu);

        final int id = menuClass.getId( );

        holder.aIconMenu.setOnClickListener(new View.OnClickListener( ) {
            public void onClick(View v) {
                Class classActivity = getMenuActivity(id);
                Intent aintent = new Intent(v.getContext( ), classActivity);
                ((Activity) v.getContext( )).startActivityForResult(aintent, 1);
            }
        });
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Class classActivity = getMenuActivity(id);
                Intent aintent = new Intent(v.getContext( ), classActivity);
                ((Activity) v.getContext( )).startActivityForResult(aintent, 1);
            }
        });
    }

    private Class getMenuActivity(int id) {
        Class aclass = null;
        switch (id) {
            case 1:
                aclass = FormUjiActivity.class;
                break;
            case 2:
                aclass = MainActivity.class;
                break;
            case 3:
                aclass = MainActivity.class;
                break;
            case 4:
                aclass = MainActivity.class;
                break;
        }
        return aclass;
    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }
}
