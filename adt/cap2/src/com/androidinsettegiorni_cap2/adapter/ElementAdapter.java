package com.androidinsettegiorni_cap2.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.androidinsettegiorni_cap2.ElementoGrafico;
import com.androidinsettegiorni_cap2.R;

public class ElementAdapter extends ArrayAdapter<ElementoGrafico> {

	public ElementAdapter(Context context, int resource, List<ElementoGrafico> objects) {
		super(context, resource, objects);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		if (convertView == null) {
			// Creazione di una nuova view - L'oggetto convertView è null quindi
			// si crea una view da layout xml
			// crea un nuovo elemento

			LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.element_list, parent, false);
		}
		// Aggiornamento o inserimento dati

		ElementoGrafico item = getItem(position);

		TextView text = (TextView) convertView.findViewById(R.id.text_element);

		text.setText(item.getName());

		return convertView;
	}
}
