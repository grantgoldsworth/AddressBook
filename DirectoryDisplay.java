import java.util.Comparator;

/**
 * Directories that implement this interface must override the {@code String getDisplay()} method,
 * intended to create an easy to read display of the directory's contents as a String.
 */
public interface DirectoryDisplay {
    String getDisplay();
}
