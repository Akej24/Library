package Options;

import java.util.List;

public interface LibraryDaoInterface {
    boolean insertBook(Library book);
    boolean deleteBook(int id);
    List<Library> getLibrary();
    Library getBook(int id);
    boolean updateBook(int numberOfParameter, int id, String changedData);

}
