package fr.rhoekath.filemanager.drawer;

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
public class DrawerAdapter extends ArrayAdapter<DrawerItem>{

    private List<DrawerItem> lMenu;
    private Context context;

    public DrawerAdapter(Context context, List<DrawerItem> lMenu) {
        super(context, R.layout.drawer_listitem, lMenu);
        this.context = context;
        this.lMenu = lMenu;
    }

    static class ViewHolderItem{
        TextView textView;
        ImageView imageView;
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
            viewHolderItem.imageView = (ImageView) convertView.findViewById(R.id.drawer_menuimg);
            convertView.setTag(viewHolderItem);
        } else{
            viewHolderItem = (ViewHolderItem)convertView.getTag();
        }

        DrawerItem drawerItem = lMenu.get(position);
        viewHolderItem.textView.setText(drawerItem.getTextView());
        viewHolderItem.imageView.setImageDrawable(drawerItem.getDrawable());

        return convertView;
    }
}
