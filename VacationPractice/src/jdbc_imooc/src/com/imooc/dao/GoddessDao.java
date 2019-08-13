package com.imooc.dao;
/**
 * 模型层
 */

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.imooc.db.DBUtil;
import com.imooc.model.Goddess;

public class GoddessDao {
	
	public void addGoddess(Goddess g) throws Exception {
		Connection conn = DBUtil.getConnection();
		String sql = ""+"insert into imooc_goddess"+"(user_name,sex,age,birthday,email,mobile,"
		+"create_user,create_date,update_user,update_date,isdel)"
				+"values("+
		"?,?,?,?,?,?,?,current_date(),?,current_date(),?)"; 
		PreparedStatement ptmt = conn.prepareStatement(sql);//预编译SQL语句
		
		//传参给预编译符"?"去赋值
		ptmt.setString(1, g.getUser_name());
		ptmt.setInt( 2, g.getSex());
		ptmt.setInt(3,g.getAge());
		ptmt.setDate(4,new Date( g.getBirthday().getTime()));
		ptmt.setString(5, g.getEmail());
		ptmt.setString(6, g.getMobile());
		ptmt.setString(7, g.getCreate_user());
		ptmt.setString(8, g.getUpdate_user());
		ptmt.setInt(9, g.getIsdel());
		
		ptmt.execute(); //调用execute()方法去执行SQL语句
	}
	
	public void delGoddess(Integer id) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = ""+
				" delete from imooc_goddess "+
				" where id=?"; 
		PreparedStatement ptmt = conn.prepareStatement(sql);
		
		ptmt.setInt(1,id);
		ptmt.execute(); 
	}
	
	public void updateGoddess(Goddess g) throws SQLException {
		Connection conn = DBUtil.getConnection();
		String sql = ""+
				" update  imooc_goddess "+
				" set user_name=?,sex=?,age=?,birthday=?,email=?,mobile=?, "+
				" update_user=?,update_date=current_date(),isdel=? "+
				" where id=?"; 
		PreparedStatement ptmt = conn.prepareStatement(sql);//预编译SQL语句
		
		ptmt.setString(1, g.getUser_name());
		ptmt.setInt( 2, g.getSex());
		ptmt.setInt(3,g.getAge());
		ptmt.setDate(4,new Date( g.getBirthday().getTime()));
		ptmt.setString(5, g.getEmail());
		ptmt.setString(6, g.getMobile());
		ptmt.setString(7, g.getUpdate_user());
		ptmt.setInt(8, g.getIsdel());
		ptmt.setInt(9,g.getId());
		ptmt.execute(); //执行SQL语句
	}
	
	public List<Goddess> query() throws Exception{
		
		Connection conn = DBUtil.getConnection();//获取数据库的连接
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select user_name,age from imooc_goddess");
		
		List<Goddess> gs = new ArrayList<Goddess>();
		Goddess g = null;
		while(rs.next()) {
			g = new Goddess();
			g.setUser_name(rs.getString("user_name"));
			g.setAge(rs.getInt("age"));
			gs.add(g);
		} 
		return gs;
	}
	
	public List<Goddess> query(String name,String mobile) throws Exception{
		
		Connection conn = DBUtil.getConnection();//获取数据库的连接
		PreparedStatement ptmt = conn.prepareStatement("select * from imooc_goddess where user_name like ? and mobile like ?");
		ptmt.setString(1,"%"+name+"%");
		ptmt.setString(2,"%"+mobile+"%");
		ResultSet rs = ptmt.executeQuery();
		
		List<Goddess> gs = new ArrayList<Goddess>();
		Goddess g = null;
		while(rs.next()) {
			g = new Goddess();
			g.setId(rs.getInt("id"));
			g.setUser_name(rs.getString("user_name"));
			g.setAge(rs.getInt("age"));
			g.setSex(rs.getInt("sex"));
			g.setBirthday(rs.getDate("birthday"));
			g.setEmail(rs.getString("email"));
			g.setMobile(rs.getString("mobile"));
			g.setCreate_date(rs.getDate("create_date"));
			g.setCreate_user(rs.getString("create_user"));
			g.setUpdate_date(rs.getDate("update_date"));
			g.setUpdate_user(rs.getString("update_user"));
			g.setIsdel(rs.getInt("isdel"));
			gs.add(g);
		}
		return gs;
	}
	
	public List<Goddess> query(List<Map<String,Object>> params) throws Exception{
		
		Connection conn = DBUtil.getConnection();//获取数据库的连接
		StringBuilder sb = new StringBuilder();
		sb.append("select * from imooc_goddess where 1=1");
		if(params != null && params.size()>0) {
			for(int i=0;i<params.size();i++) {
				Map<String,Object> map = params.get(i);
				sb.append(" and "+map.get("name")+" "+map.get("rela")+" "+map.get("value")+" ");
			}
		}
		PreparedStatement ptmt = conn.prepareStatement(sb.toString());
		
		ResultSet rs = ptmt.executeQuery();
		
		List<Goddess> gs = new ArrayList<Goddess>();
		Goddess g = null;
		while(rs.next()) {
			g = new Goddess();
			g.setId(rs.getInt("id"));
			g.setUser_name(rs.getString("user_name"));
			g.setAge(rs.getInt("age"));
			g.setSex(rs.getInt("sex"));
			g.setBirthday(rs.getDate("birthday"));
			g.setEmail(rs.getString("email"));
			g.setMobile(rs.getString("mobile"));
			g.setCreate_date(rs.getDate("create_date"));
			g.setCreate_user(rs.getString("create_user"));
			g.setUpdate_date(rs.getDate("update_date"));
			g.setUpdate_user(rs.getString("update_user"));
			g.setIsdel(rs.getInt("isdel"));
			gs.add(g);
		}
		return gs;
	}
	
	public Goddess get(Integer id) throws SQLException {
		Goddess g = null;
		Connection conn = DBUtil.getConnection();
		String sql = ""+
				" select * from imooc_goddess "+
				" where id=?"; 
		PreparedStatement ptmt = conn.prepareStatement(sql);
		
		ptmt.setInt(1,id);
		ResultSet rs = ptmt.executeQuery();//查询数据库专用方法，与增删改操作不同，需注意！！！ 
		while(rs.next()) {
			g = new Goddess();
			g.setId(rs.getInt("id"));
			g.setUser_name(rs.getString("user_name"));
			g.setAge(rs.getInt("age"));
			g.setSex(rs.getInt("sex"));
			g.setBirthday(rs.getDate("birthday"));
			g.setEmail(rs.getString("email"));
			g.setMobile(rs.getString("mobile"));
			g.setCreate_date(rs.getDate("create_date"));
			g.setCreate_user(rs.getString("create_user"));
			g.setUpdate_date(rs.getDate("update_date"));
			g.setUpdate_user(rs.getString("update_user"));
			g.setIsdel(rs.getInt("isdel"));
			
		}
		return g;
	}
	
}

