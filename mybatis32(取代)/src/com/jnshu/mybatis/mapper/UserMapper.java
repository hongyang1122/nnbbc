package com.jnshu.mybatis.mapper;

import com.jnshu.mybatis.pojo.User;

public interface UserMapper {
	//��ѭ�ĸ�ԭ��
	//�ӿڷ�����==User.xml��id��
	//����ֵ���� ��Mapper.xml�ļ��з���ֵ����Ҫһ��
	//�������������Ҫ��Mapper.xml�ļ�����ε�����Ҫһ��
	//�����ռ�󶨴˽ӿ�
	public User findUserByID(Integer id);
}
