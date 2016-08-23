package com.park.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.park.dto.*;


public class ItemDao {
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	DataSource dataSource = null;
	
	//생성자 mysql드라이버 로드, DB연결
	public ItemDao(){
		try{
			Context init = new InitialContext();
			System.out.println(init + "<-- init ItemDao() ");
			dataSource = (DataSource) init.lookup("java:comp/env/jdbc/Mysql");	
		}catch(Exception ex){
			System.out.println("DB 연결 실패 : " + ex);
			return;
		}
	}
	//카테고리 리스트
	public ArrayList<Category> categoryList(){		
		ArrayList<Category> categoryList = new ArrayList<Category>();		
		String listSql = null;
		
		try {
			connection = dataSource.getConnection();
			
			//전체카테고리를 가져오는 sql
			listSql = "SELECT * FROM category";
			
			preparedStatement = connection.prepareStatement(listSql);
			resultSet = preparedStatement.executeQuery();
			
			System.out.println(preparedStatement);
			
			while(resultSet.next()){
				
				Category category = new Category();
				// 결과값을 각 변수에 대입
				int categoryId = resultSet.getInt("category_id");
				int parentId = resultSet.getInt("parent_id");
				String name = resultSet.getString("name");
					
				//확인 출력
				System.out.println(categoryId + "<-- categoryId categoryList() ItemDao.java");
				System.out.println(parentId + "<-- parentId categoryList() ItemDao.java");
				System.out.println(name + "<-- name categoryList() ItemDao.java");
				
				
				//한명의 회원정보를 memberDto객체에 set
				category.setId(categoryId);
				category.setName(name);
				category.setParent(parentId);
				
				// 리스트에 add
				categoryList.add(category);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			//객체 종료 메서드
			close();
		}	
		return categoryList;
	}
	
	//아이템 리스트
	public ArrayList<Item> itemList(){		
		ArrayList<Item> itemList = new ArrayList<Item>();		
		String listSql = null;
		
		try {
			connection = dataSource.getConnection();
			
			//전체카테고리를 가져오는 sql
			listSql = "SELECT * FROM category";
			
			preparedStatement = connection.prepareStatement(listSql);
			resultSet = preparedStatement.executeQuery();
			
			System.out.println(preparedStatement);
			
			while(resultSet.next()){
				
				Item item = new Item();
				// 결과값을 각 변수에 대입
				int categoryId = resultSet.getInt("category_id");
				int parentId = resultSet.getInt("parent_id");
				String name = resultSet.getString("name");
					
				//확인 출력
				System.out.println(categoryId + "<-- categoryId categoryList() ItemDao.java");
				System.out.println(parentId + "<-- parentId categoryList() ItemDao.java");
				System.out.println(name + "<-- name categoryList() ItemDao.java");
				
				
				//한명의 회원정보를 memberDto객체에 set
				category.setId(categoryId);
				category.setName(name);
				category.setParent(parentId);
				
				// 리스트에 add
				itemList.add(item);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			//객체 종료 메서드
			close();
		}	
		return itemList;
	}
	
	public void close(){
		if (preparedStatement != null) try { preparedStatement.close(); } catch(SQLException ex) {}
		if (resultSet != null) try { resultSet.close(); } catch(SQLException ex) {}
		
		// 커넥션 종료
		if (connection != null) try { connection.close(); } catch(SQLException ex) {}
	}
}
