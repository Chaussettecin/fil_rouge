package Control;

import java.nio.file.Path;

public class FileController {
	
	private static final Path[] filepaths = InstallFeatures.getSaveDataPath();
	
	public FileController() {}

	public static Path[] getFilepaths() {
		return filepaths;
	}

}
