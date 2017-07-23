package com.ogogc.app;

import java.util.List;

import com.ogogc.app.bean.Response;
import com.ogogc.app.bean.UserInfoModel;
import com.ogogc.app.server.UserInfoServer;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 UserInfoServer server = new UserInfoServer();
		 Response<UserInfoModel> rs =  server.queryByAll();
		 List<UserInfoModel> list =rs.getObjlist();
		 for(int i = 0;i<list.size();i++){
			 System.out.println(list.get(i).getUserinfoName());
		 }
	}

}
