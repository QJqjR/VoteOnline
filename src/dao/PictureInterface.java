package dao;

import entity.Picture;

public interface PictureInterface {
	public boolean AddPicture(Picture picture);
	public boolean DeletePicture(Picture picture);
	public boolean FindPicture(Picture picture);
	public boolean UpdatePicture(Picture picture);
	
}
