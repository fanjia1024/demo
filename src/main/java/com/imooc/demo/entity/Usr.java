package com.imooc.demo.entity;

import java.util.Date;

public class Usr {
		// 主键ID
		private Integer Id;
		// 用户名
		private String usrName;
		// 权重，越大越排前显示
		private Integer userId;
		// 密码
		private String usrPassword;
		public Integer getId() {
			return Id;
		}
		public void setId(Integer id) {
			Id = id;
		}
		public String getUsrName() {
			return usrName;
		}
		public void setUsrName(String usrName) {
			this.usrName = usrName;
		}
		
		public Integer getUserId() {
			return userId;
		}
		public void setUserId(Integer userId) {
			this.userId = userId;
		}
		public String getUsrPassword() {
			return usrPassword;
		}
		public void setUsrPassword(String usrPassword) {
			this.usrPassword = usrPassword;
		}
		
}
