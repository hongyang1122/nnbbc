package com.jnshu.mybatis.mapper;

import java.util.List;

import com.jnshu.mybatis.pojo.Orders;
import com.jnshu.mybatis.pojo.User;

public interface OrderMapper {
	//��ѯ������������
	public List<Orders> selectOrdersList();
	//һ��һ������ѯ  �Զ���Ϊ���Ĺ����û�
	public List<Orders> selectOrders();
	//һ�Զ����
	public List<User> selectUserList();
	
}
