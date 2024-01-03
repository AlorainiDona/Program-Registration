import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.io.*;
import java.util.*;

 public class ProgramRegistration {
    public static void main(String[] args) throws IOException {
        // Read input from text file
        BufferedReader br = new BufferedReader(new FileReader(""));
        String line;
        Map<Integer, Employee> employees = new HashMap<>();
        while((line = br.readLine()) != null) {
            String[] parts = line.split(":");
            int parentId = Integer.parseInt(parts[0]);
            String name = parts[1].trim();
            int id = Integer.parseInt(parts[2]);
            double score = Double.parseDouble(parts[3]);
            Employee employee = new Employee(parentId, name, id, score);
            employees.put(id, employee);
        }
        br.close();

        // Generate all possible combinations of program registrations
        List<List<Employee>> allCombinations = generateCombinations(employees.values());

        // Find the combination with the highest sum of ratings
        double maxRating = Double.MIN_VALUE;
        List<Employee> bestCombination = null;
        for(List<Employee> combination : allCombinations) {
            double rating = 0;
            for(Employee employee : combination) {
                rating += employee.getScore();
            }
            if(rating > maxRating) {
                maxRating = rating;
                bestCombination = combination;
            }
        }


        // Print the best combination
        if ( bestCombination != null) {
            System.out.println("Best combination:");
            for (Employee employee : bestCombination) {
                System.out.println(employee.getName());
            }
        }
    }

    private static List<List<Employee>> generateCombinations(Collection<Employee> employees) {
        List<List<Employee>> allCombinations = new ArrayList<>();
        for(Employee employee : employees) {
            System.out.println("in for");
            List<List<Employee>> newCombinations = new ArrayList<>();
            for(List<Employee> combination : allCombinations) {
                System.out.println("in while");
                newCombinations.add(combination);
                List<Employee> newCombination = new ArrayList<>(combination);
                newCombination.add(employee);
                newCombinations.add(newCombination);
            }
            allCombinations.addAll(newCombinations);
        }
        return allCombinations;
    }
}

class Employee {
    private int parentId;
    private String name;
    private int id;
    private double score;

    public Employee(int parentId, String name, int id, double score) {
        this.parentId = parentId;
        this.name = name;
        this.id = id;
        this.score = score;
    }

    public int getParentId() {
        return parentId;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getScore() {
        return score;
    }
}
