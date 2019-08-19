package dao;

import entity.Music;

public interface MusicInterface {
	public boolean AddMusic(Music music);
	public boolean DeleteMusic(Music music);
	public boolean FindMusic(Music music);
	public boolean UpdateMusic(Music music);
	

}
