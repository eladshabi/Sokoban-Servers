package services;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;


@Path("sokosol")
public class SolveLevelService {


	//	SolutionDBManager manager;
	
	

	
	@DefaultValue("0")
	@QueryParam("num")
	String levelNum;
	@GET
	@Path("getSol")
	public String getLevelSolution() {
		System.out.println(levelNum);
		int num = Integer.parseInt(levelNum);
		SolutionsManager manager=new SolutionsManager();
		return manager.getSolution(num);
	}

	@POST
	@Consumes("text/plain")
	@Path("setSol")
	public void setLevelSolution(String text) {
		System.out.println("in set web"+text+"1");
		int num = Integer.parseInt(levelNum);
		System.out.println("in set web"+text+"2");
		SolutionsManager manager=new SolutionsManager();
		System.out.println("in set web"+text+"3");
		manager.addSolution(new Solution(num, text));
		System.out.println("in set web"+text+"4 end");
	}
}