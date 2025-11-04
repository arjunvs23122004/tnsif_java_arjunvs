package com.tns.onlineShoping.services;
import java.util.ArrayList;
import java.util.List;

import com.tns.onlineShoping.entities.Admin;
public class AdminServices {
	 private List<String> adminList = new ArrayList<>();

	    public void addAdmin(String admin) { adminList.add(admin); }
	    public List<String> getAdmins() { return adminList;
	    }

}
