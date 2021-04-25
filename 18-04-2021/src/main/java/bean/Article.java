package bean;

public class Article {

	private String id;
	private String date;
	private String title;
	private String image;
	private String description;
	private String content;

	public Article() {
		super();
	}

	public Article(String id, String date, String title, String image, String description,
			String content) {
		super();
		this.id = id;
		this.date = date;
		this.title = title;
		this.image = image;
		this.description = description;
		this.content = content;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
