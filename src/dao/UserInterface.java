package dao;

import entity.User;

public interface UserInterface {
	public boolean findUser(User user);
	public boolean addUser(User user);

}
