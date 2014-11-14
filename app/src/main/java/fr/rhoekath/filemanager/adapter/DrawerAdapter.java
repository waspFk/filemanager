package fr.rhoekath.filemanager.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import fr.rhoekath.filemanager.R;

/**
 * Created by Mickael on 14/11/2014.
 */
public class DrawerAdapter extends ArrayAdapter<String>{

    private List<String> lMenu;
    private Context context;

    public DrawerAdapter(Context context, List<String> lMenu) {
        super(context, R.layout.drawer_listitem, lMenu);
        this.context = context;
        this.lMenu = lMenu;
    }

    static class ViewHolderItem{
        TextView textView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolderItem viewHolderItem;
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(convertView == null) {
            convertView = inflater.inflate(R.layout.drawer_listitem, parent, false);
            viewHolderItem = new ViewHolderItem();
            viewHolderItem.textView = (TextView) convertView.findViewById(R.id.drawer_menulabel);
            convertView.setTag(viewHolderItem);
        } else{
            viewHolderItem = (ViewHolderItem)convertView.getTag();
        }

        String string = lMenu.get(position);
        viewHolderItem.textView.setText(string);

        return convertView;
    }
}
