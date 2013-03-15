package com.researchmobile.supervisionpasalo.view;

import java.util.ArrayList;
import java.util.HashMap;

public class Datos {

	public static ArrayList<HashMap<String, String>> Data()
	{
		ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();
		HashMap<String, String>map = new HashMap<String, String>();
		map.put("Create", "02/02/2013 10:19 a.m");
		map.put("Asignate", "05/02/2013 8:00 a.m");
		map.put("Result", "06/02/2013 8:00 a.m");
		map.put("Comunity", "RSOLARES");
		map.put("Tipe", "Tipo1");
		mylist.add(map);
		
		map = new HashMap<String, String>();
		map.put("Create", "02/03/2013 10:19 a.m");
		map.put("Asignate", "05/03/2013 8:00 a.m");
		map.put("Result", "06/03/2013 8:00 a.m");
		map.put("Comunity", "RSOLARES");
		map.put("Tipe", "Tipo1");
		mylist.add(map);
		
		map = new HashMap<String, String>();
		map.put("Create", "02/04/2013 10:19 a.m");
		map.put("Asignate", "05/04/2013 8:00 a.m");
		map.put("Result", "06/04/2013 8:00 a.m");
		map.put("Comunity", "RSOLARES");
		map.put("Tipe", "Tipo1");
		mylist.add(map);
		
		return mylist;
	}
}
