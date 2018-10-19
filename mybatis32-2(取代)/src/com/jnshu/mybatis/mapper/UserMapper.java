package com.jnshu.mybatis.mapper;

import java.util.List;

import com.jnshu.mybatis.pojo.QueryVo;
import com.jnshu.mybatis.pojo.User;

public interface UserMapper {
	//��ѭ�ĸ�ԭ��
	//�ӿڷ�����==User.xml��id��
	//����ֵ���� ��Mapper.xml�ļ��з���ֵ����Ҫһ��
	//�������������Ҫ��Mapper.xml�ļ�����ε�����Ҫһ��
	//�����ռ�󶨴˽ӿ�
	public User findUserByID(Integer id);
	public List<User> findUserByQueryVo(QueryVo vo);
	//��ѯ��������
	public Integer countUser();
	//�����Ա�����ֲ�ѯ�û�  User user Map map map.put(username,aabbc).put(id,1).put...
	public List<User> selectUserBySexAndUsername(User user);
	//����id��Ϣ��ѯ����û���Ϣ
	//public List<User> selectUserByIDs(Integer[] ids);//1��    ���ַ���
	public List<User> selectUserByIDs(List<Integer> ids);//2��
	//public List<User> selectUserByIDs(QueryVo vo);//3��
}
