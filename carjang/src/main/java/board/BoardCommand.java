package board;

import org.springframework.web.multipart.MultipartFile;

public class BoardCommand {

	private String contents;
	private MultipartFile file;
	private String upDir;
	private Long id;

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getUpDir() {
		return upDir;
	}

	public void setUpDir(String upDir) {
		this.upDir = upDir;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
