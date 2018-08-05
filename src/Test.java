
public class Test {
	public static void main(String[] args) {
		Query q = new Query("http://example.com/path/to/page?name=ferret&color=purple");
		
		System.out.println(q.getPath());
		System.out.println(q.getPage());
		System.out.println(q.getArguments().get("name"));
	}
}
