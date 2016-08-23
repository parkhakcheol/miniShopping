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
	
	//������ mysql����̹� �ε�, DB����
	public ItemDao(){
		try{
			Context init = new InitialContext();
			System.out.println(init + "<-- init ItemDao() ");
			dataSource = (DataSource) init.lookup("java:comp/env/jdbc/Mysql");	
		}catch(Exception ex){
			System.out.println("DB ���� ���� : " + ex);
			return;
		}
	}
	//ī�װ� ����Ʈ
	public ArrayList<Category> categoryList(){		
		ArrayList<Category> categoryList = new ArrayList<Category>();		
		String listSql = null;
		
		try {
			connection = dataSource.getConnection();
			
			//��üī�װ��� �������� sql
			listSql = "SELECT * FROM category";
			
			preparedStatement = connection.prepareStatement(listSql);
			resultSet = preparedStatement.executeQuery();
			
			System.out.println(preparedStatement);
			
			while(resultSet.next()){
				
				Category category = new Category();
				// ������� �� ������ ����
				int categoryId = resultSet.getInt("category_id");
				int parentId = resultSet.getInt("parent_id");
				String name = resultSet.getString("name");
					
				//Ȯ�� ���
				System.out.println(categoryId + "<-- categoryId categoryList() ItemDao.java");
				System.out.println(parentId + "<-- parentId categoryList() ItemDao.java");
				System.out.println(name + "<-- name categoryList() ItemDao.java");
				
				
				//�Ѹ��� ȸ�������� memberDto��ü�� set
				category.setId(categoryId);
				category.setName(name);
				category.setParent(parentId);
				
				// ����Ʈ�� add
				categoryList.add(category);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			//��ü ���� �޼���
			close();
		}	
		return categoryList;
	}
	
	//������ ����Ʈ
	public ArrayList<Item> itemList(){		
		ArrayList<Item> itemList = new ArrayList<Item>();		
		String listSql = null;
		
		try {
			connection = dataSource.getConnection();
			
			//��üī�װ��� �������� sql
			listSql = "SELECT * FROM category";
			
			preparedStatement = connection.prepareStatement(listSql);
			resultSet = preparedStatement.executeQuery();
			
			System.out.println(preparedStatement);
			
			while(resultSet.next()){
				
				Item item = new Item();
				// ������� �� ������ ����
				int categoryId = resultSet.getInt("category_id");
				int parentId = resultSet.getInt("parent_id");
				String name = resultSet.getString("name");
					
				//Ȯ�� ���
				System.out.println(categoryId + "<-- categoryId categoryList() ItemDao.java");
				System.out.println(parentId + "<-- parentId categoryList() ItemDao.java");
				System.out.println(name + "<-- name categoryList() ItemDao.java");
				
				
				//�Ѹ��� ȸ�������� memberDto��ü�� set
				category.setId(categoryId);
				category.setName(name);
				category.setParent(parentId);
				
				// ����Ʈ�� add
				itemList.add(item);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			//��ü ���� �޼���
			close();
		}	
		return itemList;
	}
	
	public void close(){
		if (preparedStatement != null) try { preparedStatement.close(); } catch(SQLException ex) {}
		if (resultSet != null) try { resultSet.close(); } catch(SQLException ex) {}
		
		// Ŀ�ؼ� ����
		if (connection != null) try { connection.close(); } catch(SQLException ex) {}
	}
}
