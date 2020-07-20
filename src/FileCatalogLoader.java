import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class FileCatalogLoader implements CatalogLoader{

	private static final String DOG_PREFIX="Dog";
	private static final String CAT_PREFIX="Cat";
	
	public FileCatalogLoader() {
		
	}
	
	public Catalog loadCatalog(String filename) throws FileNotFoundException, IOException, DataFormatException {
		Catalog catalog=new Catalog();
		
		BufferedReader reader=new BufferedReader(new FileReader(filename));
		String line=reader.readLine();
		
		while(line!=null) {
			Animal animal=null;
			
			if(line.startsWith(DOG_PREFIX)) {
				animal=readDog(line);
			}else if(line.startsWith(CAT_PREFIX)) {
				animal=readCat(line);
			}
			catalog.addAnimal(animal);
			line=reader.readLine();
		}
		reader.close();
		return catalog;
	}

	private Cat readCat(String line) throws DataFormatException {
		StringTokenizer st=new StringTokenizer(line,"_");
		if(st.countTokens()!=8) {
			throw new DataFormatException(line);
		}else {
			
			String out=st.nextToken();
			return new Cat(st.nextToken(),st.nextToken(),st.nextToken(),st.nextToken(),Integer.parseInt(st.nextToken()),
					st.nextToken(),st.nextToken());
		}
		
	}
	

	private Dog readDog(String line) throws DataFormatException {
		StringTokenizer st=new StringTokenizer(line,"_");
		if(st.countTokens()!=8) {
			throw new DataFormatException(line);
		}else {
			
			String out=st.nextToken();
			return new Dog(st.nextToken(),st.nextToken(),st.nextToken(),st.nextToken(),Integer.parseInt(st.nextToken()),
					st.nextToken(),st.nextToken());
		}
		
	}
}
