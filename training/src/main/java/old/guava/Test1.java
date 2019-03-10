package old.guava;

import com.google.common.graph.Traverser;
import com.google.common.io.Files;

import java.io.File;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author WangYuFei
 * @date 2019-01-31 17:58
 **/
public class Test1 {
    public static void main(String[] args) {
        Traverser<File> fileTraverser = Files.fileTraverser();
        Iterable<File> files = fileTraverser.breadthFirst(new File("c:/"));
        System.out.println(files);
    }
}
