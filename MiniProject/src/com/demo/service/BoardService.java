package com.demo.service;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.demo.beans.ContentBean;
import com.demo.beans.LoginUserBean;
import com.demo.beans.PageBean;
import com.demo.mapper.BoardMapper;

@Service
@PropertySource("/WEB-INF/properties/option.properties")
public class BoardService {

	@Value("${path.upload}")
	private String path_upload;

	@Autowired
	private BoardMapper boardMapper;

	@Resource(name = "loginUserBean")
	private LoginUserBean loginUserBean;

	// 서버로 업로드 된 파일을 업로드 폴더에 저장하고 파일의 이름을 리턴하는 메소드
	private String saveUploadFile(MultipartFile upload_file) {

		// 현재 시간(밀리세컨드)을 이용해서 파일의 이름이 중복되지 않게 설정
		String file_name = System.currentTimeMillis() + "_" + upload_file.getOriginalFilename();

		try {
			upload_file.transferTo(new File(path_upload + "/" + file_name));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return file_name;
	}

	public void addContentInfo(ContentBean writeContentBean) {
		MultipartFile upload_file = writeContentBean.getUpload_file();

		if (upload_file.getSize() > 0) {
			String file_name = saveUploadFile(upload_file);
			writeContentBean.setContent_file(file_name);
		}

		writeContentBean.setContent_writer_idx(loginUserBean.getUser_idx());

		boardMapper.addContentInfo(writeContentBean);

	}

	public String getBoardInfoName(int board_info_idx) {
		return boardMapper.getBoardInfoName(board_info_idx);
	}

	@Value("${page.listcnt}")
	private int page_listcnt;

	@Value("${page.paginationcnt}")
	private int page_paginationcnt;

	public List<ContentBean> getContentList(int board_info_idx, int page) {
		// 시작인덱스 = (페이지번호 - 1) * 10
		int start = (page - 1) * page_listcnt;
		// Mybatis의 RowBounds 클래스를 사용해 가져올 글시작 번호, 가져올 개수로 설정
		RowBounds rowBounds = new RowBounds(start, page_listcnt);
		// 매퍼에서 처리하도록 rowBounds 객체를 매개변수로 추가
		return boardMapper.getContentList(board_info_idx, rowBounds);
	}

	public ContentBean getContentInfo(int content_idx) {
		return boardMapper.getContentInfo(content_idx);
	}

	// 글 인덱스 번호로 검색해서 글 정보를 modifyContentBean 입력한다.
	public void getContents(ContentBean modifyContentBean) {

		ContentBean temp = boardMapper.getContentInfo(modifyContentBean.getContent_idx());

		modifyContentBean.setContent_writer_name(temp.getContent_writer_name());
		modifyContentBean.setContent_date(temp.getContent_date());
		modifyContentBean.setContent_subject(temp.getContent_subject());
		modifyContentBean.setContent_text(temp.getContent_text());
		modifyContentBean.setContent_file(temp.getContent_file());
	}

	public void modifyContentInfo(ContentBean modifyContentBean) {

		MultipartFile upload_file = modifyContentBean.getUpload_file();

		if (upload_file.getSize() > 0) {
			String file_name = saveUploadFile(upload_file);
			modifyContentBean.setContent_file(file_name);
		}

		boardMapper.modifyContentInfo(modifyContentBean);
	}

	public void deleteContentInfo(int content_idx) {
		boardMapper.deleteContentInfo(content_idx);
	}

	public PageBean getContentCnt(int content_board_idx, int currentPage) {

		int content_cnt = boardMapper.getContentCnt(content_board_idx);

		PageBean pageBean = new PageBean(content_cnt, currentPage, page_listcnt, page_paginationcnt);

		return pageBean;
	}

}
