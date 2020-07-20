import java.io.FileNotFoundException;
import java.io.IOException;

public interface CatalogLoader {
	Catalog loadCatalog(String fileName)
			throws FileNotFoundException, IOException, DataFormatException;
}
