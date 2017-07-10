package kr.co.domain;

import java.io.Serializable;
import java.util.Arrays;

public class BoardVO implements Serializable {

	private int bno;
	private String id;
	private String title;
	private String content;
	private String category;
	private String position;
	private int viewCnt;
	private int replyCnt;
	private String regDate;
	private String updateDate;	
	
	private String count;
	
	/*파일정보를 알려주는 file이 여러개라서*/ 
	private String[] files;

	
	
	
	
	

	
	public BoardVO(int bno, String id, String title, String content, String category, String position, int viewCnt,
			int replyCnt, String regDate, String updateDate, String count, String[] files) {
		super();
		this.bno = bno;
		this.id = id;
		this.title = title;
		this.content = content;
		this.category = category;
		this.position = position;
		this.viewCnt = viewCnt;
		this.replyCnt = replyCnt;
		this.regDate = regDate;
		this.updateDate = updateDate;
		this.count = count;
		this.files = files;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	/* 파일정보를 알려주는 file이 여러개라서 */
	

	public String[] getFiles() {
		return files;
	}

	public void setFiles(String[] files) {
		this.files = files;
	}

	public BoardVO() {
		// TODO Auto-generated constructor stub
	}

	
	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	public int getReplyCnt() {
		return replyCnt;
	}

	public void setReplyCnt(int replyCnt) {
		this.replyCnt = replyCnt;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bno;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BoardVO other = (BoardVO) obj;
		if (bno != other.bno)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BoardVO [bno=" + bno + ", id=" + id + ", title=" + title + ", content=" + content + ", category="
				+ category + ", position=" + position + ", viewCnt=" + viewCnt + ", replyCnt=" + replyCnt + ", regDate="
				+ regDate + ", updateDate=" + updateDate + ", count=" + count + ", files=" + Arrays.toString(files)
				+ "]";
	}
	
	
}
