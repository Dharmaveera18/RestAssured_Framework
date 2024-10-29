package api.payload;

import java.util.List;

import javax.swing.text.html.HTML.Tag;

import com.aventstack.extentreports.model.Category;

public class Pets {

	
	private int id;
	private Category category;    // Nested category object
    private String name;
    private List<String> photoUrls; // List of photo URLs
    private List<Tag> tags;        // List of tag objects
    private String status;
	
	
	
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getPhotoUrls() {
		return photoUrls;
	}
	public void setPhotoUrls(List<String> photoUrls) {
		this.photoUrls = photoUrls;
	}
	public List<Tag> getTags() {
		return tags;
	}
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	
}
