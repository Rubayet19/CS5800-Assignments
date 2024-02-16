import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class File {
    private String name;

    public File(String name) {
        this.name = name;
    }

    public void print(String prefix) {
        System.out.println(prefix + name);
    }
}

class Folder {
    private String name;
    private List<File> files = new ArrayList<>();
    private List<Folder> subFolders = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void addFile(File file) {
        files.add(file);
    }

    public void addSubFolder(Folder folder) {
        subFolders.add(folder);
    }

    public void removeSubFolder(String folderName) {
        subFolders.removeIf(folder -> folder.getName().equals(folderName));
    }

    public String getName() {
        return name;
    }

    public void print(String prefix) {
        System.out.println(prefix + name);
        for (Folder subFolder : subFolders) {
            subFolder.print(prefix + "    ");
        }
        for (File file : files) {
            file.print(prefix + "    ");
        }
    }
}

public class Ans4 {
    public static void main(String[] args) {
        Folder php_demo1 = new Folder("php_demo1/");
        
        // Sub-folders of php_demo1
        Folder sourceFiles = new Folder("Source Files/");
        Folder phalcon = new Folder(".phalcon/");
        Folder app = new Folder("app/");
        Folder config = new Folder("config/");
        Folder controllers = new Folder("controllers/");
        Folder library = new Folder("library/");
        Folder migrations = new Folder("migrations/");
        Folder models = new Folder("models/");
        Folder views = new Folder("views/");
        Folder cache = new Folder("cache/");
        Folder publicFolder = new Folder("public/");
        Folder IncludePath = new Folder("Include Path/");
        File RemoteFile = new File("Remote Files/");
        
        // Files in public
        File htaccess = new File(".htaccess");
        File hrouter = new File("hrouter.php");
        File index = new File("index.html");
        
        // Building the directory tree
        php_demo1.addSubFolder(sourceFiles);
        sourceFiles.addSubFolder(phalcon);
        sourceFiles.addSubFolder(app);
        app.addSubFolder(config);
        app.addSubFolder(controllers);
        app.addSubFolder(library);
        app.addSubFolder(migrations);
        app.addSubFolder(models);
        app.addSubFolder(views);

        php_demo1.addSubFolder(cache);
        php_demo1.addSubFolder(publicFolder);
        publicFolder.addFile(htaccess);
        publicFolder.addFile(hrouter);
        publicFolder.addFile(index);
        php_demo1.addSubFolder(IncludePath);
        php_demo1.addFile(RemoteFile);
        
        // 1. Print out the php_demo1 folder and all sub folders. All sub folders should also print out their content until the full structure above is printed.
        System.out.println("Initial structure of php_demo1:");
        php_demo1.print("");
        
        // 2. Now delete the folder app and print out the full structure.
        sourceFiles.removeSubFolder("app/");
        System.out.println("\nStructure of php_demo1 after removing app:");
        php_demo1.print("");
        
        // 3. Now delete the folder public and print out the full structure.
        php_demo1.removeSubFolder("public/");
        System.out.println("\nStructure of php_demo1 after removing public:");
        php_demo1.print("");
    }
}

