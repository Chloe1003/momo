package service.study;

public interface DetailStudyService {
	// 찜하기 중복검사
	public boolean getDuplicated(int study_no, int u_no);
	// 신청중복검사
	public boolean getAppDuplicated(int u_no, int study_no);
}
