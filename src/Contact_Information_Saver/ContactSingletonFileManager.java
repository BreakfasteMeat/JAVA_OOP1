package Contact_Information_Saver;

public class ContactSingletonFileManager {
    private static ContactSingletonFileManager instance;
    String file_path;
    private ContactSingletonFileManager(){
        file_path = "src/FILES_FOR_FILEHANDLING/contacts.txt";
    }
    public static ContactSingletonFileManager getInstance(){
        if(instance == null){
            instance = new ContactSingletonFileManager();
        }
        return instance;
    }
}
