package com.androidinsettegiorni_cap3.model;

import java.util.ArrayList;

import com.androidinsettegiorni_cap3.R;

public class DummyGenerator {

	public static ArrayList<Item> getItemNumberList() {

		ArrayList<Item> list = new ArrayList<Item>();
		list.add(new Item().setLabel("Sem").setDrawable(R.drawable.image_1));
		list.add(new Item().setLabel("Ante").setDrawable(R.drawable.image_2));
		list.add(new Item().setLabel("Nullam").setDrawable(R.drawable.image_3));
		list.add(new Item().setLabel("In").setDrawable(R.drawable.image_4));
		list.add(new Item().setLabel("Ut").setDrawable(R.drawable.image_5));
		list.add(new Item().setLabel("Justo").setDrawable(R.drawable.image_6));
		list.add(new Item().setLabel("Quis").setDrawable(R.drawable.image_7));
		list.add(new Item().setLabel("Nulla").setDrawable(R.drawable.image_8));
		return list;
	}

	public static ArrayList<Item> getItemAlphabetList() {
		ArrayList<Item> list = new ArrayList<Item>();
		list.add(new Item().setLabel("Nec").setDrawable(R.drawable.image_a));
		list.add(new Item().setLabel("Ultrices").setDrawable(R.drawable.image_b));
		list.add(new Item().setLabel("Sit").setDrawable(R.drawable.image_c));
		list.add(new Item().setLabel("Vehicula").setDrawable(R.drawable.image_d));
		list.add(new Item().setLabel("Adipiscing").setDrawable(R.drawable.image_e));
		list.add(new Item().setLabel("Eros").setDrawable(R.drawable.image_f));
		list.add(new Item().setLabel("Ut").setDrawable(R.drawable.image_g));
		list.add(new Item().setLabel("Suspendisse").setDrawable(R.drawable.image_h));
		return list;
	}

	public static ArrayList<Item> getItemShapeList() {
		ArrayList<Item> list = new ArrayList<Item>();
		list = new ArrayList<Item>();
		list.add(new Item().setDrawable(R.drawable.image_tri).setLabel("Triangolo"));
		list.add(new Item().setDrawable(R.drawable.image_triinv).setLabel("Tirangolo rovesciato"));
		list.add(new Item().setDrawable(R.drawable.image_circle).setLabel("Cerchio"));
		list.add(new Item().setDrawable(R.drawable.image_quad).setLabel("Quadrato"));
		list.add(new Item().setDrawable(R.drawable.image_dia).setLabel("Pentagono"));
		return list;
	}

	public static ArrayList<Info> getInfoList() {
		ArrayList<Info> list = new ArrayList<Info>();
		list = new ArrayList<Info>();
		for (int i = 0; i < 5; i++) {
			Info info = new Info();
			info.setLabel("Info " + i).setText("Quisque fringilla tempor ultricies, mauris nisl.");
			list.add(info);
		}
		return list;
	}

	public static ArrayList<Label> getLabelList() {
		ArrayList<Label> list = new ArrayList<Label>();
		list.add(new Label().setLabel("Luoghi").setIndex(true));
		list.add(new Label().setLabel("Casa"));
		list.add(new Label().setLabel("Scuola"));
		list.add(new Label().setLabel("Stazione"));
		list.add(new Label().setLabel("Libreria"));
		list.add(new Label().setLabel("Strada"));
		list.add(new Label().setLabel("Ospedale"));
		list.add(new Label().setLabel("Cibo").setIndex(true));
		list.add(new Label().setLabel("Pasta"));
		list.add(new Label().setLabel("Salumi"));
		list.add(new Label().setLabel("Riso"));
		list.add(new Label().setLabel("Verdure"));
		list.add(new Label().setLabel("Città").setIndex(true));
		list.add(new Label().setLabel("Milano"));
		list.add(new Label().setLabel("Torino"));
		list.add(new Label().setLabel("Aprilia"));
		list.add(new Label().setLabel("Belluno"));
		list.add(new Label().setLabel("Nazioni").setIndex(true));
		list.add(new Label().setLabel("Giappone"));
		list.add(new Label().setLabel("Francia"));
		list.add(new Label().setLabel("San Marino"));
		list.add(new Label().setLabel("Svizzera"));
		list.add(new Label().setLabel("Italia"));

		return list;
	}
}
