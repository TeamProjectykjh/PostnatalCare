package com.team.postnatalcare.Sanhumanagement;

import java.util.ArrayList;
import com.team.postnatalcareMain.UserDTO;


public interface SanhuMapper {

	public ArrayList<UserDTO> job();
	public ArrayList<SanhuNameDTO> jobsearch(String job);
	public void sanhujorisave(int usernum, String sanhurecord, String content, String sanhupath);
	public SanhujoriDTO Sanhujoriout(int usernum);
	public void sanhureviewsave(int emplonum, int posnum, int sanhunum, float point, String ment);
}
