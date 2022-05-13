package com.team.postnatalcare.Sanhumanagement;

import java.util.ArrayList;
import com.team.postnatalcareMain.UserDTO;


public interface SanhuMapper {

	public ArrayList<UserDTO> jobsearch(String job);
	public void sanhujorisave(int usernum, String sanhurecord, String content);
	
}
