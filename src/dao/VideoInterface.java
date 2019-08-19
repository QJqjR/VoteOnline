package dao;
import entity.Video;

public interface VideoInterface {
	public boolean AddVideo(Video video);
	public boolean DeleteVideo(Video video);
	public boolean FindVideo(Video video);
	public boolean UpdateVideo(Video video);

}
