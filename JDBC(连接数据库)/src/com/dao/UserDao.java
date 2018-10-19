package com.dao;

public interface UserDao {
	//update t_user set name=? where id=?
	//����id���¾�����û���
	void update(int id,String name);
	//ִ��ɾ��
	void delete(int id);

	// ִ�����
	void insert(String username, String password);

	// ��ѯ����
	void findAll();

	// ��¼����
	void login(String username, String password);
}
/*
 * Daoģʽ Data Access Object���ݷ��ʶ��� 
 * 1.�½�һ��dao�Ľӿ�,�����������ʵ��߼�
 * 2.�½�һ��dao��ʵ����,����ʵ����ǰ����Ĺ��� 3.ֱ��ʹ��ʵ��
 * 
 * �ܽ�
 * 1.JDBC����
 * 2.��ȡ������
 * 3.Statement CRUD(��ɾ�Ĳ����)
 *   �ص�����crud
 * 4.Daoģʽ
 *   ������ʵ�ַֿ�
 * 5.PrepareStatement CRUD
 *   Ԥ����sql���,�����Statement���ֵ�����
 */