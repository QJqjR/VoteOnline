package dao;

import entity.Subject;

public interface SubjectInterface {
	public boolean AddSubject(Subject subject);
	public boolean DeteleSubject(Subject subject);
	public boolean FindSubject(Subject subject);
	public boolean UpdateSubject(Subject subject);
}
