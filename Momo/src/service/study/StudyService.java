package service.study;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Study;
import dto.StudyCategory;

public interface StudyService {

	public List<StudyCategory> getCategory();

	public List<Study> getMyStudy(int u_no);

	public List<Study> getHurryStudy();

	public List<Study> getCateStudyList(int category_code);
	
	// jh ----------------------------------------------------
	public List getList();

	// CHECK BOX, SELECT한 요청 파라미터 받기
	public Study getParam(HttpServletRequest request, HttpServletResponse response);

	// 조건검색해서 가져온 값 띄워줌
	public List view(Study study);

	public Study getStudy(int study_no);

	public List selectCate(int cate_no);
	//---------------------------------------------------------
}
