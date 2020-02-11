import java.io.File;
import java.io.FileNotFoundException;

public class main {
    public static void main(String[] args) throws FileNotFoundException {

        Compare compare = new Compare();
        System.out.println("Pair 1 has a similarity score of "+ compare.checkFiles("C:\\Users\\Ralph\\IdeaProjects\\Module0-Vasquez\\assets\\test_program1.txt",
                "C:\\Users\\Ralph\\IdeaProjects\\Module0-Vasquez\\assets\\test_program2.txt"));

        System.out.println("Pair 2 has a similarity score of "+compare.checkFiles("C:\\Users\\Ralph\\IdeaProjects\\Module0-Vasquez\\assets\\test_program1.cpp",
                "C:\\Users\\Ralph\\IdeaProjects\\Module0-Vasquez\\assets\\test_program2.cpp"));

        Student students[] = new Student[34];
        File directory = new File("C:\\Users\\Ralph\\IdeaProjects\\Similarity_Checker\\Codes");
        File[] fList = directory.listFiles();

        for(int i=0; i< fList.length;i++){
            students[i] = new Student();
            students[i].setName(fList[i].getName());
            students[i].setStudentFile("C:\\Users\\Ralph\\IdeaProjects\\Similarity_Checker\\Codes\\"+fList[i].getName());
        }

        System.out.println(compare.checkFiles(students[0].getStudentFile(), students[1].getStudentFile()));
        String matrix[][] = new String[34][35];

        //initializing the values of the correlation matrix
        for(int i=0;i<34;i++){
            matrix[i][0] = students[i].getName();
            for(int k=1;k<35;k++){
                matrix[i][k] = (compare.checkFiles(students[i].getStudentFile(),students[k-1].getStudentFile()));
            }
        }

        //header of the table
        System.out.format("%15s", " ");
        for(int i=0; i < students.length;i++){
            System.out.format("%15s", students[i].getName());
        }
        System.out.println();

        for(int i=0; i<34;i++){
            for(int k=0; k < 35; k++){
                System.out.format("%15s", matrix[i][k]);
                //System.out.print(matrix[i][k]+ "\t\t");
            }
            System.out.println();
        }



    }
}
