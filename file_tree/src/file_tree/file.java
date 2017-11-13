package file_tree;

public class file {
	private String filename;
	private long size;
	private long lastmodifytime;
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
	public long getLastmodifytime() {
		return lastmodifytime;
	}
	public void setLastmodifytime(long lastmodifytime) {
		this.lastmodifytime = lastmodifytime;
	}
}
