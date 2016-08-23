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

public class MemberDao {
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	DataSource dataSource = null;
	
	//������ mysql����̹� �ε�, DB����
	public MemberDao(){
		try{
			Context init = new InitialContext();
			System.out.println(init + "<-- init MemberDao() ");
			dataSource = (DataSource) init.lookup("java:comp/env/jdbc/Mysql");	
		}catch(Exception ex){
			System.out.println("DB ���� ���� : " + ex);
			return;
		}
	}
	
	//ȸ�� ���� �޼���(insert ó��)
	public int memberInsert(Member member) throws SQLException {
		connection = dataSource.getConnection();
		int result = 0;
		String name = member.getName();
		String city = member.getAddress().getCity();
		String street = member.getAddress().getStreet();
		String zipcode = member.getAddress().getZipcode();
		
		System.out.println(name + "<-- name memberInsert() MemberDao.java");
		System.out.println(city + "<-- city memberInsert() MemberDao.java");
		System.out.println(street + "<-- street memberInsert() MemberDao.java");
		System.out.println(zipcode + "<-- zipcode memberInsert() MemberDao.java");
		
		String memberInsertSql = "INSERT INTO member(name, city, street, zipcode)VALUES(?,?,?,?)";
		
		try {
			connection.setAutoCommit(false); //Ʈ�����
			preparedStatement = connection.prepareStatement(memberInsertSql);
			
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, city);
			preparedStatement.setString(3, street);
			preparedStatement.setString(4, zipcode);
			
			result = preparedStatement.executeUpdate();
			System.out.println(preparedStatement);
			
			//member table�� ���� �ԷµǾ��ٸ� Ŀ��.
			if(result != 0){
				connection.commit();
			}

		} catch (SQLException e) {
			e.printStackTrace();
			connection.rollback();
		}finally {
			//��ü ���� �޼���
			close();
		}
		return result;	
	}
	
	//member table ���� ó�� �޼ҵ�
	public int memberDelete(String name) throws SQLException{
		connection = dataSource.getConnection();
		int result = 0;
		// ������ ȸ�� �̸� Ȯ��
		System.out.println(name + "<- name memberDelete() MemberDao.java");
		// ���� ��������
		String deleteSql = "DELETE FROM member WHERE name=?";
		try {
			connection.setAutoCommit(false);
			
			preparedStatement = connection.prepareStatement(deleteSql);
			preparedStatement.setString(1, name);
			
			result = preparedStatement.executeUpdate();
			System.out.println(preparedStatement);
			
			//ȸ���� ���� �Ǿ����� Ŀ��
			if(result != 0){	
				connection.commit();
			}
			
		} catch (SQLException e) {
			connection.rollback();
			e.printStackTrace();
		} finally {
			//��ü ���� �޼���
			close();
		}	
		return result;
		
	}
	
	//ȸ�� ����Ʈ�� �������� �޼���
	public ArrayList<Member> memberSelect(String search) throws SQLException{
		connection = dataSource.getConnection();
		ArrayList<Member> memberList = new ArrayList<Member>();
		
		String listSql = null;
		//��üȸ���� �����ִ� select
		if(search == null){
			listSql = "SELECT member_id, name, city, street, zipcode FROM member";
			preparedStatement = connection.prepareStatement(listSql);
		}else{
			listSql = "SELECT member_id, name, city, street, zipcode FROM member WHERE name=?";
			preparedStatement = connection.prepareStatement(listSql);
			preparedStatement.setString(1, search);
		}
			
		resultSet = preparedStatement.executeQuery();
		System.out.println(preparedStatement);
		
		while(resultSet.next()){
			
			Member member = new Member();
			// ������� �� ������ ����
			int memberId = resultSet.getInt("member_id");
			String name = resultSet.getString("name");
			String city = resultSet.getString("city");
			String street = resultSet.getString("street");
			String zipcode = resultSet.getString("zipcode");
				
			//Ȯ�� ���
			System.out.println(memberId + "<-- memberId memberSelect() MemberDao.java");
			System.out.println(name + "<-- name memberSelect() MemberDao.java");
			System.out.println(city + "<-- city memberSelect() MemberDao.java");
			System.out.println(street + "<-- street memberSelect() MemberDao.java");
			System.out.println(zipcode + "<-- zipcode memberSelect() MemberDao.java");
			
			//�Ѹ��� ȸ�������� memberDto��ü�� set
			member.setId(memberId);
			member.setName(name);
			member.setAddress(new Address());
			member.getAddress().setCity(city);
			member.getAddress().setStreet(street);
			member.getAddress().setZipcode(zipcode);
			
			// ����Ʈ�� add
			memberList.add(member);
		}
		
		close();
		
		return memberList;
		
	}
	
	/*// ȸ�� �ּ��� ����Ʈ �޼���
	public ArrayList<MemberAndAddressDto> addrSelect(int sendNo) throws SQLException{
		ArrayList<MemberAndAddressDto> addrList = new ArrayList<MemberAndAddressDto>();
		PreparedStatement addrListPstmt = null;
		String listSql = null;
		
		//join�� ����Ͽ� ȸ���̸��� ���� �����ݴϴ�.
		listSql = "SELECT m.member_no, m.member_id, m.member_name, addr.member_address FROM member m LEFT JOIN address addr ON m.member_no=addr.member_no WHERE m.member_no=?";
		addrListPstmt = connection.prepareStatement(listSql);
		addrListPstmt.setInt(1, sendNo);
		
		//���� ����
		resultSet = addrListPstmt.executeQuery();
		System.out.println(addrListPstmt);
		
		while(resultSet.next()){
			MemberAndAddressDto addressDto = new MemberAndAddressDto();
			// ������� �� ������ ����
			int memberNo = resultSet.getInt("member_no");
			String memberId = resultSet.getString("member_id");
			String memberName = resultSet.getString("member_name");
			String memberAddress = resultSet.getString("member_address");
			
			//Ȯ�� ���
			System.out.println("MemberDao.jsp addSelect member_no -> " + memberNo);
			System.out.println("MemberDao.jsp addSelect member_id -> " + memberId);
			System.out.println("MemberDao.jsp addSelect member_name -> " + memberName);
			System.out.println("MemberDao.jsp addSelect member_address -> " + memberAddress);
			
			//AddressDto��ü�� �Ѹ� ȸ���ּ� ���� ����
			addressDto.setMember_no(memberNo);
			addressDto.setMember_id(memberId);
			addressDto.setMember_name(memberName);
			addressDto.setMember_address(memberAddress);
			
			//����Ʈ�� add
			addrList.add(addressDto);
		}
		if (addrListPstmt != null) try { addrListPstmt.close(); } catch(SQLException ex) {}
		if (resultSet != null) try { resultSet.close(); } catch(SQLException ex) {}
		
		// Ŀ�ؼ� ����
		if (connection != null) try { connection.close(); } catch(SQLException ex) {}
		
		return addrList;
	}
	
	//ȸ������ ����ȭ�� �޼���
	public MemberDto memberUpdateForm(int memberNo) throws SQLException{
		PreparedStatement memberPstmt = null;
		
		//ArrayList<MemberAndAddressDto> memberList = new ArrayList<MemberAndAddressDto>();
		MemberDto memberDto = new MemberDto();
		String memberSql = "SELECT m.member_id, m.member_pw, m.member_name, m.member_gender, m.member_age, addr.member_address FROM member m LEFT JOIN address addr ON m.member_no=addr.member_no WHERE m.member_no=?";
		memberPstmt = connection.prepareStatement(memberSql);
		memberPstmt.setInt(1, memberNo);
		System.out.println(memberPstmt);
		
		resultSet = memberPstmt.executeQuery();
		
		//ȸ�������� ����Ʈ�� ����
		if(resultSet.next()){
			//MemberAndAddressDto addressDto = new MemberAndAddressDto();
			
			String memberId = resultSet.getString("member_id");
			String memberPw = resultSet.getString("member_pw");
			String memberName = resultSet.getString("member_name");
			String memberGender = resultSet.getString("member_gender");
			int memberAge = resultSet.getInt("member_age");
			String memberAddress = resultSet.getString("member_address");
			
			//Ȯ�� ���
			System.out.println("MemberDao.jsp memberUpdateForm() member_id -> " + memberId);
			System.out.println("MemberDao.jsp memberUpdateForm() member_pw -> " + memberPw);
			System.out.println("MemberDao.jsp memberUpdateForm() member_name -> " + memberName);
			System.out.println("MemberDao.jsp memberUpdateForm() member_gender -> " + memberGender);
			System.out.println("MemberDao.jsp memberUpdateForm() member_age -> " + memberAge);
			System.out.println("MemberDao.jsp memberUpdateForm() member_address -> " + memberAddress);
			
			//��ü�� ����
			memberDto.setMember_id(memberId);
			memberDto.setMember_pw(memberPw);
			memberDto.setMember_name(memberName);
			memberDto.setMember_gender(memberGender);
			memberDto.setMember_age(memberAge);
			memberDto.setMember_address(memberAddress);
			
			//memberList.add(addressDto);
		}
		
		if (memberPstmt != null) try { memberPstmt.close(); } catch(SQLException ex) {}
		if (resultSet != null) try { resultSet.close(); } catch(SQLException ex) {}
		
		// Ŀ�ؼ� ����
		if (connection != null) try { connection.close(); } catch(SQLException ex) {}	
		
		return memberDto;
		
	}
	
	//ȸ������ ����ó�� �޼���
		public int memberUpdateAction(MemberDto member, String memberAfterAddr) throws SQLException{
			//������ ����� ���� ����
			int result = 0;
			PreparedStatement updatePstmt = null;
			PreparedStatement addressPstmt = null;
			
			connection.setAutoCommit(false); //Ʈ�����
		
			String updateSql = "UPDATE member SET member_id=?, member_pw=?, member_name=?, member_gender=?, member_age=? WHERE member_no=?";
			
			updatePstmt = connection.prepareStatement(updateSql);
			
			updatePstmt.setString(1, member.getMember_id());
			updatePstmt.setString(2, member.getMember_pw());
			updatePstmt.setString(3, member.getMember_name());
			updatePstmt.setString(4, member.getMember_gender());
			updatePstmt.setInt(5, member.getMember_age());
			updatePstmt.setInt(6, member.getMember_no());
			
			//Ȯ�� ���
			System.out.println("MemberDao.jsp memberUpdateAction() member_id -> " + member.getMember_id());
			System.out.println("MemberDao.jsp memberUpdateAction() member_pw -> " + member.getMember_pw());
			System.out.println("MemberDao.jsp memberUpdateAction() member_name -> " + member.getMember_name());
			System.out.println("MemberDao.jsp memberUpdateAction() member_gender -> " + member.getMember_gender());
			System.out.println("MemberDao.jsp memberUpdateAction() member_age -> " + member.getMember_age());
			System.out.println("MemberDao.jsp memberUpdateAction() member_address -> " + member.getMember_address());
				
			
			result = updatePstmt.executeUpdate();
			System.out.println(updatePstmt);
			
			if(result != 0){
				String addressSql = "UPDATE address SET member_address=? WHERE member_no=? AND member_address=?";
				addressPstmt = connection.prepareStatement(addressSql);
				
				addressPstmt.setString(1, member.getMember_address());
				addressPstmt.setInt(2, member.getMember_no());
				addressPstmt.setString(3, memberAfterAddr);
				
				result = addressPstmt.executeUpdate();
				
				if(result != 0){
					connection.commit();
				}
			}
			
			if (updatePstmt != null) try { updatePstmt.close(); } catch(SQLException ex) {}
			if (addressPstmt != null) try { addressPstmt.close(); } catch(SQLException ex) {}
			if (resultSet != null) try { resultSet.close(); } catch(SQLException ex) {}
			
			// Ŀ�ؼ� ����
			if (connection != null) try { connection.close(); } catch(SQLException ex) {}	
			
			return result;
		}
		
		//ȸ�� �α��� üũ �޼���
		public String memberLoginCheck(String memberId, String memberPw) throws SQLException{
			MemberDto memberDto = new MemberDto();
			PreparedStatement loginPstmt = null;
			String result = null;
			
			String loginSql = "SELECT member_no, member_id, member_pw FROM member WHERE member_id=? AND member_pw=?";
			loginPstmt = connection.prepareStatement(loginSql);
			loginPstmt.setString(1, memberId);
			loginPstmt.setString(2, memberPw);
			
			resultSet = loginPstmt.executeQuery();
			System.out.println(loginPstmt);
			
			if(resultSet.next()){
				
				if(resultSet.getString("member_pw").equals(memberPw)){
					result = "�α��μ���";
				}else{
					result = "��й�ȣ����ġ";
				}
				
			}else{
				result = "���̵����ġ";
			}
			
			return result;
		}
		
		//ȸ�� �α��� ó�� �޼���
		public MemberDto memberLogin(String memberId) throws SQLException{
			MemberDto memberDto = new MemberDto();
			PreparedStatement loginPstmt = null;
			
			String loginSql = "SELECT member_no, member_id, member_name FROM member WHERE member_id=?";
			loginPstmt = connection.prepareStatement(loginSql);
			loginPstmt.setString(1, memberId);
			
			resultSet = loginPstmt.executeQuery();
			System.out.println(loginPstmt);
			
			if(resultSet.next()){
				memberDto.setMember_no(resultSet.getInt("member_no"));
				memberDto.setMember_name(resultSet.getString("member_name"));
				//memberDto.setMember_level(resultSet.getString("member_level"));
			}
			
			return memberDto;
		}
		*/
	public void close(){
		if (preparedStatement != null) try { preparedStatement.close(); } catch(SQLException ex) {}
		if (resultSet != null) try { resultSet.close(); } catch(SQLException ex) {}
		
		// Ŀ�ؼ� ����
		if (connection != null) try { connection.close(); } catch(SQLException ex) {}
	}
		
}
