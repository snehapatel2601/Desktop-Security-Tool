import java.net.*;
import java.io.InputStream;
public class WebsiteInfo {
	public static void main(String a[]) {
		try {
			URL url = new URL("https://www.instagram.com");
			URLConnection urlcon = url.openConnection();
			InputStream stream = urlcon.getInputStream();
			int i;
			while((i=stream.read())!=-1) {
				System.out.print((char)i);
			}
		}
		catch(Exception e) {
			System.out.print(e);	
		}
	}

}
