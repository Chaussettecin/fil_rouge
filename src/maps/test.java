package maps;


	import java.io.IOException;
	import java.nio.file.Files;
	import java.nio.file.Paths;
	 
	public class test {
	 
	    public static void main (String [] args) throws IOException
	    {
	         
	        displayPDF("./"); // Informer ton chemin
	         
	    }
	 
	    private static void displayPDF(String chemin) throws IOException {
	        Files.newDirectoryStream(Paths.get(chemin),
	                path -> path.toString().endsWith(".*"))
	                .forEach(System.out::println);
	    }
	
	

}
