package com.team.postnatalcare.Sanhumanagement;

import java.util.ArrayList;
import com.team.postnatalcareMain.UserDTO;
import com.team.postnatalcare.Sanmo.PostnatalDTO;


public interface SanhuMapper {

	public ArrayList<UserDTO> job();
	public ArrayList<SanhuNameDTO> jobsearch();
	public SanhuNameDTO namesearch(int num);
	public void sanhujorisave(int usernum, String sanhurecord, String content, String sanhupath);
	public SanhujoriDTO Sanhujoriout(int usernum);
	public void sanhureviewsave(int emplonum, int posnum, int sanhunum, float point, String ment);
	public void sanhumodi(String sanhurecord, String content, String sanhupath, int sanhunum);
	public ArrayList<SanhuLicenseDTO> sanhuliout (int sanhunum);
	public void sanhulisave(int sanhunum, String liname, String licode);
	public void sanhulidel(int linum);
	public void sanhulimodi(int linum, String liname, String licode);
	public void sanhuemploymentsave(int sanhunum, int posnum, String empstartday, String empendday);
	public PostnatalDTO posnumfind(int num);
}
